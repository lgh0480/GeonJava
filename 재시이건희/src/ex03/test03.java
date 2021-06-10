package ex03;

public class test03 {

	public static void main(String[] args) {

	String[] arr = {"bb.jpg","area.txt","moomin.jpeg","work.txt","you.JPG" };
	int cnt = 0;
	
	for (String a : arr ) {
		if (a.substring(a.length()-1).equals("g") || a.substring(a.length()-1).equals("G")){
			cnt++;
			System.out.println(a);
		}
	}
	System.out.println("이미지파일 수 : " + cnt );

		
	
	}

}
