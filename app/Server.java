import java.net.*;
import java.io.*;

/* 
the server class will host
games with another (one) user. It will handle
incoming updates and send outgoing updates of the 
game to the client */
public class Server extends Thread
{
	
	private static Server _instance = null;		//singleton instance
	private static ServerSocket _serverSocket; 	//server socket for i/o communications
	private static Socket _socket; 				
	private static int _port;					//port to connect through, the default is 7777

	//constructor to start up the server
	private Server() 
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

	//set up the server using the default port 7777
	private static void init() throws Exception
	{
		_port = 7777; 
		_serverSocket = new ServerSocket(_port); 
	}

	//get singleton instance
	public static Server getInstance()
	{
		if(_instance == null)
		{
			_instance = new Server();
		}
		return _instance;
	}

	//http://www.tutorialspoint.com/java/java_networking.htm
	//run will start communications weith the client
	//it will continue to poll for updates from the client
	public void run()
	{
		try
		{
			System.out.println("Log: Waiting for client on port " + _serverSocket.getLocalPort() + "...");
			_socket = _serverSocket.accept();
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
			}
			catch(Exception e) 
			{ 
				System.out.println("Log: " + e.toString());
			}
		}
	}
}






















































