package jdbc;

import java.sql.*;

public class Main {

    public static final String DB_URL = "jdbc:postgresql://localhost:5432/jdbc";
    public static final String USER = "postgres";
    public static final String PASWORD = "12345";
    public static final String QUERY_ONE = "select * from one order by id asc ";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASWORD);
           // String query = "insert into one(firstname,lastname) values (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ONE);
           // String name="neda";
          //  String family="yasi";
           // preparedStatement.setString(1,name);
           // preparedStatement.setString(2,family);
          //  preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print(resultSet.getInt(1));
                System.out.print(":");
                System.out.print(resultSet.getString(2));
                System.out.print("  ");
                System.out.println(resultSet.getString(3));

            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
