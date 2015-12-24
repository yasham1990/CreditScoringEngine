
package emp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import Utility.ScoringUtility;

/**
 * @author RANA
 */

public class Extverify
    extends ActionSupport
    implements SessionAware
{
    private SessionMap<String, Object> sessionMap;

    static Logger log = Logger.getLogger( Extverify.class );

    ScoringUtility utility = null;

    Connection con1 = null;

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
        try
        {
            utility = new ScoringUtility();
            con1 = utility.openDatabaseConnection();
            String str = "SELECT primarykey FROM applicationid where app_no='" + getId() + "'";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( str );
            if ( rs != null && rs.next() )
                sessionMap.put( "primarykey_app", rs.getString( 1 ) );
            sessionMap.put( "app_no", getId() );
            con1.close();
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
