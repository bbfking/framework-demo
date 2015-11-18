package com.pfxiong.frameworkweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 删除客户
 */
@WebServlet("/customer_delete")
public class CustomerDeleteServlet extends HttpServlet {

    private static final long serialVersionUID = -3237223906644045804L;

    /**
     * 处理 删除客户 请求
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO
    }
}
