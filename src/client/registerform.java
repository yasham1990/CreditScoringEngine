/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import Utility.ScoringUtility;

/**
 * @author yasham
 */
public class registerform
    extends ActionSupport
    implements SessionAware
{
    ScoringUtility utility = null;

    Connection con1 = null;

    PreparedStatement ps = null;

    SessionMap<String, Object> session;

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
        this.session = (SessionMap<String, Object>) session;
    }

    public String execute()
        throws Exception
    {
        utility = new ScoringUtility();
        try
        {
            java.sql.Date sqld = new java.sql.Date( ( (Date) session.get( "dob" ) ).getTime() );

            con1 = utility.openDatabaseConnection();
            String str = "Insert into applicationid ( app_no , status , level ) values (?,?,?)";
            ps = con1.prepareStatement( str );
            ps.setString( 1, (String) session.get( "appno" ) );
            ps.setString( 2, "started" );
            ps.setString( 3, "user" );
            ps.executeUpdate();

            str = "select primarykey from applicationid where app_no='" + (String) session.get( "appno" ) + "'";

            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( str );
            String primarykey = "";
            if ( rs != null && rs.next() )
            {
                primarykey = rs.getString( 1 );
            }

            str = "update clients set applicationid_primarykey='" + primarykey + "' where primarykey='"
                + (String) session.get( "primarykey" ) + "'";
            ps = con1.prepareStatement( str );
            ps.executeUpdate();

            str = "Insert into register1 (applicationid_primarykey , salutation , birth ,m_status , "
                + "sex , pan , annual ,monthly) values (?,?,?,?,?,?,?,?)";
            ps = con1.prepareStatement( str );
            ps.setString( 1, primarykey );
            ps.setString( 2, (String) session.get( "salu" ) );
            ps.setDate( 3, sqld );
            ps.setString( 4, (String) session.get( "status" ) );
            ps.setString( 5, (String) session.get( "sex" ) );
            ps.setString( 6, (String) session.get( "pan" ) );
            ps.setString( 7, (String) session.get( "annualinc" ) );
            ps.setString( 8, (String) session.get( "monthlyinc" ) );
            ps.executeUpdate();

            str =
                "Insert into cdetails(applicationid_primarykey, door_no, street, landmark, nationality, city,state,zip,resi_no) values(?,?,?,?,?,?,?,?,?)";
            ps = con1.prepareStatement( str );
            ps.setString( 1, primarykey );
            ps.setString( 2, (String) session.get( "door" ) );
            ps.setString( 3, (String) session.get( "street" ) );
            ps.setString( 4, (String) session.get( "lmark" ) );
            ps.setString( 5, (String) session.get( "country" ) );
            ps.setString( 6, (String) session.get( "city" ) );
            ps.setString( 7, (String) session.get( "state" ) );
            ps.setString( 8, (String) session.get( "zip" ) );
            ps.setString( 9, (String) session.get( "resi" ) );
            ps.executeUpdate();

            java.sql.Date sqld4 = new java.sql.Date( ( (Date) registerBean.getDateJoin() ).getTime() );
            str =
                "Insert into edetails(applicationid_primarykey, profession, e_name, e_id, doj, e_address, fax, office_no, email) values(?,?,?,?,?,?,?,?,?)";
            ps = con1.prepareStatement( str );
            ps.setString( 1, primarykey );
            ps.setString( 2, registerBean.getProf() );
            ps.setString( 3, registerBean.getEmpName() );
            ps.setString( 4, registerBean.getEmpId() );
            ps.setDate( 5, sqld4 );
            ps.setString( 6, registerBean.getCompAdd() );
            ps.setString( 7, registerBean.getFaxNo() );
            ps.setString( 8, registerBean.getOffNo() );
            ps.setString( 9, registerBean.getOfficialemail() );

            ps.executeUpdate();

            java.util.Date mydate1 = new Date();
            java.sql.Date sqld1 = new java.sql.Date( mydate1.getTime() );

            str = "Insert into furdetails(applicationid_primarykey,name_appear,salary_acc,bank_name,acc_no,"
                + "acc_name,bank,card_holder,card_limit,reg_date,other_card) values (?,?,?,?,?,?,?,?,?,?,?)";
            ps = con1.prepareStatement( str );
            ps.setString( 1, primarykey );
            ps.setString( 2, registerBean.getNameCard() );
            ps.setString( 3, registerBean.getSalbankacc() );
            ps.setString( 4, registerBean.getSalbankname() );
            ps.setString( 5, registerBean.getAccNo() );
            ps.setString( 6, registerBean.getAccHoldrName() );
            ps.setString( 7, registerBean.getBankName1() );
            ps.setString( 8, registerBean.getCardHoldrName() );
            ps.setString( 9, registerBean.getCardLimit() );
            ps.setDate( 10, sqld1 );
            ps.setString( 11, registerBean.getOtherbankcard() );
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
