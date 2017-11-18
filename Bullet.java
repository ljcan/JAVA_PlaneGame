package cn.just.play;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import cn.just.util.Constant;

public class Bullet extends GameObject{
 /*  double x,y;
   int speed=3;*/
   double degree;
   double speed=5;
/*   int width=10;
   int height=10;*/
   public Bullet(){
	   degree=Math.random()*Math.PI*2;
	   x=Constant.GAME_WIDTH/2;
	   y=Constant.GAME_HEIGHT/2;
	   width=10;
	   height=10;
   }
   
/*	 public Rectangle getRect(){
		 return new Rectangle((int)x,(int)y,width,height);
		 
	 }*/
   
   public void draw(Graphics g){
	   Color c=g.getColor();
	   g.setColor(Color.yellow);
	   g.fillOval((int)x,(int)y, width, height);
	   x+=speed*Math.cos(degree);
	   y+=speed*Math.sin(degree);
	   if(y>Constant.GAME_HEIGHT-height||y<30)
		   degree=-degree;
	   if(x>Constant.GAME_WIDTH-width||x<width)
		   degree=Math.PI-degree;
	   g.setColor(c);
   }
   
   
   
   
   
   
}
