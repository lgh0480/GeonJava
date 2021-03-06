package block.model;

public class BlockPlayer {

	String player;
	int score;

	public BlockPlayer() {

	}

	public BlockPlayer(String player, int score) {
		super();
		this.player = player;
		this.score = score;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Block [player=" + player + ", score=" + score + "]";
	}

}