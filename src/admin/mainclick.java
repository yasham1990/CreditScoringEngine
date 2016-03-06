
package admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import Home.EmployeeManagement;
import Utility.HibernateUtil;
import emp.click;
import hibernatemapping.Applicationid;
import hibernatemapping.Employee;

/**
 * @author yasham
 */
public class mainclick
    extends ActionSupport
    implements SessionAware
{

    private SessionMap<String, Object> sessionMap;

    static Logger log = Logger.getLogger( click.class );

    EmployeeManagement employeeManagement = null;
    @Override
    public void setSession( Map<String, Object> sessionMap )
    {
        this.sessionMap = (SessionMap<String, Object>) sessionMap;
    }

    final static private String ADMINEDITBACK = "admineditback";
    
    final static private String ADMINPASSVIEW = "adminpassview";

    final static private String ADMININSERT = "admininsert";

    final static private String ADMINAPPROVEPHOTO = "adminapprovephoto";

    final static private String MANAGEPHOTO = "managephoto";

    final static private String MNGBACK = "mngback";

    final static private String GOBACKADMIN = "gobackadmin";

    private List<String> h1;

    public mainclick()
    {
    }

    public String execute()
        throws Exception
    {
        return SUCCESS;
    }

    public String adminapprovephoto()
    {
        employeeManagement = new EmployeeManagement();
        try
        {
            h1 = new ArrayList<String>();
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, List<String>> context = new HashMap<String, List<String>>();
            List<Applicationid> applicationids = employeeManagement.getApplicationidList( "completed", "manager" );
            if ( applicationids == null || applicationids.isEmpty() )
                h1.add( "There is no application request pending" );
            else
            {
                for ( Applicationid applicationid : applicationids )
                    h1.add( applicationid.getApp_no() );
            }
            context.put( "h1", h1 );
            stack.push( context );
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return ADMINAPPROVEPHOTO;
    }

    public String adminpassview()
    {
        employeeManagement = new EmployeeManagement();
        try
        {
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, Object> context = new HashMap<String, Object>();
            Employee employee = employeeManagement.getEmployeeByPrimarykey( (int) sessionMap.get( "primarykey" ) );
            if ( employee != null )
            {
                context.put( "id", employee.getEmployeeId() );
                stack.push( context );
            }
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return ADMINPASSVIEW;
    }

    public String managephoto()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Employee> employees = null;
        try
        {
            h1 = new ArrayList<String>();
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, List<String>> context = new HashMap<String, List<String>>();
            Criteria criteria = session.createCriteria( Employee.class );
                criteria.add( Restrictions.in( "type", new String[]{"Manager","Employee"})  );
                employees = criteria.list();
                if ( employees == null || employees.isEmpty() )
                    h1.add( "No Employee Present" );
                else
                {
                    for ( Employee employee : employees )
                        h1.add( employee.getEmployeeId() );
                }
                session.getTransaction().commit();
                context.put( "h1", h1 );
                stack.push( context );
        }
        catch ( HibernateException e )
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        
        return MANAGEPHOTO;
    }

    public String admineditback()
    {
        return ADMINEDITBACK;
    }

    public String admininsert()
    {
        return ADMININSERT;
    }

    public String mngback()
    {
        return MNGBACK;
    }

    public String gobackadmin()
    {
        return GOBACKADMIN;
    }
}
