package admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import Utility.ScoringUtility;

/**
 * @author yasham
 */
public class AdminEdit
    extends ActionSupport
    implements SessionAware
{

    ScoringUtility utility = null;

    Connection con1 = null;

    final static private String ADMINMANAGERINFORMATIONBACK = "admineditback";

    static Logger log = Logger.getLogger( AdminEdit.class );

    private AdminManagerInformationBean adminManagerInformationBean;
    
    public AdminManagerInformationBean getAdminManagerInformationBean()
    {
        return adminManagerInformationBean;
    }

    public void setAdminManagerInformationBean( AdminManagerInformationBean adminManagerInformationBean )
    {
        this.adminManagerInformationBean = adminManagerInformationBean;
    }

    public AdminEdit()
    {
    }

    final static private String ADMINEDIT = "adminedit";

    private SessionMap<String, Object> sessionMap;

    @Override
    public void setSession( Map<String, Object> sessionMap )
    {
        this.sessionMap = (SessionMap<String, Object>) sessionMap;
    }

    public String execute()
        throws Exception
    {
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute( "isOld", "true" );
        utility = new ScoringUtility();
        try
        {
            con1 = utility.openDatabaseConnection();
            String str =
                "SELECT * FROM  employee where e_type in ('manager','employee') and e_id='" + adminManagerInformationBean.getId() + "'";
            java.sql.Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( str );

            if ( rs.next() )
            {
                adminManagerInformationBean.setId( adminManagerInformationBean.getId() );
                adminManagerInformationBean.setName( rs.getString( 4 ) );
                adminManagerInformationBean.setPhone( rs.getString( 5 ) );
                adminManagerInformationBean.setSalary( rs.getString( 6 ) );
                adminManagerInformationBean.setAddress( rs.getString( 7 ) );
                adminManagerInformationBean.setDob( rs.getDate( 8 ) );
                adminManagerInformationBean.setEmail( rs.getString( 9 ) );
                adminManagerInformationBean.setGen( rs.getString( 10 ) );
                adminManagerInformationBean.setDoj( rs.getDate( 11 ) );
            }
            con1.close();
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }

        return ADMINEDIT;
    }

    public String admineditback()
    {
        return ADMINMANAGERINFORMATIONBACK;
    }

    public void validate()
    {
        if ( adminManagerInformationBean.getId().length() == 0 )
            addFieldError( "adminManagerInformationBean.id", "Manager Id is required" );
        if ( adminManagerInformationBean.getId().length() != 0 )
        {
            String a = "";
            utility = new ScoringUtility();
            try
            {
                con1 = utility.openDatabaseConnection();
                Statement stmt = con1.createStatement();
                String str =
                    "SELECT e_id FROM  employee where in ('manager','employee') and e_id=" + adminManagerInformationBean.getId();
                ResultSet rs = stmt.executeQuery( str );

                if ( rs != null && !rs.next() )
                    addFieldError( "adminManagerInformationBean.id", "Invalid application id" );
                con1.close();
            }
            catch ( Exception e )
            {
                log.error( e.getMessage() );
            }

        }
    }
}
