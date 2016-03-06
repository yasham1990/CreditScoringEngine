/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import Home.EmployeeManagement;
import Utility.ScoringUtility;
import hibernatemapping.Applicationid;
import hibernatemapping.Client;

/**
 * @author yasham
 */
public class toacceptpage
    extends ActionSupport
    implements SessionAware
{
    private SessionMap<String, Object> sessionMap;

    static Logger log = Logger.getLogger( toacceptpage.class );

    EmployeeManagement employeeManagement = null;

    @Override
    public void setSession( Map<String, Object> sessionMap )
    {
        this.sessionMap = (SessionMap<String, Object>) sessionMap;
    }

    final static private String TOACCEPT = "toaccept";

    final static private String APPREQUESTBACK = "apprequestback";

    public toacceptpage()
    {
    }

    private String id;

    public String execute()
        throws Exception
    {
        try
        {
            employeeManagement = new EmployeeManagement();
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, String> context = new HashMap<String, String>();
            Applicationid applicationid =
                            employeeManagement.getApplicationidByAppno( getId() );
            Client client = employeeManagement.getClientAppId( applicationid.getPrimarykey() );
            if ( client != null )
            {
                context.put( "name", client.getFirstname() + " " + client.getLastname() );
                context.put( "score", client.getApplicationPrimaryKey().getScore() + "" );
                sessionMap.put( "app_no", getId() );
            }
            stack.push( context );
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return TOACCEPT;
    }

    public String apprequestback()
    {
        return APPREQUESTBACK;
    }

    public String getId()
    {
        return id;
    }

    public void setId( String id )
    {
        this.id = id;
    }

    public void validate()
    {
        if ( getId().length() == 0 )
            addFieldError( "id", "Application Id is required" );
        if ( id.length() != 0 )
        {
            try
            {
                employeeManagement = new EmployeeManagement();
                Applicationid applicationid =
                    employeeManagement.getApplicationidByAppno( getId() );
                if ( applicationid == null )
                    addFieldError( "id", "Invalid application id" );
            }
            catch ( Exception e )
            {
                log.error( e.getMessage() );
            }
        }
    }
}