import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Main
{
	public static Scanner scanner = new Scanner(System.in);
	public static int option;


	public static View gameView;
	public static Model gameModel;
	public static Controller gameController;

	public static NetworkController networkController;

	public static void main(String args[])
	{
		System.out.println("[0|1]");
		option = scanner.nextInt();

		init();
		((GameController)gameController).run();
	}

	public static void init()
	{
		gameView = GameView.getInstance();
		gameModel = GameModel.getInstance();
		gameController = GameController.getInstance();

		networkController = networkController.getInstance(option);

		((GameController)gameController).setView(gameView);
		((GameController)gameController).setModel(gameModel);
		((GameController)gameController).setNetworkController(networkController);

	}

}


























