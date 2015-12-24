/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import Utility.ScoringUtility;

/**
 * @author yasham
 */
public class Mngaccountup
    extends ActionSupport
{
    ScoringUtility utility = null;

    Connection con1 = null;

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
        utility = new ScoringUtility();
        try
        {
            java.sql.Date sqld = new java.sql.Date( adminManagerInformationBean.getDob().getTime() );
            con1 = utility.openDatabaseConnection();
            String str1 =
                "Update employee set e_id=?,e_gen=?,e_name=?,e_address=?,e_phone=?,e_email=?,e_salary=?,e_dob=? where e_id='"
                    + adminManagerInformationBean.getId() + "'";
            PreparedStatement ps = con1.prepareStatement( str1 );
            ps.setString( 1, adminManagerInformationBean.getId() );
            ps.setString( 2, adminManagerInformationBean.getGen() );
            ps.setString( 3, adminManagerInformationBean.getName() );
            ps.setString( 4, adminManagerInformationBean.getAddress() );
            ps.setString( 5, adminManagerInformationBean.getPhone() );
            ps.setString( 6, adminManagerInformationBean.getEmail() );
            ps.setString( 7, adminManagerInformationBean.getSalary() );
            ps.setDate( 8, sqld );
            ps.executeUpdate();
            con1.close();
        }

        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }

        return MNGUPDATE;
    }

    public String mngdelete()
    {
        utility = new ScoringUtility();
        try
        {
            con1 = utility.openDatabaseConnection();
            String str1 = "delete from employee where e_id=?";
            PreparedStatement ps = con1.prepareStatement( str1 );
            ps.setString( 1, adminManagerInformationBean.getId() );
            ps.executeUpdate();
            con1.close();
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
        utility = new ScoringUtility();
        Integer i = 0;
        try
        {
            Random forp = new Random();
            String pass = adminManagerInformationBean.getName().substring( 0, 1 ).toUpperCase() + "#" + "abc"
                + forp.nextInt( 1000 );
            java.sql.Date sqld = new java.sql.Date( adminManagerInformationBean.getDob().getTime() );
            con1 = utility.openDatabaseConnection();
            java.sql.Date sqld1 = new java.sql.Date( adminManagerInformationBean.getDoj().getTime() );
            con1 = utility.openDatabaseConnection();
            String str1 =
                "Insert into employee(e_id,e_gen,e_name,e_address,e_phone,e_email,e_salary,e_dob,e_doj,e_pass,e_type) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con1.prepareStatement( str1 );
            ps.setString( 1, utility.getNewId( "employee", "e_id" ) );
            ps.setString( 2, adminManagerInformationBean.getGen() );
            ps.setString( 3, adminManagerInformationBean.getName() );
            ps.setString( 4, adminManagerInformationBean.getAddress() );
            ps.setString( 5, adminManagerInformationBean.getPhone() );
            ps.setString( 6, adminManagerInformationBean.getEmail() );
            ps.setString( 7, adminManagerInformationBean.getSalary() );
            ps.setDate( 8, sqld );
            ps.setDate( 9, sqld1 );
            ps.setString( 10, pass );
            ps.setString( 11, adminManagerInformationBean.getType() );
            ps.executeUpdate();
            con1.close();

            con1 = utility.openDatabaseConnection();
            String str2 = "Select employee from bankinfo ";
            java.sql.Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( str2 );

            if ( rs!=null && rs.next() )
            {
                i = Integer.parseInt( rs.getString( 1 ) );
                i++;
            }
            str1 = "Update bankinfo set employee=? ";
            ps = con1.prepareStatement( str1 );
            ps.setString( 1, i.toString() );
            ps.executeUpdate();
            con1.close();
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
            HttpServletRequest request = ServletActionContext.getRequest();
            //request.setAttribute( "isOld", "true" );
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
