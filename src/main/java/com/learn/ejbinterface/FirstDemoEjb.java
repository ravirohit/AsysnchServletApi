package com.learn.ejbinterface;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.learn.ejb.servicelayer.FirstDemoEjbService;

@Stateless
public class FirstDemoEjb implements FirstDemoEjbRemote {

	@EJB  // can be used @Inject also
	FirstDemoEjbService firstDemoEjbService;
	
    public FirstDemoEjb() {
       
    }

	@Override
	public String testDemo(String str) {
       System.out.println("Ejb tesetDemo has been invoked...:-"+str);
       System.out.println("service intance:"+firstDemoEjbService);
      // firstDemoEjbService.display();
		return "value returned from testDemo Ejb method";
	}

}
