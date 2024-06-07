package com.example;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mbp.user.entity.User;
import com.example.mbp.user.mapper.LibraryOpacGeneralMapper;
import com.example.mbp.user.mapper.UserInfoMapper;
import com.example.mbp.world.mapper.LibAssetMapper;
import com.example.mbp.world.mapper.User2Mapper;
import com.flyread.lcs3.quarkus.context.Context;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.net.ContentHandler;
import java.util.Optional;

@Path("/hello")
@Transactional
public class ExampleResource {


    @Inject
    UserInfoMapper userInfoMapper;

    @Inject
    User2Mapper user2Mapper;

    @Inject
    LibAssetMapper libAssetMapper;

    @Inject
    LibraryOpacGeneralMapper libraryOpacGeneralMapper;

    @Inject
    Context context;

//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String hello() {
//        return "Hello from RESTEasy Reactive";
//    }

    @Path("/hello1")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello1() {
        return "66666";
    }
    @Path("/assetList")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String assetList() {
        System.err.println(context.getTenant());
        context.setTenant("demo");

//        libAssetMapper.list().forEach(System.err::println);
//        System.err.println(libAssetMapper.selectOne("600075202"));
        System.err.println( libraryOpacGeneralMapper.list());
        return "ok";
    }
    @Path("/hello2")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello2() {
        userInfoMapper.selectList(new QueryWrapper<>());

        return "6666666";
    }
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String add( User userInfo) {
//        UserInfoEntity entity = userInfoMapper.selectOne(new QueryWrapper<UserInfoEntity>()
//                .eq("phone", userInfo.getUsername())
//                .eq("is_del", 0));
//        userInfo.setCreateTime(new Date());
        System.out.println("Add");
//        userInfo.setIsDel(0);
        // 数据持久化
//        userInfoMapper.insert(userInfo);
        return "ok";
    }

}