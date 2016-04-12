/*
this is the game view
which will consist of the sprites  
and handle rendering of the game */
public class GameView extends View
{
	//singleton instance
	private static GameView _instance = null;

	//call the base class method to set the 
	//title of the screen to Asteroids
	private GameView() 
	{ 
		super("Asteroids");
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
	
}



















