/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import com.opensymphony.xwork2.ActionSupport;

import Utility.ScoringUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author saurabh
 */
public class Appstatus extends ActionSupport {
	private String appid;
	private String status;
	final static private String FAILURE = "failure";
	ScoringUtility utility = null;
	Connection con1 = null;
	PreparedStatement ps = null;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public Appstatus() {
	}

	public String execute() throws Exception {
		utility = new ScoringUtility();
		try {
			con1 = utility.openDatabaseConnection();
			String str = "SELECT app_no,appstatus FROM  furdetails";
			Statement stmt = con1.createStatement();
			ResultSet rs = stmt.executeQuery(str);
			while (rs.next()) {
				if (appid.equals(rs.getString(1)))
					status = rs.getString(2);
				if (rs.wasNull())
					return FAILURE;
			}
			con1.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return SUCCESS;
	}

	public void validate() {
		if (appid.length() == 0)
			addFieldError("appid", "Please enter app id!");
		else if (appid.length() != 0) {
			int flag = 0;
			try {
				utility = new ScoringUtility();
				con1 = utility.openDatabaseConnection();
				String str = "SELECT * FROM  furdetails";
				Statement stmt = con1.createStatement();
				ResultSet rs = stmt.executeQuery(str);

				while (rs.next()) {
					if (appid.equals(rs.getString(1)))
						flag = 1;
				}
				if (flag == 0)
					addFieldError("appid", "Invalid application id");
				con1.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
