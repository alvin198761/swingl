/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.luna.swingl.messagetext;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

/**
 *
 * @author tangzhichao
 */
public class Message {
     /***标记是否自己****/
    private boolean self;
	private String content;
	/***头像***/
	private String handimage;
	/**姓名**/
	private String name;
	/***发送时间**/
	private String sendtime;
	/**图片***/
	private ImageIcon image;
	/***声音***/
	private String voice;
	/**网络连接*/
	private String Url;

    public String getHandimage() {
		return handimage;
	}

	public void setHandimage(String handimage) {
		this.handimage = handimage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSendtime() {
		return sendtime;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public String getVoice() {
		return voice;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public void setSelf(boolean self) {
		this.self = self;
	}

	public Message(boolean self,String content) {
        this.self = self;
        this.content = content;
    }

	
	public Message(boolean self,ImageIcon image) {
        this.self = self;
        this.image = image;
    }
    public Point getMessagePaintLeftTop() {
        return new Point(20, 25);
    }

    public Integer getSenderHeadImageID() {
        return 1;
    }

    public boolean isSelf() {
        return self;
    }

    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    

}
