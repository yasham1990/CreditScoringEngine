/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Map;


public class ManagerView extends ActionSupport {
    final static private String MANAGEVIEWBACK="manageviewback"; 
    private String id;
private String name;
private String gen;
private String address;
private String phone;
private String email;
private String salary;
private Date dob;
private Date doj;
private String namedis;

    public String getNamedis() {
        return namedis;
    }

    public void setNamedis(String namedis) {
        this.namedis = namedis;
    }

    
final static private String VIEW="view";

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

   


    public ManagerView() {
    }
    
    public String execute() throws Exception {
         Map session = ActionContext.getContext().getSession();
       
        id=(String)session.get("userName");
         try{ Class.forName("oracle.jdbc.driver.OracleDriver");
                           /*Establish a connection with a data source*/
                           Connection con1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","yash", "yash");
                           String str="SELECT * FROM  manager";
	       		   java.sql.Statement stmt=con1.createStatement();
                           ResultSet rs=stmt.executeQuery(str);
                         
            while( rs.next())
            {
             if(id.equals(rs.getString(1)))
             {
               name=rs.getString(3);
               gen=rs.getString(9);
               address=rs.getString(4);
              
               phone=rs.getString(5);
               email=rs.getString(6);
               salary=rs.getString(7);
               dob=rs.getDate(8);
               doj=rs.getDate(10);
             }
            }
            con1.close();
         }
            catch(Exception e)
            {
                
            }
        return VIEW; 
    }
    public String manageviewback()
    {
        Map session = ActionContext.getContext().getSession();
      namedis=(String)session.get("namedis");
       return MANAGEVIEWBACK; 
    }
    
}
