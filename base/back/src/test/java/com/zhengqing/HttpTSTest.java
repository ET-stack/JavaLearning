package com.zhengqing;

/**
 * @className: HttpTSTest
 * @description: TODO 类描述
 * @author: {yitao@flyread.com.cn}
 * @date: 2022/7/14
 **/
public class HttpTSTest {
//爬取拉勾视频，cookie不用变，变的是 m3u8地址 和 key地址（cookie，code，vid，appId）
        public static void main(String[] args) {
            M3U8Factory m3U8Factory = new M3U8Factory();
            m3U8Factory.setM3u8("https://vod.lagou.com/a6951d113cee4c3380bd3b13f40f1c98/34e9c9e0cc677e60f77e22f6395eda89-sd-encrypt-stream.m3u8", "index", "d://下载视频");
            m3U8Factory.build();

    }
}
