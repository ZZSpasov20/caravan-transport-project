package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static Connection connectionInstance = null;

    public static Connection getInstance(){
        if(connectionInstance == null){
            try{
                String connectionURL = "jdbc:sqlserver://caravan-rental-server.database.windows.net:1433;database=CaravanRentalDatabase;user=caravan-rental-server-admin@caravan-rental-server;password=jAh2WmsGyD!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

                connectionInstance = DriverManager.getConnection(connectionURL);

                return connectionInstance;
            } catch(SQLException exception){
                throw new RuntimeException(exception);
            }
        }
        else{
            return connectionInstance;
        }
    }
}
