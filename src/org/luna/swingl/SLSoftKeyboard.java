/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.luna.swingl;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.text.JTextComponent;

/**
 * 软键盘
 * QQ群：481434622
 * @author QQ :444716720
 * 整理：QQ: 2273410177
 */
public class SLSoftKeyboard extends JPopupMenu {

    private JTextComponent target;
    protected List<KeyboardButton> buttons = new ArrayList<KeyboardButton>();
    //软键盘大小  
    private static Dimension popupSize = new Dimension(555, 221);
    private static String[] keys = {
        "qwertyuiop",
        "asdfghjkl",
        "zxcvbnm"
    };

    static {
        UIManager.put("sl.softkeyboard.bgcolor", new Color(138, 138, 138));
    }

    public SLSoftKeyboard(JTextComponent target) {
        this.target = target;
        initTarget();
        initComponents();
    }

    private void initTarget() {
        this.target.setEditable(false);
        this.target.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                SLSoftKeyboard.this.show(target.getParent(), target.getX(), target.getY() + target.getHeight());
            }
        });

    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(popupSize);
        setBorder(null);
        setBorderPainted(false);
        setOpaque(true);

        ActionListener action = new KeyBoardAction();
        for (int i = 0; i < this.keys.length; i++) {
            JPanel panel = new JPanel();
            panel.setOpaque(false);
            panel.setLayout(new FlowLayout(FlowLayout.CENTER, 6, 0));// 水平间隙1，垂直间隙0  
            if (i == 2) {
                KeyboardButton btn = new KeyboardButton(BUTTON_TYPE.CAPS_LOCK, "大写", action);
                panel.add(btn);
                buttons.add(btn);
            }
            for (char c : this.keys[i].toCharArray()) {
                KeyboardButton btn = new KeyboardButton(BUTTON_TYPE.VALUE, new String(new char[]{c}), action);
                panel.add(btn);
                buttons.add(btn);
            }
            if (i == 2) {
                panel.add(new KeyboardButton(BUTTON_TYPE.DELETE, "删除", action));
            }
            this.add(panel);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Color c = g.getColor();
        g.setColor(UIManager.getColor("sl.softkeyboard.bgcolor"));
        g.drawRect(0, 0, getWidth(), getHeight());
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(c);
    }

    @Override
    public Insets getInsets(Insets insets) {
        return new Insets(0, 0, 0, 0);
    }
    //-----------------------

    private void fireCapsLockChanged(boolean capsLock) {
        for (KeyboardButton button : this.buttons) {
            button.changeCapsLock(capsLock);
        }
    }

    static enum BUTTON_TYPE {
        VALUE, CAPS_LOCK, DELETE
    }

    //按钮
    private class KeyboardButton extends JButton {

        private BUTTON_TYPE type;
        private Dimension size = new Dimension(45, 50);  //按键大小

        public KeyboardButton(BUTTON_TYPE type, String value, ActionListener action) {
            setOpaque(true);
            setBorder(null);
            setBackground(Color.WHITE);
            setContentAreaFilled(false);
            setFocusPainted(false);
            this.setActionCommand(value);
            this.type = type;
            this.addActionListener(action);
            initIcon();
        }

        public BUTTON_TYPE getType() {
            return type;
        }

        private void changeCapsLock(boolean capsLock) {
            if (this.type == BUTTON_TYPE.VALUE) {
                String text = capsLock ? getActionCommand().toUpperCase() : getActionCommand().toLowerCase();
                this.setActionCommand(text);
            } else if (this.type == BUTTON_TYPE.CAPS_LOCK) {
                String text = capsLock ? "小写" : "大写";
                this.setActionCommand(text);
            }
            initIcon();
        }

        private void initIcon() {
            setIcon(new ButtonIcon(this.getActionCommand(), Color.WHITE));
            setRolloverIcon(new ButtonIcon(this.getActionCommand(), Color.WHITE.darker()));
            setPressedIcon(new ButtonIcon(this.getActionCommand(), Color.WHITE.darker().darker()));
        }
    }

    private class ButtonIcon implements Icon {

        private Dimension size = new Dimension(45, 50);  //按键大小
        private Color keyBorderFocusColor = new Color(162, 162, 157);
        private Font boldFont = new Font("微软雅黑", Font.PLAIN, 18);  //字母大小
        private Color boldColor = new Color(0, 0, 57);

        private String text;
        private Color color;

        public ButtonIcon(String text, Color color) {
            this.text = text;
            this.color = color;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(SystemColor.control);
            g2d.setColor(color);
            g2d.fill(new Rectangle(0, 0, getWidth(), getHeight()));
            g2d.setFont(boldFont);
            g2d.setPaint(boldColor);
            g2d.drawString(this.text, 3, 20);
        }

        @Override
        public int getIconWidth() {
            return size.width;
        }

        @Override
        public int getIconHeight() {
            return size.height;
        }

    }

    //点击动作
    private class KeyBoardAction implements ActionListener {

        private boolean caps_lock = false;

        @Override
        public void actionPerformed(ActionEvent e) {
            KeyboardButton btn = (KeyboardButton) e.getSource();
            if (btn.getType() == BUTTON_TYPE.VALUE) {
                target.setText(target.getText() + btn.getActionCommand());
                return;
            }
            if (btn.getType() == BUTTON_TYPE.CAPS_LOCK) {
                caps_lock = !caps_lock;
                SLSoftKeyboard.this.fireCapsLockChanged(caps_lock);
                return;
            }
            if (btn.getType() == BUTTON_TYPE.DELETE) {
                if (!target.getText().isEmpty()) {
                    target.setText(target.getText().substring(0, target.getText().length() - 1));
                }
                return;
            }
        }

    }

}
