package com.reptile.douban.chengdu;

/**
 * @className: blindDataListVo
 * @description: TODO 类描述
 * @author:相亲列表对象
 * @date: 2022/12/9
 **/
public class blindDataListVo {
    String title;

    String titleURL;
    String author;

    String authorUrl;
    String rCount;
    String rTime;

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }


    public blindDataListVo(String title, String titleURL, String author, String authorUrl, String rCount, String rTime) {
        this.title = title;
        this.titleURL = titleURL;
        this.author = author;
        this.authorUrl = authorUrl;
        this.rCount = rCount;
        this.rTime = rTime;
    }

    public String getTitleURL() {
        return titleURL;
    }

    public void setTitleURL(String titleURL) {
        this.titleURL = titleURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getrCount() {
        return rCount;
    }

    public void setrCount(String rCount) {
        this.rCount = rCount;
    }

    public String getrTime() {
        return rTime;
    }

    public void setrTime(String rTime) {
        this.rTime = rTime;
    }

    @Override
    public String toString() {
        return "blindDataListVo{" +
                "title='" + title + '\'' +
                ", titleURL='" + titleURL + '\'' +
                ", author='" + author + '\'' +
                ", authorUrl='" + authorUrl + '\'' +
                ", rCount='" + rCount + '\'' +
                ", rTime='" + rTime + '\'' +
                '}';
    }
}
