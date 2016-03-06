package Home;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import Utility.HibernateUtil;
import hibernatemapping.Applicationid;
import hibernatemapping.Bankinfo;
import hibernatemapping.Client;
import hibernatemapping.ClientEmploymentdetails;
import hibernatemapping.Clientdetails;
import hibernatemapping.Employee;
import hibernatemapping.ExternalVerification;
import hibernatemapping.FurtherClientDetails;
import hibernatemapping.RegisterClientDetails;

public class EmployeeManagement
    extends HibernateUtil
{

    public Employee create( Employee employee )
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save( employee );
        session.getTransaction().commit();
        return employee;
    }

    public Employee delete( Employee employee )
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete( employee );
        session.getTransaction().commit();
        return employee;
    }

    public Client create( Client client )
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save( client );
        session.getTransaction().commit();
        return client;
    }

    public Applicationid create( Applicationid applicationid )
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save( applicationid );
        session.getTransaction().commit();
        return applicationid;
    }

    public FurtherClientDetails create( FurtherClientDetails furtherClientDetails )
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save( furtherClientDetails );
        session.getTransaction().commit();
        return furtherClientDetails;
    }

    public RegisterClientDetails create( RegisterClientDetails registerClientDetails )
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save( registerClientDetails );
        session.getTransaction().commit();
        return registerClientDetails;
    }

    public Clientdetails create( Clientdetails clientdetails )
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save( clientdetails );
        session.getTransaction().commit();
        return clientdetails;
    }

    public ClientEmploymentdetails create( ClientEmploymentdetails clientEmploymentdetails )
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save( clientEmploymentdetails );
        session.getTransaction().commit();
        return clientEmploymentdetails;
    }

    public ExternalVerification create( ExternalVerification externalVerification )
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save( externalVerification );
        session.getTransaction().commit();
        return externalVerification;
    }

    public Employee getEmployee( String id, String password, String[] official )
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Employee employee = null;
        try
        {
            session.beginTransaction();
            Criteria criteria = session.createCriteria( Employee.class );
            criteria.add( Restrictions.eq( "employeeId", id ) );
            if(!"".equals( password ))
            criteria.add( Restrictions.eq( "employeePass", password ) );
            criteria.add( Restrictions.in( "type", official ) );
            employee = (Employee) criteria.uniqueResult();
            if ( employee != null )
            {
                System.out.println( "Employee found:" );
                System.out.println( employee.getEmployeeId() + " - " + employee.getName() );
            }
            session.getTransaction().commit();
        }
        catch ( HibernateException e )
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return employee;
    }

    public Client getClient( String id )
    {
        return getClient( id, "" );
    }

    public Client getClient( String id, String password )
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Client client = null;
        try
        {
            session.beginTransaction();
            Criteria criteria = session.createCriteria( Client.class );
            criteria.add( Restrictions.eq( "email", id ) );
            if ( !"".equals( password ) )
                criteria.add( Restrictions.eq( "clientPass", password ) );
            client = (Client) criteria.uniqueResult();
            if ( client != null )
            {
                System.out.println( "Client found:" );
                System.out.println( client.getPrimarykey() + " - " + client.getFirstname() );
            }
            session.getTransaction().commit();
        }
        catch ( HibernateException e )
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return client;
    }

    public Client getClientByPrimarykey( int primarykey )
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Client client = null;
        try
        {
            session.beginTransaction();
            client = (Client) session.get( Client.class, primarykey );
            session.getTransaction().commit();
        }
        catch ( HibernateException e )
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return client;
    }

    public Employee getEmployeeByPrimarykey( int primarykey )
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Employee employee = null;
        try
        {
            session.beginTransaction();
            employee = (Employee) session.get( Employee.class, primarykey );
            session.getTransaction().commit();
        }
        catch ( HibernateException e )
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return employee;
    }

    public Applicationid getApplicationidByPrimarykey( int primarykey )
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Applicationid applicationid = null;
        try
        {
            session.beginTransaction();
            applicationid = (Applicationid) session.get( Applicationid.class, primarykey );
            session.getTransaction().commit();
        }
        catch ( HibernateException e )
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return applicationid;
    }

    public Applicationid getApplicationidByAppno( String appno )
    {
        return getApplicationidByAppno( appno, "", "" );
    }

    public Applicationid getApplicationidByAppno( String appno, String status, String level )
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Applicationid applicationid = null;
        try
        {
            session.beginTransaction();
            Criteria criteria = session.createCriteria( Applicationid.class );
            if ( !"".equals( appno ) )
                criteria.add( Restrictions.eq( "app_no", appno ) );
            if ( !"".equals( status ) )
                criteria.add( Restrictions.eq( "status", status ) );
            if ( !"".equals( level ) )
                criteria.add( Restrictions.eq( "level", level ) );
            applicationid = (Applicationid) criteria.uniqueResult();
            if ( applicationid != null )
            {
                System.out.println( "Client found:" );
                System.out.println( applicationid.getPrimarykey() );
            }
            session.getTransaction().commit();
        }
        catch ( HibernateException e )
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return applicationid;
    }

    public Bankinfo getBankInfo()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Bankinfo bankinfo = null;
        try
        {
            session.beginTransaction();
            Criteria criteria = session.createCriteria( Bankinfo.class );
            bankinfo = (Bankinfo) criteria.uniqueResult();
            if ( bankinfo != null )
            {
                System.out.println( "Client found:" );
                System.out.println( bankinfo.getPrimarykey() );
            }
            session.getTransaction().commit();
        }
        catch ( HibernateException e )
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return bankinfo;
    }

    public List<Applicationid> getApplicationidList( String status, String level )
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Applicationid> applicationids = null;
        try
        {
            Criteria criteria = session.createCriteria( Applicationid.class );
            if ( !"".equals( status ) )
                criteria.add( Restrictions.eq( "status", status ) );
            if ( !"".equals( level ) )
                criteria.add( Restrictions.eq( "level", level ) );
            applicationids = criteria.list();
        }
        catch ( HibernateException e )
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return applicationids;
    }

    public ExternalVerification getExternalVerificationAppId( Applicationid appid )
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        ExternalVerification externalVerification = null;
        try
        {
            Criteria criteria =
                session.createCriteria( ExternalVerification.class ).createAlias( "applicationPrimaryKey",
                                                                                  "b_alias" ).add( Restrictions.disjunction().add( Restrictions.eq( "b_alias.primarykey",
                                                                                                                                                    appid.getPrimarykey() ) ) );
            externalVerification = (ExternalVerification) criteria.uniqueResult();
        }
        catch ( HibernateException e )
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return externalVerification;
    }

    public Client getClientAppId( int appid )
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Client client = null;
        try
        {
            Criteria criteria =
                session.createCriteria( Client.class ).createAlias( "applicationPrimaryKey",
                                                                    "b_alias" ).add( Restrictions.disjunction().add( Restrictions.eq( "b_alias.primarykey",
                                                                                                                                      appid ) ) );
            client = (Client) criteria.uniqueResult();
        }
        catch ( HibernateException e )
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return client;
    }

    public int getMaximumEmployeeID()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        int id = 0;
        try
        {
            String sql = "SELECT max(e_id) as count FROM EMPLOYEE";
            SQLQuery query = session.createSQLQuery( sql );
            query.setResultTransformer( Criteria.ALIAS_TO_ENTITY_MAP );
            Object object = query.uniqueResult();
            if ( object != null )
            {
                Map row = (Map) object;
                id = Integer.parseInt((String)row.get( "count" )) + 1;
            }
            else
                id = 10001;
            session.getTransaction().commit();
        }
        catch ( HibernateException e )
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return id;
    }
}