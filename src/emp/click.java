
package emp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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

import Utility.ScoringUtility;

/**
 * @author RANA
 */
public class click
    extends ActionSupport
    implements SessionAware
{

    private SessionMap<String, Object> sessionMap;

    static Logger log = Logger.getLogger( click.class );

    ScoringUtility utility = null;

    Connection con1 = null;

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
        utility = new ScoringUtility();
        try
        {
            h1 = new ArrayList<String>();
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, List<String>> context = new HashMap<String, List<String>>();
            con1 = utility.openDatabaseConnection();
            String str = "SELECT app_no FROM applicationid where status='started' and level='user'";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( str );
            if ( rs.isBeforeFirst() == false )
            {
                h1.add( "There is no application request pending" );
            }
            else
            {
                while ( rs.next() )
                    h1.add( rs.getString( 1 ) );
                context.put( "h1", h1 );
                stack.push( context );
            }
            con1.close();
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return SUCCESS;
    }
    
    public String passview()
    {
        utility = new ScoringUtility();
        try
        {
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, Object> context = new HashMap<String, Object>();
            con1 = utility.openDatabaseConnection();
            String str = "select e_id from employee where primarykey='"
                + sessionMap.get( "primarykey" ) + "'";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( str );
            if ( rs != null && rs.next() )
            {
                context.put( "id", rs.getString( 1 ) );
                stack.push( context );
            }
            con1.close();
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
        utility = new ScoringUtility();
        try
        {
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, Object> context = new HashMap<String, Object>();
            con1 = utility.openDatabaseConnection();
            String str =
                "select e_id,e_name,e_phone,e_salary,e_address,e_email,e_dob,e_gen,e_doj from employee where primarykey='"
                    + sessionMap.get( "primarykey" ) + "'";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( str );
            if ( rs != null && rs.next() )
            {
                context.put( "id", rs.getString( 1 ) );
                context.put( "name", rs.getString( 2 ) );
                context.put( "phone", rs.getString( 3 ) );
                context.put( "salary", rs.getString( 4 ) );
                context.put( "address", rs.getString( 5 ) );
                context.put( "email", rs.getString( 6 ) );
                context.put( "dob", rs.getDate( 7 ) );
                context.put( "gen", rs.getString( 8 ) );
                context.put( "doj", rs.getDate( 9 ) );
                stack.push( context );
            }
            con1.close();
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return EMPLOYVIEW;

    }

}