package emp;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class Logoutemp extends ActionSupport implements SessionAware {
    
    private SessionMap<String, Object> sessionMap;

    static Logger log=Logger.getLogger( Logoutemp.class );
    
    @Override
    public void setSession( Map<String, Object> sessionMap )
    {
        this.sessionMap = (SessionMap<String, Object>) sessionMap;
    }
    
    public Logoutemp() {
    }
    

    public String execute() throws Exception {
        sessionMap.invalidate();
        return SUCCESS;
    }
    
}
