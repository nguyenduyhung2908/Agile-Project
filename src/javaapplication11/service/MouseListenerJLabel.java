/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication11.service;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Nguyen Duy Hung
 */
public class MouseListenerJLabel extends MouseAdapter{
    JLabel lblCompoinment;
    JPanel pnCompoinment;
    
    public MouseListenerJLabel(JLabel lblCompoinment,JPanel pnCompoinment) {
        this.lblCompoinment = lblCompoinment;
        this.pnCompoinment = pnCompoinment;
    }



    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        pnCompoinment.setBackground(Color.WHITE);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        pnCompoinment.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        lblCompoinment.setForeground(Color.BLACK);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        lblCompoinment.setForeground(Color.BLACK);
    }
    
    
}
