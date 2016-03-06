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
@Table(name = "bankinfo")
public class Bankinfo {

    @Id
    @GeneratedValue
    @JoinColumn(name = "primarykey", referencedColumnName = "primarykey", insertable = false, updatable = false)
    private int primarykey;
    @Column(name = "totalcards")
    private String totalcards;
    @Column(name = "employee")
    private String numberofemployee;
    @Column(name = "dos")
    private Date dateofstart;
    public int getPrimarykey()
    {
        return primarykey;
    }
    public void setPrimarykey( int primarykey )
    {
        this.primarykey = primarykey;
    }
    public String getTotalcards()
    {
        return totalcards;
    }
    public void setTotalcards( String totalcards )
    {
        this.totalcards = totalcards;
    }
    public String getNumberofemployee()
    {
        return numberofemployee;
    }
    public void setNumberofemployee( String numberofemployee )
    {
        this.numberofemployee = numberofemployee;
    }
    public Date getDateofstart()
    {
        return dateofstart;
    }
    public void setDateofstart( Date dateofstart )
    {
        this.dateofstart = dateofstart;
    }
    
}