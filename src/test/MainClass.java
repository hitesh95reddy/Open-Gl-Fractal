/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author MAHE
 */
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClass extends JPanel {

  public void paint(Graphics g) {
    g.fillOval(25, 25, 120, 120);
  
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.getContentPane().add(new MainClass());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200,200);
    frame.setVisible(true);
  }
}