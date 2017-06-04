/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cps209.assignement.pkg2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter ;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 *
 * @author Maria
 */
public class TrainPanel extends JPanel 
{
    
private TrainEngine train;
private RailCar rail;
private int clicked = 0;
ArrayList<Vehicle> vehicle;
private int x;
private int y;
    
public TrainPanel() {
          
//vehicle = new ArrayList<Vehicle>();
      
   class MyListener implements MouseListener
         {
             //public double ymouse;
             //public double xmouse;
        public void mousePressed (MouseEvent e)
             {
                 x = e.getX();
                 y = e.getY();
                
                 
              // if(clicked == 1){
                train = new TrainEngine(x, y);
               //}
               
                             
                 repaint();
                 clicked++;
                
                
                System.out.println( e.getX() );
                System.out.println( e.getY() );
                System.out.println( "test" );
             
             }

       // @Override
        public void mouseClicked(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

       // @Override
       // public void mousePressed(MouseEvent e) {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       // }

       //@Override
        public void mouseReleased(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

       // @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

       //@Override
        public void mouseExited(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

   }
   class MyMotionListener implements MouseMotionListener{

        //@Override
        public void mouseDragged(MouseEvent e) {
           // if(clicked>6)
            train.move(e.getX(), e.getY());
           // rail.move(e.getX(), e.getY());
            repaint();
            
        }

        //@Override
        public void mouseMoved(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
}
        MouseListener listener = new MyListener();
        
        MouseMotionListener motionListener = new MyMotionListener();

         addMouseListener(listener);
         //addMouseListener(new MyListener()) ;  
        addMouseMotionListener(motionListener) ;
  }

//@Override
public void paintComponent(Graphics g)
        {
            super.paintComponent(g) ;
           Graphics2D g2 = (Graphics2D) g;
          
         train.draw(g2);
            

              /* if(clicked == 1){
                  train = new TrainEngine(x,y);
                  train.draw(g2);
                //vehicle.add(train);
                } 
                else if(clicked < 6){
                 rail = new RailCar(x,y);
                 rail.draw(g2);
                //vehicle.add(rail);
                }
               */      
            
       }
}





