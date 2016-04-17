import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Image;
/*BulletGameObject represents the
bullet the pawn object fires to 
shoot down the asteroids*/
public class BulletGameObject extends GameObject
{
	private BulletGameObject _instance = null;

	public BulletGameObject()
	{
		setImage();
	}
	
	public void setImage()
	{
		//set image
		//http://millionthvector.blogspot.com/p/free-sprites.html
		sprite = Toolkit.getDefaultToolkit().createImage("left_hbar.png");
	}

}