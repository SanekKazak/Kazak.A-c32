package org.build_patterns.singltone;

public class DataBasePersistance {
    public static DataBasePersistance connection;
    public DataBasePersistance(){
        if(connection==null){
            connection = new DataBasePersistance();
        }
    }

    public static void setConnection(DataBasePersistance connection) {
        DataBasePersistance.connection = connection;
    }

    public static DataBasePersistance getConnection() {
        if(connection != null){
            return connection;
        }else{
            return new DataBasePersistance();
        }
    }

}
