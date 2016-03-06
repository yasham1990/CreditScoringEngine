/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import Home.EmployeeManagement;
import Utility.HibernateUtil;
import hibernatemapping.Applicationid;
import hibernatemapping.Client;
import hibernatemapping.ClientEmploymentdetails;
import hibernatemapping.Clientdetails;
import hibernatemapping.FurtherClientDetails;
import hibernatemapping.RegisterClientDetails;

/**
 * @author yasham
 */
public class registerform
    extends ActionSupport
    implements SessionAware
{
    EmployeeManagement employeeManagement = null;
    
    SessionMap<String, Object> sessionMap;

    private RegisterBean registerBean;

    static Logger log = Logger.getLogger( registerform.class );

    public registerform()
    {
    }

    final static private String REGISBACKFORM = "regisbackform";

    public RegisterBean getRegisterBean()
    {
        return registerBean;
    }

    public void setRegisterBean( RegisterBean registerBean )
    {
        this.registerBean = registerBean;
    }

    @Override
    public void setSession( Map<String, Object> session )
    {
        this.sessionMap = (SessionMap<String, Object>) session;
    }

    public String execute()
        throws Exception
    {
        employeeManagement= new EmployeeManagement();
        
        try
        {
            Applicationid applicationid=new Applicationid();
            java.sql.Date sqld = new java.sql.Date( ( (Date) sessionMap.get( "dob" ) ).getTime() );

            applicationid.setApp_no( (String) sessionMap.get( "appno" ) );
            applicationid.setStatus( "started" );
            applicationid.setLevel( "user" );
            
            employeeManagement.create(applicationid);

            applicationid=employeeManagement.getApplicationidByPrimarykey( applicationid.getPrimarykey() );
            
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Client client = (Client) session.get( Client.class,(int) sessionMap.get( "primarykey" ) );
            client.setApplicationPrimaryKey( applicationid );
            session.merge(client);
            session.saveOrUpdate( client);
            session.getTransaction().commit();
            
            RegisterClientDetails registerClientDetails=new RegisterClientDetails();
            registerClientDetails.setApplicationPrimaryKey( applicationid );
            registerClientDetails.setSalutaion( (String) sessionMap.get( "salu" ) );
            registerClientDetails.setBirth( sqld );
            registerClientDetails.setM_status( (String) sessionMap.get( "status" ) );
            registerClientDetails.setSex( (String)sessionMap.get( "sex" ) );
            registerClientDetails.setPan( (String) sessionMap.get( "pan" ) );
            registerClientDetails.setAnnualsalary( (String) sessionMap.get( "annualinc" ) );
            registerClientDetails.setMonthlysalary( ( String) sessionMap.get( "monthlyinc" ) );

            employeeManagement.create(registerClientDetails);
            Clientdetails clientdetails=new Clientdetails();
            
            clientdetails.setApplicationPrimaryKey( applicationid );
            clientdetails.setDoorno( (String) sessionMap.get( "door" ) );
            clientdetails.setStreet( (String) sessionMap.get( "street" ) );
            clientdetails.setState( (String) sessionMap.get( "lmark" ) );
            clientdetails.setCountry( (String) sessionMap.get( "country" ) );
            clientdetails.setCity( (String) sessionMap.get( "city" ) );
            clientdetails.setState( (String) sessionMap.get( "state" ) );
            clientdetails.setZip( (String) sessionMap.get( "zip" ) );
            clientdetails.setResino( (String) sessionMap.get( "resi" ) );
            
            employeeManagement.create(clientdetails);

            ClientEmploymentdetails clientEmploymentdetails=new ClientEmploymentdetails();
            java.sql.Date sqld4 = new java.sql.Date( ( (Date) registerBean.getDateJoin() ).getTime() );
            clientEmploymentdetails.setApplicationPrimaryKey( applicationid );
            clientEmploymentdetails.setProfession( registerBean.getProf() );
            clientEmploymentdetails.setEmployeeName( registerBean.getEmpName() );
            clientEmploymentdetails.setEmployeeCompanyId( registerBean.getEmpId() );
            clientEmploymentdetails.setDateOfJoining( sqld4 );
            clientEmploymentdetails.setAddress( registerBean.getCompAdd() );
            clientEmploymentdetails.setFax( registerBean.getFaxNo() );
            clientEmploymentdetails.setOfficeno( registerBean.getOffNo() );
            clientEmploymentdetails.setCompanymail( registerBean.getOfficialemail() );
            
            employeeManagement.create(clientEmploymentdetails);


            java.util.Date mydate1 = new Date();
            java.sql.Date sqld1 = new java.sql.Date( mydate1.getTime() );

            FurtherClientDetails furtherClientDetails=new FurtherClientDetails();
            furtherClientDetails.setApplicationPrimaryKey( applicationid );
            furtherClientDetails.setName_appear( registerBean.getNameCard() );
            furtherClientDetails.setSalary_acc( registerBean.getSalbankacc() );
            furtherClientDetails.setBank_name( registerBean.getSalbankname() );
            furtherClientDetails.setAcc_no( registerBean.getAccNo() );
            furtherClientDetails.setAcc_name( registerBean.getAccHoldrName() );
            furtherClientDetails.setBank( registerBean.getBankName1() );
            furtherClientDetails.setCard_holder( registerBean.getCardHoldrName() );
            furtherClientDetails.setCard_limit( registerBean.getCardLimit() );
            furtherClientDetails.setReg_date( sqld1 );
            furtherClientDetails.setOther_card( registerBean.getOtherbankcard() );
            employeeManagement.create(furtherClientDetails);

        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }

        return SUCCESS;
    }

    public void validate()
    {
        String salbankacc = registerBean.getSalbankacc();
        String otherbankcard = registerBean.getOtherbankcard();
        String salbankname = registerBean.getSalbankname();
        String accNo = registerBean.getAccNo();
        String bankName1 = registerBean.getBankName1();
        if ( salbankacc.length() == 0 )
            addFieldError( "accNo", "Please enter a choice" );
        if ( otherbankcard.length() == 0 )
            addFieldError( "bankName1", "Please enter a choice" );
        if ( salbankacc.equals( "Yes" ) )
        {
            if ( salbankname.length() == 0 )
                addFieldError( "salbankname", "Please Enter bankname" );
            else if ( !salbankname.matches( "^[A-Za-z]{1,10}$" ) )
            {
                addFieldError( "salbankname", "Name can contain only characters" );
            }
            if ( accNo.length() == 0 )
                addFieldError( "accNo", "Please Enter account number" );
            else if ( !accNo.matches( "^[0-9]{12,16}$" ) )
                addFieldError( "accNo", "Please Enter correct account number" );
            if ( registerBean.getAccHoldrName().length() == 0 )
                addFieldError( "accHoldrName", "Please Enter account Holder name" );

        }
        if ( otherbankcard.equals( "Yes" ) )
        {
            if ( bankName1.length() == 0 )
                addFieldError( "bankName1", "Please Enter bankname" );
            else if ( !bankName1.matches( "^[A-Za-z]{1,10}$" ) )
            {
                addFieldError( "bankName1", "Name can contain only characters" );
            }
            if ( registerBean.getCardHoldrName().length() == 0 )
                addFieldError( "cardHoldrName", "Please Enter card Holder name" );

        }
    }

    public String regisbackform()
    {
        return REGISBACKFORM;
    }
}
