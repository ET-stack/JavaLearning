package com.xiao;/**
 * Created by 小飞 on 2019/8/3.
 */

import com.xiao.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Auther: 小飞
 * @Date: 2019/8/3 00:00
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class UserControllerTest {
    private MockMvc mock;

    @Before
    public void setUp() {
        mock = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testUserController() throws Exception {
        //测试UserController
        RequestBuilder requestBuilder = null;
        //用get查看一下列表
        requestBuilder = get("/users/");
        mock.perform(requestBuilder).andExpect(status().isOk())
                .andExpect((ResultMatcher) content().string(equalTo("[]")));
    }
}
