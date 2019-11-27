package com.controller;

import com.entity.UserInfo;
import com.service.UserInfoService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/tx")
public class TransactionController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(req.getServletContext());
        UserInfoService userInfoService = context.getBean(UserInfoService.class);
        Integer id = ServletRequestUtils.getIntParameter(req,"id",0);
        String name = ServletRequestUtils.getStringParameter(req,"name","test");
        userInfoService.deleteAndinsert(id,name);
        resp.getWriter().print("1");
    }
}
