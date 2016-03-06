
package emp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import Home.EmployeeManagement;
import hibernatemapping.Applicationid;
import hibernatemapping.Employee;

/**
 * @author Yasham
 */
public class click
    extends ActionSupport
    implements SessionAware
{

    private SessionMap<String, Object> sessionMap;

    static Logger log = Logger.getLogger( click.class );

    EmployeeManagement employeeManagement = null;

    @Override
    public void setSession( Map<String, Object> sessionMap )
    {
        this.sessionMap = (SessionMap<String, Object>) sessionMap;
    }

    private List<String> h1;

    final static private String EMPLOYVIEW = "employview";

    final static private String PASSVIEW = "passview";

    final static private String PASSWORDBACK = "passwordback";

    public click()
    {
    }

    public String execute()
        throws Exception
    {
        employeeManagement = new EmployeeManagement();
        try
        {
            h1 = new ArrayList<String>();
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, List<String>> context = new HashMap<String, List<String>>();
            List<Applicationid> applicationids = employeeManagement.getApplicationidList( "started", "user" );
            if ( applicationids == null || applicationids.isEmpty() )
                h1.add( "There is no application request pending" );
            else
            {
                for ( Applicationid applicationid : applicationids )
                    h1.add( applicationid.getApp_no() );
            }
            context.put( "h1", h1 );
            stack.push( context );
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return SUCCESS;
    }

    public String passview()
    {
        employeeManagement = new EmployeeManagement();
        try
        {
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, Object> context = new HashMap<String, Object>();
            Employee employee = employeeManagement.getEmployeeByPrimarykey( (int) sessionMap.get( "primarykey" ) );
            if ( employee != null )
            {
                context.put( "id", employee.getEmployeeId() );
                stack.push( context );
            }
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return PASSVIEW;
    }

    public String passwordback()
    {
        return PASSWORDBACK;
    }

    public String employview()
    {
        employeeManagement = new EmployeeManagement();
        try
        {
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, Object> context = new HashMap<String, Object>();
            Employee employee = employeeManagement.getEmployeeByPrimarykey( (int) sessionMap.get( "primarykey" ) );
            if ( employee != null )
            {
                context.put( "id", employee.getEmployeeId() );
                context.put( "name", employee.getName() );
                context.put( "phone", employee.getPhone() );
                context.put( "salary", employee.getSalary() );
                context.put( "address", employee.getAddress() );
                context.put( "email", employee.getEmail() );
                context.put( "dob", employee.getDob() );
                context.put( "gen", employee.getGender() );
                context.put( "doj", employee.getDoj() );
                stack.push( context );
            }
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return EMPLOYVIEW;

    }

}