/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;

import Utility.HibernateUtil;
import hibernatemapping.Applicationid;
import hibernatemapping.Bankinfo;

/**
 * @author yasham
 */
public class accept
    extends ActionSupport
    implements SessionAware
{
    private SessionMap<String, Object> sessionMap;

    static Logger log = Logger.getLogger( toacceptpage.class );

    @Override
    public void setSession( Map<String, Object> sessionMap )
    {
        this.sessionMap = (SessionMap<String, Object>) sessionMap;
    }

    final static private String REJECT = "reject";

    final static private String ACCEPT = "accept";

    public accept()
    {
    }

    public String execute()
        throws Exception
    {
        Integer bankup = 0 ;
        try
        {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria( Applicationid.class );
            criteria.add( Restrictions.eq( "app_no", (String) sessionMap.get( "app_no" ) ) );
            Applicationid applicationid = (Applicationid) criteria.uniqueResult();
            if ( applicationid != null )
            {
                applicationid.setStatus( "approved" );
                applicationid.setLevel( "admin" );
            }
            session.merge( applicationid );
            session.saveOrUpdate( applicationid );
            session.getTransaction().commit();
            
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            criteria = session.createCriteria( Bankinfo.class );
            Bankinfo bankinfo = (Bankinfo) criteria.uniqueResult();
            if ( bankinfo != null )
            {
                bankinfo.setTotalcards( (Integer.parseInt(bankinfo.getTotalcards())+1)+"" );
            }
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }

        return ACCEPT;
    }

    public String reject()
    {
        try
        {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria( Applicationid.class );
            criteria.add( Restrictions.eq( "app_no", (String) sessionMap.get( "app_no" ) ) );
            Applicationid applicationid = (Applicationid) criteria.uniqueResult();
            if ( applicationid != null )
            {
                applicationid.setStatus( "rejected" );
                applicationid.setLevel( "admin" );
            }
            session.merge( applicationid );
            session.saveOrUpdate( applicationid );
            session.getTransaction().commit();
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return REJECT;
    }

}
