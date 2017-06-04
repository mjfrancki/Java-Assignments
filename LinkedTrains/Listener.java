/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package cps209.assignement.pkg2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;

/**
 *
 * @author Maria
 */
public class Listener extends JComponent {
    
     public void paintComponent(Graphics g)
      {
        Graphics2D g2 = (Graphics2D)g;
      }
      
     class NewItemListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         System.out.println("New item was pressed.");
         
         
         
      }
   } 
     ActionListener listener1 = new NewItemListener();
     
    
    
    
    
    
    
}
