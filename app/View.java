import javax.swing.*;
import java.awt.*;
import java.util.List;

/* 
View will serve as the abstract base class for all
views in the application. the view will consist
of the window and its elements */
public abstract class View implements Observer 
{ 
	//This is the window object
	protected JFrame _frame;

	//Constructor to set up a default window
	protected View(String title)
	{
		_frame = new JFrame(title);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setSize(500, 500);
	}

	//View also implements the Observer interface
	//which means that it gets notified. When View gets
	//notified, the notifier will call update( ) with a message 
	//declaring the type of notification, and a list of parameters
	public void update(String message, List<Object> objects) { }
}