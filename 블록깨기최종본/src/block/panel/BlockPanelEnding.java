package block.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import block.access.BlockAccess;
import block.access.BlockDAO;
import block.model.BlockPlayer;

class BlockPanelEnding extends BlockSubPanel { // 서브패널을 상속 받는 종료패널

	JLabel label;
	JTextField player;
	JButton button;
	BlockAccess blockList = new BlockDAO();
	BlockPanelEnding(BlockPanel blockPanel) {
		super(blockPanel);
		PanelName = "Ending";
		setLayout(null);

		try {
			label = new JLabel("플레이어 입력 :");
			player = new JTextField(15); // 컬럼수가 15인 텍스트 필드 생성
			button = new JButton("확인");

			button.setBounds(430, 500, 70, 50);
			label.setBounds(170, 480, 150, 90);
			player.setBounds(270, 500, 150, 50);

			this.add(label);
			this.add(player);
			this.add(button);

			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					BlockPlayer blockpy = new BlockPlayer();
					blockpy.setPlayer(player.getText());
					blockpy.setScore(blockPanel.myScore);
					
					blockList.write(blockpy);
					player.requestFocus();
					
					clip.stop();
					blockPanel.changeMode("ButtonEnding");
				}
			});

			clip = AudioSystem.getClip();
			URL url = getClass().getResource("/bgm/gameover.wav");
			AudioInputStream stream = AudioSystem.getAudioInputStream(url);
			clip.open(stream);
			clip.setFramePosition(0);
			clip.start();
		} catch (Exception e) {
			return;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		printFontCenter(g2, 300, "Game Over", 90, new Color(255, 255, 255), true);
		printFontCenter(g2, 420, "High Score: " + blockPanel.getScore(), 40, new Color(155, 155, 155), false);
		printFontCenter(g2, 470, "Your Score: " + blockPanel.myScore, 40, new Color(155, 155, 155), false);
		if (n % 2 == 0) {
			printFontCenter(g2, 600, "Press SpaceBar to Play!", 30, new Color(3, 0, 65), false);
		}

	}

	public void PlayerInsert() {

		this.add(new JLabel("플레이어 입력: "));
		player = new JTextField(30); // 컬럼수가 30인 텍스트 필드 생성
		this.add(player);

	}

}
