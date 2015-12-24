
package manage;

import java.sql.Connection;
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

public class Generate
    extends ActionSupport
    implements SessionAware
{

    static Logger log = Logger.getLogger( Generate.class );

    private SessionMap<String, Object> sessionMap;

    ScoringUtility utility = null;

    Connection con1 = null;

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
            utility = new ScoringUtility();
            con1 = utility.openDatabaseConnection();
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, String> context = new HashMap<String, String>();
            String str =
                "select applicationid_primarykey,ex_income,ex_address,ex_tax,ex_billpay,ex_otherbank,ex_nfd,"
                + "ex_default,ex_hpaid,ex_crime,ex_lic,ex_agland,ex_otherinc,ex_cpaid from extverify1 "
                + "where applicationid_primarykey='" + sessionMap.get( "primarykey_app" ) + "'";
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( str );

            if ( rs != null && rs.next() )
            {
                    Float income;
                    income = Float.valueOf( rs.getString( 2 ) );
                    if ( income >= 30000 && income <= 70000 )
                        score += 10;
                    else if ( income >= 70000 && income <= 150000 )
                        score += 20;
                    else
                        score += 30;
                    totscore += score;
                    context.put( "income1", score.toString() );
                    score = 0;
                    if ( "yes".equalsIgnoreCase( rs.getString( 3 ) ) )
                        score += 10;
                    else
                        score = 0;
                    totscore += score;
                    context.put( "address", score.toString() );
                    score = 0;
                    int defaulttax=0;
                    defaulttax = Integer.parseInt( rs.getString( 4 ) );
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
                    if ( "ontime".equalsIgnoreCase( rs.getString( 5 ) ) )
                        score += 10;
                    else
                        score = -5;
                    totscore += score;
                    context.put( "billpay", score.toString() );
                    score = 0;
                    if ( "yes".equalsIgnoreCase( rs.getString( 6 ) ) )
                        score += 10;
                    else
                        score = 0;
                    totscore += score;
                    context.put( "otherbank", score.toString() );
                    score = 0;
                    int nfd1=0;
                    nfd1 = Integer.parseInt( rs.getString( 7 ) );
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
                    int bankdefault1=0;
                    bankdefault1 = Integer.parseInt( rs.getString( 8 ) );
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
                    if ( "regular".equalsIgnoreCase( rs.getString( 9 ) ) || "NotAvailable".equalsIgnoreCase( rs.getString( 9 ) ) )
                        score = 0;
                    else
                        score += -5;
                    totscore += score;
                    context.put( "loanpaidhome", score.toString() );
                    score = 0;
                    if ( "regular".equalsIgnoreCase( rs.getString( 14 ) ) || "NotAvailable".equalsIgnoreCase( rs.getString( 14 ) ) )
                        score = 0;
                    else
                        score += -5;
                    totscore += score;
                    context.put( "loanpaidcar", score.toString() );
                    score = 0;
                    if ( "no".equalsIgnoreCase( rs.getString( 10 ) ) )
                        score = 0;
                    else
                        score += -5;
                    totscore += score;
                    context.put( "criminalrecord", score.toString() );
                    score = 0;
                    if ( rs.getInt( 11 ) == 0 )
                        score += 0;
                    else if ( rs.getInt( 11 ) == 1 )
                        score += 4;
                    else if ( rs.getInt( 11 ) == 2 )
                        score += 6;
                    else
                        score += 10;
                    totscore += score;
                    context.put( "lic", score.toString() );
                    score = 0;
                    Float aggland1;
                    aggland1 = Float.valueOf( rs.getString( 12 ) );
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
                    if ( "yes".equalsIgnoreCase( rs.getString( 13 ) ) )
                        score += 10;
                    else
                        score = 0;
                    totscore += score;
                    context.put( "otherinc", score.toString() );
                    context.put( "totscore", totscore.toString() );
                }
            stack.push( context );
            con1.close();
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
