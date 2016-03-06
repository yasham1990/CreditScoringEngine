package hibernatemapping;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * @author yasham
 *
 */
@Entity
@Table(name = "employee")
public class Employee {

    @Id
	@GeneratedValue
	@JoinColumn(name = "primarykey", referencedColumnName = "primarykey", insertable = false, updatable = false)
	private int primarykey;
	@Column(name = "e_id")
	private String employeeId;
	@Column(name = "e_pass")
	private String employeePass;
	@Column(name = "e_name")
	private String name;
	@Column(name = "e_phone")
	private String phone;
	@Column(name = "e_salary")
	private String salary;
	@Column(name = "e_address")
	private String address;
    @Column(name = "e_dob")
    private Date dob;
	@Column(name = "e_email")
	private String email;
	@Column(name = "e_gen")
	private String gender;
	@Column(name = "e_doj")
	private Date doj;
	@Column(name = "e_type")
	private String type;
    public int getPrimarykey()
    {
        return primarykey;
    }
    public void setPrimarykey( int primarykey )
    {
        this.primarykey = primarykey;
    }
    public String getEmployeeId()
    {
        return employeeId;
    }
    public void setEmployeeId( String employeeId )
    {
        this.employeeId = employeeId;
    }
    public String getEmployeePass()
    {
        return employeePass;
    }
    public void setEmployeePass( String employeePass )
    {
        this.employeePass = employeePass;
    }
    public String getName()
    {
        return name;
    }
    public void setName( String name )
    {
        this.name = name;
    }
    public String getPhone()
    {
        return phone;
    }
    public void setPhone( String phone )
    {
        this.phone = phone;
    }
    public String getSalary()
    {
        return salary;
    }
    public void setSalary( String salary )
    {
        this.salary = salary;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress( String address )
    {
        this.address = address;
    }
    public Date getDob()
    {
        return dob;
    }
    public void setDob( Date dob )
    {
        this.dob = dob;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail( String email )
    {
        this.email = email;
    }
    public String getGender()
    {
        return gender;
    }
    public void setGender( String gender )
    {
        this.gender = gender;
    }
    public Date getDoj()
    {
        return doj;
    }
    public void setDoj( Date doj )
    {
        this.doj = doj;
    }
    public String getType()
    {
        return type;
    }
    public void setType( String type )
    {
        this.type = type;
    }

	
}