/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package cps209.assignement.pkg2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
//import static javafx.scene.input.KeyCode.J;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
   This frame has a menu with commands to change the font 
   of a text sample.
*/        
public class TrainFrame extends JFrame
{
   private static final int FRAME_WIDTH = 300;
   private static final int FRAME_HEIGHT = 400;
   
 
   private TrainPanel pan;
//TrainPanel pan = new TrainPanel();
  //frame.add(pan);
   //pan = new TrainPanel();
     //  add(pan);
   /**
      Constructs the frame.
   */
   public TrainFrame()
   {  
     
       
      // Construct menu      
      JMenuBar menuBar = new JMenuBar();     
      setJMenuBar(menuBar);
      menuBar.add(createFileMenu());
      menuBar.add(createQueueMenu());
      menuBar.add(createListMenu());
     
     
      pan = new TrainPanel();
      add(pan);
    
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }

  
   class ExitItemListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         System.exit(0);
      }
   }      
   
   /**
      Creates the File menu.
      @return the menu
   */
 
   public JMenu createFileMenu()
   {
      JMenu menu = new JMenu("File");
      JMenuItem exitItem = new JMenuItem("Exit"); 
      JMenuItem newItem = new JMenuItem("New"); 
      ActionListener listener = new ExitItemListener();
      ActionListener listener1 = new NewItemListener();
      exitItem.addActionListener(listener);
      newItem.addActionListener(listener1);
      menu.add(newItem);
      menu.add(exitItem);
      return menu;
  
      }
   

   
   class NewItemListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         System.out.println("New item was pressed.");
         //listen to 
           
         
         
      }
   } 

   /**
      Creates the Font submenu.
      @return the menu
   */
   public JMenu createQueueMenu()
   {
      JMenu menu = new JMenu("Queue");
      JMenuItem removeItem = new JMenuItem("Remove");
      JMenuItem addItem = new JMenuItem("Add");
      menu.add(removeItem);
      menu.add(addItem);
      
      ActionListener listener = new AddItemListener();
      addItem.addActionListener(listener);
      ActionListener listener1 = new RemoveItemListener();
      removeItem.addActionListener(listener1);
      
      return menu;
   }  

   class RemoveItemListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         System.out.println("Remove item");
      }
   } 
   
   class AddItemListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         System.out.println("Add item");
      }
   } 
   /**
      Creates the Face submenu.
      @return the menu
   */
   public JMenu createListMenu()
   {
      JMenu menu = new JMenu("List");
      JMenuItem addfirstItem = new JMenuItem("Add First");
      JMenuItem addlastItem = new JMenuItem("Add Last");
      JMenuItem removefirstItem = new JMenuItem("Remove First");
      JMenuItem removelastItem = new JMenuItem("Remove Last");
      menu.add(addfirstItem);
      menu.add(addlastItem);
      menu.add(removefirstItem);
      menu.add(removelastItem);
     
      
      ActionListener listener = new AddFirstItemListener();
      addfirstItem.addActionListener(listener);
      ActionListener listener2 = new AddLastItemListener();
      addlastItem.addActionListener(listener2);
      ActionListener listener3 = new RemoveFirstItemListener();
      removefirstItem.addActionListener(listener3);
      ActionListener listener4 = new RemoveLastItemListener();
      removelastItem.addActionListener(listener4);
      return menu;
      
   }  

   class AddFirstItemListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         System.out.println("Add first item");
      }
   } 
   
   class AddLastItemListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         System.out.println("Add last item");
      }
   } 
   class RemoveFirstItemListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         System.out.println("Remove first item");
      }
   } 
   
   class RemoveLastItemListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         System.out.println("Remove last item");
      }
   } 
  
  
}


