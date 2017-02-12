import java.awt.Color;
import java.awt.Point;

public class TetrisBlock {
	public TetrisBlock(String[] shape){
		/**
		 * This is what the input should look like (Standard right now should be 5x5 square) 
		 * 
		 * OOXOOO	XXOOOO
		 * OOXOOO	OXXOOO
		 * OOXXOO	OOXXOO
		 * OOOXOO	OOOXXO
		 * OOOXOO	OOOOXX
		 * 
		 */
		
		
		//Make Rnd Color
		
	}
	public Point getMidPoint(){
		return new Point(2,2);
	}
	private Color getColor;
	public Color getGetColor() {
		return getColor;
	}
	public void setGetColor(Color getColor) {
		this.getColor = getColor;
	}
	public Point getSize(){
		return new Point(5,5);
	}
}
