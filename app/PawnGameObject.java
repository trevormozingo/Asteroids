import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
/* PawnGameObject is a player game object,
can be more than one object when multiplayer
functionality is implemented */
public class PawnGameObject extends GameObject
{
	//private PawnGameObject _instance = null; 
	public PawnGameObject(){
		super();
		setImage();
	}
	
	public void setImage()
	{
		//set image
		//http://millionthvector.blogspot.com/p/free-sprites.html
		sprite = Toolkit.getDefaultToolkit().createImage("speedship.png");
	}
	
}