package com.store.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IndexServlet extends BaseServlet {


	public String index(HttpServletRequest request, HttpServletResponse response) {
		//去数据库查询最新商品和最热商品，将他们放入request域中，请求转发
		return "/jsp/index.jsp";
	}
   

}
