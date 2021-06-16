package block.main;

import javax.swing.JFrame;
import javax.swing.UIManager;
import block.panel.*;

public class BlockAppMain extends JFrame {

	BlockAppMain() {
		System.out.println("Block=1");
		setSize(800, 800);
		setTitle("벽돌 깨기 게임");
		add(new BlockPanel());
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		System.out.println("Block=2");

		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		new BlockAppMain();
	}

}
