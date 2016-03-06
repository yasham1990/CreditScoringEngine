package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class ScoringUtility
{

    static Logger log = Logger.getLogger( ScoringUtility.class );

    public Connection openDatabaseConnection()
    {
        Connection con1 = null;
        try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
            /* Establish a connection with a data source */
            con1 = DriverManager.getConnection( "jdbc:mysql://cmpe.cgje8hjr4ff1.us-west-2.rds.amazonaws.com/creditscoringengine", "cmpe", "india123" );
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return con1;
    }

    /*
     * private void putVariableInSession(SessionMap<String, Object> sessionMap) { sessionMap.put( "namedis", namedis );
     * sessionMap.put( "id", id ); }
     */
    public String getNewId( String tableName, String columnName )
    {
        String id = "";
        try
        {
            int j = 0;
            Connection con1 = new ScoringUtility().openDatabaseConnection();
            String str = "select max(" + columnName + ") from " + tableName;
            Statement stmt = con1.createStatement();
            ResultSet rs = stmt.executeQuery( str );
            if ( rs.isBeforeFirst() == false )
                id = "10001";
            else if ( rs.next() )
                id = String.valueOf( Integer.parseInt( rs.getString( 1 ) )+1 );
            con1.close();
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
        }
        return id;
    }

    public static void main( String[] args )
    {
        try
        {
            Connection con1 = new ScoringUtility().openDatabaseConnection();
            String str1 = "Insert into register1 (app_no, salutation, fname) values(?,?,?)";
            PreparedStatement ps = con1.prepareStatement( str1 );
            ps.setString( 1, "123" );
            ps.setString( 2, "123" );
            ps.setString( 3, "123" );

            ps.executeUpdate();
            con1.close();
        }
        catch ( Exception e )
        {
            System.out.println( e.getMessage() );
        }
    }

}
