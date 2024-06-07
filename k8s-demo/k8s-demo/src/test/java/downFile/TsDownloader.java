package downFile;

/**
 * @className: TsDownloader
 * @description: TODO 类描述
 * @date: 2024/4/30
 **/
class TsDownloader implements Runnable {
    private final String tsUrl;
    private final int taskId;

    public TsDownloader(String tsUrl, int taskId) {
        this.tsUrl = tsUrl;
        this.taskId = taskId;
    }

    @Override
    public void run() {
        // 模拟下载操作，这里只是打印任务ID和URL
        System.out.println("Task ID: " + taskId + ", Downloading: " + tsUrl);
        // 在实际项目中，这里应该是下载TS分片并保存到本地的代码
        // 假设下载成功，更新进度
        updateProgress(taskId);
    }

    // 更新下载进度的模拟方法
    private void updateProgress(int taskId) {
        // 在实际项目中，你可能会使用某种同步机制来更新全局进度
        System.out.println("Task ID: " + taskId + ", Download completed");
    }
}
