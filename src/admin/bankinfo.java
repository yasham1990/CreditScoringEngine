
package admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import Utility.ScoringUtility;

public class bankinfo
    extends ActionSupport
{

    ScoringUtility utility = null;

    Connection con1 = null;

    static Logger log = Logger.getLogger( bankinfo.class );

    public bankinfo()
    {
    }

    final static private String BANKINFOBACK = "bankinfoback";

    public String bankinfoback()
    {
        return BANKINFOBACK;
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
            String str = "select totalcards,employee,dos from bankinfo";
            java.sql.Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( str );
            while ( rs.next() )
            {
                context.put( "totalcards", rs.getString( 1 ) );
                context.put( "employee", rs.getString( 2 ) );
                context.put( "dos", rs.getDate( 3 ) );
            }
            stack.push( context );
            con1.close();
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return SUCCESS;
    }

}
