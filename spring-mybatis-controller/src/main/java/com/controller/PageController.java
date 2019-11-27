package com.controller;

import com.entity.UserInfo;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.service.UserInfoService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class PageController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(req.getServletContext());
        UserInfoService userInfoService = context.getBean(UserInfoService.class);
        Integer pageNum = ServletRequestUtils.getIntParameter(req,"pageNum",1);
        Integer pageSize = ServletRequestUtils.getIntParameter(req,"pageSize",3);
        List<UserInfo> userInfos = userInfoService.getAll(pageNum, pageSize);
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userInfos,5);
        //req.setAttribute("pageInfo",pageInfo);
        //req.getRequestDispatcher("index.jsp").forward(req,resp);
        Gson gson = new Gson();
        resp.getWriter().write(gson.toJson(pageInfo));

    }
}
