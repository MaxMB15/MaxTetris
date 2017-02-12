import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class TetrisBoard {
	private int spacing = 2;
	private TetrisBoardSpace[][] spaces = null;
	private Point Size = new Point(0,0);
	private Color backColor = new Color(.4f,.5f,.5f);
	public TetrisBoard(Point size, int col, int row, int space, float difficulty){
		//Initialize the board
		spacing = space;
		int cellW = (size.x-(spacing*(col-1)))/col;
		int cellH = (size.y-(spacing*(row-1)))/row;
		spaces = new TetrisBoardSpace[col][row];
		for(int x = 0;x<col;x++){
			for(int y = 0;y<row;y++){
				spaces[x][y] = new TetrisBoardSpace(new Point(cellW,cellH));
			}
		}
		//Size and Image initialization
		Size = size;
		buffer1 = new BufferedImage(size.x,size.y,BufferedImage.TYPE_4BYTE_ABGR);
		bufferOut = new BufferedImage(size.x,size.y,BufferedImage.TYPE_4BYTE_ABGR);
		
		
	}
	public void addBlock(TetrisBlock block,int offset){
		//Check to make sure offset is valid
		if(block.getSize().x+offset>spaces.length){
			System.out.println("Error: "+block.toString()+" does not fit the board!");
			System.exit(1);
		}
	}
	private BufferedImage buffer1;
	private BufferedImage bufferOut;
	private Graphics g;
	private Point getSize(){
		return Size;
	}
	public BufferedImage drawBoard(){
		//Transfer buffers
		bufferOut.getGraphics().drawImage(buffer1, 0, 0, null);
		//Reset graphics and background
		g = buffer1.createGraphics();
		g.setColor(backColor);
		g.fillRect(0, 0, Size.x, Size.y);
		//Draw Board
		int offsetX = 0;
		int offsetY = 0;
		for(int x = 0;x<spaces.length;x++){
			for(int y = 0;y<spaces[0].length;y++){
				g.drawImage(spaces[x][y].getImage(), offsetX, offsetY, null);
				offsetY += spacing + spaces[x][y].getImage().getHeight();
			}
			offsetY = 0;
			offsetX += spacing + spaces[x][0].getImage().getWidth();
		}
		
		return bufferOut;
	}
	
}
