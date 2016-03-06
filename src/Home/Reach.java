
package Home;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Properties;

public class Reach
    extends ActionSupport
{
    private String myemail;

    private String mytelephone;

    private String myname;

    private String message;

    private int out;

    public int getOut()
    {
        return out;
    }

    public void setOut( int out )
    {
        this.out = out;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage( String message )
    {
        this.message = message;
    }

    public String getMyname()
    {
        return myname;
    }

    public void setMyname( String myname )
    {
        this.myname = myname;
    }

    final static private String FAILURE = "failure";

    public String getMytelephone()
    {
        return mytelephone;
    }

    public void setMytelephone( String mytelephone )
    {
        this.mytelephone = mytelephone;
    }

    public String getMyemail()
    {
        return myemail;
    }

    public void setMyemail( String myemail )
    {
        this.myemail = myemail;
    }

    public Reach()
    {
    }

    @Override
    public String execute()
        throws Exception
    {
        out = 1;
        /*
         * String from = "him448@gmail.com"; String to = "him448@gmail.com"; String subject = "IMP:Reach Us Msg"; String
         * message1 = "Sender's mail:"+myemail+"\nSender's Name:"+myname+"\nSender's Number:"
         * +mytelephone+"\nMSG:"+message; String login = "him448@gmail.com"; String password = "celeronn";
         */

        // try {
        /*
         * Properties props = new Properties(); props.setProperty("mail.host", "smtp.gmail.com");
         * props.setProperty("mail.smtp.port", "587"); props.setProperty("mail.smtp.auth", "true");
         * props.setProperty("mail.smtp.starttls.enable", "true"); Authenticator auth = new SMTPAuthenticator(login,
         * password); Session session = Session.getInstance(props, auth); MimeMessage msg = new MimeMessage(session);
         * msg.setText(message1); msg.setSubject(subject); msg.setFrom(new InternetAddress(from));
         * msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); Transport.send(msg);
         */

        /*
         * catch (AuthenticationFailedException ex) { } catch (AddressException ex) { } catch (MessagingException ex) {
         * }
         */

        return SUCCESS;
    }

    public String clearall()
    {
        return FAILURE;
    }
    /*
     * private class SMTPAuthenticator extends Authenticator { private PasswordAuthentication authentication; public
     * SMTPAuthenticator(String login, String password) { authentication = new PasswordAuthentication(login, password);
     * } protected PasswordAuthentication getPasswordAuthentication() { return authentication; } }
     */
}
