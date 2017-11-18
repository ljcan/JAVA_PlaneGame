package cn.just.play;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import cn.just.util.GameUtil;

public class plant extends GameObject{
	/* Image img;
	 double x,y;*/
	 private boolean left,up,right,down;
	 private boolean live=true;
	 double speed=15;
/*	 double speed=15;
	 int width,height;
	 public Rectangle getRect(){
		 return new Rectangle((int)x,(int)y,width,height);
		
	 }*/    //以封装为gameobject
	 public void draw(Graphics g){
		 if(live){
		 g.drawImage(img,(int)x,(int)y,null);
		 move();
		 }
	 }
	public plant(String imgpath, double x, double y) {
		super();
		this.img =GameUtil.getImage(imgpath);
		this.width=img.getWidth(null);
		this.height=img.getHeight(null);
		this.x = x;
		this.y = y;
	}
	 public plant(){
		 
	 }
	 
	 public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	//增加方向
	 public void addDirection(KeyEvent e){
			switch(e.getKeyCode()){
			case 37:
		      left=true;
			break;
			case 38:
			  up=true;
				break;
			case 39:
			  right=true;
				break;
			case 40:
			  down =true;
				break;
			default:
				break;
			}
	 }
	 //取消方向
	 public void minusDirection(KeyEvent e){
			switch(e.getKeyCode()){
			case 37:
		      left=false;
			break;
			case 38:
			  up=false;
				break;
			case 39:
			  right=false;
				break;
			case 40:
			  down =false;
				break;
			default:
				break;
			}
	 }
	 public void move(){
		 if(left)
		     x-=speed;
		 if(up)
			 y-=speed;
		 if(right)
			 x+=speed;
		 if(down)
			 y+=speed;
	 }
	 
}
