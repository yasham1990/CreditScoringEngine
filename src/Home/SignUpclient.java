    package Home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

import Utility.ScoringUtility;

public class SignUpclient
    extends ActionSupport

{

    ScoringUtility utility = null;

    Connection con1 = null;

    static Logger log = Logger.getLogger( SignUpclient.class );

    final static private String SIGNUPCLIENTBACK = "signupclientback";

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
        utility = new ScoringUtility();
        try
        {
            con1 = utility.openDatabaseConnection();
            String str = "insert into clients( c_firstname,c_lastname,c_phone,c_email,c_pass) VALUES(?,?,?,?,?) ";
            PreparedStatement ps = con1.prepareStatement( str );
            ps.setString( 1, signUpBean.getFname() );
            ps.setString( 2, signUpBean.getLname() );
            ps.setString( 3, signUpBean.getMobile() );
            ps.setString( 4, signUpBean.getEmail() );
            ps.setString( 5, signUpBean.getPass() );
            ps.executeUpdate();
            con1.close();
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
        checkData( "clients" );
    }

    private void checkData( String tableName )
    {
        utility = new ScoringUtility();
        try
        {
            con1 = utility.openDatabaseConnection();
            String str = "SELECT c_email FROM " + tableName + " where c_email='" + signUpBean.getEmail() + "'";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( str );
            if ( rs != null && rs.next() )
                addFieldError( "signUpBean.email", "User already exits." );
            con1.close();
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }

    }

}
