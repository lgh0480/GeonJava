package 좌표;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BasicPaint {

	public static void main(String[] args) {

		JFrame f = new JFrame("그래픽 기초 프로그램");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new MyPanel());

		f.setSize(300, 200);
		f.setVisible(true);

	}
}

class MyPanel extends JPanel {
	private int squareX = 50;
	private int squareY = 50;
	private int squareW = 20;
	private int squareH = 20;

	public MyPanel() {

		setBorder(BorderFactory.createLineBorder(Color.black));

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				moveSquare(e.getX(), e.getY());
			}

		});
		addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				moveSquare(e.getX(), e.getY());
			}

		});
	}

	protected void moveSquare(int x, int y) {
		int OFFSET = 1;
		if((squareX != x) || (squareY != y)) {
			repaint(squareX,squareY,squareW+ OFFSET, squareH+ OFFSET);
			squareX = x;
			squareY = y;
			repaint(squareX,squareY,squareW+ OFFSET, squareH+ OFFSET);
			
		}
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("마우스를 클릭하면 사각형이 그려짐", 10,20);
		g.setColor(Color.blue);
		g.fillRect(squareX, squareY, squareW, squareH);
		g.setColor(Color.BLACK);
		g.drawRect(squareX, squareY, squareW, squareH);
	}
}