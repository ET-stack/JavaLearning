package com.quartz;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @className: b
 * @description: TODO 类描述
 * @date: 2023/4/17
 **/
public class b {
    public static void main(String[] args) throws JsonProcessingException {
        String s1 = "{\\\"sourceCharset\\\":\\\"UTF-8\\\",\\\"group\\\":[\\\"ISBN\\\",\\\"书籍名称\\\"],\\\"refMap\\\":{\\\"ISBN\\\":\\\"010[0].a[0]\\\",\\\"图书价格\\\":\\\"010[0].d[0]\\\",\\\"书籍名称\\\":\\\"200[0].a[0]\\\",\\\"作者\\\":\\\"200[0].f[0]\\\",\\\"出版社\\\":\\\"210[0].c[0]\\\",\\\"出版时间\\\":\\\"210[0].d[0]\\\",\\\"书籍开本\\\":\\\"215[0].d[0]\\\",\\\"中图法分类\\\":\\\"690[0].a[0]\\\",\\\"书籍资产编号\\\":\\\"905[0].a[0]\\\"},\\\"isoConf\\\":{\\\"assets\\\":{\\\"905\\\":{\\\"a\\\":\\\"no\\\",\\\"e\\\":\\\"callNo\\\",\\\"h\\\":\\\"price\\\"}},\\\"tmpImpConf\\\":{\\\"ctrlDefaultStatus\\\":\\\"active\\\",\\\"orgId\\\":\\\"001\\\",\\\"assetDefaultStatus\\\":\\\"COLL_IN\\\",\\\"defDupStatus\\\":\\\"single\\\",\\\"marcCharset\\\":\\\"GBK\\\"}}}";
        ObjectMapper objectMapper = new ObjectMapper();
        CSVToISOConf csvToISOConf = objectMapper.readValue(s1, CSVToISOConf.class);
        System.out.println(csvToISOConf);
    }
}
