/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import Home.EmployeeManagement;
import hibernatemapping.Applicationid;
import hibernatemapping.ExternalVerification;

/**
 * @author yasham
 */
public class ExternalInfo
    extends ActionSupport
    implements SessionAware
{

    static Logger log = Logger.getLogger( ExternalInfo.class );

    private SessionMap<String, Object> sessionMap;

    EmployeeManagement employeeManagement = null;

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
            employeeManagement = new EmployeeManagement();

            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, String> context = new HashMap<String, String>();
            Applicationid applicationid=employeeManagement.getApplicationidByPrimarykey( (int) sessionMap.get( "primarykey_app" ) );
            ExternalVerification externalVerification =
                employeeManagement.getExternalVerificationAppId( applicationid );
            if ( externalVerification != null )
            {
                context.put( "fname", externalVerification.getEx_fname() );
                context.put( "lname", externalVerification.getEx_lname() );
                context.put( "address", externalVerification.getEx_address() );
                context.put( "email", externalVerification.getEx_email() );
                context.put( "mobile", externalVerification.getEx_mobile() );
                context.put( "member", externalVerification.getEx_member() );
                context.put( "area", externalVerification.getEx_area() );
                context.put( "hloan", externalVerification.getEx_hloan() );
                context.put( "hpaid", externalVerification.getEx_hpaid() );
                context.put( "billpay", externalVerification.getEx_billpay() );
                context.put( "cars", externalVerification.getEx_cars() );
                context.put( "cloan", externalVerification.getEx_cloan() );
                context.put( "cpaid", externalVerification.getEx_cpaid() );
                context.put( "income", externalVerification.getEx_income() );
                context.put( "nfd", externalVerification.getEx_nfd() );
                context.put( "fdamount", externalVerification.getEx_famount() );
                context.put( "agland", externalVerification.getEx_agland() );
                context.put( "lic", externalVerification.getEx_lic() );
                context.put( "bankdefault", externalVerification.getEx_default() );
                context.put( "tax", externalVerification.getEx_tax() );
                context.put( "crime", externalVerification.getEx_crime() );
                context.put( "otherinc", externalVerification.getEx_otherinc() );
                context.put( "otherbankcard", externalVerification.getEx_otherbank() );
            }
            stack.push( context );
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
