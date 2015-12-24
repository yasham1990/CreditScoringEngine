/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import Utility.ScoringUtility;

/**
 * @author yasham
 */
public class accept
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

    final static private String REJECT = "reject";

    final static private String ACCEPT = "accept";

    public accept()
    {
    }

    public String execute()
        throws Exception
    {
        utility = new ScoringUtility();
        Integer bankup = 0 ;
        try
        {
            con1 = utility.openDatabaseConnection();
            String str2 = "UPDATE applicationid set status='approved', level='admin' where app_no=?";
            PreparedStatement ps = con1.prepareStatement( str2 );
            ps.setString( 1, (String)sessionMap.get( "app_no" ) );
            ps.executeUpdate();
            
            String str3 = "Select * from bankinfo";
            java.sql.Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( str3 );
            if ( rs != null && rs.next() )
                bankup = Integer.parseInt( rs.getString( 2 ) )+1;
            
            String str4 = "Update bankinfo set totalcards=?";
            ps = con1.prepareStatement( str4 );
            ps.setString( 1, bankup.toString() );
            con1.close();
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }

        return ACCEPT;
    }

    public String reject()
    {
        try
        {
            con1 = utility.openDatabaseConnection();
            String str2 = "UPDATE applicationid set status='rejected' and level='admin' where app_no=?";
            PreparedStatement ps = con1.prepareStatement( str2 );
            ps.setString( 1, (String)sessionMap.get( "app_no" ) );
            ps.executeUpdate();
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return REJECT;
    }

}
