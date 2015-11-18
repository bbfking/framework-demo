package com.pfxiong.frameworkweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 显示客户基本信息
 */
@WebServlet("/customer_show")
public class CustomerShowServlet extends HttpServlet {

    private static final long serialVersionUID = -4937555947860488931L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO
    }
}
