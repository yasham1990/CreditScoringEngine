/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import hibernatemapping.Client;
import hibernatemapping.Employee;

/**
 * @author yasham
 */
public class login
    extends ActionSupport
    implements SessionAware
{
    private String userName;

    private String official = "";
    
    EmployeeManagement employeeManagement=null;

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
        String returnPage = SUCCESS;
        try
        {
            if ( official.equalsIgnoreCase( "Admin" ) )
                returnPage = ADMIN;
            else if ( official.equalsIgnoreCase( "Manager" ) )
                returnPage = MANAGER;
            else if ( official.equalsIgnoreCase( "Employee" ) )
                returnPage = EMPLOYEE;
            else if ( official.equalsIgnoreCase( "Clients" ) )
                returnPage = USER;
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return returnPage;
    }

    public void validate()
    {
        if ( official.length() == 0 )
            addFieldError( "official", "Please select the usertype!" );
        if ( userName.length() == 0 )
            addFieldError( "userName", "Please enter username!" );
        if ( pass1.length() == 0 )
            addFieldError( "pass1", "Please enter password!" );
        employeeManagement = new EmployeeManagement();
        if ( official.equalsIgnoreCase( "Clients" ) )
        {
            Client client = employeeManagement.getClient( userName, pass1 );
            if ( client == null )
                addFieldError( "userName", "Invalid username or password" );
            else
                sessionMap.put( "primarykey", client.getPrimarykey() );
        }
        else
        {
            Employee employee = employeeManagement.getEmployee( userName, pass1, new String[]{official});
            if ( employee == null )
                addFieldError( "userName", "Invalid username or password" );
            else
                sessionMap.put( "primarykey", employee.getPrimarykey() );
        }

    }

    public String signupclient()
    {
        return SIGNUPCLIENT;
    }

}
