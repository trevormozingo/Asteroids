import java.util.ArrayList;
import java.util.List;

/* 
network controller will manage
the input and output events for the 
client and the server */
public class NetworkController extends Controller
{
	//client and server classes will be 
	//used for driving the input and output
	private static Server _server; 
	private static Client _client; 
	//boolean to determine if we are hosting or not
	private static boolean _hosting;
	//singleton instance
	private static NetworkController _instance = null;
	private static Observer _gameController;

	//private constructor to maintain
	//singleton pattern
	private NetworkController() { }

	//constructor will set up the network
	//controller such that it will use 
	//a server or a client
	private NetworkController(int type) 
	{ 
		if (type == 0)
		{
			_hosting = false; 
			_client = Client.getInstance();
			_client.setNetworkController(this);
		}
		else
		{
			_hosting = true; 
			_server = Server.getInstance();
			_server.setNetworkController(this);
		}
	} 

	//get singleton instance
	public static NetworkController getInstance(int type)
	{
		if(_instance == null)
		{
			_instance = new NetworkController(type);
		}
		return _instance;
	}

	//get singleton instance (this should never be used)
	/*
	public static NetworkController getInstance()
	{
		if(_instance == null)
		{
			_instance = new NetworkController();
		}
		return _instance;
	}	
	*/

	public void setGameController(Observer gameController) { _gameController = gameController; }

	//this will start the client 
	// or server threads
	public static void run()
	{
		if (_hosting)
		{
			_server.start();
		}
		else
		{
			_client.start();
		}
	}

	synchronized public void update(String message, Object object) 
	{ 

		//System.out.println("Log: " + message);
		if (_hosting)
		{
			switch(message)
			{
				case "friend object":
					_server.update(message, object);
					break;
				case "recieved":
					_gameController.update(((Packet)object).getMessage(), ((Packet)object).getObject());
					break;
			}
		}
		else
		{
			switch(message)
			{
				case "friend object":
					_client.update(message, object);
					break;
				case "recieved":
					_gameController.update(((Packet)object).getMessage(), ((Packet)object).getObject());
					break;
			}
		}
	}
}


















