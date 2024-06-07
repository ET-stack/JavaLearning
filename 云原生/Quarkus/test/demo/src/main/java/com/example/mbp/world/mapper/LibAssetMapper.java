package com.example.mbp.world.mapper;

import io.quarkiverse.mybatis.runtime.meta.MapperDataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @className: LibAssetMapper
 * @description: TODO 类描述
 * @author: {yitao@flyread.com.cn}
 * @date: 2022/9/7
 **/
@Mapper
public interface LibAssetMapper {
    @Select("SELECT asset_id as assetId FROM ${_lcs2}.lib_asset")
    List<LibAsset> list();


    @Results(value = {
            @Result(property = "assetId", column = "asset_id"),
            @Result(property = "assetNo", column = "asset_no"),
            @Result(property = "barcode", column = "barcode"),
            @Result(property = "ctrlId", column = "ctrl_id"),
            @Result(property = "orgId", column = "org_id"),
            @Result(property = "callNo", column = "call_no"),
            @Result(property = "volume", column = "volume"),
            @Result(property = "bindery", column = "bindery"),
            @Result(property = "price", column = "price"),
            @Result(property = "priceVal", column = "price_val"),
            @Result(property = "edition", column = "edition"),
            @Result(property = "status", column = "status"),
            @Result(property = "prop0", column = "prop0"),
            @Result(property = "prop1", column = "prop1"),
            @Result(property = "prop2", column = "prop2"),
            @Result(property = "prop3", column = "prop3"),
            @Result(property = "callNo0", column = "call_no0"),
            @Result(property = "callNo1", column = "call_no1"),
            @Result(property = "callNo2", column = "call_no2"),
            @Result(property = "callNo3", column = "call_no3"),
            @Result(property = "sourceId", column = "source_id"),
            @Result(property = "sourceType", column = "source_type"),
            @Result(property = "loanTimes", column = "loan_times"),
            @Result(property = "errMsg", column = "err_msg"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "createUser", column = "create_user"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "updateUser", column = "update_user"),
            @Result(property = "specCode", column = "spec_code"),
            @Result(property = "faker", column = "faker")
    })
    @Select(value = "select asset_id as assetId from ${_lcs2}.lib_asset where asset_id= #{queryParam} ")
    LibAsset selectOne(String queryParam);

}
