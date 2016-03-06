package admin;

import java.util.Random;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;

import Home.EmployeeManagement;
import Utility.HibernateUtil;
import hibernatemapping.Bankinfo;
import hibernatemapping.Employee;

/**
 * @author yasham
 */
public class Mngaccountup
    extends ActionSupport
{

    static Logger log = Logger.getLogger( Mngaccountup.class );

    private AdminManagerInformationBean adminManagerInformationBean;

    public AdminManagerInformationBean getAdminManagerInformationBean()
    {
        return adminManagerInformationBean;
    }

    public void setAdminManagerInformationBean( AdminManagerInformationBean adminManagerInformationBean )
    {
        this.adminManagerInformationBean = adminManagerInformationBean;
    }

    public Mngaccountup()
    {
    }

    final static private String MNGUPDATE = "mngupdate";

    final static private String MNGINSERT = "mnginsert";

    final static private String MNGDELETE = "mngdelete";

    final static private String MNGBACK = "mngback";

    public String execute()
        throws Exception
    {

        try
        {

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria( Employee.class );
            criteria.add( Restrictions.eq( "employeeId", adminManagerInformationBean.getId() ) );
            Employee employee = (Employee) criteria.uniqueResult();
            if ( employee != null )
            {
                employee.setEmployeeId( adminManagerInformationBean.getId() );
                employee.setGender( adminManagerInformationBean.getGen() );
                employee.setName( adminManagerInformationBean.getName() );
                employee.setAddress( adminManagerInformationBean.getAddress() );

                employee.setPhone( adminManagerInformationBean.getPhone() );
                employee.setEmail( adminManagerInformationBean.getEmail() );
                employee.setSalary( adminManagerInformationBean.getSalary() );
            }
            session.merge( employee );
            session.saveOrUpdate( employee );
            session.getTransaction().commit();

        }

        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }

        return MNGUPDATE;
    }

    public String mngdelete()
    {
        try
        {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria( Employee.class );
            criteria.add( Restrictions.eq( "employeeId", adminManagerInformationBean.getId() ) );
            Employee employee = (Employee) criteria.uniqueResult();
            session.delete( employee );
            session.getTransaction().commit();
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return MNGDELETE;
    }

    public String mngback()
    {
        return MNGBACK;
    }

    public String mnginsert()
    {
        try
        {
            EmployeeManagement employeeManagement = new EmployeeManagement();
            Random forp = new Random();
            String pass = adminManagerInformationBean.getName().substring( 0, 1 ).toUpperCase() + "#" + "abc"
                + forp.nextInt( 1000 );
            java.sql.Date sqld = new java.sql.Date( adminManagerInformationBean.getDob().getTime() );
            java.sql.Date sqld1 = new java.sql.Date( adminManagerInformationBean.getDoj().getTime() );
            Employee employee = new Employee();
            if ( employee != null )
            {
                employee.setEmployeeId( String.valueOf( employeeManagement.getMaximumEmployeeID() ));
                employee.setGender( adminManagerInformationBean.getGen() );
                employee.setName( adminManagerInformationBean.getName() );
                employee.setAddress( adminManagerInformationBean.getAddress() );

                employee.setPhone( adminManagerInformationBean.getPhone() );
                employee.setEmail( adminManagerInformationBean.getEmail() );
                employee.setSalary( adminManagerInformationBean.getSalary() );
                employee.setType( adminManagerInformationBean.getType() );
                employee.setDob( sqld );
                employee.setDoj( sqld1 );
                employee.setEmployeePass( pass );
            }
            employeeManagement.create( employee );

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria( Bankinfo.class );
            Bankinfo bankinfo = (Bankinfo) criteria.uniqueResult();
            if ( bankinfo != null )
            {
                bankinfo.setTotalcards( ( Integer.parseInt( bankinfo.getNumberofemployee() ) + 1 ) + "" );
            }
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }

        return MNGINSERT;
    }

    @Override
    public void validate()
    {
        try
        {
            String name = adminManagerInformationBean.getName();
            String gender = adminManagerInformationBean.getGen();
            if ( name.length() == 0 )
                addFieldError( "adminManagerInformationBean.name", "Name is required" );
            else if ( !name.matches( "^[A-Za-z ]{1,30}$" ) )
                addFieldError( "adminManagerInformationBean.name", "Only alphabets allowed" );
            else if ( gender.length() == 0 )
                addFieldError( "adminManagerInformationBean.gen", "Gender is required" );
            else if ( !gender.equalsIgnoreCase( "male" ) && !gender.equalsIgnoreCase( "female" ) )
                addFieldError( "adminManagerInformationBean.gen", "Invalid Detail" );
            else if ( adminManagerInformationBean.getAddress().length() == 0 )
                addFieldError( "adminManagerInformationBean.address", "Address is required" );
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }

    }

}
