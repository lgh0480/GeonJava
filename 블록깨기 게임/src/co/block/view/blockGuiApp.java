package co.block.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.TextField;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import co.block.access.BlockAccess;
import co.block.access.BlockDAO;
import co.block.model.Block;

public class blockGuiApp extends JFrame {
	JButton btnPlayerAll;
	JTable table;
	TextArea txtList;
	
	TextField txtPlayer, txtScore;
	
	

	BlockAccess blockList = new BlockDAO();
	
	public blockGuiApp(){
		setSize(800,800); //사이즈 생성 
		setTitle("벽돌 부수기"); // 이름 생성 
		//BottonInit();
		GemeScore();
		//add(new blockGuiApp()); // Hw5Panel를 부착
		setResizable(false); //프레임의 크기를 사용자가 변할 수 있게 지정 
		setVisible(true); //창을 화면에 나타낼것인지 아닌지 말해주는것!
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 메인 프레임 닫았을떄 Jfream객체도 같이 종료되게 만듬
		
	}
	
	public void BottonInit() {
		btnPlayerAll = new JButton("명예의전당");
		btnPlayerAll.setBounds(680, 700, 100, 50);
		
	
		//this.getContentPane().add(btnPlayerAll, BorderLayout.SOUTH);
		btnPlayerAll.addActionListener(e ->PlayerAll() );
		this.setLayout(null);
		this.add(btnPlayerAll);
		
	}
	private void PlayerAll() {
			List<Block> list = blockList.playerAll();
			StringBuffer sb = new StringBuffer();
			for (Block b : list) {
				sb.append(b);
				sb.append("\n");
			}
			txtList.setText(sb.toString());
		
	
	
	}
	
	private void GemeScore() {
		JLabel label = new JLabel("명예의 전당", JLabel.CENTER);
		label.setFont(new Font("SansSerif", Font.PLAIN, 30));
		add(label, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(500, 200));
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		
		panel.add(new JLabel("Player"));
		txtPlayer = new TextField(45);
		panel.add(txtPlayer);
		
		panel.add(new JLabel("점수"));
		txtScore = new TextField(45);
		panel.add(txtScore);		
		
		

		
	
	}
	
	public void insert() {
		Block block  = new Block();
		block.setPlayer(txtPlayer.getText()); //구분에 있는 텍스트를 가져오겠다
		block.setScore(Integer.parseInt(txtScore.getText()));
		blockList.write(block);
		
		
	}
	
}
