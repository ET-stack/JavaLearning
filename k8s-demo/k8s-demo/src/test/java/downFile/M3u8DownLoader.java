package downFile;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @className: M3u8DownLoader
 * @description: TODO 类描述
 * @date: 2024/4/30
 **/
public class M3u8DownLoader {
    public static void main(String[] args) {
        List<String> tsUrls = new ArrayList<>();
        tsUrls.add("https://1");
        tsUrls.add("https://2");
        tsUrls.add("https://3");
        tsUrls.add("https://4");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < tsUrls.size(); i++) {
            executorService.submit(new TsDownloader(tsUrls.get(i), i));
        }
        executorService.shutdown();
    }
}
