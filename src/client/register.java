
package client;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import Home.EmployeeManagement;
import hibernatemapping.Applicationid;

public class register
    extends ActionSupport
    implements SessionAware
{
    
    EmployeeManagement employeeManagement = null;
    
    static Logger log=Logger.getLogger( register.class );

    private RegisterBean registerBean;

    private SessionMap<String, Object> sessionMap;
    
    final static private String REGISBACK = "regisback";

    public register()
    {

    }

    @Override
    public void setSession( Map<String, Object> sessionMap )
    {
        this.sessionMap = (SessionMap<String, Object>) sessionMap;
    }

    @Override
    public String execute() throws Exception
    {
        employeeManagement = new EmployeeManagement();
        try
        {
            Integer i = 1001, j = 0;
            String a;
            List<Applicationid> applicationids=employeeManagement.getApplicationidList("","");
            String appno = "A1001";
            if(applicationids!=null)
            {
                for ( Applicationid applicationid:applicationids )
                {
                    a = applicationid.getApp_no();
                    appno = a.substring( 1 );
                    j = Integer.parseInt( appno );
                    if ( i < j )
                    {
                        i = j;
                    }
                }
                i++;
                appno = "A" + i.toString();
            }

            //sessionMap.put( "card", registerBean.getCardtype() );
            sessionMap.put( "salu", registerBean.getSalu() );
            sessionMap.put( "dob", registerBean.getDob() );
            sessionMap.put( "city", registerBean.getCity() );
            sessionMap.put( "state", registerBean.getState() );
            sessionMap.put( "country", registerBean.getCountry() );
            sessionMap.put( "pan", registerBean.getPan() );
            sessionMap.put( "annualinc", registerBean.getAnnualinc() );
            sessionMap.put( "monthlyinc", registerBean.getMonthlyinc() );
            sessionMap.put( "door", registerBean.getDoor() );
            sessionMap.put( "street", registerBean.getStreet() );
            sessionMap.put( "lmark", registerBean.getLmark() );
            sessionMap.put( "zip", registerBean.getZip() );
            sessionMap.put( "resi", registerBean.getResi() );
            sessionMap.put( "status", registerBean.getStatus() );
            sessionMap.put( "sex", registerBean.getSex() );
            sessionMap.put( "appno", appno );
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return SUCCESS;
    }

    public String regisback()
    {
        return REGISBACK;
    }
    
    public RegisterBean getRegisterBean()
    {
        return registerBean;
    }

    public void setRegisterBean( RegisterBean registerBean )
    {
        this.registerBean = registerBean;
    }

    @Override
    public void validate()
    {
        try
        {
            Long i, j;
            String annualinc = registerBean.getAnnualinc();
            String monthlyinc = registerBean.getMonthlyinc();
            if ( annualinc.length() == 0 )
            {

                addFieldError( "annualinc", "Annual Income Required" );
            }
            if ( monthlyinc.length() == 0 )
            {
                addFieldError( "monthlyinc", "Monthly Income Required" );
            }
            else if ( !annualinc.matches( "^[0-9_-]{1,30}$" ) )
            {
                addFieldError( "annualinc", "Annual Income accepted in numbers only" );
            }
            else if ( !monthlyinc.matches( "^[0-9_-]{1,30}$" ) )
            {
                addFieldError( "monthlyinc", "Monthly Income accepted in numbers only" );
            }
            else
            {
                i = Long.valueOf( annualinc );
                j = Long.valueOf( monthlyinc );
                if ( ( i / 12 ) != j )
                    addFieldError( "monthlyinc", "invalid" );
            }
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }

    }

}
