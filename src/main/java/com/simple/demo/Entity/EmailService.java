package com.simple.demo.Entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.Authenticator;
import jakarta.mail.BodyPart;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

@Service
public class EmailService {
	
	
	
	@Autowired
	public JavaMailSender javaMailSender;

	@Autowired
	private Environment env;

	@Autowired
	private ResourceLoader resourceLoader;
	
	

	public boolean sendmail(CurdEntity model) throws MessagingException {
		
		String name=model.getName();
		String mobile=model.getMobileNumber();
		String email=model.getEmailAddress();
		
		
		String sub="welcome to Devop";
		String otpCode="123456";
		
//		Path emailTemplatePath = Paths.get("").toAbsolutePath();
//		System.out.println("emailTemplatePath==>" + emailTemplatePath + "/resource/adminlogin.html");
//		File saveFile = new File(emailTemplatePath + "/resource/adminlogin.html");
		File saveFile = new File( "resource/adminlogin.html");
		String message = getMailBody(saveFile.getPath());
		message = message.replace(AppConstants.NAME, name);
		message = message.replace(AppConstants.MOBILE, mobile);
		message=message.replace(AppConstants.EMAIL_ADDRESS, email);
		message = message.replace(AppConstants.VERIFICATIONPIN,otpCode );
		message = message.replace(AppConstants.LOGO, AppConstants.EMAIL_LOGO_PATH);
		message = message.replace(AppConstants.REGARDS, "Basispay");

		boolean sent = sendEmail(email, AppConstants.Login, message, null);

		return sent;
	}

	private String getMailBody(String configurationFilePath) {
		StringBuffer sb = new StringBuffer();
		InputStream is = null;
		try {
			is = new FileInputStream(new File(configurationFilePath));
			int ch;
			while ((ch = is.read()) != -1)
				sb.append((char) ch);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (Exception e) {
			}
			is = null;
		}
		return sb.toString();

	}

	private boolean sendEmail(String toMail, String subject, String emailcontent, String filename)
			throws  MessagingException {

		boolean ismailSent = false;
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", env.getProperty("spring.mail.host"));
		properties.put("mail.smtp.port", env.getProperty("spring.mail.port"));
		properties.put("mail.smtp.auth", env.getProperty("spring.mail.properties.mail.smtp.auth"));
		properties.put("mail.transport.protocol", env.getProperty("spring.mail.properties.mail.smtp.port"));
		properties.put("mail.smtp.connectiontimeout",
				env.getProperty("spring.mail.properties.mail.smtp.connectiontimeout"));
		properties.put("mail.smtp.starttls.enable",
				env.getProperty("spring.mail.properties.mail.smtp.starttls.enable"));
		properties.put("mail.smtp.socketFactory.port",
				env.getProperty("spring.mail.properties.mail.smtp.socketFactory.port"));
		properties.put("mail.smtp.socketFactory.class",
				env.getProperty("spring.mail.properties.mail.smtp.socketFactory.class"));

		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(env.getProperty("spring.mail.username"),
						env.getProperty("spring.mail.password"));
			}
		});

		MimeMessage message = new MimeMessage(session);
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom(env.getProperty("spring.mail.username"));
		helper.setTo(toMail);
		helper.setSubject(subject);

		/** Send message with html format **/
		Multipart multipart = new MimeMultipart();
		BodyPart htmlBodyPart = new MimeBodyPart();

		if (filename != null) {
			try {
				MimeBodyPart attachPart = new MimeBodyPart();
				Resource resource = resourceLoader.getResource("/WEB-INF/receiptDocuments/" + filename);
				DataSource source = new FileDataSource(resource.getFile().getPath());

				attachPart.setDataHandler(new DataHandler(source));
				attachPart.setFileName(new File(resource.getFile().getName()).getName());

				multipart.addBodyPart(attachPart);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		htmlBodyPart.setContent(emailcontent, "text/html");
		multipart.addBodyPart(htmlBodyPart);
		message.setContent(multipart);
		Transport.send(message);
		ismailSent = true;
		System.out.println("Mail has been sent successfully!");
		return ismailSent;
	}

}
