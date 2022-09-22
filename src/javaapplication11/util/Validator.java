/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication11.util;

import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.JLabel;

/**
 *
 * @author Nguyen Duy Hung
 */
public class Validator {
    public String getString(String text, JLabel lblMsg){
        if(text.isBlank()){
            lblMsg.setText(lblMsg.getName() + " khong duoc trong");
            lblMsg.setForeground(Color.red);
            return null;
        }else{
            lblMsg.setText("");
            return text;
        }
    }
    public String formatNumber(int number){
        DecimalFormat deci = new DecimalFormat("###,###,###");
        return deci.format(number);
    }
}
