package AnalogClock;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
 

public  class Clock extends Applet implements Runnable{

	public void init(){
		Timer timer = new Timer();
		 timer.schedule(new TimerTask(){public void run(){
			 
			 
			 repaint();
		 }}, 0, 1000);
		
	}
	
	int theta;
	double r;
	int  x1,y1,x2,y2;
	
	public void paint(Graphics g){
		setBackground(Color.WHITE);
		g.setColor(Color.blue);
		g.drawOval(0, 0, 200, 200);
		theta = 0;
		while(theta<=360){
			r= Math.toRadians(theta);
			x1 = (int) ((int)100*Math.sin(r));
			y1 = (int) ((int)100*Math.cos(r));
			
			x2 = (int) ((int)80*Math.sin(r));
			y2 = (int) ((int)80*Math.cos(r));
			
			g.drawLine((int)100+x1,(int)100+y1,(int)100+x2, (int)100+y2);		
			theta = theta+30;
		}
			theta=0; 
		while(theta<=360){
			r= Math.toRadians(theta);
			x1 = (int) ((int)100*Math.sin(r));
			y1 = (int) ((int)100*Math.cos(r));
			
			x2 = (int) ((int)95*Math.sin(r));
			y2 = (int) ((int)95*Math.cos(r));
			
			g.drawLine((int)100+x1,(int)100+y1,(int)100+x2, (int)100+y2);		
			theta = theta+6;
		}
		
	    Date time = new Date();
		int hours = time.getHours();
		int minute= time.getMinutes();
		int second= time.getSeconds();
	
		g.setColor(Color.black);
		g.drawString(hours+":"+minute+":"+second, 250, 50);
		g.setColor(Color.magenta);
		double theta = Math.PI* second/60*2;
		x1 =(int) (100+77*Math.sin(theta));
		y1 =(int) (100-77*Math.cos(theta));
		g.drawLine(100, 100, (int)x1, (int)y1);
		g.setColor(Color.RED);
		double theta1 = Math.PI* minute/60*2;
		x1 =(int) (100+62*Math.sin(theta1));
		y1 =(int) (100-62*Math.cos(theta1));
		g.drawLine(100, 100, (int)x1, (int)y1);
		 
		g.setColor(Color.green);
		double theta2 = Math.PI*  hours/12*2; ;
		x1 =(int) (100+50*Math.sin(theta2));
		y1 =(int) (100-50*Math.cos(theta2));
		g.drawLine(100, 100, (int)x1, (int)y1);
		
		
		
		
		
	}
	@Override
	public void run() {
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
