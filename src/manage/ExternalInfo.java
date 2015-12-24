/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import Utility.ScoringUtility;

/**
 * @author yasham
 */
public class ExternalInfo
    extends ActionSupport
    implements SessionAware
{

    static Logger log = Logger.getLogger( ExternalInfo.class );

    private SessionMap<String, Object> sessionMap;

    ScoringUtility utility = null;

    Connection con1 = null;

    @Override
    public void setSession( Map<String, Object> sessionMap )
    {
        this.sessionMap = (SessionMap<String, Object>) sessionMap;
    }

    public ExternalInfo()
    {
    }

    final static private String EXTERNALBACK = "externalback";

    public String execute()
        throws Exception
    {
        try
        {
            utility = new ScoringUtility();
            con1 = utility.openDatabaseConnection();
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, String> context = new HashMap<String, String>();
            String str =
                "select * from extverify1 where applicationid_primarykey='" + sessionMap.get( "primarykey_app" ) + "'";
            java.sql.Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( str );
            if ( rs != null && rs.next() )
            {
                context.put( "fname",rs.getString( 2 ));
                context.put( "lname",rs.getString( 3 ));
                context.put( "address",rs.getString( 4 ));
                context.put( "email",rs.getString( 5 ));
                context.put( "mobile",rs.getString( 6 ));
                context.put( "member",rs.getString( 7 ));
                context.put( "area",rs.getString( 8 ));
                context.put( "hloan",rs.getString( 9 ));
                context.put( "hpaid",rs.getString( 10 ));
                context.put( "billpay",rs.getString( 11 ));
                context.put( "cars",rs.getString( 12 ));
                context.put( "cloan",rs.getString( 13 ));
                context.put( "cpaid",rs.getString( 14 ));
                context.put( "income",rs.getString( 15 ));
                context.put( "nfd",rs.getString( 16 ));
                context.put( "fdamount",rs.getString( 17 ));
                context.put( "agland",rs.getString( 18 ));
                context.put( "lic",rs.getString( 19 ));
                context.put( "bankdefault",rs.getString( 20 ));
                context.put( "tax",rs.getString( 21 ));
                context.put( "crime",rs.getString( 22 ));
                context.put( "otherinc",rs.getString( 23 ));
                context.put( "otherbankcard",rs.getString( 24 ));
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

    public String externalback()
    {
        return EXTERNALBACK;
    }

}
