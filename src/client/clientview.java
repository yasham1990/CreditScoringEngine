
package client;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

public class clientview
    extends ActionSupport
    implements SessionAware
{

    ScoringUtility utility = null;

    Connection con1 = null;

    private RegisterBean registerBean;

    private SessionMap<String, Object> sessionMap;

    static Logger log = Logger.getLogger( clientview.class );

    final static private String CLIENTVIEWBACK = "clientviewback";

    final static private String UPDATEBASICDETAIL = "clientviewupdate";

    @Override
    public void setSession( Map<String, Object> sessionMap )
    {
        this.sessionMap = (SessionMap<String, Object>) sessionMap;
    }

    public RegisterBean getRegisterBean()
    {
        return registerBean;
    }

    public void setRegisterBean( RegisterBean registerBean )
    {
        this.registerBean = registerBean;
    }

    public String execute()
        throws Exception
    {
        utility = new ScoringUtility();
        try
        {
            con1 = utility.openDatabaseConnection();
            String str = "update clients set c_firstname=?,c_lastname=?,c_phone=?,c_email=? where primarykey="
                + sessionMap.get( "primarykey" );
            PreparedStatement ps = con1.prepareStatement( str );
            ps.setString( 1, registerBean.getFname() );
            ps.setString( 2, registerBean.getLname() );
            ps.setString( 3, registerBean.getMobile() );
            ps.setString( 4, registerBean.getEmail() );
            ps.executeUpdate();
            con1.close();
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return SUCCESS;
    }

    public String clientviewback()
    {
        return CLIENTVIEWBACK;
    }

    public void validate()
    {
        ValueStack stack = ActionContext.getContext().getValueStack();
        Map<String, Object> context = new HashMap<String, Object>();
        context.put( "fname", registerBean.getFname() );
        context.put( "lname", registerBean.getLname() );
        context.put( "mobile", registerBean.getMobile() );
        context.put( "email", registerBean.getEmail() );
        stack.push( context );
        utility = new ScoringUtility();
        try
        {
            con1 = utility.openDatabaseConnection();
            String str = "SELECT c_email FROM clients  where c_email='" + registerBean.getEmail() + "'";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( str );
            if ( rs != null && rs.next() )
                addFieldError( "signUpBean.email", "User already exits." );
            con1.close();
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }

    }

}
