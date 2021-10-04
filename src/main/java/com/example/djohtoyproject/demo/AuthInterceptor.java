package com.example.djohtoyproject.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("###### Custom Annotation Interceptor ######");
            Enumeration<String> names = request.getParameterNames();
            while (names.hasMoreElements()) {
                String getparam = names.nextElement();
                System.out.println("getparam = " + getparam);
                String value = request.getParameter(getparam);
                if (value.contains("../")) {
                    log.info("Intercept Before Filter ---->" + value);
                    response.sendError(403,"path traversal");
                    return false;
                }
        }

        return true;
    }
}
