/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

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

/**
 * @author yasham
 */
public class Datatoadmin
    extends ActionSupport
    implements SessionAware
{

    static Logger log = Logger.getLogger( Datatoadmin.class );

    private SessionMap<String, Object> sessionMap;

    EmployeeManagement employeeManagement = null;
    @Override
    public void setSession( Map<String, Object> sessionMap )
    {
        this.sessionMap = (SessionMap<String, Object>) sessionMap;
    }

    public Datatoadmin()
    {
    }

    public String execute()
        throws Exception
    {
        try
        {
            employeeManagement=new EmployeeManagement();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria( Applicationid.class );
            criteria.add( Restrictions.eq( "app_no", String.valueOf( sessionMap.get( "app_no" ) ) ));
            Applicationid applicationid = (Applicationid) criteria.uniqueResult();
            if ( applicationid != null )
            {
                applicationid.setStatus( "completed" );
                applicationid.setLevel( "manager" );
                applicationid.setScore( Integer.parseInt( (String)sessionMap.get( "totalscore" ) ) );
            }
            session.merge( applicationid );
            session.saveOrUpdate( applicationid );
            session.getTransaction().commit();
            
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return SUCCESS;
    }

}