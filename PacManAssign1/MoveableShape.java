import java.awt.*;

public interface MoveableShape
{
	
  public void move();


  public boolean collide(Pray other);


  public void draw(Graphics2D g2);

}
