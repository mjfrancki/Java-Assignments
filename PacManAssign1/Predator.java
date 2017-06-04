import java.awt.*;
import java.awt.geom.*;
import java.util.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.*;

import javax.swing.JComponent;

public class Predator //implements MoveableShape //extends Creature 
{
   /**
      Constructs a car item.
      @param x the left of the bounding rectangle
      @param y the top of the bounding rectangle
      @param width the width of the bounding rectangle
   */
  private String direction = "Down";
  private int x;
  private int y;
 
 private int xHeadPos=35;
 private int yHeadPos=-10;
 Rectangle body;


   public Predator(int xPos, int yPos)
   {
     
  
  x = xPos;
  y = yPos;
body = new Rectangle(xPos, yPos, 40, 20);
   
   }

 public void draw(Graphics2D g2) 
    {
   
final int sizeOfHead=20;
 

  
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
      

   g2.setColor(Color.YELLOW);   
   g2.draw(body);
   g2.draw(head);
   g2.draw(frontLeg);
   g2.draw(backLeg);

    }



public void changeDirectionLeft(){

if(direction == "Up"){

direction = "Left";

}

else if(direction == "Left"){

direction = "Down";

}  

else if(direction == "Down"){

direction = "Right";

}

else if(direction == "Right"){

direction = "Up";

}  
  
}
 
public void changeDirectionRight(){
   
if(direction == "Up"){

direction = "Right";

}

else if(direction == "Right"){

direction = "Down";

}  

 
else if(direction == "Down"){

direction = "Left";

}

else if(direction == "Left"){

direction = "Up";

} 
  

  }



public void move()
{




if(direction == "Up"){

y = y - 1;

}

if(direction == "Left"){
x = x - 1;
xHeadPos = -15;

}

if(direction == "Right"){
x = x + 1;
xHeadPos = 35;

}

if(direction == "Down"){
y = y + 1;

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

public String getDirection(){
   return direction;
}

public boolean collide(Pray other){


if (body.intersects(other.body)) {
        return true;
    }


   return false;

}



}