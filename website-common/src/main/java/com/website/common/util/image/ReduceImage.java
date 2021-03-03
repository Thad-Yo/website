package com.website.common.util.image;
  
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferedImage;  
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;


public class ReduceImage {   
	/**
	 * 
	 * @param originalFilePath 源文件路径
	 * @param resizedFilePath  压缩后文件路径
	 * @param scale 宽高比例
	 * @param quality 质量比例
	 * @throws IOException
	 */
	public static void resize(String originalFilePath, String resizedFilePath,double scale, float quality) throws IOException {
		File originalFile = new File(originalFilePath);
		File resizedFile = new File(resizedFilePath);
	    ImageIcon ii = new ImageIcon(originalFile.getCanonicalPath());    
	    Image i = ii.getImage();    
	    int iWidth = (int) (i.getWidth(null)*scale);    
	    int iHeight = (int) (i.getHeight(null)*scale);   
	    //在这你可以自定义 返回图片的大小 iWidth iHeight  
	    Image resizedImage = i.getScaledInstance(iWidth,iHeight, Image.SCALE_SMOOTH);    
	    // 获取图片中的所有像素  
	    Image temp = new ImageIcon(resizedImage).getImage();
	    // 创建缓冲  
	    
	    Image src=Toolkit.getDefaultToolkit().getImage(originalFilePath);  
	    BufferedImage bufferedImage=toBufferedImage(src);//Image to BufferedImage  
	    
	    // 复制图片到缓冲流中  
	    Graphics g = bufferedImage.createGraphics();    
	    // 清除背景并开始画图  
	    g.setColor(Color.white);
	    g.fillRect(0, 0, temp.getWidth(null), temp.getHeight(null));    
	    g.drawImage(temp, 0, 0, null);
	    g.dispose();  
	    // 柔和图片.    
	    float softenFactor =0.05f;    
	    float[] softenArray = { 0, softenFactor, 0, softenFactor,    
	            1 - (softenFactor * 4), softenFactor, 0, softenFactor, 0 };    
	    Kernel kernel = new Kernel(3, 3, softenArray);    
	    ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);    
	    bufferedImage = cOp.filter(bufferedImage, null);    
	    FileOutputStream out = new FileOutputStream(resizedFile);    
	    JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
	    JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bufferedImage);
	    param.setQuality(quality, true);    
	    encoder.setJPEGEncodeParam(param);    
	    encoder.encode(bufferedImage);  
	    bufferedImage.flush();  
	    out.close();  
	} 
public static BufferedImage toBufferedImage(Image image) {  
       if (image instanceof BufferedImage) {  
           return (BufferedImage) image;  
       }  
       // This code ensures that all the pixels in the image are loaded  
       image = new ImageIcon(image).getImage();  
       BufferedImage bimage = null;  
       GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();  
       try {  
           int transparency = Transparency.OPAQUE;  
           GraphicsDevice gs = ge.getDefaultScreenDevice();  
           GraphicsConfiguration gc = gs.getDefaultConfiguration();  
           bimage = gc.createCompatibleImage(image.getWidth(null),  
                   image.getHeight(null), transparency);  
       } catch (HeadlessException e) {  
           // The system does not have a screen  
       }  
       if (bimage == null) {  
           // Create a buffered image using the default color model  
           int type = BufferedImage.TYPE_INT_RGB;  
           bimage = new BufferedImage(image.getWidth(null),  
                   image.getHeight(null), type);  
       }  
       // Copy image to buffered image  
       Graphics g = bimage.createGraphics();  
       // Paint the image onto the buffered image  
       g.drawImage(image, 0, 0, null);  
       g.dispose();  
       return bimage;  
    }

public static void main(String[]arg){
	try {
		File file1 = new File("F:\\phone\\皂波球.jpg");
		File file2 = new File("F:\\phone\\123.png");
		resize("D:/websiteData/uploadFiles/attachments/banner/20180713150443_136.jpg","D:\\work\\doc\\联信\\photo\\123.jpg",1d, 0.2f);
		System.out.println("123");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}  