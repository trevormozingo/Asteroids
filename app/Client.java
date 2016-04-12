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
				//DataInputStream in = new DataInputStream(_socket.getInputStream());
				
				/*
				Scanner scanner = new Scanner(System.in);
				System.out.println(">>> ");
				String output = scanner.nextLine();

				OutputStream outToServer = _socket.getOutputStream();
         		DataOutputStream out = new DataOutputStream(outToServer);
         		out.writeUTF(output);
         		*/
         	}
         	catch(Exception e) 
			{ 
				System.out.println("Log: " + e.toString());
			}
		}
	}
}























