import java.util.ArrayList;
import java.util.List;

/*	
This serves as the abstract base class for all 
controller classes */
public abstract class Controller implements Observer 
{ 
	//Controller also implements the Observer interface
	//which means that it gets notified. When Controller gets
	//notified, the notifier will call update( ) with a message 
	//declaring the type of notification, and a list of parameters
	public void update(String message, List<Object> objects) { }
}