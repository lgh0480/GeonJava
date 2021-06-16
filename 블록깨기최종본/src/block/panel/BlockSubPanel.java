package block.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.sound.sampled.Clip;
import javax.swing.JPanel;

import block.access.BlockAccess;
import block.access.BlockDAO;

class BlockSubPanel extends JPanel implements Runnable, KeyListener { // 시작,게임,종료 패널의 부모 클래스인 서브패널

	int n;// "Press Space" 깜빡이게

	Thread t = new Thread(this);
	String PanelName;
	Clip clip; // Clip clip; //.wav 파일 재생을위한 녀석
	BlockPanel blockPanel;
	
	
	
	public BlockSubPanel(BlockPanel blockPanel) {
		System.out.println("Block=6");

		this.blockPanel = blockPanel;
		this.setBounds(0, 0, 800, 800);
		setFocusable(true); // 1
		requestFocus();// 2 키보드,마우스 누른애가 포커스를 가짐
		addKeyListener(this); // 3 이 세트
		t.start();

	}

	@Override
	public void run() {
		while (true) {

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				return;
			}
			n++;
			revalidate();
			repaint();
		}
	}

	// 글자 가운데 출력
	public void printFontCenter(Graphics2D g2, float height, String str, int size, Color color, Boolean bold) {
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, size);
		if (bold) {
			font = new Font(Font.SANS_SERIF, Font.BOLD, size);
		}
		FontMetrics metrics = g2.getFontMetrics(font);
		int font_width = metrics.stringWidth(str);
		g2.setFont(font);
		g2.setColor(color);
		g2.drawString(str, 400 - font_width / 2, height);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Dimension size = this.getSize();
		int w = size.width;
		int h = size.height;
		GradientPaint gp = new GradientPaint(0, 0, new Color(212, 223, 230), 0, h, new Color(142, 192, 228));
		g2.setPaint(gp);
		g2.fillRect(0, 0, w, h);

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {// 스페이스바 눌렸을 경우
			t.interrupt();

			switch (PanelName) {

			case "Opening":
				clip.stop();
				blockPanel.changeMode("Playing");
				break;
			case "Playing":
				blockPanel.changeMode("Ending");
				break;
			case "Ending":
				clip.stop();
				blockPanel.changeMode("Opening");
				break;
			
			case "Score":
				clip.stop();
				blockPanel.changeMode("Score");
				break;

			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	class ClickMain implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			clip.stop();
			blockPanel.changeMode("Opening");
		}

	}

	class ClickPlay implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			//
			clip.stop();
			blockPanel.changeMode("Playing");

		}
	}

	class ClickScore implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			clip.stop();
			blockPanel.changeMode("Score");

		}

	}

	


}
