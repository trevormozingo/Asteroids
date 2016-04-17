import java.util.ArrayList;
import java.util.List;

/*
The GameModel will be in charge
of handling storage of information for all
game objects and status */
public class GameModel extends Model
{

	private List<Object> _gameObjectLists;

	private List<AsteroidGameObject> _asteroids;
	private List<BulletGameObject> _friendBullets;
	private List<BulletGameObject> _pawnBullets;
	private List<PawnGameObject> _pawns;
	private List<PawnGameObject> _friends;

	//singleton instance
	private static GameModel _instance = null;

	//private constructor to follow
	//singleton pattern
	private GameModel() 
	{ 
		_gameObjectLists = new ArrayList<Object>();

		_asteroids = new ArrayList<AsteroidGameObject>();
		_friendBullets = new ArrayList<BulletGameObject>();
		_pawnBullets = new ArrayList<BulletGameObject>();
		_pawns = new ArrayList<PawnGameObject>();
		_friends = new ArrayList<PawnGameObject>();

		_gameObjectLists.add(_asteroids);
		_gameObjectLists.add(_friendBullets);
		_gameObjectLists.add(_pawnBullets);
		_gameObjectLists.add(_pawns);
		_gameObjectLists.add(_friends);

	}

	//get singleton instance of the gameModel
	public static GameModel getInstance()
	{
		if(_instance == null)
		{
			_instance = new GameModel();
		}
		return _instance;
	}

	public void add(String type)
	{
		switch(type)
		{
			case "asteroid":
				_asteroids.add(new AsteroidGameObject());
				break;
			case "friendBullet": 
				_friendBullets.add(new BulletGameObject());
				break;
			case "pawnBullet": 
				_pawnBullets.add(new BulletGameObject());
				break;
			case "pawn": 
				_pawns.add(new PawnGameObject());
				break;
			case "friend": 
				_friends.add(new PawnGameObject());
				break;
		}
	}

	synchronized public void update(String message, Object object) 
	{ 
		//System.out.println("Log: " + message);

		switch(message)
		{
			case "pawn object": updatePawns((String)object);
				break;
			case "friend object": updateFriends((String)object);
				break;				
		}
	}

	private void updatePawns(String direction)
	{
		for (PawnGameObject pawn : _pawns)
		{
			pawn.update("move", direction);
		}
	}

	private void updateFriends(String direction)
	{
		for (PawnGameObject pawn : _friends)
		{
			pawn.update("move", direction);
		}
	}

	public List<Object> getGameObjectLists()
	{
		return _gameObjectLists;
	}

}














