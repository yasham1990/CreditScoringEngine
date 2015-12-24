/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author yasham
 */
public class Back extends ActionSupport {
    
    public Back() {
    }
       final static private String REGISBACK="regisback";
        final static private String REGISBACK1="regisback1";
final static private String APPBACKFAIL="appbackfail";
    final static private String OFFBACK="offback";
    public String execute()  {
        return SUCCESS;
    }
      public String offBack(){
        return OFFBACK;
    }
         
    
    public String appbackfail(){
        return APPBACKFAIL;
    }
    public String regisback(){
    return REGISBACK;
}
    public String regisback1(){
    return REGISBACK1;
}
}
