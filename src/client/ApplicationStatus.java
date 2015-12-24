
package client;

import java.sql.Connection;
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

import Utility.ScoringUtility;

public class ApplicationStatus
    extends ActionSupport implements SessionAware
{
    
    ScoringUtility utility = null;

    Connection con1 = null;
    
    private RegisterBean registerBean;

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
        utility = new ScoringUtility();
        try
        {
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, Object> context = new HashMap<String, Object>();
            con1 = utility.openDatabaseConnection();
            String str = "select c_firstname,c_lastname,c_phone,c_email from clients where primarykey='"
                + sessionMap.get( "primarykey" )+"'";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( str );
            if ( rs != null && rs.next() )
            {
                context.put("fname" , rs.getString( 1 ) );
                context.put("lname" , rs.getString( 2 ) );
                context.put("mobile" , rs.getString( 3 ) );
                context.put("email" , rs.getString( 4 ) );
                stack.push(context);
            }
            con1.close();
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
