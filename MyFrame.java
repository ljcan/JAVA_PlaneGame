package cn.just.util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame{
	/**
	 * 加载窗口
	 */
     public void launchFrame(){
    	 setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
    	 setLocation(100,100);
    	 setVisible(true);
    	 new PaintThread().start();
    	 addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
    		 
    	 });
     }
     //利用双缓冲消除闪烁
     private Image offScreenImage=null;
     public void update(Graphics g){
   	  if(offScreenImage==null)
   		  offScreenImage=this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
   	  Graphics goff=offScreenImage.getGraphics();
   	  paint(goff);
   	  g.drawImage(offScreenImage, 0, 0, null);
     }
	 /**
	  * 定义一个重画窗口的线程类，是一个内部类
	  * @author 刘军强
	  *
	  */
	 class PaintThread extends Thread{
		 public void run(){
			 while(true){
				 repaint();
				 try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 }
		 }
	 }


}
