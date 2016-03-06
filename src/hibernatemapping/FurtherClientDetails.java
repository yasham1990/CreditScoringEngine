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
@Table(name = "furdetails" )
public class FurtherClientDetails
{

    @Id
    @GeneratedValue
    @JoinColumn(name = "primarykey", referencedColumnName = "primarykey", insertable = false, updatable = false )
    private int primarykey;

    @Column(name = "name_appear" )
    private String name_appear;

    @Column(name = "salary_acc" )
    private String salary_acc;

    @Column(name = "bank_name" )
    private String bank_name;

    @Column(name = "acc_no" )
    private String acc_no;

    @Column(name = "acc_name" )
    private String acc_name;

    @Column(name = "bank" )
    private String bank;
    
    @Column(name = "card_holder" )
    private String card_holder;
    
    @Column(name = "card_limit" )
    private String card_limit;
    
    @Column(name = "reg_date" )
    private Date reg_date;
    
    @Column(name = "other_card" )
    private String other_card;
    
    @Column(name = "appstatus" )
    private String appstatus;

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

    public String getName_appear()
    {
        return name_appear;
    }

    public void setName_appear( String name_appear )
    {
        this.name_appear = name_appear;
    }

    public String getSalary_acc()
    {
        return salary_acc;
    }

    public void setSalary_acc( String salary_acc )
    {
        this.salary_acc = salary_acc;
    }

    public String getBank_name()
    {
        return bank_name;
    }

    public void setBank_name( String bank_name )
    {
        this.bank_name = bank_name;
    }

    public String getAcc_no()
    {
        return acc_no;
    }

    public void setAcc_no( String acc_no )
    {
        this.acc_no = acc_no;
    }

    public String getAcc_name()
    {
        return acc_name;
    }

    public void setAcc_name( String acc_name )
    {
        this.acc_name = acc_name;
    }

    public String getBank()
    {
        return bank;
    }

    public void setBank( String bank )
    {
        this.bank = bank;
    }

    public String getCard_holder()
    {
        return card_holder;
    }

    public void setCard_holder( String card_holder )
    {
        this.card_holder = card_holder;
    }
    
    public String getCard_limit()
    {
        return card_limit;
    }

    public void setCard_limit( String card_limit )
    {
        this.card_limit = card_limit;
    }

    public Date getReg_date()
    {
        return reg_date;
    }

    public void setReg_date( Date reg_date )
    {
        this.reg_date = reg_date;
    }

    public String getOther_card()
    {
        return other_card;
    }

    public void setOther_card( String other_card )
    {
        this.other_card = other_card;
    }

    public String getAppstatus()
    {
        return appstatus;
    }

    public void setAppstatus( String appstatus )
    {
        this.appstatus = appstatus;
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