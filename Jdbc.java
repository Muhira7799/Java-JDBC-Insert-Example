import java.sql.*;
class Jdbc {
public static void main(String[] args) throws Exception {

    final String url = "jdbc:mysql://localhost:3306/unilak";
    final String username = "root";
    final String password = "";

    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(url, username, password);

    Statement st = con.createStatement();

    String insertQuery =
            "INSERT INTO students(id, name, district, country) " + "VALUES (20, 'Mnique', 'Rwamagana', 'Rwanda')";

    int rows = st.executeUpdate(insertQuery);

    System.out.println(rows + " row inserted");

    con.close();
}
}