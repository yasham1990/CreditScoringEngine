
package client;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import Home.EmployeeManagement;
import hibernatemapping.Applicationid;
import hibernatemapping.Client;

public class clientclick
    extends ActionSupport
    implements SessionAware
{
    EmployeeManagement employeeManagement = null;

    final static private String CLIENTPASS = "clientpass";

    final static private String CLIENTDETAILSCLICK = "clientdetailsclick";

    final static private String APPLICATIONSTATUS = "applicationStatus";

    final static private String APPLICATIONNEW = "applicationNew";

    final static private String REACHOUTSECTION = "reachoutsection";

    private String namedis;

    private String id;

    private SessionMap<String, Object> sessionMap;

    static Logger log = Logger.getLogger( clientclick.class );

    public String getId()
    {
        return id;
    }

    public void setId( String id )
    {
        this.id = id;
    }

    public String getNamedis()
    {
        return namedis;
    }

    public void setNamedis( String namedis )
    {
        this.namedis = namedis;
    }

    @Override
    public void setSession( Map<String, Object> sessionMap )
    {
        this.sessionMap = (SessionMap<String, Object>) sessionMap;
    }

    public clientclick()
    {
    }

    public String execute()
        throws Exception
    {
        try
        {

        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }

        return SUCCESS;
    }

    public String clientpass()
    {
        try
        {
            employeeManagement = new EmployeeManagement();
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, Object> context = new HashMap<String, Object>();
            Client client = employeeManagement.getClientByPrimarykey( (int) sessionMap.get( "primarykey" ) );
            if ( client != null )
            {
                context.put( "email", client.getEmail() );
                stack.push( context );
            }
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return CLIENTPASS;
    }

    public String reachoutsection()
    {
        return REACHOUTSECTION;

    }

    public String applicationNew()
    {
        try
        {
            employeeManagement = new EmployeeManagement();
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute( "isOld", "true" );
            Applicationid applicationid = null;
            Client client = employeeManagement.getClientByPrimarykey( (int) sessionMap.get( "primarykey" ) );
            if ( client != null && client.getApplicationPrimaryKey()!=null )
                applicationid =
                    employeeManagement.getApplicationidByPrimarykey( ( client.getApplicationPrimaryKey() ).getPrimarykey() );

            if ( applicationid == null )
                request.setAttribute( "filed", "" );
            else
                request.setAttribute( "filed", "alreadyfiled" );
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return APPLICATIONNEW;

    }

    public String applicationStatus()
    {
        try
        {
            employeeManagement = new EmployeeManagement();
            Applicationid applicationid = null;
            Client client = employeeManagement.getClientByPrimarykey( (Integer) sessionMap.get( "primarykey" ) );
            if ( client != null && client.getApplicationPrimaryKey()!=null )
                applicationid =
                    employeeManagement.getApplicationidByPrimarykey( ( client.getApplicationPrimaryKey() ).getPrimarykey() );

            HttpServletRequest request = ServletActionContext.getRequest();
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, Object> context = new HashMap<String, Object>();
            if ( applicationid == null )
                request.setAttribute( "filed", "" );
            else
            {
                request.setAttribute( "filed", "alreadyfiled" );
                if ( "completed".equalsIgnoreCase( applicationid.getStatus() )
                    && "employee".equalsIgnoreCase( applicationid.getLevel() ) )
                {
                    context.put( "percentage", "50" );
                    context.put( "status", "Processing" );
                    context.put( "level", "Manager" );
                }
                else if ( "completed".equalsIgnoreCase( applicationid.getStatus() )
                    && "manager".equalsIgnoreCase( applicationid.getLevel() ) )
                {
                    context.put( "percentage", "80" );
                    context.put( "status", "Processing" );
                    context.put( "level", "Admin" );
                }
                else if ( "approved".equalsIgnoreCase( applicationid.getStatus() )
                    && "admin".equalsIgnoreCase( applicationid.getLevel() ) )
                {
                    context.put( "percentage", "100" );
                    context.put( "status", "Approved" );
                    context.put( "level", "Admin" );
                }
                else if ( "rejected".equalsIgnoreCase( applicationid.getStatus() )
                    && "admin".equalsIgnoreCase( applicationid.getLevel() ) )
                {
                    context.put( "percentage", "100" );
                    context.put( "status", "Rejected" );
                    context.put( "level", "Admin" );
                }
                else
                {
                    context.put( "percentage", "20" );
                    context.put( "status", "Processing" );
                    context.put( "level", "Employee" );
                }
            }
            stack.push( context );
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return APPLICATIONSTATUS;
    }

    /*
     * public String applicationNew() { return APPLICATIONSTATUS; }
     */

    public String clientdetailsclick()
    {
        try
        {
            employeeManagement = new EmployeeManagement();
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, Object> context = new HashMap<String, Object>();
            Client client = employeeManagement.getClientByPrimarykey( (Integer) sessionMap.get( "primarykey" ) );
            if ( client != null )
            {
                context.put( "fname", client.getFirstname() );
                context.put( "lname", client.getLastname() );
                context.put( "mobile", client.getPhone() );
                context.put( "email", client.getEmail() );
                if ( client.getApplicationPrimaryKey() != null )
                    context.put( "app_no", client.getApplicationPrimaryKey().getPrimarykey() );
                else
                    context.put( "app_no", "" );
                stack.push( context );
            }
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return CLIENTDETAILSCLICK;
    }

}
