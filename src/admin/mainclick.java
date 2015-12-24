
package admin;

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
import emp.click;

/**
 * @author yasham
 */
public class mainclick
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

    final static private String ADMINEDITBACK = "admineditback";

    final static private String ADMININSERT = "admininsert";

    final static private String ADMINAPPROVEPHOTO = "adminapprovephoto";

    final static private String MANAGEPHOTO = "managephoto";

    final static private String MNGBACK = "mngback";

    final static private String GOBACKADMIN = "gobackadmin";

    private List<String> h1;

    public mainclick()
    {
    }

    public String execute()
        throws Exception
    {
        return SUCCESS;
    }

    public String adminapprovephoto()
    {
        utility = new ScoringUtility();
        try
        {
            h1 = new ArrayList<String>();
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, List<String>> context = new HashMap<String, List<String>>();
            con1 = utility.openDatabaseConnection();
            String str = "SELECT app_no FROM applicationid where status='completed' and level='manager'";
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
            }
            context.put( "h1", h1 );
            stack.push( context );
            con1.close();
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return ADMINAPPROVEPHOTO;
    }

    public String managephoto()
    {
        utility = new ScoringUtility();
        String b;
        try
        {
            h1 = new ArrayList<String>();
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, List<String>> context = new HashMap<String, List<String>>();
            con1 = utility.openDatabaseConnection();
            String str = "SELECT e_id FROM  employee where e_type!='Admin' order by primarykey";
            java.sql.Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( str );
            if ( rs.isBeforeFirst() == false )
                h1.add( "There is no application request pending" );
            else
            {
                while ( rs.next() )
                    h1.add( rs.getString( 1 ) );
            }
            context.put( "h1", h1 );
            stack.push( context );
            con1.close();
        }
        catch ( Exception e )
        {
        }
        return MANAGEPHOTO;
    }

    public String admineditback()
    {
        return ADMINEDITBACK;
    }

    public String admininsert()
    {
        return ADMININSERT;
    }

    public String mngback()
    {
        return MNGBACK;
    }

    public String gobackadmin()
    {
        return GOBACKADMIN;
    }
}
