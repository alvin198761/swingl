/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.luna.color;

import java.awt.Color;

/**
 *
 * @author tangzhichao
 */
public class ColorUtils {

    /**
     *
     * @param colorStr 如： #404040
     * @return
     */
    public static Color parseColor(String colorStr) {
        String r = colorStr.substring(1, 3);
        String g = colorStr.substring(3, 5);
        String b = colorStr.substring(5, 7);
        return new Color(Integer.valueOf(r, 16), Integer.valueOf(g, 16), Integer.valueOf(b, 16));
    }

    public static String toColorStr(Color color) {
        String r = Integer.toHexString(color.getRed());
        String g = Integer.toHexString(color.getGreen());
        String b = Integer.toHexString(color.getBlue());

        r = r.length() == 1 ? "0" + r : r;
        g = g.length() == 1 ? "0" + g : g;
        b = b.length() == 1 ? "0" + b : b;
        return "#".concat(r).concat(g).concat(b);
    }

}
