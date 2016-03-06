package hibernatemapping;

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
@Table(name = "applicationid")
public class Applicationid {

    @Id
	@GeneratedValue
	@JoinColumn(name = "primarykey", referencedColumnName = "primarykey", insertable = false, updatable = false)
	private int primarykey;
	@Column(name = "app_no")
	private String app_no;
	@Column(name = "status")
	private String status;
	@Column(name = "level")
	private String level;
	@Column(name = "score")
	private int score;
	public int getPrimarykey() {
		return primarykey;
	}
	public void setPrimarykey(int primarykey) {
		this.primarykey = primarykey;
	}
	public String getApp_no() {
		return app_no;
	}
	public void setApp_no(String app_no) {
		this.app_no = app_no;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

   
	
}