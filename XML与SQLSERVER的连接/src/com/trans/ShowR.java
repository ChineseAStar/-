package com.trans;

import java.awt.Desktop;  
import java.io.IOException;  
import java.net.URI;  
import java.net.URISyntaxException;  
    /** 
     * @author  毛兴宇 
     * @time    2013年9月14日  
     */  
public class ShowR{  
  
    public static void main(String[] args) { 
    	if(new HowToXSLT().trans())
    	{
    		//启用系统默认浏览器来打开网址。  
	        try {  
	        	//定义地址
	            URI uri = new URI("output.html");
	            //打开默认浏览器，显示
	            Desktop.getDesktop().browse(uri);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }
    	}
        
    }  
}  
