package engine;

import java.sql.*;
import java.util.UUID;

public class DBUtils {

    private static final String DB_URL = "jdbc:postgresql://XXX.XXX.XXX.XXX:XXXX/";
    private static final String USER = "";
    private static final String PASS = "";
    private static Connection connection;


    public DBUtils() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("---> JDBC PostgreSQL driver is not found.");
            e.printStackTrace();
            return;
        }
    }

    public void connectToBD() {

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("---> JDBC connection failed");
            e.printStackTrace();
        }

        if (connection != null) {
            System.out.println("You has been connected");
        } else {
            System.out.println("Failed to make connection");
        }

    }

    public static Connection getConnection() {
        return connection;
    }

    public void createUserMock(String phoneNumber, String userId, String lastName) {
//        connectToBD();
        String userData = "{\"client\":{\"id\":\"" + userId + "\",\"primaryRecordId\":\"001\",\"lastName\":\"" + lastName + "\",\"firstName\":\"Иван\",\"middleName\":\"Иванович\",\"birthDate\":\"01.01.2000\",\"intermediaryCode\":\"example\",\"intermediaryChannelCode\":\"example\",\"acquiredAt\":\"2021-02-20T02:20:02.222Z\",\"phone\":\"+70000000000\",\"phoneConfirmed\":true,\"email\":\"abc@mail.com\",\"status\":\"PROSPECT\",\"isActive\":true,\"requestSourceCode\":\"MOBILE_BACKEND\",\"actualVersionId\":\"0.0.1\"},\"consents\":[{\"id\":\"001\",\"clientId\":\"001\",\"businessObjectId\":\"001\",\"consentType\":\"0123456789012345678901234567890123456789\",\"hash\":\"001\",\"approvedAt\":\"01.01.2000\",\"approvingSystem\":\"MOBILE_BACKEND\"}]}";
        String sqlCommandMockTableFind = "INSERT INTO tyumen-proxy-mock.mock (method, type, key, data, code) VALUES ('find-by-phone', 'preload' ,'" + phoneNumber + "', '{}', 200)";
        String sqlCommandMockTableCreate = "INSERT INTO tyumen-proxy-mock.mock (method, type, key, data, code) VALUES ('create', 'preload' ,'" + phoneNumber + "', '" + userData + "', 200)";

        String sqlCommandUserTable = "UPDATE tyumen-api-gateway.user SET client_core_id = '" + userId + "' WHERE user.phone_number = '" + phoneNumber + "'";

        System.out.println("EXECUTE to " + DB_URL + "---------->");
        System.out.println(sqlCommandMockTableFind);
        System.out.println("");
        System.out.println(sqlCommandMockTableCreate);
        System.out.println("<----------");

//        try {
//            PreparedStatement preparedStatementFind = connection.prepareStatement(sqlCommandMockTableFind);
//            PreparedStatement preparedStatementCreate = connection.prepareStatement(sqlCommandMockTableCreate);
//            Statement updateUser = connection.createStatement();
//            preparedStatementFind.executeUpdate();
//            preparedStatementCreate.executeUpdate();
//            updateUser.executeUpdate(sqlCommandUserTable);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        try {
//            getConnection().close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }

    public void createVoidUser(String phoneNumber) {
//        connectToBD();
        String sqlCommandMockTableFind = "INSERT INTO tyumen-proxy-mock.mock (method, type, key, data, code) VALUES ('find-by-phone', 'preload' ,'" + phoneNumber + "', '{}', 200)";

        System.out.println("EXECUTE to " + DB_URL + "---------->");
        System.out.println(sqlCommandMockTableFind);
        System.out.println("<----------");

//        try {
//            PreparedStatement preparedStatementFind = connection.prepareStatement(sqlCommandMockTableFind);
//            preparedStatementFind.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        try {
//            getConnection().close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }


}
