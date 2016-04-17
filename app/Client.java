import java.util.ArrayList;
import java.util.List;
import java.net.*;
import java.io.*;
import java.util.Scanner;

/* 
client will parallel the server class
but will not be hosting, rather sending
and fetching game updates */
public class Client extends Thread
{
	
	private static Client _instance = null;		//singleton instance
	private static Socket _socket; 				//client socket for i/o communications
	private static int _port;					//server port
	private static String _hostname;			//server hostname
	private static Observer _networkController;

	//constructor to setup the client
	private Client() 
	{
		try 
		{
			init(); 
		}
		catch(Exception e) 
		{ 
			System.out.println("Log: " + e.toString());
		} 
	}

	//set up the client to connect to the
	//server port. we will just be connecting
	//to localhost for now
	private static void init()
	{
		_port = 7777; 
		_hostname = "localhost";
	}

	//get singleton instance
	public static Client getInstance()
	{
		if(_instance == null)
		{
			_instance = new Client();
		}
		return _instance;
	}

	public void setNetworkController(Observer networkController) { _networkController = networkController; }

	//this will start the client side
	//the client will then continue to poll for 
	//server side updates
	public void run()
	{
		try
		{
			 System.out.println("Log: Connecting to " + _hostname + " on port " + _port);
			_socket = new Socket(_hostname, _port); 
			System.out.println("Log: Just connected to " + _socket.getRemoteSocketAddress());
		}
		catch(Exception e) 
		{ 
			System.out.println("Log: " + e.toString());
		}

		while (true)
		{
			try
			{
				ObjectInputStream in = new ObjectInputStream(_socket.getInputStream());
				Packet packet = (Packet)in.readObject();
				_networkController.update("recieved", packet);
         	}
         	catch(Exception e) 
			{ 
				System.out.println("Log: " + e.toString());
			}
		}
	}

	synchronized public void update(String message, Object object) 
	{ 
		try
		{
			Packet packet = new Packet(message, object);
			ObjectOutputStream out = new ObjectOutputStream(_socket.getOutputStream());
			out.writeObject(packet);
			out.flush();
			//DataOutputStream out = new DataOutputStream(_socket.getOutputStream());
			//out.writeUTF(message);

		}
		catch(Exception e) 
		{ 
			System.out.println("Log: " + e.toString());
		}
	}

}























