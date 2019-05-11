package com.learn.resource.asynccontroller;

import java.io.IOException;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.AsyncContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="myasyncservlet", urlPatterns={"/myasyncservlet"}, asyncSupported=true)
public class MyAsyncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private  static AtomicInteger a = new AtomicInteger(0);
    public MyAsyncServlet() {
        super();
    }
	public void init(ServletConfig config) throws ServletException {
	}

	// response going from doGet method is:
	// async servlet called:1 >>> current thread:default task-60
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get method get called:"+Thread.currentThread().getName());
        ServletContext appScope = request.getServletContext();
        //((Queue<AsyncContext>)appScope.getAttribute("slowWebServiceJobQueue")).add(aCtx);
        final AsyncContext acontext = request.startAsync();   // <async-supported>true</async-supported> in web.xml
        if(a.get() == 0)
        System.out.println("timeoug value:"+acontext.getTimeout()); // by default value is 30000...
        acontext.setTimeout(7000);   // Period of time for which request will be hold and release the sever thread 
        acontext.start(new Runnable() {
            public void run() {
             //  String param = acontext.getRequest().getParameter("param");
               try {
	       			//System.out.println("waiting time started:"+"     ----  "+a.getAndIncrement());
	       			Thread.sleep(6000);   // How long can this wait.. if we put this value very high... it will throw internal server error.
	       			System.out.println("waiting time completed:"+Thread.currentThread().getName());
	                /*Random rn = new Random();
	                Thread.sleep(rn.nextInt(10000));*/
	       			acontext.getResponse().getWriter().append(" >>> current thread:"+Thread.currentThread().getName());
	               // acontext.complete();	   // Internal Server Error
	       			acontext.complete();
               } catch (Exception e) {
          			e.printStackTrace();
          		}
            }
      });
		
		//System.out.println("-------- service side response:"+Thread.currentThread().getName()+"\n");
		response.getWriter().append("async servlet called:"+Thread.currentThread().getName());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
