package emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import Utility.ScoringUtility;

/**
 * @author RANA
 */
public class Forwardapp
    extends ActionSupport
    implements SessionAware
{
    private SessionMap<String, Object> sessionMap;

    static Logger log = Logger.getLogger( Forwardapp.class );

    ScoringUtility utility = null;

    Connection con1 = null;

    EmployeeVerificationBean employeeVerificationBean;

    public EmployeeVerificationBean getEmployeeVerificationBean()
    {
        return employeeVerificationBean;
    }

    public void setEmployeeVerificationBean( EmployeeVerificationBean employeeVerificationBean )
    {
        this.employeeVerificationBean = employeeVerificationBean;
    }

    @Override
    public void setSession( Map<String, Object> sessionMap )
    {
        this.sessionMap = (SessionMap<String, Object>) sessionMap;
    }

    final static private String EXTVERIFYBACK = "extverifyback";

    public String execute()
        throws Exception
    {
        utility = new ScoringUtility();
        try
        {
            con1 = utility.openDatabaseConnection();
            String str = "update applicationid set status='completed' , level='employee' where app_no ='"+(String) sessionMap.get( "app_no" ) +"'";
            PreparedStatement ps = con1.prepareStatement( str );
            ps.executeUpdate();
            
            str = "insert into extverify1(applicationid_primarykey,ex_fname,  ex_lname,  ex_address,ex_email, "
                + " ex_mobile, ex_member, ex_area,   ex_hloan,  ex_hpaid,  ex_billpay,ex_cars,   ex_cloan,  ex_cpaid, "
                + " ex_income, ex_nfd, ex_fdamount,ex_agland, ex_lic,ex_default,ex_tax,ex_crime,  ex_otherinc,ex_otherbank)"
                + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con1.prepareStatement( str );
            ps.setString( 1, (String) sessionMap.get( "primarykey_app" ) );
            ps.setString( 2, employeeVerificationBean.getFname() );
            ps.setString( 3, employeeVerificationBean.getLname() );
            ps.setString( 4, employeeVerificationBean.getAddress() );
            ps.setString( 5, employeeVerificationBean.getEmail() );
            ps.setString( 6, employeeVerificationBean.getMob() );
            ps.setString( 7, employeeVerificationBean.getMembers() );
            ps.setString( 8, employeeVerificationBean.getHarea() );
            ps.setString( 9, employeeVerificationBean.getHloan() );
            ps.setString( 10, employeeVerificationBean.getHinstal() );
            ps.setString( 11, employeeVerificationBean.getBill() );
            ps.setString( 12, employeeVerificationBean.getCars() );
            ps.setString( 13, employeeVerificationBean.getCarloan() );
            ps.setString( 14, employeeVerificationBean.getCinstal() );
            ps.setString( 15, employeeVerificationBean.getInc() );
            ps.setString( 16, employeeVerificationBean.getFd() );
            ps.setString( 17, employeeVerificationBean.getNetfd() );
            ps.setString( 18, employeeVerificationBean.getAgland() );
            ps.setString( 19, employeeVerificationBean.getLic() );
            ps.setString( 20, employeeVerificationBean.getBdflt() );
            ps.setString( 21, employeeVerificationBean.getTax() );
            ps.setString( 22, employeeVerificationBean.getCrime() );
            ps.setString( 23, employeeVerificationBean.getOthinc() );
            ps.setString( 24, employeeVerificationBean.getOthcard() );
            ps.executeUpdate();
            con1.close();

        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return SUCCESS;
    }

    public void validate()
    {
        if ( employeeVerificationBean.getHarea().length() == 0 )
            addFieldError( "employeeVerificationBean.harea", "Please select a choice" );
        if ( employeeVerificationBean.getHloan().length() == 0 )
            addFieldError( "employeeVerificationBean.hloan", "Please select a choice" );
        if ( employeeVerificationBean.getHinstal().length() == 0 )
            addFieldError( "employeeVerificationBean.hinstal", "Please select a choice" );
        if ( employeeVerificationBean.getBill().length() == 0 )
            addFieldError( "employeeVerificationBean.bill", "Please select a choice" );
        if ( employeeVerificationBean.getCarloan().length() == 0 )
            addFieldError( "employeeVerificationBean.carloan", "Please select a choice" );
        if ( employeeVerificationBean.getCinstal().length() == 0 )
            addFieldError( "employeeVerificationBean.cinstal", "Please select a choice" );
        if ( employeeVerificationBean.getCrime().length() == 0 )
            addFieldError( "employeeVerificationBean.crime", "Please select a choice" );
        if ( employeeVerificationBean.getOthcard().length() == 0 )
            addFieldError( "employeeVerificationBean.othcard", "Please select a choice" );
        if ( employeeVerificationBean.getOthinc().length() == 0 )
            addFieldError( "employeeVerificationBean.othinc", "Please select a choice" );
    }

    public String extverifyback()
    {
        return EXTVERIFYBACK;
    }
}