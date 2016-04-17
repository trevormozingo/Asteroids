import java.util.List;

/* 
this servers as the abstract base class for all
model classes. models will be the primary data
container for this application */
public abstract class Model implements Observer 
{ 
	//Model also implements the Observer interface
	//which means that it gets notified. When Model gets
	//notified, the notifier will call update( ) with a message 
	//declaring the type of notification, and a list of parameters
	synchronized public void update(String message, Object object) { }
}