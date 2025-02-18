package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.java.dao.MMapper;
import com.java.dto.MemberDto;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMessage.RecipientType;

@Service
public class MServiceImpl implements MService {

	@Autowired MMapper mMapper;
	@Autowired JavaMailSender javaMailsender; // 이메일 전송객체 : text만 가능
	
	@Override
	public MemberDto login(MemberDto mdto) {
		
		MemberDto memberDto = mMapper.selectLogin(mdto);
		return memberDto;
	}

	@Async // 비동기식으로 : 시간이 오래걸려도 다음 시스템이 실행되게
	@Override
	public String sendEmail(String email) {
		
		String pwCode = getCreateKey();
		
		// 네이버 이메일 발송 - 보내는 이의 메일도 네이버메일이여야함
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email); // 받는이
		message.setFrom("mylim52@naver.com"); // 보내는이
		message.setSubject("인증코드 입니다."); // 제목
		message.setText("안녕하세요. 회원가입을 위한 이메일 인증코드입니다. \n" + "[ 인증코드 : "+pwCode+" ]"); // 내용
		
		javaMailsender.send(message); 
		System.out.println("이메일 전송완료!");
		
		return pwCode;
	}
	
	@Override
	public String sendEmail2(String email) {
		
		String pwCode = getCreateKey();
		
		// 네이버 이메일 발송 - html
		MimeMessage message = javaMailsender.createMimeMessage();
		
		try {
			message.setSubject("[ 안내 ] 인증코드를 보내드립니다.","utf-8");
			String hdata = ""
//					+ "<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>\r\n"
//					+ "<html xmlns='http://www.w3.org/1999/xhtml' lang='ko' xml:lang='ko'>\r\n"
//					+ "<head>\r\n"
//					+ "<meta http-equiv='Content-Type' content='application/xhtml+xml; charset=utf-8' />\r\n"
//					+ "<meta http-equiv='X-UA-Compatible' content='IE=edge' />\r\n"
//					+ "<title> 비밀번호 발송 </title>\r\n"
//					+ "\r\n"
//					+ "\r\n"
//					+ "</head>\r\n"
//					+ "<body bgcolor='#FFFFFF' leftmargin='0' topmargin='0' marginwidth='0' marginheight='0' style='margin:0; padding:0; font:normal 12px/1.5 돋움;'>\r\n"
//					+ "\r\n"
//					+ "\r\n"
//					+ "<table width='700' cellpadding='0' cellspacing='0' align='center'>\r\n"
//					+ "<tr>\r\n"
//					+ "	<td style='width:700px;height:175px;padding:0;margin:0;vertical-align:top;font-size:0;line-height:0;'>\r\n"
//					+ "		<img src='../images/email/img_email_top.jpg' alt='JARDIN' />					\r\n"
//					+ "	</td>\r\n"
//					+ "</tr>\r\n"
//					+ "<tr>\r\n"
//					+ "	<td style='width:700px;height:78px;padding:0;margin:0;vertical-align:top;'>\r\n"
//					+ "		<p style='width:620px;margin:50px 0 40px 38px;text-align:center;font-size:0;line-height:0;'><img src='../images/email/img_txt_password01.jpg' alt='원두커피의 名家, JARDIN 인증코드가 발급되었습니다.' /></p>\r\n"
//					+ "	</td>\r\n"
//					+ "</tr>\r\n"
					+ "<tr>\r\n"
					+ "	<td style='width:700px;height:196px;padding:0;margin:0;vertical-align:top;'>\r\n"
					+ "		<table width='618' height='194' cellpadding='0' cellspacing='0' align='center' style='margin:0 0 0 40px;border:1px #d9d9d9 solid;'>\r\n"
					+ "		<tr>\r\n"
					+ "			<td style='width:618px;height:194px;padding:0;margin:0;vertical-align:top;font-size:0;line-height:0;background:#f9f9f9;'>\r\n"
					+ "				<p style='width:620px;margin:30px 0 0 0;padding:0;text-align:center;'><img src='../images/email/img_txt_password02.jpg' alt='JARDIN에서 비밀번호 찾기를 요청하셨습니다.' /></p>\r\n"
					+ "				<p style='width:620px;margin:10px 0 0 0;padding:0;text-align:center;color:#888888;font-size:12px;line-height:1;'>아래의 PASSWORD는 임시 인증코드이므로 홈페이지 로그인 후 다시 수정해 주십시오.</p>\r\n"
					+ "				<p style='width:620px;margin:28px 0 0 0;padding:0;text-align:center;color:#666666;font-size:12px;line-height:1;'><strong>임시 인증코드 : <span style='color:#f7703c;line-height:1;'>"+pwCode+"</span></strong></p>\r\n"
					+ "				<p style='width:620px;margin:30px 0 0 0;padding:0;text-align:center;color:#888888;font-size:12px;line-height:1.4;'>쟈뎅샵에서는 고객님께 보다 나은 서비스를 제공하기 위해 항상 노력하고 있습니다.<br/>앞으로 많은 관심 부탁드립니다.</p>\r\n"
					+ "			</td>\r\n"
					+ "		</tr>\r\n"
					+ "		</table>	\r\n"
					+ "	</td>\r\n"
					+ "</tr>\r\n"
//					+ "<tr>\r\n"
//					+ "	<td style='width:700px;height:120px;padding:0;margin:0;vertical-align:top;'>\r\n"
//					+ "		<p style='width:700px;margin:30px 0 50px 0;text-align:center;'><a href='#'><img src='../images/email/btn_jardin.jpg' alt='JARDIN 바로가기' /></a></p>\r\n"
//					+ "	</td>\r\n"
//					+ "</tr>\r\n"
//					+ "<tr>\r\n"
//					+ "	<td style='width:700px;height:50px;padding:0;vertical-align:top;font-size:0;line-height:0;text-align:center;'>\r\n"
//					+ "		<img src='../images/email/img_email_bottom.jpg' alt='' />\r\n"
//					+ "	</td>\r\n"
//					+ "</tr>\r\n"
//					+ "<tr>\r\n"
//					+ "	<td style='width:700px;height:140px;padding:0;margin:0;vertical-align:top;background-color:#5a524c;'>\r\n"
//					+ "		<p style='width:620px;margin:20px 0 0 40px;padding:0;text-align:center;line-height:1.5;color:#b2aeac;'>메일수신을 원치 않으시는 분은 로그인 후. <span style='color:#ffffff'>메일 수신 여부</span>를 변경해주시기 바랍니다.<br/>IF YOU DO NOT WISH TO RECEIVE EMAILS FROM US, PLEASE LOG-IN AND UPDATE<br/> YOUR MEMBERSHIP INFORMATION.</p>\r\n"
//					+ "\r\n"
//					+ "		<p style='width:620px;margin:15px 0 0 40px;padding:0;text-align:center;line-height:1.5;color:#b2aeac;'><span style='color:#ffffff'>본 메일에 관한 문의사항은 사이트 내 고객센터를 이용해주시기 바랍니다.</span><br/>COPYRIGHT ©  2014 JARDIN ALL RIGHTS RESERVED.</p>\r\n"
//					+ "	</td>\r\n"
//					+ "</tr>\r\n"
//					+ "</table>\r\n"
//					+ "\r\n"
//					+ "\r\n"
//					+ "\r\n"
//					+ "</div>\r\n"
//					+ "</body>\r\n"
//					+ "</html>"
//					+""
//					+""
//					+""
					+"";
			message.setText(hdata,"utf-8","html"); // 언어, 타입
			message.setFrom(new InternetAddress("mylim52@naver.com")); // 보내는이
			message.addRecipient(RecipientType.TO, new InternetAddress(email)); // 받는이
			javaMailsender.send(message);
		} catch (MessagingException e) {e.printStackTrace();}
		
		System.out.println("이메일 전송완료!");
		return pwCode;
	}
	
	// pwCode 만들기
	public String getCreateKey() {
		
		String pwCode = "";
		char[] charSet = {
				'0','1','2','3','4','5','6','7','8','9',
				'A','B','C','D','E','F','G','H','I','J',
				'K','L','M','N','O','P','Q','R','S','T',
				'U','V','W','X','Y','Z'};
		
		// 10자리 랜덤 비밀번호 생성
		int idx = 0;
		for(int i=0;i<10;i++) {
			idx = (int)(Math.random()*36);
			pwCode += ""+charSet[idx];
		}
		
		System.out.println("임시비밀번호 : "+pwCode);
		return pwCode;
	}

}
