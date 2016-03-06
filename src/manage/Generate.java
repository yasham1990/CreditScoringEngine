
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

public class Generate
    extends ActionSupport
    implements SessionAware
{

    static Logger log = Logger.getLogger( Generate.class );

    private SessionMap<String, Object> sessionMap;

    EmployeeManagement employeeManagement = null;

    @Override
    public void setSession( Map<String, Object> sessionMap )
    {
        this.sessionMap = (SessionMap<String, Object>) sessionMap;
    }

    final static private String FAILURE = "failure";

    final static private String GENERATEBACK = "generateback";

    private String id;

    private Integer score = 0;

    private Integer totscore = 0;

    public Generate()
    {
    }

    public String execute()
        throws Exception
    {
        try
        {
            employeeManagement=new EmployeeManagement();
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, String> context = new HashMap<String, String>();
            Applicationid applicationid=employeeManagement.getApplicationidByPrimarykey( (int) sessionMap.get( "primarykey_app" ) );
            ExternalVerification externalVerification =
                employeeManagement.getExternalVerificationAppId( applicationid );
            if ( externalVerification != null )
            {
                Float income;
                income = Float.valueOf( externalVerification.getEx_income() );
                if ( income >= 30000 && income <= 70000 )
                    score += 10;
                else if ( income >= 70000 && income <= 150000 )
                    score += 20;
                else
                    score += 30;
                totscore += score;
                context.put( "income1", score.toString() );
                score = 0;
                if ( "yes".equalsIgnoreCase( externalVerification.getEx_address() ) )
                    score += 10;
                else
                    score = 0;
                totscore += score;
                context.put( "address", score.toString() );
                score = 0;
                int defaulttax = 0;
                defaulttax = Integer.parseInt( externalVerification.getEx_default() );
                if ( defaulttax == 0 )
                    score += 10;
                else if ( defaulttax == 1 )
                    score += -4;
                else if ( defaulttax == 2 )
                    score += -6;
                else
                    score += -10;
                totscore += score;
                context.put( "taxpay", score.toString() );
                score = 0;
                if ( "ontime".equalsIgnoreCase( externalVerification.getEx_billpay() ) )
                    score += 10;
                else
                    score = -5;
                totscore += score;
                context.put( "billpay", score.toString() );
                score = 0;
                if ( "yes".equalsIgnoreCase( externalVerification.getEx_otherbank() ) )
                    score += 10;
                else
                    score = 0;
                totscore += score;
                context.put( "otherbank", score.toString() );
                score = 0;
                int nfd1 = 0;
                nfd1 = Integer.parseInt( externalVerification.getEx_nfd() );
                if ( nfd1 == 0 )
                    score += 0;
                else if ( nfd1 == 1 )
                    score += 4;
                else if ( nfd1 == 2 )
                    score += 6;
                else
                    score += 10;
                totscore += score;
                context.put( "nfd", score.toString() );
                score = 0;
                int bankdefault1 = 0;
                bankdefault1 = Integer.parseInt( externalVerification.getEx_default() );
                if ( bankdefault1 == 0 )
                    score += 10;
                else if ( bankdefault1 == 1 )
                    score += -4;
                else if ( bankdefault1 == 2 )
                    score += -6;
                else
                    score += -10;
                totscore += score;
                context.put( "bankdefault", score.toString() );
                score = 0;
                if ( "regular".equalsIgnoreCase( externalVerification.getEx_hpaid() )
                    || "NotAvailable".equalsIgnoreCase( externalVerification.getEx_hpaid() ) )
                    score = 0;
                else
                    score += -5;
                totscore += score;
                context.put( "loanpaidhome", score.toString() );
                score = 0;
                if ( "regular".equalsIgnoreCase( externalVerification.getEx_cpaid() )
                    || "NotAvailable".equalsIgnoreCase( externalVerification.getEx_cpaid() ) )
                    score = 0;
                else
                    score += -5;
                totscore += score;
                context.put( "loanpaidcar", score.toString() );
                score = 0;
                if ( "no".equalsIgnoreCase( externalVerification.getEx_crime() ) )
                    score = 0;
                else
                    score += -5;
                totscore += score;
                context.put( "criminalrecord", score.toString() );
                score = 0;
                if ( Integer.parseInt( externalVerification.getEx_lic() ) == 0 )
                    score += 0;
                else if ( Integer.parseInt( externalVerification.getEx_lic() ) == 1 )
                    score += 4;
                else if ( Integer.parseInt( externalVerification.getEx_lic() ) == 2 )
                    score += 6;
                else
                    score += 10;
                totscore += score;
                context.put( "lic", score.toString() );
                score = 0;
                Float aggland1;
                aggland1 = Float.valueOf( externalVerification.getEx_agland() );
                if ( aggland1 == 0 )
                    score = 0;
                else if ( aggland1 == 500 )
                    score += 10;
                else if ( aggland1 == 1000 )
                    score += 20;
                else
                    score += 30;
                totscore += score;
                context.put( "aggland", score.toString() );
                score = 0;
                if ( "yes".equalsIgnoreCase( externalVerification.getEx_otherinc() ) )
                    score += 10;
                else
                    score = 0;
                totscore += score;
                context.put( "otherinc", score.toString() );
                context.put( "totscore", totscore.toString() );
                sessionMap.put( "totalscore", totscore.toString() );
            }
            stack.push( context );
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }

        return FAILURE;
    }

    public String generateback()
    {
        return GENERATEBACK;
    }

}
