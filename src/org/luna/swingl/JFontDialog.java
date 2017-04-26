/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.luna.swingl;

import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author tangzhichao
 */
public class JFontDialog extends javax.swing.JDialog {

    private Font selectedFont;

    /**
     * Creates new form JFontDialog
     */
    public JFontDialog() {
        this(new Font("宋体", Font.PLAIN, 12));
    }

    public JFontDialog(Font font) {
        initComponents();
        this.selectedFont = font;
        this.setModal(true);
        this.setSize(490, 480);
        this.setLocationRelativeTo(null);
        this.initFont();
        this.getRootPane().setDefaultButton(jButton1);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.jButton1.setAction(new OKAction());
        this.jButton2.setAction(new CancelAction());
    }

    public Font getSelectedFont() {
        return this.selectedFont;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtStyle = new javax.swing.JTextField();
        txtSize = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listName = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listStyle = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listSize = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        lblDemo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbbScript = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("字体");
        setResizable(false);

        lblName.setText("字体(F):");

        jLabel2.setText("字形(Y):");

        jLabel3.setText("大小(S):");

        txtName.setEditable(false);

        txtStyle.setEditable(false);

        txtSize.setEditable(false);

        listName.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listName.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listName);

        listStyle.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listStyle.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(listStyle);

        listSize.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listSize.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(listSize);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("示例"));
        jPanel1.setLayout(new java.awt.BorderLayout());

        lblDemo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDemo.setText("jLabel4");
        jPanel1.add(lblDemo, java.awt.BorderLayout.CENTER);

        jLabel1.setText("脚步(R):");

        cbbScript.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbScript, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStyle, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(13, 13, 13))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane1, lblName, txtName});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jScrollPane2, txtStyle});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jScrollPane3, txtSize});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbbScript, jLabel1, jPanel1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblName)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStyle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbScript, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblName, txtName});

    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbScript;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDemo;
    private javax.swing.JLabel lblName;
    private javax.swing.JList<String> listName;
    private javax.swing.JList<String> listSize;
    private javax.swing.JList<String> listStyle;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSize;
    private javax.swing.JTextField txtStyle;
    // End of variables declaration//GEN-END:variables

    private void initFont() {
        initFontName();
        initFontStyle();
        initFontSize();
        initScript();
        initText();
    }

    private void initFontName() {
        initList(this.listName, this.txtName);
        Font[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
        DefaultListModel model = new DefaultListModel();
        for (int i = fonts.length - 1; i >= 0; i--) {
            model.addElement(fonts[i].getName());
        }
        this.listName.setModel(model);
        this.listName.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
                Font defaultFont = this.getFont();
                Font f = new Font(value.toString(), defaultFont.getStyle(), defaultFont.getSize());
                setFont(f);
                return label;
            }

        });
    }

    private void initFontStyle() {
        initList(this.listStyle, this.txtStyle);
        DefaultListModel model = new DefaultListModel();
        model.addElement(new Item("常规", Font.PLAIN));
        model.addElement(new Item("倾斜", Font.ITALIC));
        model.addElement(new Item("粗体", Font.BOLD));
        model.addElement(new Item("粗体 倾斜", Font.BOLD | Font.ITALIC));
        this.listStyle.setModel(model);
        this.listStyle.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
                Font defaultFont = this.getFont();
                Item item = (Item) value;
                Font f = new Font(defaultFont.getName(), (Integer) item.value, defaultFont.getSize());
                setFont(f);
                return label;
            }
        });
    }

    private void initFontSize() {
        initList(this.listSize, this.txtSize);
        DefaultListModel model = new DefaultListModel();
        for (int i = 8; i <= 28; i++) {
            model.addElement(new Item(Integer.toString(i), i));
            if (i >= 12) {
                i++;
            }
        }
        model.addElement(new Item(Integer.toString(36), 36));
        model.addElement(new Item(Integer.toString(48), 48));
        model.addElement(new Item(Integer.toString(72), 72));
        this.listSize.setModel(model);
    }

    private void initScript() {
        DefaultComboBoxModel model = new DefaultComboBoxModel<Object>(new Item[]{
            new Item("中文字符", "汉字"),
            new Item("西欧字符", "AaBb")
        });
        this.cbbScript.setModel(model);
        this.cbbScript.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                lblDemo.setText(((Item) e.getItem()).value.toString());
            }
        });
        lblDemo.setText(((Item) model.getElementAt(0)).value.toString());
    }

    private void initList(final JList jlist, final JTextField textField) {
        jlist.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                if (listName.getSelectedIndex() == -1 || listStyle.getSelectedIndex() == -1 || listSize.getSelectedIndex() == -1) {
                    return;
                }
                textField.setText(jlist.getSelectedValue().toString());
                String name = listName.getSelectedValue();
                Item item = (Item) ((DefaultListModel) listStyle.getModel()).getElementAt(listStyle.getSelectedIndex());
                int style = (int) item.value;
                item = (Item) ((DefaultListModel) listSize.getModel()).getElementAt(listSize.getSelectedIndex());
                int size = (int) item.value;
                selectedFont = new Font(name, style, size);
                lblDemo.setFont(selectedFont);
            }
        });
    }

    private void initText() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                txtName.setText(selectedFont.getName());
                listName.setSelectedValue(selectedFont.getName(), true);

                Item item = getItemByValue(listStyle, selectedFont.getStyle());
                if (item != null) {
                    txtStyle.setText(item.label);
                    listStyle.setSelectedValue(item, true);
                }

                item = getItemByValue(listSize, selectedFont.getSize());
                if (item != null) {
                    txtSize.setText(item.label);
                    listSize.setSelectedValue(item, true);
                }
            }

        });
    }

    private Item getItemByValue(JList jlist, int value) {
        for (int i = 0; i < jlist.getModel().getSize(); i++) {
            Item item = (Item) jlist.getModel().getElementAt(i);
            if (((Integer) item.value).intValue() == value) {
                return item;
            }
        }
        return null;

    }

    private class Item {

        String label;
        Object value;

        public Item(String label, Object value) {
            this.label = label;
            this.value = value;
        }

        @Override
        public String toString() {
            return label;
        }

    }

    private class OKAction extends AbstractAction {

        public OKAction() {
            putValue(NAME, "确定");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JFontDialog.this.setVisible(false);
        }
    }

    private class CancelAction extends AbstractAction {

        public CancelAction() {
            putValue(NAME, "关闭");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            selectedFont = null;
            JFontDialog.this.setVisible(false);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFontDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFontDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFontDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFontDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFontDialog dialog = new JFontDialog();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
                System.out.println(dialog.getSelectedFont());
            }
        });
    }
}
