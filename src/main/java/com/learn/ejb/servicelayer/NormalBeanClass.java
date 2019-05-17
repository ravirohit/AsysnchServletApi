package com.learn.ejb.servicelayer;

import javax.inject.Named;


public class NormalBeanClass {
   public void display(){
	   System.out.println("NormalBeanClass method get called after injecting using @Inject:");
   }
}
