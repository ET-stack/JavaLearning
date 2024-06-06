package com.reptile.m3u8;

/**
 * @className: MultiThreadDownloadWithLimit
 * @description: TODO 类描述
 * @author:
 * @date: 2023/7/13
 **/

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MultiThreadDownloadWithLimit {

    private static final int BUFFER_SIZE = 1024;
    private static final int DEFAULT_MAX_DOWNLOAD_SPEED = 1024 * 1024; // 默认下载速度为 1MB/s

    private final int maxDownloadSpeed; // 最大下载速度，单位为字节/秒
    private final ExecutorService executorService; // 线程池
    private long lastDownloadStartTime; // 上一次下载开始时间
    private long downloadedBytes; // 已下载字节数

    public MultiThreadDownloadWithLimit(int maxDownloadSpeed, int numThreads) {
        this.maxDownloadSpeed = maxDownloadSpeed;
        this.executorService = Executors.newFixedThreadPool(numThreads);
        this.lastDownloadStartTime = 0L;
        this.downloadedBytes = 0L;
    }

    public void downloadFile(String downloadUrl, String outputFilePath) throws IOException, InterruptedException {
        URL url = new URL(downloadUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("HEAD");
        int fileSize = connection.getContentLength();
        connection.disconnect();

        // 创建输出文件
        try (OutputStream outputStream = createFile(outputFilePath)) {
            // 计算每个线程需要下载的字节数
            int numThreads = executorService instanceof ThreadPoolExecutor ?
                    ((ThreadPoolExecutor) executorService).getMaximumPoolSize() : 1;
            int blockSize = fileSize / numThreads;

            // 启动下载线程
            for (int i = 0; i < numThreads; i++) {
                int start = i * blockSize;
                int end = i == numThreads - 1 ? fileSize - 1 : start + blockSize - 1;
                executorService.execute(() -> {
                    try (InputStream inputStream = openConnectionForRange(downloadUrl, start, end)) {
                        byte[] buffer = new byte[BUFFER_SIZE];
                        int bytesRead;
                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);
                            downloadedBytes += bytesRead;
                            limitDownloadSpeed();
                        }
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }

            // 等待所有下载线程完成
            executorService.shutdown();
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        }
    }

    private InputStream openConnectionForRange(String downloadUrl, int start, int end) throws IOException {
        URL url = new URL(downloadUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Range", "bytes=" + start + "-" + end);
        return connection.getInputStream();
    }

    private void limitDownloadSpeed() throws InterruptedException {
        long currentTime = System.currentTimeMillis();
        if (lastDownloadStartTime == 0L) {
            lastDownloadStartTime = currentTime;
        } else {
            long elapsedTime = currentTime - lastDownloadStartTime;
            if (elapsedTime > 0) {
                double currentDownloadSpeed = (double) downloadedBytes / elapsedTime * 1000; // 转换为字节/秒
                if (currentDownloadSpeed > maxDownloadSpeed) {
                    long sleepTime = (long) (((double) downloadedBytes / maxDownloadSpeed) * 1000 - elapsedTime);
                    if (sleepTime > 0) {
                        Thread.sleep(sleepTime);
                    }
                    lastDownloadStartTime += elapsedTime + sleepTime;
                } else {
                    lastDownloadStartTime = currentTime;
                }
                downloadedBytes = 0L;
            }
        }
    }
    public static FileOutputStream createFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return new FileOutputStream(file);
    }
}