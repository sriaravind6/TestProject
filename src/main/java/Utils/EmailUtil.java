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
     /*   final String fromEmail = "aravindeee18@gmail.com"; // Sender's email
        final String password = "8143224606"; // App-specific password

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587"); // Use 587 with STARTTLS
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS

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
    }*/
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");          // Gmail SMTP server
        props.put("mail.smtp.port", "587");                     // TLS port (587)
        props.put("mail.smtp.auth", "true");                    // Enable authentication
        props.put("mail.smtp.starttls.enable", "true");         // Enable STARTTLS for security


        // Gmail Credentials (Use App Password if 2FA is enabled)
        final String senderEmail = "aravindeee18@gmail.com";
        final String appPassword = "8143224606";

        // Create Session with Authenticator
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, appPassword);
            }
        });

        try {
            // Create a MimeMessage
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));      // Sender's Email
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toEmail)); // Recipient's Email
            message.setSubject(subject);       // Email Subject

            // Email Body (Text + Attachment)
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);

            // Attachment Part
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(filePath);  // Path to your attachment

            // Combine Parts
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);
            message.setContent(multipart);

            // Send the Email
            Transport.send(message);
            System.out.println("Email sent successfully with attachment!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
