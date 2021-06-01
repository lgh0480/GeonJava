package 상속;

public class DmbCellPhoneTest {

	public static void main(String[] args) {
		DmbCellPhone phone = new DmbCellPhone(); 
		DmbCellPhone dmbCellPhone = new DmbCellPhone("삼성","검정",10);
		
		System.out.println(dmbCellPhone.model);
		System.out.println(dmbCellPhone.color);
		
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannelDmb(100);
		dmbCellPhone.turnOffDmb();
		dmbCellPhone.powerOff();
		
	
	
	}


}
