import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Image;
/* AstroidGameObject contains one asteroid,
possibly implements an RNG to vary number 
and size of astroids*/
public class AsteroidGameObject extends GameObject
{
	private AsteroidGameObject _instance = null;

	public AsteroidGameObject()
	{
		setImage();
	}
	
	public void setImage()
	{
		//set image
		//https://classes.soe.ucsc.edu/cmps080k/Winter07/games/Team%20Mindopener/game%20files/sprites%20underwater/asteroid.gif
		sprite = Toolkit.getDefaultToolkit().createImage("asteriod.gif");
	}

}