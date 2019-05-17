package com.learn.ejb.servicelayer;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

@Stateless
@LocalBean
public class FirstDemoEjbService {
    
	@Inject
	private NormalBeanClass normalBeanClass;
	
    public FirstDemoEjbService() {
        
    }
    public void display(){
    	System.out.println(" display method called in FirstDemoEjbService :");
    	System.out.println("normalBeanClass:"+normalBeanClass);
    	normalBeanClass.display();
    }

}
