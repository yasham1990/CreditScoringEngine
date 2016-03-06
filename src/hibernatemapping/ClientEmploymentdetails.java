package hibernatemapping;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author yasham
 */
@Entity
@Table(name = "edetails" )
public class ClientEmploymentdetails
{

    @Id
    @GeneratedValue
    @JoinColumn(name = "primarykey", referencedColumnName = "primarykey", insertable = false, updatable = false )
    private int primarykey;

    @Column(name = "profession" )
    private String profession;

    @Column(name = "e_name" )
    private String employeeName;

    @Column(name = "e_id" )
    private String employeeCompanyId;

    @Column(name = "e_address" )
    private String address;

    @Column(name = "doj" )
    private Date dateOfJoining;

    @Column(name = "fax" )
    private String fax;

    @Column(name = "office_no" )
    private String officeno;

    @Column(name = "email" )
    private String companymail;

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "applicationid_primarykey" )
    private Applicationid applicationPrimaryKey;

    public int getPrimarykey()
    {
        return primarykey;
    }

    public void setPrimarykey( int primarykey )
    {
        this.primarykey = primarykey;
    }

    public String getProfession()
    {
        return profession;
    }

    public void setProfession( String profession )
    {
        this.profession = profession;
    }

    public String getEmployeeName()
    {
        return employeeName;
    }

    public void setEmployeeName( String employeeName )
    {
        this.employeeName = employeeName;
    }

    public String getEmployeeCompanyId()
    {
        return employeeCompanyId;
    }

    public void setEmployeeCompanyId( String employeeCompanyId )
    {
        this.employeeCompanyId = employeeCompanyId;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress( String address )
    {
        this.address = address;
    }

    public Date getDateOfJoining()
    {
        return dateOfJoining;
    }

    public void setDateOfJoining( Date dateOfJoining )
    {
        this.dateOfJoining = dateOfJoining;
    }

    public String getFax()
    {
        return fax;
    }

    public void setFax( String fax )
    {
        this.fax = fax;
    }

    public String getOfficeno()
    {
        return officeno;
    }

    public void setOfficeno( String officeno )
    {
        this.officeno = officeno;
    }

    public String getCompanymail()
    {
        return companymail;
    }

    public void setCompanymail( String companymail )
    {
        this.companymail = companymail;
    }

    public Applicationid getApplicationPrimaryKey()
    {
        return applicationPrimaryKey;
    }

    public void setApplicationPrimaryKey( Applicationid applicationPrimaryKey )
    {
        this.applicationPrimaryKey = applicationPrimaryKey;
    }
}