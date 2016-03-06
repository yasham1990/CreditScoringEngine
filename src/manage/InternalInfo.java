/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import Home.EmployeeManagement;
import Utility.HibernateUtil;

public class InternalInfo
    extends ActionSupport implements SessionAware
{
    static Logger log = Logger.getLogger( InternalInfo.class );

    private SessionMap<String, Object> sessionMap;
    EmployeeManagement employeeManagement = null;

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
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, String> context = new HashMap<String, String>();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            String sql =
                "select c_firstname,c_lastname,birth,m_status,sex,pan,c_phone,c_email,annual,monthly,door_no,street,landmark,"
                + "nationality,city,state,zip,resi_no,profession,e_name,e_id,doj,e_address,office_no,e.email as eemail,"
                + "salary_acc,bank_name,acc_no,acc_name,other_card,bank,card_holder,card_limit,reg_date from clients,register1 r,"
                + "cdetails c,edetails e,furdetails f where clients.applicationid_primarykey=r.applicationid_primarykey and "
                + "r.applicationid_primarykey=c.applicationid_primarykey and "
                + "r.applicationid_primarykey=e.applicationid_primarykey and "
                + "r.applicationid_primarykey=f.applicationid_primarykey and r.applicationid_primarykey='" + sessionMap.get( "primarykey_app" ) + "'";
            SQLQuery query = session.createSQLQuery(sql);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            Object object = query.uniqueResult();
            if ( object != null  )
            {
                Map row = (Map)object;
                context.put("fname",(String)row.get("c_firstname") );
                context.put("lname",(String)row.get("c_lastname"));
                //context.put("birth",(String)row.get("birth"));
                context.put("m_status",(String)row.get("m_status"));
                context.put("sex",(String)row.get("sex"));
                context.put("pan",(String)row.get("pan"));
                context.put("mobile",(String)row.get("c_phone"));
                context.put("email",(String)row.get("c_email"));
                context.put("annual",(String)row.get("annual"));
                context.put("monthly",(String)row.get("monthly"));
                context.put("door",(String)row.get("door_no"));
                context.put("street",(String)row.get("street"));
                context.put("landmark",(String)row.get("landmark"));
                context.put("nationality",(String)row.get("nationality"));
                context.put("city",(String)row.get("city"));
                context.put("state",(String)row.get("state"));
                context.put("zip",(String)row.get("zip"));
                context.put("resino",(String)row.get("resi_no"));
                context.put("profession",(String)row.get("profession"));
                context.put("ename",(String)row.get("e_name"));
                context.put("eid",(String)row.get("e_id"));
                //context.put("join",((Date)row.get("doj"))+"");
                context.put("comaddress",(String)row.get("e_address"));
                context.put("officeno",(String)row.get("office_no"));
                context.put("officeemail",(String)row.get("eemail"));
                context.put("salaccount",(String)row.get("salary_acc"));
                context.put("salbankname",(String)row.get("bank_name"));
                context.put("accountno",(String)row.get("acc_no"));
                context.put("accountname",(String)row.get("acc_name"));
                context.put("othercard",(String)row.get("other_card"));
                context.put("cardbank",(String)row.get("bank"));
                context.put("cardhold",(String)row.get("card_holder"));
                context.put("cardlimit",(String)row.get("card_limit"));
               // context.put("regdate",(Date)row.get("reg_date")+"");
            }
            stack.push( context );
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
