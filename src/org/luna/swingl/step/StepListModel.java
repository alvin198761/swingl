/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.luna.swingl.step;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author tangzhichao
 */
public class StepListModel<StepItemPane> extends AbstractListModel<StepItemPane> {

    private List<StepItemPane> items = new ArrayList<>();

    public StepListModel() {
    }

    @Override
    public int getSize() {
        return items.size();
    }

    @Override
    public StepItemPane getElementAt(int index) {
        return items.get(index);
    }

    public void addItem(StepItemPane item) {
        this.items.add(item);
        this.fireIntervalAdded(item, this.items.size() - 1, this.items.size() - 1);
    }

}
