import java.awt.Color;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

/*
this is the game view
which will consist of the sprites  
and handle rendering of the game */
public class GameView extends View
{

	private static Observer _controller;
	//singleton instance
	private static GameView _instance = null;
	int _key;

	//call the base class method to set the 
	//title of the screen to Asteroids
	private GameView() 
	{ 
		super("Asteroids");
		_panel = new Universe();
		_frame.add(_panel);
	}

	//get singleton instance
	public static GameView getInstance()
	{
		if(_instance == null)
		{
			_instance = new GameView();
			
		}
		return _instance;
	}

	//this will start the screen
	//which is handled by the controller
	public void run()
	{
		_frame.setVisible(true);
	}

	public static void setController(Observer controller) { _controller = controller; }

	synchronized public void update(String message, Object object) 
	{ 
		switch(message)
		{ 
			case "refresh":
				refresh((List<GameObject>)object); 
				break;
		}
	}

	private void refresh(List<GameObject> gameObjectLists)
	{
		((Universe)_panel).setSprites(gameObjectLists);
		_panel.repaint();
	}

	public void keyPressed(KeyEvent e) 
	{ 
        _key = e.getKeyCode();
        action();
	}

	public void action()
	{
		if (_key != 0)
		{
			switch (_key)
	        {
	        	case KeyEvent.VK_LEFT:
	        		_controller.update("button pressed", "left");
	            	break;
	        	case KeyEvent.VK_RIGHT:
	        		_controller.update("button pressed",  "right");
	        		break;
	        	case KeyEvent.VK_UP: 
	        		_controller.update("button pressed",  "up");
	        		break;
	        	case KeyEvent.VK_DOWN:
	        		_controller.update("button pressed",  "down");
	        }
	     }
	}
	
	public void keyTyped(KeyEvent e) { } 

	public void keyReleased(KeyEvent e) 
	{ 
		_key = 0;
	}

	public void actionPerformed(ActionEvent e) 
	{ 
		action();
	}

}



















