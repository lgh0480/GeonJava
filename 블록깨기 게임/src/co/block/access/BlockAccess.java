package co.block.access;

import java.util.ArrayList;

import co.block.model.Block;

public interface BlockAccess {
	//전체명예의 전당
	public ArrayList<Block> playerAll();

	//플레이어 기록 입력 
	public void write(Block block);
}
