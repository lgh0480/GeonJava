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

class BlockPanelOpening extends BlockSubPanel { // 서브패널 상속 받는 시작패널

	public BlockPanelOpening(BlockPanel blockPanel) {

		super(blockPanel);
		System.out.println("Block=4");
		setLayout(null);
		
		PanelName = "Opening";
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.setBounds(220, 450, 100, 90);
		btnPlay.addActionListener(new ClickPlay());
		this.add(btnPlay);

		// 2번째 버튼 : 명예의전당
		JButton btnScore = new JButton("명예의전당");
		btnScore.setBounds(340, 450, 100, 90);
		btnScore.addActionListener(new ClickScore());
		this.add(btnScore);

		// 3번쨰 버튼 : 나가기.
		JButton btnExit = new JButton("나 가 기");
		btnExit.setBounds(460, 450, 100, 90);
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		this.add(btnExit);

		try {

			clip = AudioSystem.getClip();
			URL url = getClass().getResource("/bgm/opening.wav");
			AudioInputStream stream = AudioSystem.getAudioInputStream(url);
			clip.open(stream);
			clip.setFramePosition(0);
			clip.start();

		} catch (Exception e) {
			return;
		}

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		printFontCenter(g2, 100, "Java Programming", 50, new Color(255, 255, 255), false);
		printFontCenter(g2, 200, "블록 게임", 50, new Color(255, 255, 255), false);
		printFontCenter(g2, 400, "Block Breaker", 90, new Color(255, 255, 255), true);

		if (n % 2 == 0) {

			printFontCenter(g2, 600, "Press SpaceBar to Play!", 30, new Color(3, 0, 65), false);

		}
	}
}