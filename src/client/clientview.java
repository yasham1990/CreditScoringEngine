
package client;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import Home.EmployeeManagement;
import Utility.HibernateUtil;
import hibernatemapping.Client;

public class clientview
    extends ActionSupport
    implements SessionAware
{

    EmployeeManagement employeeManagement = null;

    private RegisterBean registerBean;

    private SessionMap<String, Object> sessionMap;

    static Logger log = Logger.getLogger( clientview.class );

    final static private String CLIENTVIEWBACK = "clientviewback";

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
        try
        {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Client client = null;
            session.beginTransaction();
            client = (Client) session.get( Client.class,(int) sessionMap.get( "primarykey" ) );

            if ( client != null )
            {
                client.setFirstname( registerBean.getFname() );
                client.setLastname( registerBean.getLname() );
                client.setPhone( registerBean.getMobile() );
                client.setEmail( registerBean.getEmail() );
            }
            session.merge( client );
            session.saveOrUpdate( client );
            session.getTransaction().commit();
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
        employeeManagement = new EmployeeManagement();
        ValueStack stack = ActionContext.getContext().getValueStack();
        Map<String, Object> context = new HashMap<String, Object>();
        context.put( "fname", registerBean.getFname() );
        context.put( "lname", registerBean.getLname() );
        context.put( "mobile", registerBean.getMobile() );
        context.put( "email", registerBean.getEmail() );
        stack.push( context );
        try
        {
            Client client = employeeManagement.getClient( registerBean.getEmail() );
            if ( client != null && !registerBean.getEmail().equals( client.getEmail() ) )
                addFieldError( "email", "User already exits." );
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }

    }

}
