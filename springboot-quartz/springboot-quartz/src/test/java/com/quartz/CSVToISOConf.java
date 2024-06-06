package com.quartz;

import java.util.Map;

/**
 * @className: CSVToISOConf
 * @description: TODO 类描述
 * @date: 2023/4/14
 **/
public class CSVToISOConf {
    private Map<String, String> refMap;
    private String[] group;
    private String targetSPath;
    private String sourcePath;
    private String sourceCharset;
    private String targetCharset;
    private boolean nameToCode = true;
    private  String[] shareTag;






    public String[] getShareTag() {
        return shareTag;
    }

    public CSVToISOConf setShareTag(String[] shareTag) {
        this.shareTag = shareTag;
        return this;
    }

    public Map<String, String> getRefMap() {
        return refMap;
    }

    public CSVToISOConf setRefMap(Map<String, String> refMap) {
        this.refMap = refMap;
        return this;
    }

    public String[] getGroup() {
        return group;
    }

    public CSVToISOConf setGroup(String[] group) {
        this.group = group;
        return this;
    }

    public String getTargetSPath() {
        return targetSPath;
    }

    public CSVToISOConf setTargetSPath(String targetSPath) {
        this.targetSPath = targetSPath;
        return this;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public CSVToISOConf setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
        return this;
    }

    public String getSourceCharset() {
        return sourceCharset;
    }

    public CSVToISOConf setSourceCharset(String sourceCharset) {
        this.sourceCharset = sourceCharset;
        return this;
    }

    public String getTargetCharset() {
        return targetCharset;
    }

    public CSVToISOConf setTargetCharset(String targetCharset) {
        this.targetCharset = targetCharset;
        return this;
    }

    public boolean isNameToCode() {
        return nameToCode;
    }

    public CSVToISOConf setNameToCode(boolean nameToCode) {
        this.nameToCode = nameToCode;
        return this;
    }
}
