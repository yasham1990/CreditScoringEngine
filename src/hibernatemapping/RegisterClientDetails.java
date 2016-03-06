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
@Table(name = "register1" )
public class RegisterClientDetails
{

    @Id
    @GeneratedValue
    @JoinColumn(name = "primarykey", referencedColumnName = "primarykey", insertable = false, updatable = false )
    private int primarykey;

    @Column(name = "salutation" )
    private String salutaion;

    @Column(name = "birth" )
    private Date birth;

    @Column(name = "m_status" )
    private String m_status;

    @Column(name = "sex" )
    private String sex;

    @Column(name = "pan" )
    private String pan;

    @Column(name = "annual" )
    private String annualsalary;
    
    @Column(name = "monthly" )
    private String monthlysalary;
    
    @Column(name = "card_type" )
    private String card_type;

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

    public String getSalutaion()
    {
        return salutaion;
    }

    public void setSalutaion( String salutaion )
    {
        this.salutaion = salutaion;
    }

    public Date getBirth()
    {
        return birth;
    }

    public void setBirth( Date birth )
    {
        this.birth = birth;
    }

    public String getM_status()
    {
        return m_status;
    }

    public void setM_status( String m_status )
    {
        this.m_status = m_status;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex( String sex )
    {
        this.sex = sex;
    }

    public String getPan()
    {
        return pan;
    }

    public void setPan( String pan )
    {
        this.pan = pan;
    }

    public String getAnnualsalary()
    {
        return annualsalary;
    }

    public void setAnnualsalary( String annualsalary )
    {
        this.annualsalary = annualsalary;
    }

    public String getMonthlysalary()
    {
        return monthlysalary;
    }

    public void setMonthlysalary( String monthlysalary )
    {
        this.monthlysalary = monthlysalary;
    }

    public String getCard_type()
    {
        return card_type;
    }

    public void setCard_type( String card_type )
    {
        this.card_type = card_type;
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