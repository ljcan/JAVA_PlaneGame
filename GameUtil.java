package cn.just.util;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * 游戏开发中的一些工具
 * @author Shinelon
 *
 */
public class GameUtil {
	public GameUtil(){}
	//加载图片
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
