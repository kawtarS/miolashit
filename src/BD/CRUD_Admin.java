
package BD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
public class CRUD_Admin {
    public static Connection getConnection() {
		Connection con=null;;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/db_project";
		con = DriverManager.getConnection(url,"root","");
                //JOptionPane.showMessageDialog(null,"connectionEstablised");
		}catch(ClassNotFoundException | SQLException e) {
			  JOptionPane.showMessageDialog(null,e);
		}
		return con;
	}
}
