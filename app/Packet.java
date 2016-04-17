import java.net.*;
import java.io.*;

public class Packet implements Serializable
{
	private String _message; 
	private Object _object;

	public Packet(String message, Object object)
	{
		_message = message;
		_object = object;
	}

	public String getMessage() { return _message; }
	public Object getObject() { return _object; }
}