package com.in6k.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.in6k.form.EmployeeForm;

import java.io.IOException;

public class EditListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EmployeeForm ef = new EmployeeForm();
   	 
    	ef.setName(request.getParameter("name"));
    	ef.setLastName(request.getParameter("lastName"));
		ef.setEmail(request.getParameter("email"));
		ef.setBirthDate(request.getParameter("birthDate"));
		
		request.setAttribute("form", ef);

        request.getRequestDispatcher("/employeeform.jsp").include(request, response);
    }
}
