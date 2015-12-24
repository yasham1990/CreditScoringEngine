
package client;

import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class Reach
    extends ActionSupport
{
    static Logger log = Logger.getLogger( ActionSupport.class );

    private String myemail;

    private String mytelephone;

    private String myname;

    private String message;

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
        final String from = "him448@gmail.com";
        String to = "him448@gmail.com";
        String subject = "IMP:Reach Us Msg";
        String message1 = "Sender's mail:" + myemail + "\nSender's Name:" + myname + "\nSender's Number:" + mytelephone
            + "\nMSG:" + message;
        final String password = "celeronn";
        try
        {

            Properties props = new Properties();
            props.setProperty( "mail.host", "smtp.gmail.com" );
            props.setProperty( "mail.smtp.port", "587" );
            props.setProperty( "mail.smtp.auth", "true" );
            props.setProperty( "mail.smtp.starttls.enable", "true" );
            Session session = Session.getInstance( props, new javax.mail.Authenticator()
            {
                protected PasswordAuthentication getPasswordAuthentication()
                {
                    return new PasswordAuthentication( from, password );
                }
            } );
            MimeMessage msg = new MimeMessage( session );
            msg.setText( message1 );
            msg.setSubject( subject );
            msg.setFrom( new InternetAddress( from ) );
            msg.addRecipient( Message.RecipientType.TO, new InternetAddress( to ) );
            Transport.send( msg );

        }
        catch ( AuthenticationFailedException e )
        {
            log.error( e.getMessage() );
        }
        catch ( AddressException e )
        {
            log.error( e.getMessage() );
        }
        catch ( MessagingException e )
        {
            log.error( e.getMessage() );
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }

        return SUCCESS;
    }

    public String clearall()
    {
        return FAILURE;
    }

   

}
