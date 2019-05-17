package com.learn.ejbinterface;

import javax.ejb.Remote;

@Remote
public interface FirstDemoEjbRemote {
	
	public String testDemo(String str);

}
