package com.in6k.servlet;

import java.io.*;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.in6k.domain.EmployeeModel;
import com.in6k.form.EmployeeForm;
import com.in6k.persistence.ProviderFactory;

public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Collection<EmployeeModel> employeeList;
    	
    	employeeList = (new EmployeeModel(ProviderFactory.ProviderType.XML)).load();
    	
    	request.setAttribute("employers", employeeList.toArray());
    	request.setAttribute("size", employeeList.size());
    	
    	request.getRequestDispatcher("./List.jsp").include(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	EmployeeForm ef = new EmployeeForm();
	    	 
    	ef.setName(request.getParameter("name"));
    	ef.setLastName(request.getParameter("lastName"));
		ef.setEmail(request.getParameter("email"));
		ef.setPassword(request.getParameter("password"));
		ef.setPasswordConfirmation(request.getParameter("passwordConfirmation"));
		ef.setBirthDate(request.getParameter("birthDate"));

        List<String> errors = ef.validate();
        boolean HAS_ERROR = errors.size() > 0;

        if (HAS_ERROR) {
            request.setAttribute("form", ef);
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("/employeeform.jsp").include(request, response);
            return;
        }

        EmployeeModel em = new EmployeeModel(ef, ProviderFactory.ProviderType.XML);
        em.save();

        request.getRequestDispatcher("./success.jsp").forward(request, response);
    }

    

}
