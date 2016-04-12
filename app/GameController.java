import java.util.ArrayList;
import java.util.List;

/* 
The game controller will be the main center for
handling events incoming form the network controller, 
the view, and the model. Based on these events, it will
handle ingame logic, and route events to the appropriate
destination */
public class GameController extends Controller
{
	//the controller will have direct access
	//to the view, the model, and the network controller.
	//by using the observer design pattern, controller
	//will be able to update each of these. 
	private Observer _view;
	private Observer _model;
	private Observer _networkController;

	//singleton design pattern for the  GameController
	//needs an instance
	private static GameController _instance = null;

	//because this follows the singleton design pattern
	//we need a private contructor so nothing from 
	//the outside can instantiate this object
	private GameController() { }
	
	//method to return the singleton instance
	//to the outside world.
	public static GameController getInstance()
	{
		if(_instance == null)
		{
			_instance = new GameController();
		}
		return _instance;
	}

	//public Observer getView() { return _view; }
	//set the view
	public void setView(Observer view) { _view = view; }

	//public Observer getModel() { return _model; }
	//set the model
	public void setModel(Observer model) { _model = model; }

	//public Observer getNetworkController() { return _networkController; }
	//set the network controller
	public void setNetworkController(Observer networkController) { _networkController = networkController; }

	//this will serve as the gameLoop
	public void run()
	{
		((GameView)_view).run();
		((NetworkController)_networkController).run();

		while (true)
		{

		}
	}
\
}








































