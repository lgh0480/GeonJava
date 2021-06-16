package block.access;

import java.util.ArrayList;

import block.model.BlockPlayer;

public interface BlockAccess {

	// 전체명예의 전당
	public ArrayList<BlockPlayer> playerAll();

	// 플레이어 기록 입력
	public void write(BlockPlayer block);
}
