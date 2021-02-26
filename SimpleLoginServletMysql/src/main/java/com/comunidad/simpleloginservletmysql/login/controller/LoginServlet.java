package com.comunidad.simpleloginservletmysql.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.comunidad.simpleloginservletmysql.login.dao.vo.LoginVo;
import com.comunidad.simpleloginservletmysql.login.service.LoginService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1355303364010209814L;

	private LoginService loginService;

	public void init() {
		loginService = new LoginService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginVo loginVo = new LoginVo();
		loginVo.setUsername(username);
		loginVo.setPassword(password);

		try {
			if (loginService.buscar(loginVo)!=0) {
				response.sendRedirect("loginsuccess.jsp");
			} else {
				HttpSession session = request.getSession();
				response.sendRedirect("loginerror.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace(System.out);
		}catch (Exception ex) {
			ex.printStackTrace(System.out);
		}
	}
}
