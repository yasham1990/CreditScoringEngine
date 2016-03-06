package Home;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import hibernatemapping.Client;

public class SignUpclient
    extends ActionSupport

{

    static Logger log = Logger.getLogger( SignUpclient.class );

    final static private String SIGNUPCLIENTBACK = "signupclientback";

    EmployeeManagement employeeManagement = new EmployeeManagement();

    private SignUpBean signUpBean;

    public SignUpBean getSignUpBean()
    {
        return signUpBean;
    }

    public void setSignUpBean( SignUpBean signUpBean )
    {
        this.signUpBean = signUpBean;
    }

    public String execute()
        throws Exception
    {
        try
        {
            Client client = new Client();
            client.setEmail( signUpBean.getEmail() );
            client.setFirstname( signUpBean.getFname() );
            client.setLastname( signUpBean.getLname() );
            client.setPhone( signUpBean.getMobile() );
            client.setClientPass( signUpBean.getPass() );
            employeeManagement.create( client );
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return SUCCESS;
    }

    public String signupclientback()
    {
        return SIGNUPCLIENTBACK;
    }

    public void validate()
    {
        if ( "".equals( signUpBean.getPass() ) )
        {
            addFieldError( "signUpBean.pass", "Password is required" );
        }
        else if ( !signUpBean.getPass().matches( "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})" ) )
            addFieldError( "signUpBean.pass", "Invalid password" );
        else if ( "".equals( signUpBean.getConfirmpassword() ) )
        {
            addFieldError( "signUpBean.confirmpassword", "ConfirmPassword is required" );
        }

        else if ( !( signUpBean.getPass().equals( signUpBean.getConfirmpassword() ) ) )
        {
            addFieldError( "signUpBean.confirmpassword", "Password did not match" );
        }
        else
        {
            Client client = employeeManagement.getClient( signUpBean.getEmail() );
            if ( client != null )
                addFieldError( "signUpBean.email", "User already exits." );
        }

    }

}
