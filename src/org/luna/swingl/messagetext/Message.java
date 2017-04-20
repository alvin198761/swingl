/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.luna.swingl.messagetext;

import java.awt.Point;

/**
 *
 * @author tangzhichao
 */
public class Message {

    private boolean self;

    public Message(boolean self) {
        this.self = self;
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

//    
//     private Long id;
//    private MessageType type;
//    private String content;
//    private Map<Integer, Image> imageMap = new HashMap<Integer, Image>();
//    private Date time;
//    private boolean self;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public MessageType getType() {
//        return type;
//    }
//
//    public void setType(MessageType type) {
//        this.type = type;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public Map<Integer, Image> getImageMap() {
//        return imageMap;
//    }
//
//    public void setImageMap(Map<Integer, Image> imageMap) {
//        this.imageMap = imageMap;
//    }
//
//    public Date getTime() {
//        return time;
//    }
//
//    public void setTime(Date time) {
//        this.time = time;
//    }
//
//    public boolean isSelf() {
//        return self;
//    }
//
//    public void setSelf(boolean self) {
//        this.self = self;
//    }
}
