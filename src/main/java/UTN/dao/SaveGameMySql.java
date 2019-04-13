package UTN.dao;

import UTN.model.Human;

import java.sql.*;

public class SaveGameMySql {


    private Connection con;
    private Statement st;

    private static SaveGameMySql ourInstance = new SaveGameMySql();

    public static SaveGameMySql getInstance() {
        return ourInstance;
    }

    private SaveGameMySql() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
            st = con.createStatement();
            st.execute("CREATE DATABASE IF NOT EXISTS save;");
            st.execute(""
                    + "CREATE TABLE IF NOT EXISTS winners ("
                    + " id int auto_increment,"
                    + " winner_name varchar(60),"
                    + " beer_quantity int not null,"
                    + " primary key(id)"
                    + ");");
            con.close();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/save", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void saveWinner(Human human,int quantityBeer)  {
        try {
            String sql = ("INSERT INTO winners(winner_name,beer_quantity) VALUES(?,?)");
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, human.getName());
            st.setInt(2, quantityBeer);
            st.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
