/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import Utility.ScoringUtility;

public class InternalInfo
    extends ActionSupport implements SessionAware
{
    static Logger log = Logger.getLogger( InternalInfo.class );

    private SessionMap<String, Object> sessionMap;

    ScoringUtility utility = null;

    Connection con1 = null;

    @Override
    public void setSession( Map<String, Object> sessionMap )
    {
        this.sessionMap = (SessionMap<String, Object>) sessionMap;
    }
    
    final static private String INTERNALBACK = "internalback";

    public InternalInfo()
    {
    }

    public String execute()
        throws Exception
    {
        try
        {
            utility = new ScoringUtility();
            con1 = utility.openDatabaseConnection();
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, String> context = new HashMap<String, String>();
            String str =
                "select c_firstname,c_lastname,birth,m_status,sex,pan,c_phone,c_email,annual,monthly,door_no,street,landmark,"
                + "nationality,city,state,zip,resi_no,profession,e_name,e_id,doj,e_address,office_no,e.email,"
                + "salary_acc,bank_name,acc_no,acc_name,other_card,bank,card_holder,card_limit,reg_date from clients,register1 r,"
                + "cdetails c,edetails e,furdetails f where clients.applicationid_primarykey=r.applicationid_primarykey and "
                + "r.applicationid_primarykey=c.applicationid_primarykey and "
                + "r.applicationid_primarykey=e.applicationid_primarykey and "
                + "r.applicationid_primarykey=f.applicationid_primarykey and r.applicationid_primarykey='" + sessionMap.get( "primarykey_app" ) + "'";
            java.sql.Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( str );
            if ( rs != null && rs.next() )
            {
                context.put("fname",rs.getString( 1 ));
                context.put("lname",rs.getString( 2 ));
                context.put("birth",rs.getString( 3 ));
                context.put("m_status",rs.getString( 4 ));
                context.put("sex",rs.getString( 5 ));
                context.put("pan",rs.getString( 6 ));
                context.put("mobile",rs.getString( 7 ));
                context.put("email",rs.getString( 8 ));
                context.put("annual",rs.getString( 9 ));
                context.put("monthly",rs.getString( 10 ));
                context.put("door",rs.getString( 11 ));
                context.put("street",rs.getString( 12 ));
                context.put("landmark",rs.getString( 13 ));
                context.put("nationality",rs.getString( 14 ));
                context.put("city",rs.getString( 15 ));
                context.put("state",rs.getString( 16 ));
                context.put("zip",rs.getString( 17 ));
                context.put("resino",rs.getString( 18 ));
                context.put("profession",rs.getString( 19 ));
                context.put("ename",rs.getString( 20 ));
                context.put("eid",rs.getString( 21 ));
                context.put("join",rs.getDate( 22 ).toString());
                context.put("comaddress",rs.getString( 23 ));
                context.put("officeno",rs.getString( 24 ));
                context.put("officeemail",rs.getString( 25 ));
                context.put("salaccount",rs.getString( 26 ));
                context.put("salbankname",rs.getString( 27 ));
                context.put("accountno",rs.getString( 28 ));
                context.put("accountname",rs.getString( 29 ));
                context.put("othercard",rs.getString( 30 ));
                context.put("cardbank",rs.getString( 31 ));
                context.put("cardhold",rs.getString( 32 ));
                context.put("cardlimit",rs.getString( 33 ));
                context.put("regdate",rs.getDate( 34 ).toString());
            }
            stack.push( context );
            con1.close();
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return SUCCESS;
    }

    public String internalback()
    {
        return INTERNALBACK;
    }
}
