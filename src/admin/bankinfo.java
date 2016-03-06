
package admin;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import Home.EmployeeManagement;
import hibernatemapping.Bankinfo;

public class bankinfo
    extends ActionSupport
{

    EmployeeManagement employeeManagement = null;

    static Logger log = Logger.getLogger( bankinfo.class );

    public bankinfo()
    {
    }

    final static private String BANKINFOBACK = "bankinfoback";

    public String bankinfoback()
    {
        return BANKINFOBACK;
    }

    public String execute()
        throws Exception
    {
        employeeManagement = new EmployeeManagement();
        try
        {
            ValueStack stack = ActionContext.getContext().getValueStack();
            Map<String, Object> context = new HashMap<String, Object>();
            Bankinfo bankinfo = employeeManagement.getBankInfo();
            if ( bankinfo != null )
            {
                context.put( "totalcards", bankinfo.getTotalcards() );
                context.put( "employee", bankinfo.getNumberofemployee() );
                context.put( "dos", bankinfo.getDateofstart() );
            }
            stack.push( context );
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return SUCCESS;
    }

}
