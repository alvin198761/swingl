/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.luna.swingl.messagetext;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.swing.ImageIcon;

/**
 *
 * @author tangzhichao
 */
public class JIMHistoryTextPane extends JIMSendTextPane {

	private ConcurrentLinkedQueue<Message> messageConcurrentLinkedQueue;
	private Color otherMessageColor = new Color(188, 237, 245);
	private Color otherMessageBorderColor = new Color(156, 205, 213);
	private Color selfMessageColor = new Color(230, 230, 230);
	private Color selfMessageBorderColor = new Color(198, 198, 198);

	
	private Color textColor = new Color(0, 0, 0);

	
	private List<String> strList = new ArrayList();
	/**
	 * 段落
	 */
	private int mindex = 0;//(标记：记载消息段落的坐标，超过最大值会报错)
	
	public JIMHistoryTextPane() {
		setEditable(false); // 用于显示历史消息，因此必须为只读模式，不允许用户修改内容
		setOpaque(false); // 设置成背景透明后，完全自绘才会看到效果
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // 执行默认组件绘制（消息文本、图片以及段落显示等内容）
		Graphics2D g2D = (Graphics2D) g;
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // 反锯齿平滑绘制

		// 通过对并发消息链表遍历绘制全部消息气泡、消息发出者头像
	
		if (messageConcurrentLinkedQueue != null) {
			Iterator<Message> iterator = messageConcurrentLinkedQueue.iterator();
			int topGap = 10;

			int screenWidth = (int) (this.getWidth() * 0.8)-40;

			while (iterator.hasNext()) {
				
				Message message = iterator.next();
//				Image image = new ImageIcon(this.getClass().getResource("/com/test/image/下载.jpg")).getImage();
				
				Point point = message.getMessagePaintLeftTop();//获取定点位置（0,0）
				if (point != null) {
					topGap += point.y;
					
					// 绘制额消息气泡左边小箭头
					int xPoints[] = new int[3];
					int yPoints[] = new int[3];
					int messageWidth = this.getWidth()/2;
					int messageHeight = 30;
					if (message.isSelf()) {

		                 /**
		                  * 绘制头像
		                  */
						 Image image = getHeadImageIcon(message.getHandimage(), 40, 40).getImage();
						 g2D.drawImage(image, this.getWidth() - image.getWidth(null) - 9, topGap - 40, null);  
						 Image image2 = getHeadImageIcon("/com/test/image/头像背景@2x(1).png", 40, 40).getImage();
						 g2D.drawImage(image2, this.getWidth() - image.getWidth(null) - 9, topGap - 40, null); 
						 
						 
						  if(message.getName()!=null&&!message.getName().equals("")){
						 g2D.setColor(textColor);
						 int usernamelenth =  (int) getFontSize(g2D, g2D.getFont(), message.getName());
						 int usernameHeight =  (int) getFontHeight(g2D, g2D.getFont());
						 g2D.drawString(message.getName(), this.getWidth() - image.getWidth(null) - 53, topGap-10);
						  }
						 
						 
						/**
						 * 绘制右边文字消息
						 */
						 mindex = topGap;
						if(message.getContent()!=null&&!message.getContent().equals("")){
						messageWidth = (int) getFontSize(g2D, g2D.getFont(), message.getContent());
						messageHeight = (int) getFontHeight(g2D, g2D.getFont());

						int one = messageWidth / message.getContent().length();
//                        System.out.println(one);
						int total = screenWidth / one;

						
						
						getStringList(message.getContent(), total);
						int size = 1;
						size = strList.size();
						if (size == 0) {
							size = 1;
						}
						
						if (messageWidth > screenWidth) {
							messageWidth = screenWidth;
						}
						
						g2D.setColor(selfMessageColor);
						g2D.fillRoundRect(getWidth() - messageWidth - 65, topGap, messageWidth+10, (messageHeight +5) *size  + 14,
								10, 10);
						// 绘制圆角消息气泡边框
						g2D.setColor(selfMessageBorderColor);
						g2D.drawRoundRect(getWidth() - messageWidth -65, topGap, messageWidth+10, (messageHeight +5) *size  + 14,
								10, 10);
                       
						g2D.setColor(textColor);
						if (strList.size()  < 1) {
							g2D.drawString(message.getContent(), getWidth() - messageWidth - 62, topGap + 17);
						
						}else{
							for (int i = 0; i < strList.size(); i++) {
								g2D.drawString(strList.get(i), getWidth() - messageWidth -62, topGap + 17);
								topGap += messageHeight+5;
							}
						}
						}
						
						
					 /**
					  * 绘制图片
					  */
						if(message.getImage()!=null){
	
							messageWidth = message.getImage().getIconWidth();
							messageHeight = message.getImage().getIconHeight();
							
							g2D.setColor(selfMessageColor);
							g2D.fillRoundRect(getWidth() - messageWidth - 65, topGap, messageWidth+10, messageHeight  + 10,
									10, 10);
//							 绘制圆角消息气泡边框
							g2D.setColor(selfMessageBorderColor);
							g2D.drawRoundRect(getWidth() - messageWidth -65, topGap, messageWidth+10, messageHeight + 10,
									10, 10);
							
							g2D.drawImage(message.getImage().getImage(), getWidth() - messageWidth -60,  topGap+6, null); 
						}
						
						xPoints[0] = getWidth() - 55;
						yPoints[0] = mindex+7;
						xPoints[1] = xPoints[0] + 7;
						yPoints[1] = mindex+7;
						xPoints[2] = xPoints[0];
						yPoints[2] = mindex + 14;

					
						
						g2D.setColor(selfMessageColor);
						g2D.fillPolygon(xPoints, yPoints, 3);
						g2D.setColor(selfMessageBorderColor);
						g2D.drawPolyline(xPoints, yPoints, 3);
						g2D.setColor(selfMessageColor);
						
						g2D.drawLine(xPoints[0], yPoints[0] + 1, xPoints[2], yPoints[2] - 1);//画气泡框
						mindex = 0;
					} else {
						/**
						 * 头像的绘制
						 */
				     	Image image = getHeadImageIcon(message.getHandimage(), 40, 40).getImage();
		                 g2D.drawImage(image, 9,  topGap - 30, null); 
		       			 Image image2 = getHeadImageIcon("/com/test/image/头像背景@2x(1).png", 40, 40).getImage();
						 g2D.drawImage(image2, 9,  topGap - 30, null);  
						 
		                 if(message.getName()!=null&&!message.getName().equals("")){
		    				 g2D.setColor(textColor);
							 int usernamelenth =  (int) getFontSize(g2D, g2D.getFont(), message.getName());
							 int usernameHeight =  (int) getFontHeight(g2D, g2D.getFont());
							 g2D.drawString(message.getName(), 53, topGap-10);
		                 }
						 
						/**
						 * 绘制文本消息
						 */
						 mindex = topGap;
                        if(message.getContent()!=null&&!message.getContent().equals("")){
						messageWidth = (int) getFontSize(g2D, g2D.getFont(), message.getContent());
						messageHeight = (int) getFontHeight(g2D, g2D.getFont());

						int one = messageWidth / message.getContent().length();
//                        System.out.println(one);
						int total = screenWidth / one;

						
						
						getStringList(message.getContent(), total);
						int size = 1;
						size = strList.size();
						if (size == 0) {
							size = 1;
						}
						
						if (messageWidth > screenWidth) {
							messageWidth = screenWidth;
						}
						g2D.setColor(otherMessageColor);
						g2D.fillRoundRect(point.x +40, topGap , messageWidth + 17,  (messageHeight +5) *size  + 14, 10, 10);
						g2D.setColor(otherMessageBorderColor);
						g2D.drawRoundRect(point.x + 40, topGap , messageWidth + 17,  (messageHeight+5) * size + 14, 10, 10);		
						
						
						g2D.setColor(textColor);
						if (strList.size()  < 1) {
							g2D.drawString(message.getContent(), point.x + 45, topGap + 18);
						}else{
							for (int i = 0; i < strList.size(); i++) {
								g2D.drawString(strList.get(i), point.x +45, topGap + 18);
								topGap = messageHeight+5+topGap;
							}
							
						}
						
                        }
                        
                        /**
                         * 绘制图片
                         */
                        if(message.getImage()!=null){
                        	messageWidth = message.getImage().getIconWidth();
                        	messageHeight = message.getImage().getIconHeight();
                        	
                        	g2D.setColor(otherMessageColor);
    						g2D.fillRoundRect(point.x +40, topGap , messageWidth + 17,  messageHeight  + 14, 10, 10);
    						g2D.setColor(otherMessageBorderColor);
    						g2D.drawRoundRect(point.x + 40, topGap , messageWidth + 17,  messageHeight + 14, 10, 10);		
    						
    						g2D.drawImage(message.getImage().getImage(), point.x + 49,  topGap+6, null); 
    						
//    						topGap = messageHeight+topGap+14;
                        }
                        
						

					
				
						

						// 消息发出者是别人，则头像靠左显示
						xPoints[0] = point.x + 40;
						yPoints[0] = mindex+10;
						xPoints[1] = xPoints[0] - 7;
						yPoints[1] = mindex+10;
						xPoints[2] = xPoints[0];
						yPoints[2] = mindex + 17;

						g2D.setColor(otherMessageColor);
						g2D.fillPolygon(xPoints, yPoints, 3);
						g2D.setColor(otherMessageBorderColor);
						g2D.drawPolyline(xPoints, yPoints, 3);
						g2D.setColor(otherMessageColor);

						g2D.drawLine(xPoints[0], yPoints[0] + 1, xPoints[2], yPoints[2] - 1);
					}
                    
//					topGap += messageHeight + 20;
                    topGap = messageHeight+topGap+40;
				}
			} // while
		}

	}

