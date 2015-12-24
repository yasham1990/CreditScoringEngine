/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import Utility.ScoringUtility;

/**
 * @author yasham
 */
public class Datatoadmin
    extends ActionSupport implements SessionAware
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

    public Datatoadmin()
    {
    }

    public String execute()
        throws Exception
    {
        utility = new ScoringUtility();
        try
        {
            con1 = utility.openDatabaseConnection();
            String str = "update applicationid set status='completed' , level='manager' where app_no ='"+(String) sessionMap.get( "app_no" ) +"'";
            PreparedStatement ps = con1.prepareStatement( str );
            ps.executeUpdate();
            con1.close();
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return SUCCESS;
    }

}