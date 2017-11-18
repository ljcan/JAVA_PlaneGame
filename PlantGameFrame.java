package cn.just.play;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.ArrayList;

import cn.just.util.Constant;
import cn.just.util.GameUtil;
import cn.just.util.MyFrame;

public class PlantGameFrame extends MyFrame{
	Image bg=GameUtil.getImage("image/solar.png");
     plant p=new plant("image/plant.jpg",50,50);
     ArrayList  bulletlist=new ArrayList();     //泛型暂时没加
     Date startTime;
     Date endTime;
     int n=1;
     
      public void paint(Graphics g){
    	  g.drawImage(bg,0,0,null);
    	 p.draw(g);
    	 for(int i=0;i<30;i++){
    		 Bullet b=(Bullet)bulletlist.get(i);
    		 b.draw(g);
    		 //检测子弹与飞机是否碰撞
    		 boolean peng=b.getRect().intersects(p.getRect());
    		 if(peng){
    			p.setLive(false);      //如果碰到了飞机死掉
    			if(n==1){            //只记碰一次的时间
    			 endTime=new Date();
    			}
    			n=0;
    		 }
    	 }
    	 if(!p.isLive()){
    		
    		printinfo(g,"GAME OVER",100,80,300,Color.WHITE);
    		int period=(int)(endTime.getTime()-startTime.getTime())/1000;  //因为是毫秒
    		printinfo(g,"生存时间："+period+"秒",30,230,350,Color.YELLOW);
    		switch(period/10){
    		case 0:
    			printinfo(g,"菜鸟",30,280,400,Color.YELLOW);
    			break;
    		case 1:
    		case 2:
    		case 3:
    			printinfo(g,"哈哈！还是菜鸟",30,280,400,Color.YELLOW);
    			break;
    		case 4:
    		case 5:
    		case 6:
    			printinfo(g,"哎呦！还行吧",30,280,380,Color.YELLOW);
    			break;
    			default:
    				printinfo(g,"厉害了！！！",30,280,400,Color.YELLOW);
    				break;
    		}
    	 }
    	//printinfo(g,"分数：100",20,50,100,Color.YELLOW);
      }
      /**
       *当飞机死亡时在窗口上打印信息
       * @param g
       * @param str
       * @param size
       */
    	 public void printinfo(Graphics g,String str,int size,int x,int y,Color color){
    			Color c=g.getColor();
    			g.setColor(color);
    			Font f=new Font("宋体",Font.BOLD,size);
    			g.setFont(f);
    			g.drawString(str, x, y);
    			g.setColor(c);
    	 }
      //利用双缓冲消除闪烁
    /*  private Image offScreenImage=null;
      public void update(Graphics g){
    	  if(offScreenImage==null)
    		  offScreenImage=this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
    	  Graphics goff=offScreenImage.getGraphics();
    	  paint(goff);
    	  g.drawImage(offScreenImage, 0, 0, null);
      }
      */
      
      
      
      
      public static void main(String[] args){
    	  new PlantGameFrame().launchFrame();
      }
      public void launchFrame(){
    	  super.launchFrame();
    	  //增加键盘的监听
    	  addKeyListener(new KeyMonitor());
    	  //生成一推子弹
    	  for(int i=0;i<50;i++){
    		  Bullet b=new Bullet();
    		  bulletlist.add(b);
    	  }
    	  startTime=new Date();
      }
      //定义一个人内部类，以便于使用这个类的属性
      class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
	     p.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
		    p.minusDirection(e);
		}

	
    	  
      }
}
