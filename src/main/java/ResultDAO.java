package main.java;
import java.sql.*;

/**
 * Created by admin on 20.01.2017.
 */
public class ResultDAO {
    private Connection connection;
    private String result;
    private String urlDB;
    private String login;
    private String pass;

    public void putResult(String result) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO history (volume) values(?)");
            preparedStatement.setString(1, result);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            this.result = e.getMessage();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                this.result = e.getMessage();
            }
        }
    }

    public String getResults() {
        Statement statement = null;
        String firstPartOfAnswer = "<table><thead><tr><th>История операций</th></tr></thead><tbody>";
        String endPartOfAnswer = "</tbody></table>";
        this.result = firstPartOfAnswer;
        try {
            statement = connection.createStatement();
            ResultSet resultDB = statement.executeQuery("SELECT * FROM history");
            while (resultDB.next()) {
                this.result += "<tr><td>" + resultDB.getString("volume") + "</tr></td>";
            }
            resultDB.close();
            this.result += endPartOfAnswer;
        } catch (SQLException e) {
            this.result = e.getMessage();
        } catch (NullPointerException e) {
            this.result = e.getMessage();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                this.result = e.getMessage();
            }
        }
        return this.result;
    }

    public ResultDAO(String urlDB, String login, String pass) {
        this.urlDB = urlDB;
        this.login = login;
        this.pass = pass;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(urlDB,login,pass);
        } catch (ClassNotFoundException e) {
            this.result = "Драйвер JDBC не найден";
        } catch (SQLException e) {
            this.result = "Проблемы с доступом к серверу";
        }
    }

}
