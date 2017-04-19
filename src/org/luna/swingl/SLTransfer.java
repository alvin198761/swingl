/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.luna.swingl;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;
import javax.swing.AbstractAction;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import static jdk.nashorn.internal.objects.NativeRegExp.source;

/**
 *
 * @author tangzhichao
 */
public class SLTransfer<T extends Object> extends javax.swing.JComponent {

    /**
     * Creates new form SLTransfer
     */
    public SLTransfer(Collection<T> source, Collection<T> dist) {
        initComponents();

        this.jButton1.setAction(new AddAction());
        this.jButton2.setAction(new RemoveAction());
        this.jButton3.setAction(new AddAAllction());
        this.jButton4.setAction(new RemoveAllAction());

        this.initList(sourceList, source);
        this.initList(targetList, dist);
    }

    private void initList(JList list, Collection data) {
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        final DefaultListModel sourceModel = new DefaultListModel();
        data.iterator().forEachRemaining(new Consumer<Object>() {
            @Override
            public void accept(Object item) {
                sourceModel.addElement(item);
            }
        });

        list.setModel(sourceModel);
        list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                actionEnabledChanged();
            }
        });
        sourceModel.addListDataListener(new ListDataListener() {
            @Override
            public void intervalAdded(ListDataEvent e) {
                actionEnabledChanged();
            }

            @Override
            public void intervalRemoved(ListDataEvent e) {
            }

            @Override
            public void contentsChanged(ListDataEvent e) {
            }
        });
    }

    private void actionEnabledChanged() {
        ((BaseSLTransferAction) this.jButton1.getAction()).fireEnabledChanged();
        ((BaseSLTransferAction) this.jButton2.getAction()).fireEnabledChanged();
        ((BaseSLTransferAction) this.jButton3.getAction()).fireEnabledChanged();
        ((BaseSLTransferAction) this.jButton4.getAction()).fireEnabledChanged();
    }

    abstract class BaseSLTransferAction extends AbstractAction {

        public abstract boolean isEnabled();

        public void fireEnabledChanged() {
            firePropertyChange("enabled", true, false);
        }
    }

    class AddAction extends BaseSLTransferAction {

        public AddAction() {
            putValue(NAME, ">");
            putValue(SHORT_DESCRIPTION, "添加");
        }

        @Override
        public boolean isEnabled() {
            return sourceList.getSelectedIndices().length > 0;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            swap(sourceList, targetList);
        }

    }

    private void swap(JList source, JList target) {
        DefaultListModel sourceModel = (DefaultListModel) source.getModel();
        DefaultListModel targetModel = (DefaultListModel) target.getModel();
        int[] index = source.getSelectedIndices();
        for (int i = 0; i < index.length; i++) {
            Object obj = sourceModel.remove(0);
            targetModel.addElement(obj);
        }
    }

    private void swapAll(JList source, JList target) {
        DefaultListModel sourceModel = (DefaultListModel) source.getModel();
        DefaultListModel targetModel = (DefaultListModel) target.getModel();
        for (int i = 0; i < sourceModel.size(); i++) {
            Object obj = sourceModel.remove(0);
            targetModel.addElement(obj);
        }
    }

    private Collection<T> getListData(JList source) {
        DefaultListModel sourceModel = (DefaultListModel) source.getModel();
        Collection<T> list = new ArrayList<T>();
        for (int i = 0; i < sourceModel.getSize(); i++) {
            list.add((T) sourceModel.get(i));
        }
        return list;
    }

    class RemoveAction extends BaseSLTransferAction {

        public RemoveAction() {
            putValue(NAME, "<");
            putValue(SHORT_DESCRIPTION, "移除");
        }

        @Override
        public boolean isEnabled() {
            return targetList.getSelectedIndices().length > 0;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            swap(targetList, sourceList);
        }

    }

    class AddAAllction extends BaseSLTransferAction {

        public AddAAllction() {
            putValue(NAME, ">>");
            putValue(SHORT_DESCRIPTION, "添加所有");
        }

        @Override
        public boolean isEnabled() {
            return sourceList.getModel().getSize() > 0;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            swapAll(sourceList, targetList);
        }

    }

    class RemoveAllAction extends BaseSLTransferAction {

        public RemoveAllAction() {
            putValue(NAME, "<<");
            putValue(SHORT_DESCRIPTION, "移除所有");
        }

        @Override
        public boolean isEnabled() {
            return targetList.getModel().getSize() > 0;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            swapAll(targetList, sourceList);
        }
    }

    public Collection<T> getSourceList() {
        return getListData(sourceList);
    }

    public Collection<T> getTargetList() {
        return getListData(targetList);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        sourceList = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 3), new java.awt.Dimension(0, 3), new java.awt.Dimension(0, 3));
        jButton2 = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 3), new java.awt.Dimension(0, 3), new java.awt.Dimension(0, 3));
        jButton3 = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 3), new java.awt.Dimension(0, 3), new java.awt.Dimension(0, 3));
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        targetList = new javax.swing.JList<>();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));

        sourceList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(sourceList);

        add(jScrollPane1);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jButton1.setText("jButton1");
        jPanel1.add(jButton1);
        jPanel1.add(filler1);

        jButton2.setText("jButton2");
        jPanel1.add(jButton2);
        jPanel1.add(filler2);

        jButton3.setText("jButton3");
        jPanel1.add(jButton3);
        jPanel1.add(filler3);

        jButton4.setText("jButton4");
        jPanel1.add(jButton4);

        add(jPanel1);

        targetList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(targetList);

        add(jScrollPane2);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> sourceList;
    private javax.swing.JList<String> targetList;
    // End of variables declaration//GEN-END:variables
}
