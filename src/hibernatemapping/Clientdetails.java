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
 *
 */
@Entity
@Table(name = "cdetails")
public class Clientdetails {

    @Id
    @GeneratedValue
    @JoinColumn(name = "primarykey", referencedColumnName = "primarykey", insertable = false, updatable = false)
    private int primarykey;
    @Column(name = "door_no")
    private String doorno;
    @Column(name = "street")
    private String street;
    @Column(name = "landmark")
    private String landmark;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "zip")
    private String zip;
    @Column(name = "resi_no")
    private String resino;
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
    public String getDoorno()
    {
        return doorno;
    }
    public void setDoorno( String doorno )
    {
        this.doorno = doorno;
    }
    public String getStreet()
    {
        return street;
    }
    public void setStreet( String street )
    {
        this.street = street;
    }
    public String getLandmark()
    {
        return landmark;
    }
    public void setLandmark( String landmark )
    {
        this.landmark = landmark;
    }
    public String getNationality()
    {
        return nationality;
    }
    public void setNationality( String nationality )
    {
        this.nationality = nationality;
    }
    
    public String getCountry()
    {
        return country;
    }
    public void setCountry( String country )
    {
        this.country = country;
    }
    public String getCity()
    {
        return city;
    }
    public void setCity( String city )
    {
        this.city = city;
    }
    public String getState()
    {
        return state;
    }
    public void setState( String state )
    {
        this.state = state;
    }
    public String getZip()
    {
        return zip;
    }
    public void setZip( String zip )
    {
        this.zip = zip;
    }
    public String getResino()
    {
        return resino;
    }
    public void setResino( String resino )
    {
        this.resino = resino;
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