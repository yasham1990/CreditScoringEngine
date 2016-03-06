package admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import Home.EmployeeManagement;
import hibernatemapping.Employee;

/**
 * @author yasham
 */
public class AdminEdit
    extends ActionSupport
    implements SessionAware
{

    EmployeeManagement employeeManagement = null;

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
        employeeManagement = new EmployeeManagement();
        try
        {
            Employee employee = employeeManagement.getEmployee( adminManagerInformationBean.getId(), "",
                                                                new String[] { "Manager", "Employee" } );
            if ( employee != null )
            {
                adminManagerInformationBean.setId( adminManagerInformationBean.getId() );
                adminManagerInformationBean.setName( employee.getName() );
                adminManagerInformationBean.setPhone( employee.getPhone() );
                adminManagerInformationBean.setSalary( employee.getSalary() );
                adminManagerInformationBean.setAddress( employee.getAddress() );
                adminManagerInformationBean.setDob( employee.getDob() );
                adminManagerInformationBean.setEmail( employee.getEmail() );
                adminManagerInformationBean.setDoj( employee.getDoj() );
                adminManagerInformationBean.setGen( employee.getGender() );
            }
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
            employeeManagement = new EmployeeManagement();
            try
            {
                Employee employee = employeeManagement.getEmployee( adminManagerInformationBean.getId(), "",
                                                                    new String[] { "Manager", "Employee" } );
                if ( employee == null )
                    addFieldError( "adminManagerInformationBean.id", "Invalid application id" );
            }
            catch ( Exception e )
            {
                log.error( e.getMessage() );
            }

        }
    }
}
