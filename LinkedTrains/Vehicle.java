/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package cps209.assignement.pkg2;

import java.awt.Color;

/**
 *
 * @author Maria
 */
abstract public class Vehicle 
{
    private int xPos;
    private int yPos;
    private int i;
    private int num;
    protected Color color;
    boolean selected;
    
public Vehicle()
{
    xPos = 0;
    yPos = 0;
    color = Color.BLACK;
}

public Vehicle( int x, int y)
{
    xPos = x;
    yPos = y;
    color = Color.BLACK;
}

public final int getX()
{
    return xPos;
}

public final int getY()
{
    return yPos;
}

public final int getNumber()
{
    num++;
    
    return num;
}
public void move(int x, int y){
    yPos = y;
    xPos = x;
}
/* public boolean contains(int x, int y){
    boolean result = true;
    
}
*/
}
