package com.example.mbp.user.mapper;

import com.example.mbp.user.entity.LibraryOpacGeneral;
import io.quarkiverse.mybatis.runtime.meta.MapperDataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @className: LibraryOpacGeneralMapper
 * @description: TODO 类描述
 * @author: {yitao@flyread.com.cn}
 * @date: 2022/9/7
 **/
@Mapper
public interface LibraryOpacGeneralMapper {

    @Select("<script>SELECT * FROM ${_lcs1}.library_opac_general WHERE "
            + "<if test = 'subhead != null'> subhead = #{subhead} ,</if>"
            + "<if test = 'content != null'> content = #{content} ,</if>"
            +" </script>")
     List<LibraryOpacGeneral> query(String id);

    @Select("<script>SELECT ctrl_no as ctrlNo FROM ${_lcs1}.library_opac_general </script>")
    List<LibraryOpacGeneral> list();
}
