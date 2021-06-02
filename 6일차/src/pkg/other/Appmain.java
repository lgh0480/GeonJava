package pkg.other;

import pkg.Car;
import pkg.Count;
import pkg.DateUtil;
import pkg.ProjectInfo;

public class Appmain {

	public static void main(String[] args) {
		Car car = new Car();
		car.setModel("테슬라");
		car.setSpeed(100);
		
		Car car2 = new Car("람보르기니",250);
		Car car3 = new Car("르노");
		System.out.println(car3.getModel());
		
		System.out.println(DateUtil.curDate());
		System.out.println(ProjectInfo.name);
		
		Count count1 = new Count();
		Count.cnt1++;
		count1.setCnt2(count1.getCnt2()+ 1);
	
	}

}
