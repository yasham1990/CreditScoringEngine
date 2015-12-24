/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import Utility.ScoringUtility;

/**
 * @author yasham
 */
public class clientpass
    extends ActionSupport
    implements SessionAware
{

    ScoringUtility utility = null;

    Connection con1 = null;

    static Logger log = Logger.getLogger( clientpass.class );

    final static private String CLIENTPASSCHANGEBACK = "back";

    final static private String CLIENTPASSCHANGEBACKCHANGE = "change";

    private SessionMap<String, Object> sessionMap;

    @Override
    public void setSession( Map<String, Object> sessionMap )
    {
        this.sessionMap = (SessionMap<String, Object>) sessionMap;
    }

    public clientpass()
    {
    }

    private String id;

    private String oldpassword;

    int flag = 0;

    public String getId()
    {
        return id;
    }

    public void setId( String id )
    {
        this.id = id;
    }

    private String password;

    private String confirmpassword;

    public String getConfirmpassword()
    {
        return confirmpassword;
    }

    public void setConfirmpassword( String confirmpassword )
    {
        this.confirmpassword = confirmpassword;
    }

    public String getOldpassword()
    {
        return oldpassword;
    }

    public void setOldpassword( String oldpassword )
    {
        this.oldpassword = oldpassword;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public String execute()
        throws Exception
    {
        utility = new ScoringUtility();
        try
        {
            con1 = utility.openDatabaseConnection();
            String str = "SELECT c_pass FROM  clients where primarykey='" + sessionMap.get( "primarykey" ) + "'";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( str );

            if ( rs != null && rs.next() && oldpassword.equals( rs.getString( 1 ) ) )
            {
                String str1 = "update clients set c_pass=? where primarkey=? ";
                PreparedStatement ps = con1.prepareStatement( str1 );
                ps.setString( 1, password );
                ps.setString( 2, (String) sessionMap.get( "primarykey" ) );
                ps.executeUpdate();
            }
            con1.close();
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return SUCCESS;
    }

    public String back()
    {

        return CLIENTPASSCHANGEBACK;
    }

    public void validate()
    {
        if ( "".equals( getOldpassword() ) )
        {
            addFieldError( "oldpassword", "Password is required" );
        }
        else if ( oldpassword.length() != 0 )
        {
            try
            {
                String str = "SELECT c_pass FROM  clients where primarykey='" + sessionMap.get( "primarykey" ) + "'";
                java.sql.Statement stmt = con1.createStatement();
                ResultSet rs = stmt.executeQuery( str );
                if ( rs != null && rs.next() && !oldpassword.equals( rs.getString( 1 ) ) )
                {
                    addFieldError( "oldpassword", "Old Password did not match" );
                }
                con1.close();
            }
            catch ( Exception e )
            {
                log.error( e.getMessage() );
            }

        }
        if ( "".equals( getPassword() ) )
        {
            addFieldError( "password", "Password is required" );
        }
        else if ( !getPassword().matches( "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})" ) )
            addFieldError( "password", "Invalid password" );
        else if ( "".equals( getConfirmpassword() ) )
        {
            addFieldError( "confirmpassword", "ConfirmPassword is required" );
        }

        else if ( !( getPassword().equals( getConfirmpassword() ) ) )
        {
            addFieldError( "confirmpassword", "Password did not match" );
        }

    }
}
