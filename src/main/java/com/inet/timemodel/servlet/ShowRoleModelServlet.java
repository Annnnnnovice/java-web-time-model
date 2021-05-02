package com.inet.timemodel.servlet;

import com.inet.timemodel.domain.RoleModel;
import com.inet.timemodel.service.RoleModelService;
import com.inet.timemodel.service.impl.RoleModelServiceImpl;
import com.inet.timemodel.utils.JsonUtils;
import com.sun.org.apache.bcel.internal.generic.IFNE;
import jdk.nashorn.internal.ir.IfNode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet(value = "/ShowRoleModelServlet")
public class ShowRoleModelServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置输出编码
        response.setContentType("text/json;charset=utf-8");
        //创建roleModelService服务层
        RoleModelService roleModelService = new RoleModelServiceImpl();
        //调用查询的方法
        List<RoleModel> list = roleModelService.getRoleModel();
        //变成JSON字符串
        String json = JsonUtils.objectToJson(list);
        //输出到权限
        response.getWriter().print(json);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
