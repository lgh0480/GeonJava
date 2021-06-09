package co.friend.view;

import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import co.friend.access.FriendAccess;
import co.friend.access.FriendDAO;
import co.friend.model.Friend;

public class FriendGuiApp extends JFrame {
//JFrame 하나의 창을 말함.
	TextField txtName, txtGubun, txtTel;
	JButton btnInsert, btnUpdate, btnDelete, btnSelectAll, btnFindName;
	TextArea txtList;
	FriendAccess friendList = new FriendDAO();

	public FriendGuiApp() {
		setTitle("친구관리"); // 위에 이름
		setSize(400, 400);	// 전체적인테두리 사이즈
		init();  //입력값들
		setVisible(true); //창을 화면에 나타낼것인지 설정.
		setResizable(false); //창 크기 조절 할수 업도록 설정.
	}

	public void init() {
		txtName = new TextField(45);
		txtGubun = new TextField(45);
		txtTel = new TextField(45);

		btnInsert = new JButton("등록");
		btnUpdate = new JButton("수정");
		btnDelete = new JButton("삭제");
		btnSelectAll = new JButton("전체조회");
		btnFindName = new JButton("이름조회");

		txtList = new TextArea(12, 50);

		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(new JLabel("구분"));
		this.getContentPane().add(txtGubun);
		this.getContentPane().add(new JLabel("이름"));
		this.getContentPane().add(txtName);
		this.getContentPane().add(new JLabel("전화"));
		this.getContentPane().add(txtTel);

		this.getContentPane().add(btnInsert);
		this.getContentPane().add(btnUpdate);
		this.getContentPane().add(btnDelete);
		this.getContentPane().add(btnSelectAll);
		this.getContentPane().add(btnFindName);

		this.getContentPane().add(txtList);

		this.getContentPane().add(txtList);

		btnInsert.addActionListener(new ClickHandler());
		btnUpdate.addActionListener(new UpdateHandler());
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				delete(); // 이것이야 말로!!!익명객체
			}
		});
		//람다식: 메소드를 하나의 간결한 식(expression)으로 표현한 것
		//메소드를 람다식으로 표현하면 메소드의 이름과 반환값이 없어지므로 람다식을 
		//'익명 함수(anonymous function)'라고도 한다.
		btnSelectAll.addActionListener(e ->selectAll() );
		btnFindName.addActionListener(e -> findName());	
			
		
	}

	class UpdateHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			update();
		}

	}

	class ClickHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			insert();

		}
	}

	// 등록
	public void insert() {
		Friend friend = new Friend();
		friend.setGubun(txtGubun.getText()); //구분에 있는 텍스트를 가져오겠다
		friend.setName(txtName.getText());
		friend.setTel(txtTel.getText());
		friendList.insert(friend);
	}

	// 수정
	public void update() {
		Friend friend = new Friend();
		friend.setName(txtName.getText());
		friend.setTel(txtTel.getText());
		friendList.update(friend);
	}

	// 삭제
	public void delete() {
		String name = txtName.getText();
		friendList.delete(name);
	}

	// 이름검색
	public void findName() {
		String name = txtName.getText();
		Friend friend = friendList.selectOne(name);
		txtGubun.setText(friend.getGubun());
		txtTel.setText(friend.getTel());
		txtName.setText(friend.getName());
	}

	// 전체조회
	public void selectAll() {
		List<Friend> list = friendList.selectAll();
		StringBuffer sb = new StringBuffer();
		for (Friend friend : list) {
			sb.append(friend);
			sb.append("\n");
		}
		txtList.setText(sb.toString());
	}

}
