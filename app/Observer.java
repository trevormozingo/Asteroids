import java.util.ArrayList;
import java.util.List;

/* 
this interface is used for the 
observer design pattern which allows
objects to observe and be notified */
public interface Observer 
{ 
	//when an observer object is notified the
	//notifying object will call this objects
	//update method
	void update(String message, Object object);
}