	public void setMessageConcurrentLinkedQueue(ConcurrentLinkedQueue<Message> messageConcurrentLinkedQueue) {
		this.messageConcurrentLinkedQueue = messageConcurrentLinkedQueue;
		repaint();
	}

	/**
	 * 给文字分行显示
	 * @param content
	 * @param num
	 */
	public void getStringList(String content, int num) {
		strList.clear();
		StringBuffer str = new StringBuffer(content);
		int start = 0;
		int end = start + num;

		while (true) {
			if (start >= str.length() || str.length() < num)
				return;
			String temp = str.substring(start, end);
			strList.add(temp);
			System.out.println(temp);
			start = end;
			end = end + num;
			if (end >= str.length()) {
				end = str.length();
			}
		}
	}

	/**
	 * 获取对应字体的文字的高度
	 * 
	 * @param g2d @param font @return @parm @exception
	 */
	public double getFontHeight(Graphics2D g2d, Font font) {
		// 设置大字体
		FontRenderContext context = g2d.getFontRenderContext();
		// 获取字体的像素范围对象
		Rectangle2D stringBounds = font.getStringBounds("w", context);
		double fontWidth = stringBounds.getWidth();
		return fontWidth;
	}

	/**
	 * 获取对应的文字所占有的长度
	 * 
	 * @param g2d @param font @return @parm @exception
	 */
	public double getFontSize(Graphics2D g2d, Font font, String text) {
		// 设置大字体
		FontRenderContext context = g2d.getFontRenderContext();
		// 获取字体的像素范围对象
		Rectangle2D stringBounds = font.getStringBounds(text, context);
		double fontWidth = stringBounds.getWidth();
		return fontWidth;
	}
	/**
	 * 获取指定的大小的图片
	 * @param head 路劲（可写网络图片）
	 * @param width 设定图片宽度
	 * @param height 设定图片的长度
	 * @return
	 */
	public static ImageIcon getHeadImageIcon(String head, int width, int height) {
		ImageIcon headImageIcon = null;
		if (head == null || head.equals("") || head.equals("null")) {
			headImageIcon = new ImageIcon(JIMHistoryTextPane.class.getResource("/com/test/image/下载.jpg"));//默认加载头像
		} else {
			try {
				if(head.indexOf("http")>=0){
				headImageIcon = new ImageIcon(new URL(head));
				}else{
					headImageIcon = new ImageIcon(JIMHistoryTextPane.class.getResource(head));
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		headImageIcon.setImage(headImageIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		
		return headImageIcon;
	}
}
