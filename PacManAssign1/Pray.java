import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.*;

import javax.swing.JComponent;

public class Pray //implements MoveableShape //extends Creature  
{
  private String direction = "Down";
  private int x;
  private int y;
  private int speed;
 Rectangle body;
 
  private int xHeadPos=35;


   public Pray(int xpos, int ypos, int speed_)
   {
  
   x = xpos;
   y = ypos;
   speed = speed_;
   body = new Rectangle(x, y, 40, 20);
   }







public void move()
{
      


if(direction == "Up"){

y = y - speed;

}

if(direction == "Left"){
x = x - speed;
xHeadPos = -15;

}

if(direction == "Right"){
x = x + speed;
xHeadPos = 35;

}

if(direction == "Down"){
y = y + speed;

}


}




public void changeDirection(){

int randomInt = (int)(100.0 * Math.random());

if ( randomInt == 0 ){

randomInt = (int)(4 * Math.random());

    if(randomInt == 0){
        direction ="Right";
    }

    if(randomInt == 1){
         direction ="Left";
    }
    
    if(randomInt == 2){
        direction ="Down";
    }


    if(randomInt == 3){
       direction ="Up";
    }  
    

  }



}







public void wallHit(){

if(x<0){
direction ="Right";
}

if(x>540){
direction ="Left";
}

if(y<0){
direction = "Down";
}

if(y>520){
direction = "Up";
}


}


 public void draw(Graphics2D g2) 
{
   
final int sizeOfHead=20;

final int yHeadPos=-10;

  
 final   int xFrontLeg1=5;
 final   int yFrontLeg1=20;
 final   int xFrontLeg2=5;
 final   int yFrontLeg2=35;

 final   int xBackLeg1=35;
 final   int yBackLeg1=20;
 final   int xBackLeg2=35;
 final   int yBackLeg2=35;


 body = new Rectangle(x, y, 40, 20);
         
Ellipse2D.Double head = new Ellipse2D.Double(x+xHeadPos, y+yHeadPos,sizeOfHead,sizeOfHead);
       
Line2D.Double frontLeg = new Line2D.Double(x+xFrontLeg1,y+yFrontLeg1,x+xFrontLeg2,y+yFrontLeg2);
         
Line2D.Double backLeg = new Line2D.Double(x+xBackLeg1,y+yBackLeg1,x+xBackLeg2,y+yBackLeg2);
      
if (speed == 1)
   g2.setColor(Color.RED);   
 
if (speed == 2)
  g2.setColor(Color.GREEN); 

   g2.draw(body);
   g2.draw(head);
   g2.draw(frontLeg);
   g2.draw(backLeg);

}





public boolean collide(Pray other){
  return false;
}

   
}