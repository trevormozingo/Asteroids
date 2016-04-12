/*
The GameModel will be in charge
of handling storage of information for all
game objects and status */
public class GameModel extends Model
{
	//singleton instance
	private static GameModel _instance = null;

	//private constructor to follow
	//singleton pattern
	private GameModel() { }

	//get singleton instance of the gameModel
	public static GameModel getInstance()
	{
		if(_instance == null)
		{
			_instance = new GameModel();
		}
		return _instance;
	}
}