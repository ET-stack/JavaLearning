package com.demo;

import com.alipay.mychain.sdk.api.MychainClient;
import com.alipay.mychain.sdk.api.env.ClientEnv;
import com.alipay.mychain.sdk.api.env.ISslOption;
import com.alipay.mychain.sdk.api.env.SignerOption;
import com.alipay.mychain.sdk.api.env.SslBytesOption;
import com.alipay.mychain.sdk.api.logging.AbstractLoggerFactory;
import com.alipay.mychain.sdk.api.logging.ILogger;
import com.alipay.mychain.sdk.api.utils.Utils;
import com.alipay.mychain.sdk.crypto.MyCrypto;
import com.alipay.mychain.sdk.crypto.hash.Hash;
import com.alipay.mychain.sdk.crypto.keyoperator.Pkcs8KeyOperator;
import com.alipay.mychain.sdk.crypto.keypair.Keypair;
import com.alipay.mychain.sdk.crypto.signer.SignerBase;
import com.alipay.mychain.sdk.errorcode.ErrorCode;
import com.alipay.mychain.sdk.message.query.QueryTransactionResponse;
import com.alipay.mychain.sdk.message.transaction.account.DepositDataRequest;
import com.alipay.mychain.sdk.message.transaction.account.DepositDataResponse;
import com.alipay.mychain.sdk.utils.IOUtil;

import java.io.*;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * demo
 */
public class Demo {

    /**
     * sdk client
     */
    private static MychainClient sdk;

    /**
     * mychain environment
     */
    private static ClientEnv env;

    /**
     * client key password
     */
    private static String keyPassword = "Yt1826869334.";  //根据实际情况更新，申请证书时候指定的SSL密码

    /**
     * trustCa password.
     */
    private static String trustStorePassword = "mychain";

    /**
     * baas上创建的帐户名字
     */
    private static final String account = "15211846416"; // 根据实际情况更新，创建账户的名称
    private static Keypair userKeypair;

    /**
     * user password
     */
    private static String userPassword = "Yt1826869334."; // 根据实际情况更新，创建账户的密码

    /**
     * host ip
     */
    private static String host = "47.102.11.238";

    /**
     * server port
     */
    private static int port = 18130;

    /**
     * 运行入口
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        //step 1: init mychain env.
        initMychainEnv();

        //step 2: init sdk client
        initSdk();

        // step 3: deposit data
        String hash = depositdata("data");

        //step 4:
        queryTransaction(hash);

        //step 5: sdk shut down
        sdk.shutDown();
    }

    private static void exit(String tag, String msg) {
        exit(String.format("%s error : %s ", tag, msg));
    }

    private static void exit(String msg) {
        System.out.println(msg);
        System.exit(0);
    }

    private static String getErrorMsg(int errorCode) {
        int minMychainSdkErrorCode = ErrorCode.SDK_INTERNAL_ERROR.getErrorCode();
        if (errorCode < minMychainSdkErrorCode) {
            return ErrorCode.valueOf(errorCode).getErrorDesc();
        } else {
            return ErrorCode.valueOf(errorCode).getErrorDesc();
        }
    }

    private static void initMychainEnv() throws IOException {
        // any user key for sign message
        String userPrivateKeyFile = "user.key";
        Pkcs8KeyOperator pkcs8KeyOperator = new Pkcs8KeyOperator();
        userKeypair = pkcs8KeyOperator.load(IOUtil.inputStreamToByte(Demo.class.getClassLoader().getResourceAsStream(userPrivateKeyFile)), userPassword);

        env = buildMychainEnv();
        ILogger logger = AbstractLoggerFactory.getInstance(Demo.class);
        env.setLogger(logger);
    }

    private static ClientEnv buildMychainEnv() throws IOException {
        InetSocketAddress inetSocketAddress = InetSocketAddress.createUnresolved(host, port);
        String keyFilePath = "client.key";
        String certFilePath = "client.crt";
        String trustStoreFilePath = "trustCa";

        // build ssl option
        ISslOption sslOption = new SslBytesOption.Builder()
                .keyBytes(IOUtil.inputStreamToByte(Demo.class.getClassLoader().getResourceAsStream(keyFilePath)))
                .certBytes(IOUtil.inputStreamToByte(Demo.class.getClassLoader().getResourceAsStream(certFilePath)))
                .keyPassword(keyPassword)
                .trustStorePassword(trustStorePassword)
                .trustStoreBytes(
                        IOUtil.inputStreamToByte(Demo.class.getClassLoader().getResourceAsStream(trustStoreFilePath)))
                .build();

        List<InetSocketAddress> socketAddressArrayList = new ArrayList<InetSocketAddress>();
        socketAddressArrayList.add(inetSocketAddress);

        List<SignerBase> signerBaseList = new ArrayList<SignerBase>();
        SignerBase signerBase = MyCrypto.getInstance().createSigner(userKeypair);
        signerBaseList.add(signerBase);
        SignerOption signerOption = new SignerOption();
        signerOption.setSigners(signerBaseList);

        return ClientEnv.build(socketAddressArrayList, sslOption, signerOption);
    }

    private static void initSdk() {
        sdk = new MychainClient();
        boolean initResult = sdk.init(env);
        if (!initResult) {
            exit("initSdk", "sdk init failed.");
        }
    }

    /**
     * 存证上链
     *
     * @param data
     * @return
     */
    private static String depositdata(String data) {
        System.out.println("depositData start, data is: " + data);
        if (data.getBytes().length > 1024 * 1024) {
            exit("depositData", "data size more than 1Mb.");
        }

        // 构建存证交易
        DepositDataRequest request = new DepositDataRequest(Utils.getIdentityByName(account), Utils.getIdentityByName(account), data.getBytes(), BigInteger.ZERO);
        DepositDataResponse response = sdk.getAccountService().depositData(request);
        if (!response.isSuccess() || response.getTransactionReceipt().getResult() != 0) {
            exit("depositData", getErrorMsg((int) response.getTransactionReceipt().getResult()));
        } else {
            System.out.println("depositData end, deposit hash is: " + response.getTxHash());
            return response.getTxHash().hexStrValue();
        }

        return null;
    }

    /**
     * 链上查询
     *
     * @param txHash
     */
    private static void queryTransaction(String txHash) {
        if (txHash == null) {
            exit("queryTransaction", "txHash is empty.");
        }

        // 查询交易
        Hash hash = new Hash(txHash);
        QueryTransactionResponse queryTransactionResponse = sdk.getQueryService().queryTransaction(hash);
        if (!queryTransactionResponse.isSuccess()) {
            exit("queryTransaction", getErrorMsg(0));
        } else {
            String txData = new String(queryTransactionResponse.getTransaction().getData());
            System.out.println("queryTransaction end, deposit data is: " + txData);
        }
    }
}
