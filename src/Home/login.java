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

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    private String password;

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
                namedis = getData( "employee", "primarykey ","e_id" );
                returnPage = ADMIN;
            }
            if ( official.equalsIgnoreCase( "Manager" ) )
            {
                namedis = getData( "employee", "primarykey ", "e_id" );
                returnPage = MANAGER;
            }
            else if ( official.equalsIgnoreCase( "Employee" ) )
            {
                namedis = getData( "employee", "primarykey", "e_id" );
                returnPage = EMPLOYEE;
            }
            else if ( official.equalsIgnoreCase( "User" ) )
            {
                namedis = getData( "clients", "primarykey ", "c_email" );
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
                "SELECT " + attributesName + " FROM " + tableName + " where " + whereClause + "='" + userName + "'";
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
            addFieldError( "official", "Please enter username!" );
        if ( userName.length() == 0 )
            addFieldError( "userName", "Please enter username!" );
        if ( password.length() == 0 )
            addFieldError( "pass", "Please enter password!" );
        if ( userName.length() != 0 && password.length() != 0 )
        {
            if ( official.equalsIgnoreCase( "Admin" ) )
                checkData( "employee" );
            else if ( official.equalsIgnoreCase( "Manager" ) )
                checkData( "employee" );
            else if ( official.equalsIgnoreCase( "Employee" ) )
                checkData( "employee" );
            else if ( official.equalsIgnoreCase( "Clients" ) )
                checkData( "clients" );
        }
    }

    private void checkData( String tableName )
    {
        try
        {
            int flag = 0;
            con1 = utility.openDatabaseConnection();
            String str = "SELECT * FROM " + tableName+" where e_type='"+official+"'";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( str );

            while ( rs.next() )
            {
                if ( rs.getString( 2 ).equals( userName ) && rs.getString( 3 ).equals( password ) )
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
