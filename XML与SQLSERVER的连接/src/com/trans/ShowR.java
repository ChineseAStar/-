package com.trans;

import java.awt.Desktop;  
import java.io.IOException;  
import java.net.URI;  
import java.net.URISyntaxException;  
    /** 
     * @author  ë���� 
     * @time    2013��9��14��  
     */  
public class ShowR{  
  
    public static void main(String[] args) { 
    	if(new HowToXSLT().trans())
    	{
    		//����ϵͳĬ�������������ַ��  
	        try {  
	        	//�����ַ
	            URI uri = new URI("output.html");
	            //��Ĭ�����������ʾ
	            Desktop.getDesktop().browse(uri);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }
    	}
        
    }  
}  
