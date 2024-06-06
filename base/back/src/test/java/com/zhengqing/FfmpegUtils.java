package com.zhengqing;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @className: FfmpegUtils
 * @description: TODO 类描述
 * @author: {yitao@flyread.com.cn}
 * @date: 2022/7/14
 **/
@Slf4j
public class FfmpegUtils {

    private String inputPath;
    private String outputPath;
    private static String ffmpegPath = "D:\\Program Files\\ffmpeg-4.3.1\\bin\\ffmpeg.exe"; // 填你本地的ffmpeg.exe路径


    public static void mergeVedio(String inputPath, String outputPath) {

        StringBuffer command = new StringBuffer("");
        command.append(ffmpegPath);
        command.append(" -y");
        command.append(" -allowed_extensions");
        command.append(" ALL");
        //command.append(" -protocol_whitelist");
        //command.append(" file,http,https,crypto,tcp,tls");
        command.append(" -i");
        command.append(" " + inputPath);
        command.append(" -c");
        command.append(" copy");
        command.append(" " + outputPath);

        try {
            final Process process = Runtime.getRuntime().exec(command.toString());

            log.info("start run cmd {}", command);
            //⚠️此处代码是因为如果合并大视频文件会产生大量的日志缓存导致线程阻塞，最终合并失败，所以加两个线程处理日志的缓存，之后再调用waitFor方法，等待执行结果。
            //打印输出信息
            new Thread(() -> {
                BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line = null;
                try {
                    while ((line = in.readLine()) != null) {
                        System.out.println("output:" + line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            //打印错误信息
            new Thread(() -> {
                BufferedReader err = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                String line = null;
                try {
                    while ((line = err.readLine()) != null) {
                        System.out.println("err:" + line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        err.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            // 等待命令子线程执行完成
            process.waitFor();
            process.destroy();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

