package co.geonhui.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class naverSend {
	
	static void naverMailsend() {
		
		//발신자의 메일계정과 비밀번호를 설정
		final String user = "lgh0480@naver.com";
		final String password = "rjs#5502a1als";
		
		//Property에 SMTP 서버 정보를 설정
		Properties props = new Properties();
		props.put("mail.smtp.host","smtp.naver.com");
		props.put("mail.smtp.port",587); //SMTP서버와 통신하는 포트 
		props.put("mail.smtp.host" , "true");
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		try { 
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("ktko@ktko.com"));
			
			// 메일 제목
			message.setSubject("KTKO SMTP TEST1111");
			// 메일 내용 
			message.setText("KTKO Success!!");
			// send the message 
			Transport.send(message); 
			System.out.println("Success Message Send");
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	
}//end of naverMailsend

public static void main(String[] args) {
	naverMailsend();
	
}
		
	
}// end of class
