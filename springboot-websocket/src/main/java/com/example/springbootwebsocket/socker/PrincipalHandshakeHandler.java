package com.example.springbootwebsocket.socker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Map;
/**
 * @author Yi
 * @date 2020/6/15 11:41
 */


/**
 * 我们可以通过请求信息，比如token、或者session判用户是否可以连接，这样就能够防范非法用户
 */
@Slf4j
@Component
public class PrincipalHandshakeHandler extends DefaultHandshakeHandler {
    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        /**
         * 这边可以按你的需求，如何获取唯一的值，既unicode
         * 得到的值，会在监听处理连接的属性中，既WebSocketSession.getPrincipal().getName()
         * 也可以自己实现Principal()
         */
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletServerHttpRequest = (ServletServerHttpRequest) request;
            HttpServletRequest httpRequest = servletServerHttpRequest.getServletRequest();
            /**
             * 这边就获取你最熟悉的陌生人,携带参数，你可以cookie，请求头，或者url携带，这边我采用url携带
             */
            final String token = httpRequest.getParameter("token");
            if (StringUtils.isEmpty(token)) {
                return null;
            }
            return new Principal() {
                @Override
                public String getName() {
                    return token;
                }
            };
        }
        return null;
    }
}


