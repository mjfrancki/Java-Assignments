import javax.swing.* ;
import java.awt.Graphics ;
import java.awt.Graphics2D ;
import java.awt.geom.Ellipse2D ;
import java.awt.event.MouseEvent ;
import java.awt.event.MouseListener ;
import java.awt.event.MouseAdapter ;
import java.awt.event.MouseMotionListener ;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import javax.swing.event.*;
import javax.swing.JButton;
import javax.swing.*;
import java.lang.*;

public class CreatureComponent extends JComponent
{
static double time; 


private ArrayList<Pray> prays = new ArrayList<Pray>();

//private ArrayList<Creature> prays = new ArrayList<Creature>();

private Predator player = new Predator(200,200);




public CreatureComponent()
    {
   

  Pray pray = new Pray((int) (600.0 * Math.random()),(int)(600.0 * Math.random()),1);
  prays.add(pray);

  pray = new Pray((int)(600.0 * Math.random()),(int)(600.0 * Math.random()),1);
  prays.add(pray);

  pray = new Pray((int)(600.0 * Math.random()),(int)(600.0 * Math.random()),1);
  prays.add(pray);

  pray = new Pray((int)(600.0 * Math.random()),(int)(600.0 * Math.random()),2);
  prays.add(pray);

   pray = new Pray((int)(600.0 * Math.random()),(int)(600.0 * Math.random()),2);
  prays.add(pray);


class MyListener extends MouseAdapter
{
       public void mousePressed(MouseEvent e)
       {

if(SwingUtilities.isLeftMouseButton(e)){

 player.changeDirectionLeft();

}


else if(SwingUtilities.isRightMouseButton(e)){
player.changeDirectionRight();

}
     
      }
 
}

addMouseListener(new MyListener()) ;
   



  





class TimerListener implements ActionListener
{
     
   

        public void actionPerformed(ActionEvent e)
         {
       
       if(AnimationTest.start ){
      
	     player.move();
	     player.wallHit();
      

 	for (int i=0; i<prays.size() ;i++) {
	
	prays.get(i).move();
    prays.get(i).wallHit();
    prays.get(i).changeDirection();

	if(  player.collide( prays.get(i) )   )
     prays.remove(i);
	 
     
	 
	 }     


   
        repaint();
       
        //time = time + 0.01;
       

if (prays.size() == 0){

AnimationTest.start = false;
System.out.println("YOU WIN, YOUR TIME IS "+AnimationTest.time);
}


        }

         }
         
}
      
      ActionListener timerListener = new TimerListener();
      final int DELAY = 10; // Milliseconds between timer ticks
      final Timer t  = new Timer(DELAY, timerListener);
      
      t.start();







}
    
    public void paintComponent(Graphics g)
    {
	//
    
    Graphics2D g2 = (Graphics2D) g ;
	  


   	for (Pray pray : prays) {
	    pray.draw(g2) ;
	}

    player.draw(g2);
        
     
    }




}