package emp;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;

import Home.EmployeeManagement;
import Utility.HibernateUtil;
import hibernatemapping.Applicationid;
import hibernatemapping.ExternalVerification;

/**
 * @author RANA
 */
public class Forwardapp
    extends ActionSupport
    implements SessionAware
{
    private SessionMap<String, Object> sessionMap;

    static Logger log = Logger.getLogger( Forwardapp.class );

    EmployeeManagement employeeManagement = null;

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
        try
        {
            employeeManagement=new EmployeeManagement();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria( Applicationid.class );
            criteria.add( Restrictions.eq( "app_no", (String) sessionMap.get( "app_no" ) ) );
            Applicationid applicationid = (Applicationid) criteria.uniqueResult();
            if ( applicationid != null )
            {
                applicationid.setStatus( "completed" );
                applicationid.setLevel( "employee" );
            }
            session.merge( applicationid );
            session.saveOrUpdate( applicationid );
            session.getTransaction().commit();

            ExternalVerification externalVerification = new ExternalVerification();

            externalVerification.setApplicationPrimaryKey( applicationid );
            externalVerification.setEx_fname( employeeVerificationBean.getFname() );
            externalVerification.setEx_lname( employeeVerificationBean.getLname() );
            externalVerification.setEx_address( employeeVerificationBean.getAddress() );
            externalVerification.setEx_email( employeeVerificationBean.getEmail() );
            externalVerification.setEx_mobile( employeeVerificationBean.getMob() );
            externalVerification.setEx_member( employeeVerificationBean.getMembers() );
            externalVerification.setEx_area( employeeVerificationBean.getHarea() );
            externalVerification.setEx_hloan( employeeVerificationBean.getHloan() );
            externalVerification.setEx_hpaid( employeeVerificationBean.getHinstal() );
            externalVerification.setEx_billpay( employeeVerificationBean.getBill() );
            externalVerification.setEx_cars( employeeVerificationBean.getCars() );
            externalVerification.setEx_cloan( employeeVerificationBean.getCarloan() );
            externalVerification.setEx_cpaid( employeeVerificationBean.getCinstal() );
            externalVerification.setEx_income( employeeVerificationBean.getInc() );
            externalVerification.setEx_nfd( employeeVerificationBean.getFd() );
            externalVerification.setEx_famount( employeeVerificationBean.getNetfd() );
            externalVerification.setEx_agland( employeeVerificationBean.getAgland() );
            externalVerification.setEx_lic( employeeVerificationBean.getLic() );
            externalVerification.setEx_default( employeeVerificationBean.getBdflt() );
            externalVerification.setEx_tax( employeeVerificationBean.getTax() );
            externalVerification.setEx_crime( employeeVerificationBean.getCrime() );
            externalVerification.setEx_otherinc( employeeVerificationBean.getOthinc() );
            externalVerification.setEx_otherbank( employeeVerificationBean.getOthcard() );
            employeeManagement.create( externalVerification );
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