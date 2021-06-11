package co.board.model;

public class User {
	// 회원 정보
	
	private String u_id;
	private String u_pass;

	public String getU_id() {
		return u_id;
	}


	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_pass() {
		return u_pass;
	}

	public void setU_pass(String u_pass) {
		this.u_pass = u_pass;
	}
	@Override
	public String toString() {
		return "BoardMember [u_id=" + u_id + "]";
	}

}
