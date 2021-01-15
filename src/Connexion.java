import java.sql.*;

public class Connexion {

    private final String address;
    private final String username;
    private final String password;
    private boolean connected;
    private Connection connection;
    private Statement statement;

    public Connexion ( String address, String username, String password ) {
        this.connected = false;
        this.address = address;
        this.username = username;
        this.password = password;
        this.connection = null;
    }

    /*
    ____________________________
        CONNECTION & ERREURS
    ____________________________
    */

    public boolean connect () {

        System.out.println("-------- Oracle JDBC Connection Testing ------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            this.connected = false;
            System.err.println("Could not find the Oracle JDBC Driver");
            e.printStackTrace();
            return false;

        }

        System.out.println("Oracle JDBC Driver Registered!");

        try {

            connection = DriverManager.getConnection(address, username, password);
            statement = connection.createStatement();

        } catch (SQLException e) {

            this.connected = false;
            System.err.println("Connection Failed!");
            e.printStackTrace();
            return false;

        }

        if (connection != null) {

            this.connected = true;
            System.out.println("Connection successfully established!");
            return true;

        } else {

            this.connected = false;
            System.err.println("Connection Failed!");
            return false;

        }
    }

    public ResultSet executeQuery ( String query ) {

        try {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Could not execute query : " + query);
            e.printStackTrace();
            return null;
        }
    }

    public int executeUpdate ( String query ) {

        try {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println("Could not execute update : " + query);
            e.printStackTrace();
            return 0;
        }
    }

    /*
    ____________________________
        GETTERS & SETTERS
    ____________________________
    */

    public boolean isConnected () {
        return connected;
    }

    public void setConnected ( boolean connected ) {
        this.connected = connected;
    }

    public String getAddress () {
        return address;
    }

    public String getUsername () {
        return username;
    }

    public String getPassword () {
        return password;
    }

    /*
    ____________________________
        REQUESTS SQL
    ____________________________
    */


}
