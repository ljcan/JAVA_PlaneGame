package cn.just.util;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * ��Ϸ�����е�һЩ����
 * @author Shinelon
 *
 */
public class GameUtil {
	public GameUtil(){}
	//����ͼƬ
   public static Image getImage(String path){
	   BufferedImage bi=null;
	   try {
		   URL u=GameUtil.class.getClassLoader().getResource(path);
		 bi=ImageIO.read(u);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return bi;
	   
   }
}
