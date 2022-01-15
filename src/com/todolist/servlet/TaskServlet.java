package com.todolist.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todolist.dao.TaskDao;
import com.todolist.entity.Task;

@WebServlet(name="TaskServlet", urlPatterns={"/task"})
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TaskDao taskDao;
	
	public TaskServlet() {
        super();
        taskDao = new TaskDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long connectedUserId = (Long) request.getSession().getAttribute("id");
		List<Task> tasks = taskDao.getAllByUser(connectedUserId);
		request.setAttribute("tasks", tasks);
		this.getServletContext().getRequestDispatcher("/WEB-INF/task.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if("create".equals(action)) {
			Task task = new Task(request.getParameter("name"), false, (Long) request.getSession().getAttribute("id"));
			taskDao.save(task);
		} else if ("delete".equals(action)) {
			Long idTask = Long.parseLong(request.getParameter("id"));
			taskDao.delete(idTask);
		} else if ("checked".equals(action)) {
			taskDao.checked(Long.parseLong(request.getParameter("id")));
		}
		
		response.sendRedirect(request.getContextPath() + "/task");
	}
}
