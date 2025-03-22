package Utils;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class EmailUtil {

    public static void sendEmailWithAttachment(String toEmail, String subject, String body, String filePath) {
        final String fromEmail = "aravindeee18@gmail.com.com"; // Sender's email
        final String password = "8143224606"; // Sender's email password

        Properties props = new Properties();
//        props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
//        props.put("mail.smtp.port", "465"); // TLS Port
//        props.put("mail.smtp.auth", "true"); // Enable authentication
//        props.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465"); // OR use 587 with STARTTLS
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        // Create a session with the properties and authenticate
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            // Create a new email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);

            // Create a multipart message for attachment
            Multipart multipart = new MimeMultipart();

            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);
            multipart.addBodyPart(messageBodyPart);

            // Create the attachment part
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(filePath);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filePath);
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully with attachment.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
