
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


public class Creature //implements MoveableShape
{

   int xPos, yPos, speed ;
   Rectangle body ;

  public Creature(int x, int y, int speed_){  
    xPos = x ;
    yPos = y ;
    speed = speed_;
    body = new Rectangle(xPos, yPos, 40, 20) ;
  
  }



public void move(){
} 

public boolean collide(Pray other){
return false;
} 


public void draw(Graphics2D g2){}

public void wallHit(){}


public void changeDirection(){}

public int getX() { return xPos ; }
public int getY() { return yPos ; }
public int getWidth() { return 40 ; }
public int getHeight() { return 20 ; }

}

