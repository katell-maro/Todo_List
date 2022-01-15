package com.todolist.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.todolist.dao.UserDao;
import com.todolist.entity.User;

@WebServlet(name="UserServlet", urlPatterns={"/user"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao;
	
	public UserServlet() {
		super();
		this.userDao = new UserDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = userDao.getByLogin(request.getParameter("login"));
		
		this.openSession(user, request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setLogin(request.getParameter("login"));
		user = userDao.save(user);
		
		this.openSession(user, request, response);
	}
	
	private void openSession(User user, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("id", user.getId());
		session.setAttribute("login", user.getLogin());
		
		response.sendRedirect(request.getContextPath() + "/task");
	}
}