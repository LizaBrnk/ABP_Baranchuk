import java.sql.*;

public class DataConnect {
    String databaseURL;
    public DataConnect(String databaseURL) {
        this.databaseURL = databaseURL;
    }
    Object[][] getDatabase() {
        Object[][] data = new Object[getRows()][5];
        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            String sql = "SELECT * FROM Products";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            System.out.println("Connected");
            int i = 0;
            while (result.next()) {
                data[i][0] = result.getInt("ID");
                data[i][1] = result.getString("ProductName");
                data[i][2] = result.getString("Numbers");
                data[i][3] = result.getInt("Price");
                System.out.println(data[i][0] + ". " + data[i][1] + "   " + data[i][2] + "   " + data[i][3]);
                i++;
            }
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
    int getFreeID() {
        int id = 0;
        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            String sql = "SELECT * FROM Products";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                id = result.getInt("ID");
            }
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id + 1;
    }
    int getRows() {
        int i = 0;
        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            String sql = "SELECT * FROM Products";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                i++;
            }
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    void addNewInfo(String productName, String Number, int price) {
        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            String sql = "INSERT INTO Products (ProductName, Numbers, Price) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, productName);
            preparedStatement.setString(2, Number);
            preparedStatement.setString(3, String.valueOf(price));
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("A row has been inserted successfully.");
            }
            connection.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    void deleteInfo(int ID) {
        try (Connection connection = DriverManager.getConnection(databaseURL)) {
            String sql = "DELETE FROM Products where ID=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, String.valueOf(ID));
            pst.execute();
            System.out.println("Deleted");
            connection.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
