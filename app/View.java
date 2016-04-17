import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

/* 
View will serve as the abstract base class for all
views in the application. the view will consist
of the window and its elements */
public abstract class View implements Observer, KeyListener, ActionListener 
{ 
	//This is the window object
	protected JFrame _frame;
	protected JPanel _panel;
	protected Timer _timer;

	//Constructor to set up a default window
	protected View(String title)
	{
		_frame = new JFrame(title);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setSize(700, 700);
		_frame.setLayout(new BorderLayout());

 		_timer = new Timer(1, this);
 		_timer.start();

		_frame.addKeyListener(this);
		_frame.setFocusable(true);
	}

	//View also implements the Observer interface
	//which means that it gets notified. When View gets
	//notified, the notifier will call update( ) with a message 
	//declaring the type of notification, and a list of parameters

	synchronized public void update(String message, Object object) { }

	public void keyPressed(KeyEvent e) { }
	
	public void keyTyped(KeyEvent e) { } 

	public void keyReleased(KeyEvent e) { }

	public void actionPerformed(ActionEvent e) { }
}



























