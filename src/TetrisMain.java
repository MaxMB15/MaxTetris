import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TetrisMain implements MouseListener{
	public static void main(String[] args){
		new TetrisMain();
	}
	private JFrame frame;
	private JPanel pane;
	private TetrisBoard board = null;
	private Rectangle boardBounds = new Rectangle(50,50,600,600);
	public TetrisMain(){
		frame = new JFrame("Max Tetris");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
		
		pane = new JPanel();
		frame.setContentPane(pane);
		board = new TetrisBoard(new Point(boardBounds.width,boardBounds.height),20,20,3,1f);

		//Start Timer
		Timer timer = new Timer(100,new ActionListener(){public void actionPerformed(ActionEvent e){paint();}});
		timer.setRepeats(true);
		timer.start();
		
		frame.setVisible(true);
	}
	public void paint(){
		pane.getGraphics().drawImage(board.drawBoard(), boardBounds.x, boardBounds.y, null);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
