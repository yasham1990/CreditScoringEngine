
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

public class clientclick
    extends ActionSupport
    implements SessionAware
{

    ScoringUtility utility = null;

    Connection con1 = null;

    final static private String CLIENTPASS = "clientpass";

    final static private String TRANSREWBACK = "transrewback";

    final static private String TRANSLIST = "translist";

    final static private String FUNDTRANS = "fundtrans";

    final static private String REWARD = "reward";

    final static private String CLIENTDETAILSCLICK = "clientdetailsclick";

    final static private String BENEFITBACK = "benefitback";

    final static private String TRANSLISTBACK = "translistback";

    final static private String FUNDTRANSBACK = "fundtransback";

    final static private String APPLICATIONSTATUS = "applicationStatus";

    final static private String APPLICATIONNEW = "applicationNew";

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

        return FUNDTRANS;
    }

    public String clientpass()
    {
        utility = new ScoringUtility();
        try
        {
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, Object> context = new HashMap<String, Object>();
            con1 = utility.openDatabaseConnection();
            String str = "select c_email from clients where primarykey='"
                + sessionMap.get( "primarykey" ) + "'";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( str );
            if ( rs != null && rs.next() )
            {
                context.put( "email", rs.getString( 1 ) );
                stack.push( context );
            }
            con1.close();
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return CLIENTPASS;
    }

    public String applicationStatus()
    {
        return APPLICATIONSTATUS;

    }

    public String applicationNew()
    {
        return APPLICATIONSTATUS;

    }

    public String clientdetailsclick()
    {
        utility = new ScoringUtility();
        try
        {
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, Object> context = new HashMap<String, Object>();
            con1 = utility.openDatabaseConnection();
            String str = "select c_firstname,c_lastname,c_phone,c_email,(select app_no from applicationid where primarykey=applicationid_primarykey) "
                + " from clients where primarykey='"
                + sessionMap.get( "primarykey" ) + "'";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( str );
            if ( rs != null && rs.next() )
            {
                context.put( "fname", rs.getString( 1 ) );
                context.put( "lname", rs.getString( 2 ) );
                context.put( "mobile", rs.getString( 3 ) );
                context.put( "email", rs.getString( 4 ) );
                if(rs.getString( 5 )!=null)
                context.put( "app_no", rs.getString( 5 ) );
                else
                    context.put( "app_no", "" );
                stack.push( context );
            }
            con1.close();
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return CLIENTDETAILSCLICK;
    }

}
