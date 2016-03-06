/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import Home.EmployeeManagement;
import Utility.HibernateUtil;
import hibernatemapping.Employee;

/**
 * @author yasham
 */
public class forpassword
    extends ActionSupport
    implements SessionAware
{

    EmployeeManagement employeeManagement = null;

    static Logger log = Logger.getLogger( forpassword.class );

    final static private String PASSBACKMAN = "passwordbackman";

    private SessionMap<String, Object> sessionMap;

    @Override
    public void setSession( Map<String, Object> sessionMap )
    {
        this.sessionMap = (SessionMap<String, Object>) sessionMap;
    }

    public forpassword()
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
        try
        {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Employee employee = null;
            session.beginTransaction();
            employee = (Employee) session.get( Employee.class, (int) sessionMap.get( "primarykey" ) );
            if ( employee != null && oldpassword.equals( employee.getEmployeePass() ) )
                employee.setEmployeePass( password );
            session.merge( employee );
            session.saveOrUpdate( employee );
            session.getTransaction().commit();
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return SUCCESS;
    }

    public String passwordbackman()
    {

        return PASSBACKMAN;
    }

    public void validate()
    {
        try
        {
            setId( getId() );
            if ( "".equals( getOldpassword() ) )
            {
                addFieldError( "oldpassword", "Password is required" );
            }
            else if ( oldpassword.length() != 0 )
            {
                employeeManagement = new EmployeeManagement();
                Employee employee = employeeManagement.getEmployeeByPrimarykey( (int) sessionMap.get( "primarykey" ) );
                if ( employee != null && !oldpassword.equals( employee.getEmployeePass() ) )
                    addFieldError( "oldpassword", "Old Password did not match" );
            }
            if ( "".equals( getPassword() ) )
                addFieldError( "password", "Password is required" );
            else if ( !getPassword().matches( "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})" ) )
                addFieldError( "password", "Invalid password" );
            else if ( "".equals( getConfirmpassword() ) )
                addFieldError( "confirmpassword", "ConfirmPassword is required" );
            else if ( !( getPassword().equals( getConfirmpassword() ) ) )
                addFieldError( "confirmpassword", "Password did not match" );
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }

    }
}
