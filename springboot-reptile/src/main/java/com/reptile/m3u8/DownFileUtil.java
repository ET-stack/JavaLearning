package com.reptile.m3u8;

/**
 * @className: DownFileUtil
 * @description: TODO 类描述
 * @date: 2023/2/27
 **/



import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DownFileUtil {

    private static String rootPath = "E:\\Development\\BackEnd\\Java\\Gitee\\video-pp\\video-pp\\src\\test\\java\\com\\cc\\videopp\\download\\temp";
    private static String key = null;

    static   ExecutorService executorService = Executors.newFixedThreadPool(100);
//    public static void run1(String indexPath){
//        System.out.println(indexPath+"下载成功");
//    }
    public static void run(String indexPath){
        long startTime = System.currentTimeMillis();
//        String indexPath = "https://cdn.bigcloud.click/hls/815239/index.m3u8";
//        String prePath = indexPath.substring(0, indexPath.indexOf('/', indexPath.indexOf('/', indexPath.indexOf('/') + 1) + 1));
        String prePath = indexPath.substring(0,indexPath.lastIndexOf("/"))+"/";
        System.out.println(prePath);
        //下载索引文件

        String indexStr = getIndexFile(indexPath);
        //解析索引文件
        List videoUrlList = analysisIndex(prePath,indexStr);

        //生成文件下载目录
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        String fileRootPath = rootPath+File.separator+uuid;
        File fileDir = new File(fileRootPath);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }
        //下载视频片段，分成50个线程切片下载
        HashMap keyFileMap = new HashMap();
        int downForThreadCount = videoUrlList.size();
        System.out.println("key是"+key);
        for(int i=0;i<videoUrlList.size();i+=downForThreadCount){
            int end = i+downForThreadCount-1;
            if(end>videoUrlList.size()){
                end = videoUrlList.size()-1;
            }
            executorService.submit( new DownFileUtil().new downLoadNode(videoUrlList,i,end,keyFileMap,prePath,fileRootPath));

        }
        //等待下载
        while (keyFileMap.size()<videoUrlList.size()){
            System.out.println("当前下载数量"+keyFileMap.size());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 解密文件夹下的所有文件
        if (key != null){
            try {
                decryptFolder(new File(fileRootPath), key);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        // 执行文件重命名
        if (key != null){
            renameFiles(keyFileMap);
        }
        removeTsFolders(new File("fileRootPath"));
        //合成视频片段
        composeFile(fileRootPath+File.separator+uuid+".mp4",keyFileMap);
        long endTime = System.currentTimeMillis();
        System.out.println("下载总运行时间为"+(endTime-startTime)+"ms");
    }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String indexPath = "https://cdn.bigcloud.click/hls/815239/index.m3u8";
//        String prePath = indexPath.substring(0, indexPath.indexOf('/', indexPath.indexOf('/', indexPath.indexOf('/') + 1) + 1));
        String prePath = indexPath.substring(0,indexPath.lastIndexOf("/"))+"/";
        System.out.println(prePath);
        //下载索引文件

        String indexStr = getIndexFile(indexPath);
        //解析索引文件
        List videoUrlList =     analysisIndex(prePath,indexStr);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //生成文件下载目录
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        String fileRootPath = rootPath+File.separator+uuid;
        File fileDir = new File(fileRootPath);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }
        //下载视频片段，分成50个线程切片下载
        HashMap keyFileMap = new HashMap();
        int downForThreadCount = videoUrlList.size();
        System.out.println("key是"+key);
        for(int i=0;i<videoUrlList.size();i+=downForThreadCount){
            int end = i+downForThreadCount-1;
            if(end>videoUrlList.size()){
                end = videoUrlList.size()-1;
            }
            executorService.submit( new DownFileUtil().new downLoadNode(videoUrlList,i,end,keyFileMap,prePath,fileRootPath));

        }
        //等待下载
        while (keyFileMap.size()<videoUrlList.size()){
            System.out.println("当前下载数量"+keyFileMap.size());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 解密文件夹下的所有文件
        if (key != null){
            try {
                decryptFolder(new File(fileRootPath), key);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

        // 执行文件重命名
      if (key != null){
          renameFiles(keyFileMap);
      }
        removeTsFolders(new File("fileRootPath"));
        //合成视频片段
        composeFile(fileRootPath+File.separator+uuid+".mp4",keyFileMap);
        long endTime = System.currentTimeMillis();
        System.out.println("下载总运行时间为"+(endTime-startTime)+"ms");
    }
    public static void renameFiles(Map<String, String> keyFileMap) {
        for (Map.Entry<String, String> entry : keyFileMap.entrySet()) {
            String fileName = entry.getValue();
            if (fileName.toLowerCase().endsWith(".ts")) {
                fileName = fileName.substring(0, fileName.length() - 3) + ".ts.xyz";
                entry.setValue(fileName);
            }
        }
    }
    public static void removeTsFolders(File folder) {
        // 获取文件夹下的所有文件和文件夹
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // 如果是文件夹，递归处理该文件夹
                    removeTsFolders(file);
                } else {
                    // 如果是文件，检查文件名后缀是否为".ts"，是则删除该文件
                    String fileName = file.getName();
                    if (fileName.toLowerCase().endsWith(".ts")) {
                        file.delete();
                    }
                }
            }
        }
    }
    public static void decryptFolder(File folder, String key) throws Exception {
        // 解密密钥
        byte[] keyBytes = key.getBytes("UTF-8");
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

        // 遍历文件夹下的所有文件
        File[] files = folder.listFiles();
        for (File file : files) {
            // 解密文件
            decryptFile(file, secretKeySpec);
        }
    }

    public static void decryptFile(File file, SecretKeySpec secretKeySpec) throws Exception {
        // 创建输入流
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);

        // 创建输出流
        String outputFilePath = file.getParent() + File.separator + file.getName() + ".xyz";
        FileOutputStream fos = new FileOutputStream(outputFilePath);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        // 创建解密器
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(new byte[16]));

        // 读取并解密数据
        byte[] buffer = new byte[1024];
        int len;
        while ((len = bis.read(buffer)) > 0) {
            byte[] decryptedData = cipher.update(buffer, 0, len);
            if (decryptedData != null) {
                bos.write(decryptedData);
            }
        }
        byte[] decryptedData = cipher.doFinal();
        if (decryptedData != null) {
            bos.write(decryptedData);
        }
        // 删除源文件
        if (file.exists()) {
            file.delete();
        }
        // 关闭流
        bis.close();
        bos.close();
    }

    public static void start(String indexPath){
        long startTime = System.currentTimeMillis();
//        String indexPath = "http://playertest.longtailvideo.com/adaptive/bipbop/gear4/prog_index.m3u8";
        String prePath = indexPath.substring(0,indexPath.lastIndexOf("/")+1);
        //下载索引文件
        String indexStr = getIndexFile(indexPath);
        //解析索引文件
        List videoUrlList = analysisIndex(prePath,indexStr);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //生成文件下载目录
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        String fileRootPath = rootPath+File.separator+uuid;
        File fileDir = new File(fileRootPath);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }
        //下载视频片段，分成50个线程切片下载
        HashMap keyFileMap = new HashMap();
        int downForThreadCount = videoUrlList.size();
        for(int i=0;i<videoUrlList.size();i+=downForThreadCount){
            int end = i+downForThreadCount-1;
            if(end>videoUrlList.size()){
                end = videoUrlList.size()-1;
            }
            executorService.submit( new DownFileUtil().new downLoadNode(videoUrlList,i,end,keyFileMap,prePath,fileRootPath));
        }
        //等待下载
        while (keyFileMap.size()<videoUrlList.size()){
            System.out.println("当前下载数量"+keyFileMap.size());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //合成视频片段
        composeFile(fileRootPath+File.separator+uuid+".mp4",keyFileMap);
        long endTime = System.currentTimeMillis();
        System.out.println("下载总运行时间为"+(endTime-startTime)+"ms");
    }


    /**
     * 视频片段合成
     * @param fileOutPath
     * @param keyFileMap
     */
    public static void composeFile(String fileOutPath,HashMap<Integer,String> keyFileMap){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(fileOutPath));
            byte[] bytes = new byte[1024];
            int length = 0;
            for(int i=0;i<keyFileMap.size();i++){
                String nodePath = keyFileMap.get(i);
                File file = new File(nodePath);
                if(!file.exists())
                    continue;
                FileInputStream fis = new FileInputStream(file);
                while ((length = fis.read(bytes)) != -1) {
                    fileOutputStream.write(bytes, 0, length);
                }
            }
        }catch (Exception e) {
           e.printStackTrace();
        }

    }



    public static String getM3u8Url(String m3u8Url) {
        URL url = null;
        StringBuffer response = new StringBuffer();
        try {
            url = new URL(m3u8Url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");

            int responseCode = conn.getResponseCode();
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;


            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            System.out.println("Response Body : " + response.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return response.toString();

    }
    public static void getKey(String prePath,String s){
        if (s.contains("key")){
            String url = s.substring(s.indexOf("URI=")+5,s.indexOf(".key")+4);
            StringBuilder keyBuilder = new StringBuilder();
            try {
                URL u = new URL(prePath+url);
                HttpURLConnection conn = (HttpURLConnection) u.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    keyBuilder.append(inputLine);
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            key = keyBuilder.toString();
        }

    }

    public static List analysisIndex(String prePath,String content){
        String m3u8Url = null;
        if (content.contains("m3u8")){

            //说明需要再提取一层
            Pattern pattern = Pattern.compile("/\\w+(/\\w+)+\\.m3u8");
            Matcher matcher = pattern.matcher(content);

            if (matcher.find()) {
                String extractedString = matcher.group(0);
                m3u8Url =  getM3u8Url(prePath+extractedString);
                getKey(prePath,m3u8Url);
                System.out.println(extractedString);
            } else {
                System.out.println("No match found.");
            }

        }
//        Pattern pattern = Pattern.compile("/\\w+(/\\w+)+\\.ts");
        Pattern pattern = Pattern.compile("(\\w+)+\\.ts");
        Matcher ma = null;
        if (m3u8Url != null){
             ma = pattern.matcher(m3u8Url);
        }else {
             ma = pattern.matcher(content);
        }


        List<String> list = new ArrayList<String>();

        while(ma.find()){
            String s = ma.group();
//            list.add(prePath+"/hls/815239/"+s);
            list.add( prePath+s);
            System.out.println(s);
        }
        return list;
    }


    class downLoadNode extends  Thread{
        private List<String> tsList ;
        private  int start;
        private  int end;
        public  HashMap keyFileMap ;
        private  String preUrlPath ;
        private  String fileRootPath ;

        private int count = 0;

        public  downLoadNode(List list,int start,int end,HashMap keyFileMap,String preUrlPath,String fileRootPath){
            this.tsList = list;
            this.end = end;
            this.start = start;
            this.keyFileMap = keyFileMap;
            this.preUrlPath = preUrlPath;
            this.fileRootPath = fileRootPath;
        }
        @Override
        public void run(){
            try{
                double speed = 0;//速度
                long startTime = System.currentTimeMillis(); // 记录开始下载的时间
                long totalBytes = 0; // 已下载的字节数
                DecimalFormat decimalFormat = new DecimalFormat("#.00"); // 用于格式化下载速度
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

                for( int i = start;i<=end;i++){
                    String uuid = UUID.randomUUID().toString().replaceAll("-","");
                    String urlPath = tsList.get(i);
                    URL url = new URL(urlPath);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    //下在资源
                    DataInputStream dataInputStream = new DataInputStream(conn.getInputStream());
                    String fileOutPath = fileRootPath+File.separator+i+".ts";
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(fileOutPath));


                    byte[] bytes = new byte[1024];
                    int length = 0;
                    while ((length = dataInputStream.read(bytes)) != -1) {
                        fileOutputStream.write(bytes, 0, length);


                        totalBytes += length;
                        long endTime = System.currentTimeMillis(); // 记录下载结束的时间
                         speed  = (totalBytes / 1024.0) / ((endTime - startTime) / 1000.0); // 计算下载速度
                       
                    }
                    dataInputStream.close();
                    keyFileMap.put(i,fileOutPath);
                    count++;
                }
                System.out.print("\r" + decimalFormat.format(speed) + " KB/s"); // 实时显示下载速度
                System.out.println("第"+count+"组完成，"+"开始位置"+start+",结束位置"+end);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static String getIndexFile(String urlpath){
        try{
            URL url = new URL(urlpath);
            //下在资源
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
            String content = "" ;
            String line;
            while ((line = in.readLine()) != null) {
                content += line + "\n";
            }
            in.close();
            System.out.println(content);
            return content;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



//    public static void main(String[] args) {
//        try {
//            encryptFile("E:\\Development\\BackEnd\\Java\\Gitee\\video-pp\\video-pp\\src\\test\\java\\com\\cc\\videopp\\download\\1.txt","0123456789abcdef");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            decryptFile("E:\\Development\\BackEnd\\Java\\Gitee\\video-pp\\video-pp\\src\\test\\java\\com\\cc\\videopp\\download\\2.txt","0123456789abcdef");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

}