
package client;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import Home.EmployeeManagement;
import hibernatemapping.Client;

public class ApplicationStatus
    extends ActionSupport implements SessionAware
{
    
    EmployeeManagement employeeManagement = null;
    
    private SessionMap<String, Object> sessionMap;
    
    static Logger log=Logger.getLogger( ApplicationStatus.class );
    
    final static private String APPLICATIONSTATUSBACK = "applicationStatusBack";
    
    final static private String REGISTERCLICKSTATUSBACK = "registerClickNewBack";
    
    @Override
    public void setSession( Map<String, Object> sessionMap )
    {
        this.sessionMap = (SessionMap<String, Object>) sessionMap;
    }
    
    public String execute()
        throws Exception
    {
        employeeManagement=new EmployeeManagement();
        try
        {
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, Object> context = new HashMap<String, Object>();
            employeeManagement = new EmployeeManagement();
            Client client = employeeManagement.getClientByPrimarykey( (int) sessionMap.get( "primarykey" ) );
            if ( client != null )
            {
                context.put( "fname", client.getFirstname() );
                context.put( "lname", client.getLastname() );
                context.put( "mobile", client.getPhone() );
                context.put( "email",  client.getEmail()  );
                stack.push(context);
            }
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return SUCCESS;
    }

    public String applicationStatusBack()
    {
        return APPLICATIONSTATUSBACK;
    }
    
    public String registerClickNewBack()
    {
        return REGISTERCLICKSTATUSBACK;
    }
    
}
