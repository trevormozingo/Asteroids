import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.JPanel;

/*	
This serves as the abstract base class for all 
game object classes */
public abstract class GameObject implements Observer 
{ 
	//x and y coordinates of object
	private AtomicInteger _x;
	private AtomicInteger _y;

	//for object image
	protected Image sprite;
	
	public GameObject()
	{
		super();
		_x = new AtomicInteger();
		_y = new AtomicInteger();
	}
	
	//pure virtual function must be implemented by inheriting classes
	public abstract void setImage();
	
	public Image getImage()
	{
		if (sprite == null)
		{
			setImage();
		}
		return sprite;
	}
	
	//Object also implements the Observer interface
	//which means that it gets notified. When Object gets
	//notified, the notifier will call update( ) with a message 
	//declaring the type of notification, and a list of parameters
	synchronized public void update(String message, Object object) 
	{
		//parses the list of objects as integers and sets them as 
		//the new coordinates of the current game object

		//System.out.println("Log: " + message);

		switch(message)
		{
			case "move": move((String)object);
				break;
		}

	}

	private void move(String direction)
	{
		switch (direction)
		{
			case "left":
				_x.set(_x.get() - 1);
				break;
			case "right":
				_x.set(_x.get() + 1);
				break;
			case "up":
				_y.set(_y.get() - 1);
				break;
			case "down":
				_y.set(_y.get() + 1);
				break;
		}

		if (_x.get() > 700) { _x.set(0); }
		if (_x.get() < 0) { _x.set(700); }
		if (_y.get() > 700) { _y.set(0); }
		if (_y.get() < 0) { _y.set(700); }


	}

	public int getXPos() { return _x.get(); }

	public int getYPos() { return _y.get(); }

}











