import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Universe extends JPanel
{
	private List<GameObject> _sprites;

	public Universe() { this.setBackground(Color.BLACK); }

	@Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;

        if (_sprites != null) 
        { 
	       	for (Object lists : _sprites)
			{	
				for (Object object : (ArrayList<Object>)lists)
				{
					GameObject gameObject = (GameObject)object;
					g2d.drawImage(gameObject.getImage(), gameObject.getXPos(), gameObject.getYPos(), this); 
				}
			}	
		}
    }

    public void setSprites(List<GameObject> sprites)
    {
    	_sprites = sprites;
    }
}








