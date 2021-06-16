package block.panel;

import javax.swing.JPanel;

public class BlockPanel extends JPanel { // 시작,게임,종료 화면을 넣을 메인패널

	private int highScore;
	int myScore;

	BlockPanelOpening Opening;
	BlockPanelPlaying Playing;
	BlockPanelEnding Ending;
	BlockPanelScore Score;

	public BlockPanel() {
		System.out.println("Block=3");

		highScore = 0;
		setLayout(null);
		Opening = new BlockPanelOpening(this);
		add(Opening);
	}

	public void changeMode(String panelMode) {

		if (panelMode.equals("Opening")) {
			Opening = new BlockPanelOpening(this);
			this.add(Opening);
		    this.remove(Score);

		} else if (panelMode.equals("Playing")) {
			Playing = new BlockPanelPlaying(this);
			this.add(Playing);
			this.remove(Opening);

		} else if (panelMode.equals("Ending")) {
			Ending = new BlockPanelEnding(this);
			this.add(Ending);
			this.remove(Playing);

		} else if (panelMode.equals("Score")) {
			Score = new BlockPanelScore(this);
			this.add(Score);
			this.remove(Opening);
			
		} else if (panelMode.equals("ButtonEnding")) {
			Opening = new BlockPanelOpening(this);
			this.add(Opening);
		    this.remove(Ending);
		}

	}

	public void setScore(int score) {
		highScore = score;
	}

	public int getScore() {
		return highScore;
	}

}
