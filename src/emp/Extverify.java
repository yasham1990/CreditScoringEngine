
package emp;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import Home.EmployeeManagement;
import hibernatemapping.Applicationid;

/**
 * @author RANA
 */

public class Extverify
    extends ActionSupport
    implements SessionAware
{
    private SessionMap<String, Object> sessionMap;

    static Logger log = Logger.getLogger( Extverify.class );

    EmployeeManagement employeeManagement = null;

    @Override
    public void setSession( Map<String, Object> sessionMap )
    {
        this.sessionMap = (SessionMap<String, Object>) sessionMap;
    }

    final static private String APPLISTBACK = "applistback";

    private String id;

    public String getId()
    {
        return id;
    }

    public void setId( String id )
    {
        this.id = id;
    }

    public Extverify()
    {
    }

    @Override
    public String execute()
        throws Exception
    {
        Applicationid applicationid = null;
        try
        {
            employeeManagement = new EmployeeManagement();
            applicationid = employeeManagement.getApplicationidByAppno( getId() );
            if ( applicationid != null )
                sessionMap.put( "primarykey_app", applicationid.getPrimarykey() );
            sessionMap.put( "app_no", getId() );
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return SUCCESS;
    }

    public String applistback()
    {
        return APPLISTBACK;
    }

    public void validate()
    {
        if ( getId().length() == 0 )
            addFieldError( "id", "Application Id is required" );
        if ( id.length() != 0 )
        {
            employeeManagement = new EmployeeManagement();
            Applicationid applicationid = employeeManagement.getApplicationidByAppno( getId() );
            if ( applicationid == null )
                addFieldError( "id", "Invalid application id" );
        }
    }
}
