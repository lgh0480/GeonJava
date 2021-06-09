package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class SqliteConnect {
	// 필드로 선언
	static PreparedStatement psmt; // 스테틱으로 선언해야됨
	static ResultSet rs;
	static Connection conn;
	// 1.조회, 2.입력, 3.수정 4.삭제 5.전체리스트(각각 기능을 분리) => 메서드로 기능 분리.

	// 전체리스트 //항상 커넥션 객체가 있어야됨.
	public static ArrayList<Person> getPersonList() {
		ArrayList<Person> personList = new ArrayList<>(); // 담을 변수를 선언해야됨.
		connect(); // Connection 객체 연결.
		String sql = "select * from person";
		try {
			psmt = conn.prepareStatement(sql); // Connection가지고있는 sql실행하고 결과를 받아내는것
			rs = psmt.executeQuery(); // 쿼리실행결과를 가져오는 부분 // select만 사용함
			while (rs.next()) { // 건수 만큼 반복
				// System.out.println(rs.getInt("id")+"," + rs.getString("name")); // rs. 가지고있는
				// id를 가져옴
				Person person = new Person(); // 데이터 베이스에서 선언된 4개의 값을 person에 담기위해서
				person.setId(rs.getInt("id")); // db에 있는 id 컬럼 값을 가져 오는게 rs.getInt("id")이다.
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
				person.setPhone(rs.getString("Phone"));
				personList.add(person); // 최종적으로 리스트에 입력한 값을 한건씩 담는 것이 add();이다.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(); // 실행이 잘되고 안되고 간에 무조껀 close
		}
		return personList;
	}

	// 한건조회 -> 한건만 가져올수 있는 조건이 필요함
	public static Person getPerson(int id) {
		connect();
		String sql = "select * from person where id = ?"; // ? 값을
		Person p = null;
		try {
			psmt = conn.prepareStatement(sql); // PreparedStatment 객체 생성
			psmt.setInt(1, id); // 1의 매개변수는 ?이거를 뜻함 . 두번째는 메서드에 매개변수
			rs = psmt.executeQuery();
			if (rs.next()) {
				p = new Person(); // instance 를 생성하고 변수 p에 대입
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setPhone(rs.getString("Phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return p;
	}

	// 이름만 조회
	public static ArrayList<Person> getPersonName(String name) {
		connect();
		ArrayList<Person> nameList = new ArrayList<>();

		String sql = "select * from person where name=?";
		try {
			psmt = conn.prepareStatement(sql); // Connection가지고있는 sql실행하고 결과를 받아내는것
			psmt.setString(1, name);
			rs = psmt.executeQuery(); // 쿼리실행결과를 가져오는 부분 // select만 사용함
			// nameList = new ArrayList<>();
			while (rs.next()) { // 건수 만큼 반복
				// System.out.println(rs.getInt("id")+"," + rs.getString("name")); // rs. 가지고있는
				// id를 가져옴
				Person person = new Person(); // 데이터 베이스에서 선언된 4개의 값을 person에 담기위해서
				person.setId(rs.getInt("id")); // db에 있는 id 컬럼 값을 가져 오는게 rs.getInt("id")이다.
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
				person.setPhone(rs.getString("Phone"));
				nameList.add(person); // 최종적으로 리스트에 입력한 값을 한건씩 담는 것이 add();이다.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(); // 실행이 잘되고 안되고 간에 무조껀 close
		}
		return nameList;
	}

	// 입력기능 -- 데이터 넣어버리면 끝남 , 실행하는 메서드도 다름
	public static void insertPerson(int id, String name, int age, String Phone) {
		connect();
		String sql = "insert into person values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.setString(2, name);
			psmt.setInt(3, age);
			psmt.setString(4, Phone);
			int r = psmt.executeUpdate(); // insert, update , delete 할 때 사용합니다.
			System.out.println(r + "건 입력.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	// 수정기능
	public static void updatePerson(Person p) {
		connect();
		String sql = "update person set name=?, age=?,phone=? where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, p.getName());
			psmt.setInt(2, p.getAge());
			psmt.setString(3, p.getPhone());
			psmt.setInt(4, p.getId());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	// 삭제기능
	public static void deletePerson(int id) {
		connect();
		String sql = "delete from person where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r + " 건 입력되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public static void connect() { // db 연결 하는것 까지만 하는것
//		Connection conn = null; // 자바 프로그램이랑 sql이랑 연결해주는 통로
		String url = "jdbc:sqlite:C:/sqlite/db/sample.db"; // db를 쓰기위한 작업
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("연결성공!!!");

//		PreparedStatement psmt = conn.prepareStatement("select * from person"); //쿼리를 실행하고 받아오는  
//		ResultSet rs = psmt.executeQuery(); //결과값을 받는타입. 

		} catch (SQLException e) {
			e.printStackTrace();
//		} finally {
//			if (conn != null) {
//				try {
//					conn.close();
//
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
		}
	}

	public static void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // System.in 키보드로 입력하는 값

		while (true) {
			System.out.println("1:전체리스트 2:입력  3:수정 4:삭제 5:한건조회 6.이름조회 9:종료");
			int menu = scanner.nextInt();
			if (menu == 1) {
				// 전체리스트 기능.
				System.out.println("<조회결과>");
				ArrayList<Person> list = getPersonList(); // personList를 반환했다.
				for (Person person : list) {
					System.out.println(person);
				}

			} else if (menu == 2) {
				// 입력기능
				System.out.println("아이디를 입력하세요 > ");
				int searchId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("이름을 입력하세요 > ");
				String name = scanner.nextLine();
				System.out.println("나이를 입력하세요 > ");
				int age = scanner.nextInt();
				scanner.nextLine();
				System.out.println("전화번호를 입력하세요 > ");
				String Phone = scanner.nextLine();

				insertPerson(searchId, name, age, Phone);

			} else if (menu == 3) {
				// 수정
				System.out.print("조회할 아이디를 입력하세요 >");
				int searchId = scanner.nextInt();
				scanner.nextLine();
				Person p = getPerson(searchId); // p ->id(고정값), name, age, Phone 다들어가있음.

				if (p == null) { // 조회아이디가 존재 x.
					System.out.println("존재하지 않는 아이디입니다 다시 입력하세요.");
					continue;
				}

				System.out.print("변경할 이름을 입력하세요 >");
				String changeName = scanner.nextLine(); // 비어있으면 안넣겠다는 의미
				System.out.print("변경할 나이을 입력하세요 > ");
				String changeAge = scanner.nextLine();
				System.out.println("변경할 연락처를 입력하세요 > ");
				String changePhone = scanner.nextLine();
				if (!changeName.equals("")) {
					p.setName(changeName); // ??
				}
				if (!changeAge.equals("")) {
					p.setAge(Integer.parseInt(changeAge));
				}
				if (!changePhone.equals("")) {
					p.setPhone((changePhone));
				}
				updatePerson(p);

				;
			} else if (menu == 4) {
				System.out.println("삭제할 아이디를 입력하세요.");
				int searchId = scanner.nextInt();
				scanner.nextLine();
				deletePerson(searchId);

			} else if (menu == 5) {
				// 한건조회
				System.out.println("조회할 아이디를 입력하세요.");
				int searchId = scanner.nextInt();
				Person p = getPerson(searchId);
				if (p == null) {
					System.out.println("조회된 값이 없습니다.");
				} else {
					System.out.println(p);
				}

			} else if (menu == 6) {
				// 이름조회
				System.out.println("조회할 이름을 입력하세요");
				String name = scanner.next();

				ArrayList<Person> p = getPersonName(name);
				if (p.size() == 0) { // ArrayList 메서드 길이 비교 구문
					System.out.println("조회된 이름이 없습니다.");
				} else {
					System.out.println(p);
				}

			} else if (menu == 9) {
				break;
			}
		} // end of while
		scanner.close();
		System.out.println("정상적인 종료ㅋㅋ"); // break에서 빠지면 메세지가 출력이된다.
	} // end of main()
} // end of class
