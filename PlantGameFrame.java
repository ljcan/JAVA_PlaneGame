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
     ArrayList  bulletlist=new ArrayList();     //������ʱû��
     Date startTime;
     Date endTime;
     int n=1;
     
      public void paint(Graphics g){
    	  g.drawImage(bg,0,0,null);
    	 p.draw(g);
    	 for(int i=0;i<30;i++){
    		 Bullet b=(Bullet)bulletlist.get(i);
    		 b.draw(g);
    		 //����ӵ���ɻ��Ƿ���ײ
    		 boolean peng=b.getRect().intersects(p.getRect());
    		 if(peng){
    			p.setLive(false);      //��������˷ɻ�����
    			if(n==1){            //ֻ����һ�ε�ʱ��
    			 endTime=new Date();
    			}
    			n=0;
    		 }
    	 }
    	 if(!p.isLive()){
    		
    		printinfo(g,"GAME OVER",100,80,300,Color.WHITE);
    		int period=(int)(endTime.getTime()-startTime.getTime())/1000;  //��Ϊ�Ǻ���
    		printinfo(g,"����ʱ�䣺"+period+"��",30,230,350,Color.YELLOW);
    		switch(period/10){
    		case 0:
    			printinfo(g,"����",30,280,400,Color.YELLOW);
    			break;
    		case 1:
    		case 2:
    		case 3:
    			printinfo(g,"���������ǲ���",30,280,400,Color.YELLOW);
    			break;
    		case 4:
    		case 5:
    		case 6:
    			printinfo(g,"���ϣ����а�",30,280,380,Color.YELLOW);
    			break;
    			default:
    				printinfo(g,"�����ˣ�����",30,280,400,Color.YELLOW);
    				break;
    		}
    	 }
    	//printinfo(g,"������100",20,50,100,Color.YELLOW);
      }
      /**
       *���ɻ�����ʱ�ڴ����ϴ�ӡ��Ϣ
       * @param g
       * @param str
       * @param size
       */
    	 public void printinfo(Graphics g,String str,int size,int x,int y,Color color){
    			Color c=g.getColor();
    			g.setColor(color);
    			Font f=new Font("����",Font.BOLD,size);
    			g.setFont(f);
    			g.drawString(str, x, y);
    			g.setColor(c);
    	 }
      //����˫����������˸
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
    	  //���Ӽ��̵ļ���
    	  addKeyListener(new KeyMonitor());
    	  //����һ���ӵ�
    	  for(int i=0;i<50;i++){
    		  Bullet b=new Bullet();
    		  bulletlist.add(b);
    	  }
    	  startTime=new Date();
      }
      //����һ�����ڲ��࣬�Ա���ʹ������������
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
