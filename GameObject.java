package cn.just.play;

import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
	 Image img;
	 double x,y;
	 int width,height;
	 public Rectangle getRect(){
		 return new Rectangle((int)x,(int)y,width,height);
		
	 }
	public GameObject(Image img, double x, double y, int width, int height) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	 public GameObject(){
		 
	 }
	 
	 
	 
	 
}
