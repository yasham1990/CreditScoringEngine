/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import Utility.ScoringUtility;
import emp.Extverify;

/**
 * @author yasham
 */
public class toacceptpage
    extends ActionSupport
    implements SessionAware
{
    private SessionMap<String, Object> sessionMap;

    static Logger log = Logger.getLogger( toacceptpage.class );

    ScoringUtility utility = null;

    Connection con1 = null;

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
        utility = new ScoringUtility();
        try
        {
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, String> context = new HashMap<String, String>();
            con1 = utility.openDatabaseConnection();
            String str = "select score, CONCAT_WS(' ', c_firstname,c_lastname) as name from clients, "
                + "applicationid where applicationid.primarykey=clients.applicationid_primarykey and app_no='"
                + getId() + "'";
            java.sql.Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( str );
            if ( rs != null && rs.next() )
            {
                context.put( "name", rs.getString( 2 ) );
                context.put( "score", rs.getString( 1 ) );
                sessionMap.put( "app_no", getId() );
            }
            con1.close();
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
            int flag = 1;
            try
            {
                utility = new ScoringUtility();
                con1 = utility.openDatabaseConnection();
                String str = "SELECT app_no FROM applicationid where app_no='" + getId() + "'";
                Statement stmt = con1.createStatement();
                ResultSet rs = stmt.executeQuery( str );

                if ( rs != null && rs.next() )
                    flag = 0;
                con1.close();
            }
            catch ( Exception e )
            {
                log.error( e.getMessage() );
            }
            if ( flag == 1 )
                addFieldError( "id", "Invalid application id" );
        }
    }
}