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
import javax.swing.* ;
/**

   This program implements an animation that moves creaturs around. 
*/
public class AnimationTest
{

static int time;

static boolean start = false;

public static void main(String[] args)
{
     

   final int FRAME_WIDTH = 600;
   final int FRAME_HEIGHT = 600;

      JFrame frame = new JFrame();
      CreatureComponent component = new CreatureComponent() ;
      frame.add(component) ;

   frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
   frame.setTitle("Pacman... kinda of") ;
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  // frame.setLayout(new BorderLayout());
   frame.getContentPane().setBackground(Color.BLACK);
   frame.setVisible(true);




final JButton startAnimationButton = new JButton("Start");      
 JPanel panel = new JPanel();
    
frame.add(panel,BorderLayout.NORTH);
        
panel.add(startAnimationButton);
      
class StartButtonListener implements ActionListener
{
         public void actionPerformed(ActionEvent event)
         {
          

          start = true;
         

         }

}
      
      ActionListener startButtonListener = new StartButtonListener();
      startAnimationButton.addActionListener(startButtonListener);






class TimerListener implements ActionListener
{
     
        public void actionPerformed(ActionEvent e)
         {
       
       if(start ){
       
        time = time + 1;
        startAnimationButton.setText(time+"");
        
        }

         }
         
}
      
      ActionListener timerListener = new TimerListener();
      final int DELAY = 1000; // Milliseconds between timer ticks
      final Timer t2  = new Timer(DELAY, timerListener);
      
      t2.start();













}

















}

   
