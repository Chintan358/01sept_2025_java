package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

@WebServlet("/mail")
public class MailController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	

		

		        final String fromEmail = "chintan.tops@gmail.com";
		        final String password = ""; // NOT normal password
		        final String toEmail = "chintan.tops@gmail.com";

		        // SMTP settings
		        Properties props = new Properties();
		        props.put("mail.smtp.host", "smtp.gmail.com");
		        props.put("mail.smtp.port", "587");
		        props.put("mail.smtp.auth", "true");
		        props.put("mail.smtp.starttls.enable", "true");

		        // Authentication
		        Session session = Session.getInstance(props,
		            new Authenticator() {
		                protected PasswordAuthentication getPasswordAuthentication() {
		                    return new PasswordAuthentication(fromEmail, password);
		                }
		            });

		        try {
		            Message message = new MimeMessage(session);
		            message.setFrom(new InternetAddress(fromEmail));
		            message.setRecipients(
		                Message.RecipientType.TO,
		                InternetAddress.parse(toEmail)
		            );

		            message.setSubject("Test Email from Java");
		            message.setText("Hello, this is a test email sent using Gmail SMTP!");

		            Transport.send(message);

		            System.out.println("Email sent successfully!");

		        } catch (MessagingException e) {
		            e.printStackTrace();
		        }
		    }
	
}
