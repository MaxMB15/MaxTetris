import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class TetrisBoardSpace {
	//Default background color
	private Color defaultColor = new Color(69, 75, 35);
	//For Highlights
	private float defaultColorDifference = 0.4f;
	private int paddingWidth = 1;
	private float paddingPer = 0.15f;
	public TetrisBoardSpace(Point size){
		image = new BufferedImage(size.x,size.y,BufferedImage.TYPE_4BYTE_ABGR);
		paddingWidth = (int)(Math.max(size.getX(), size.getY())*paddingPer);
		resetImage();
		if(Math.random()>.8){
			colorHit(Color.green);
		}
	}
	public void colorHit(Color blockColor){
		makeImage(blockColor);
	}
	//Image representing the board block
	private BufferedImage image = null;
	public BufferedImage getImage() {
		return image;
	}
	public void resetImage() {
		makeImage(defaultColor);
	}
	private void makeImage(Color c) {
		//Outside padding
		Graphics g = image.createGraphics();
		g.setColor(new Color((int)(c.getRed()*defaultColorDifference),(int)(c.getGreen()*defaultColorDifference),(int)(c.getBlue()*defaultColorDifference)));
		g.fillRect(0, 0, image.getWidth(), image.getHeight());
		//Inside Square
		g.setColor(c);
		g.fillRect(paddingWidth, paddingWidth, image.getWidth()-2*paddingWidth, image.getHeight()-2*paddingWidth);
	}
}
