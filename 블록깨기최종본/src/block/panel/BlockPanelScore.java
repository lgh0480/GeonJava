package block.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TextField;
import java.net.URL;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.JButton;
import javax.swing.JLabel;

import block.access.BlockAccess;
import block.access.BlockDAO;
import block.model.BlockPlayer;



class BlockPanelScore extends BlockSubPanel {
	
	TextField Player, Score;
	JButton btnOp;
	JLabel label[];
	
	BlockAccess blockList = new BlockDAO();


	// BlockSubPanel에 상속받았음.
	public BlockPanelScore(BlockPanel blockPanel) {

		super(blockPanel);
		
		PanelName = "Score";
		setLayout(null);
		
		
		try {
			int i = 0;
			
			btnOp = new JButton("처음으로");
			btnOp.setBounds(350, 680, 100, 60);
			btnOp.addActionListener(new ClickMain());
			
			this.add(btnOp);
			
			List<BlockPlayer> block = blockList.playerAll();
			
			label = new JLabel[10];
			Font font = new Font("맑은 고딕", Font.BOLD, 30);

			for(BlockPlayer p : block) {
				label[i] = new JLabel(p.getPlayer() + " : " + p.getScore());
				label[i].setBounds(200, 75+i*50, 350, 200);
				label[i].setFont(font);
				this.add(label[i]);
				i++;
				if (i == 10) {
					break;
				}
			}
			
			clip = AudioSystem.getClip(); //
			URL url = getClass().getResource("/bgm/score.wav");
			AudioInputStream stream = AudioSystem.getAudioInputStream(url);
			clip.open(stream);
			clip.setFramePosition(0);
			clip.start();
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		
	} // end of class

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		printFontCenter(g2, 100, "명예의 전당", 90, new Color(255, 255, 255), false);
	}

	
		


}
