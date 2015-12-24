/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import Utility.ScoringUtility;
import client.registerform;

/**
 * @author yasham
 */
public class login
    extends ActionSupport
    implements SessionAware
{
    ScoringUtility utility = null;

    Connection con1 = null;

    private String userName;

    private String official = "";

    private SessionMap<String, Object> sessionMap;

    final static private String ADMIN = "admin";

    final static private String MANAGER = "manager";

    final static private String EMPLOYEE = "employee";

    final static private String USER = "user";
    
    final static private String SIGNUPCLIENT = "signupclient";
    
    private String pass1;

    static Logger log = Logger.getLogger( login.class );

    @Override
    public void setSession( Map<String, Object> sessionMap )
    {
        this.sessionMap = (SessionMap<String, Object>) sessionMap;
    }

    public String getOfficial()
    {
        return official;
    }

    public void setOfficial( String official )
    {
        this.official = official;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName( String userName )
    {
        this.userName = userName;
    }

    public String getPass1()
    {
        return pass1;
    }

    public void setPass1( String pass1 )
    {
        this.pass1 = pass1;
    }

    public login()
    {
    }

    public String execute()
        throws Exception
    {
        String namedis = "";
        String returnPage = SUCCESS;
        try
        {
            if ( official.equalsIgnoreCase( "Admin" ) )
            {
                namedis = getData( "employee", "primarykey ","e_id='"+userName+"' and e_pass='"+pass1+"'" );
                returnPage = ADMIN;
            }
            if ( official.equalsIgnoreCase( "Manager" ) )
            {
                namedis = getData( "employee", "primarykey ", "e_id='"+userName+"' and e_pass='"+pass1+"'" );
                returnPage = MANAGER;
            }
            else if ( official.equalsIgnoreCase( "Employee" ) )
            {
                namedis = getData( "employee", "primarykey", "e_id='"+userName+"' and e_pass='"+pass1+"'" );
                returnPage = EMPLOYEE;
            }
            else if ( official.equalsIgnoreCase( "Clients" ) )
            {
                namedis = getData( "clients", "primarykey ", "c_email='"+userName+"' and c_pass='"+pass1+"'" );
                returnPage = USER;
            }
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        sessionMap.put( "primarykey", namedis );
        return returnPage;
    }

    private String getData( String tableName, String attributesName, String whereClause )
        throws SQLException
    {
        String namedis = "";
        try
        {
            utility = new ScoringUtility();
            con1 = utility.openDatabaseConnection();
            String str =
                "SELECT " + attributesName + " FROM " + tableName + " where " + whereClause;
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( str );

            if ( rs != null && rs.next() )
                namedis = rs.getString( 1 );
            con1.close();
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return namedis;
    }

    public void validate()
    {
        utility = new ScoringUtility();
        if ( official.length() == 0 )
            addFieldError( "official", "Please select the usertype!" );
        if ( userName.length() == 0 )
            addFieldError( "userName", "Please enter username!" );
        if ( pass1.length() == 0 )
            addFieldError( "pass1", "Please enter password!" );
        if ( userName.length() != 0 && pass1.length() != 0 )
        {
            if ( official.equalsIgnoreCase( "Admin" ) )
                checkData( "employee", "e_id='"+userName+"' and e_pass='"+pass1+"' and e_type='"+official+"'" );
            else if ( official.equalsIgnoreCase( "Manager" ) )
                checkData( "employee", "e_id='"+userName+"' and e_pass='"+pass1+"' and e_type='"+official+"'" );
            else if ( official.equalsIgnoreCase( "Employee" ) )
                checkData( "employee" , "e_id='"+userName+"' and e_pass='"+pass1+"' and e_type='"+official+"'" );
            else if ( official.equalsIgnoreCase( "Clients" ) )
                checkData( "clients" , "c_email='"+userName+"' and c_pass='"+pass1+"'"  );
        }
    }

    private void checkData( String tableName , String whereClause )
    {
        try
        {
            int flag = 0;
            con1 = utility.openDatabaseConnection();
            String str = "SELECT * FROM " + tableName+" where "+whereClause;
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( str );

            while ( rs.next() )
            {
                if ( rs.getString( 2 ).equals( userName ) && rs.getString( 3 ).equals( pass1 ) )
                    flag = 1;
            }
            if ( flag == 0 )
                addFieldError( "userName", "Invalid username or password" );
            con1.close();
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }

    }
    
    public String signupclient()
    {
        return SIGNUPCLIENT;
    }

}
