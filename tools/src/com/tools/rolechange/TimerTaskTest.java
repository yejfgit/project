package com.tools.rolechange;

import java.io.IOException;
import java.util.Timer;

class MyTimerTask extends java.util.TimerTask{   
	 String info = "^_^";
	 final String[] ss = new String[]{"11","cancel","22","cancel"};
	static int i=0;
	public void run() {   
	  // TODO Auto-generated method stub   
	  System.out.println("start");  
	  info = ss[i++];
	}   
	public void setInfo(String text){
		info = text;
	}
	public String getInfo(){
		return info;
	}
}  

public class TimerTaskTest {   
	
	 static MyTimerTask myTask2 = new MyTimerTask(); 
	    public static void main(String[] args) { 
	        Timer timer = new Timer();
	        boolean cal = false;
	      
	      
	        timer.scheduleAtFixedRate(myTask2,2000, 5000); 
	       
	        while(true){
	        	
	        if(myTask2.getInfo().startsWith("cancel"))
        		myTask2.cancel();
	        }
	    }


}  


