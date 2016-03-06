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
@Table(name = "clients" )
public class Client
{

    @Id
    @GeneratedValue
    @JoinColumn(name = "primarykey", referencedColumnName = "primarykey", insertable = false, updatable = false )
    private int primarykey;

    @Column(name = "c_pass" )
    private String clientPass;

    @Column(name = "c_firstname" )
    private String firstname;

    @Column(name = "c_lastname" )
    private String lastname;

    @Column(name = "c_email" )
    private String email;

    @Column(name = "c_phone" )
    private String phone;

    @Column(name = "Applicationstatus" )
    private String applicationstatus;

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

    public String getClientPass()
    {
        return clientPass;
    }

    public void setClientPass( String clientPass )
    {
        this.clientPass = clientPass;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname( String firstname )
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname( String lastname )
    {
        this.lastname = lastname;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone( String phone )
    {
        this.phone = phone;
    }

    public String getApplicationstatus()
    {
        return applicationstatus;
    }

    public void setApplicationstatus( String applicationstatus )
    {
        this.applicationstatus = applicationstatus;
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