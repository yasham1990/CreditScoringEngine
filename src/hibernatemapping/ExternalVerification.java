package hibernatemapping;

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
@Table(name = "extverify1" )
public class ExternalVerification
{

    @Id
    @GeneratedValue
    @JoinColumn(name = "primarykey", referencedColumnName = "primarykey", insertable = false, updatable = false )
    private int primarykey;

    @Column(name = "ex_fname" )
    private String ex_fname;

    @Column(name = "ex_lname" )
    private String ex_lname;

    @Column(name = "ex_email" )
    private String ex_email;

    @Column(name = "ex_address" )
    private String ex_address;

    @Column(name = "ex_mobile" )
    private String ex_mobile;

    @Column(name = "ex_member" )
    private String ex_member;
    
    @Column(name = "ex_area" )
    private String ex_area;
    
    @Column(name = "ex_hloan" )
    private String ex_hloan;
    
    @Column(name = "ex_hpaid" )
    private String ex_hpaid;
    
    @Column(name = "ex_billpay" )
    private String ex_billpay;
    
    @Column(name = "ex_cars" )
    private String ex_cars;
    
    @Column(name = "ex_cloan" )
    private String ex_cloan;
    
    @Column(name = "ex_cpaid" )
    private String ex_cpaid;
    
    @Column(name = "ex_income" )
    private String ex_income;
    
    @Column(name = "ex_nfd" )
    private String ex_nfd;
    
    @Column(name = "ex_fdamount" )
    private String ex_famount;
    
    @Column(name = "ex_agland" )
    private String ex_agland;
    
    @Column(name = "ex_lic" )
    private String ex_lic;
    
    @Column(name = "ex_default" )
    private String ex_default;
    
    @Column(name = "ex_tax" )
    private String ex_tax;
    
    @Column(name = "ex_crime" )
    private String ex_crime;
    
    @Column(name = "ex_otherinc" )
    private String ex_otherinc;
    
    @Column(name = "ex_otherbank" )
    private String ex_otherbank;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "applicationid_primarykey")
    private Applicationid applicationPrimaryKey;

    public int getPrimarykey()
    {
        return primarykey;
    }

    public void setPrimarykey( int primarykey )
    {
        this.primarykey = primarykey;
    }

    public String getEx_fname()
    {
        return ex_fname;
    }

    public void setEx_fname( String ex_fname )
    {
        this.ex_fname = ex_fname;
    }

    public String getEx_lname()
    {
        return ex_lname;
    }

    public void setEx_lname( String ex_lname )
    {
        this.ex_lname = ex_lname;
    }

    public String getEx_email()
    {
        return ex_email;
    }

    public void setEx_email( String ex_email )
    {
        this.ex_email = ex_email;
    }

    public String getEx_address()
    {
        return ex_address;
    }

    public void setEx_address( String ex_address )
    {
        this.ex_address = ex_address;
    }

    public String getEx_mobile()
    {
        return ex_mobile;
    }

    public void setEx_mobile( String ex_mobile )
    {
        this.ex_mobile = ex_mobile;
    }

    public String getEx_member()
    {
        return ex_member;
    }

    public void setEx_member( String ex_member )
    {
        this.ex_member = ex_member;
    }

    public String getEx_area()
    {
        return ex_area;
    }

    public void setEx_area( String ex_area )
    {
        this.ex_area = ex_area;
    }

    public String getEx_hloan()
    {
        return ex_hloan;
    }

    public void setEx_hloan( String ex_hloan )
    {
        this.ex_hloan = ex_hloan;
    }

    public String getEx_hpaid()
    {
        return ex_hpaid;
    }

    public void setEx_hpaid( String ex_hpaid )
    {
        this.ex_hpaid = ex_hpaid;
    }

    public String getEx_billpay()
    {
        return ex_billpay;
    }

    public void setEx_billpay( String ex_billpay )
    {
        this.ex_billpay = ex_billpay;
    }

    public String getEx_cars()
    {
        return ex_cars;
    }

    public void setEx_cars( String ex_cars )
    {
        this.ex_cars = ex_cars;
    }

    public String getEx_cloan()
    {
        return ex_cloan;
    }

    public void setEx_cloan( String ex_cloan )
    {
        this.ex_cloan = ex_cloan;
    }

    public String getEx_cpaid()
    {
        return ex_cpaid;
    }

    public void setEx_cpaid( String ex_cpaid )
    {
        this.ex_cpaid = ex_cpaid;
    }

    public String getEx_income()
    {
        return ex_income;
    }

    public void setEx_income( String ex_income )
    {
        this.ex_income = ex_income;
    }

    public String getEx_nfd()
    {
        return ex_nfd;
    }

    public void setEx_nfd( String ex_nfd )
    {
        this.ex_nfd = ex_nfd;
    }

    public String getEx_famount()
    {
        return ex_famount;
    }

    public void setEx_famount( String ex_famount )
    {
        this.ex_famount = ex_famount;
    }

    public String getEx_agland()
    {
        return ex_agland;
    }

    public void setEx_agland( String ex_agland )
    {
        this.ex_agland = ex_agland;
    }

    public String getEx_lic()
    {
        return ex_lic;
    }

    public void setEx_lic( String ex_lic )
    {
        this.ex_lic = ex_lic;
    }

    public String getEx_default()
    {
        return ex_default;
    }

    public void setEx_default( String ex_default )
    {
        this.ex_default = ex_default;
    }

    public String getEx_tax()
    {
        return ex_tax;
    }

    public void setEx_tax( String ex_tax )
    {
        this.ex_tax = ex_tax;
    }

    public String getEx_crime()
    {
        return ex_crime;
    }

    public void setEx_crime( String ex_crime )
    {
        this.ex_crime = ex_crime;
    }

    public String getEx_otherinc()
    {
        return ex_otherinc;
    }

    public void setEx_otherinc( String ex_otherinc )
    {
        this.ex_otherinc = ex_otherinc;
    }

    public String getEx_otherbank()
    {
        return ex_otherbank;
    }

    public void setEx_otherbank( String ex_otherbank )
    {
        this.ex_otherbank = ex_otherbank;
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