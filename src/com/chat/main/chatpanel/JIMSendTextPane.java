package com.chat.main.chatpanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author tangzhichao
 */
import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BoxView;
import javax.swing.text.ComponentView;
import javax.swing.text.Element;
import javax.swing.text.IconView;
import javax.swing.text.LabelView;
import javax.swing.text.ParagraphView;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;

/**
 * 璇ョ被鏄湡姝ｅ疄鐜拌秴闀垮崟璇嶉兘鑳借嚜鍔ㄦ崲琛岀殑 JTextPane 鐨勫瓙锟?Java 7 浠ヤ笅鐗堟湰锟?JTextPane 鏈韩閮借兘瀹炵幇鑷姩鎹㈣锛屽
 * 瓒呴暱鍗曡瘝閮借兘鏈夋晥锛屼絾锟?Java 7 锟?锟斤拷璇昏秴闀垮崟璇嶅氨涓嶈兘鑷姩 鎹㈣锛屽锟?JTextPane 鐨勫疄闄呭搴﹀彉澶э紝浣垮緱婊氬姩鏉″嚭鐜帮拷? 涓嬮潰鐨勬柟娉曟槸瀵硅繖锟?
 * bug 鐨勮緝濂戒慨澶嶏拷?
 *
 * Created by dolphin on 15-2-3.
 */
public class JIMSendTextPane extends JTextPane {

    // 鍐呴儴锟?
    // 浠ヤ笅鍐呴儴绫诲叏閮界敤浜庡疄鐜拌嚜鍔ㄥ己鍒舵姌锟?
    private class WarpEditorKit extends StyledEditorKit {

        private ViewFactory defaultFactory = new WarpColumnFactory();

        @Override
        public ViewFactory getViewFactory() {
            return defaultFactory;
        }
    }

    private class WarpColumnFactory implements ViewFactory {

        public View create(Element elem) {
            String kind = elem.getName();
            if (kind != null) {
                if (kind.equals(AbstractDocument.ContentElementName)) {
                    return new WarpLabelView(elem);
                } else if (kind.equals(AbstractDocument.ParagraphElementName)) {
                    return new ParagraphView(elem);
                } else if (kind.equals(AbstractDocument.SectionElementName)) {
                    return new BoxView(elem, View.Y_AXIS);
                } else if (kind.equals(StyleConstants.ComponentElementName)) {
                    return new ComponentView(elem);
                } else if (kind.equals(StyleConstants.IconElementName)) {
                    return new IconView(elem);
                }
            }

            // default to text display
            return new LabelView(elem);
        }
    }

    private class WarpLabelView extends LabelView {

        public WarpLabelView(Element elem) {
            super(elem);
        }

        @Override
        public float getMinimumSpan(int axis) {
            switch (axis) {
                case View.X_AXIS:
                    return 0;
                case View.Y_AXIS:
                    return super.getMinimumSpan(axis);
                default:
                    throw new IllegalArgumentException("Invalid axis: " + axis);
            }
        }
    }

    // 鏈被
    // 鏋勶拷?鍑芥暟
    public JIMSendTextPane() {
        super();
        this.setEditorKit(new WarpEditorKit());
//        this.setBackground(new Color(0,0,0,0));
    }
}
