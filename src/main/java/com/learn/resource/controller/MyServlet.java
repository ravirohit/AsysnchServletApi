package com.learn.resource.controller;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static private AtomicInteger a = new AtomicInteger(0);

    public MyServlet() {
       
    }

	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("################ waiting time started:");
			//Thread.sleep(20000);
			System.out.println("-------- waiting time completed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().append("#############Method get called : ");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
