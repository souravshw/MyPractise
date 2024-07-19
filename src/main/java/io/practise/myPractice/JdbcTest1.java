package io.practise.myPractice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest1 {
	public static void main(String[] args) {

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingMall", "root", "tiger");
			Statement statement = conn.createStatement();
			ResultSet rs;
			String query;
			// query="desc products;";

			// rs=statement.executeQuery(query);

			// ResultSetMetaData rm = rs.getMetaData();
			/*
			 * int column = rm.getColumnCount(); for(int i= 1; i<= column; i++){
			 * String colName = rm.getColumnName(i);
			 * System.out.print(colName+"\t"); } System.out.println();
			 * DatabaseMetaData dbm = conn.getMetaData(); ResultSet rs1 =
			 * dbm.getColumns(null,"%","products","%"); while (rs1.next()){
			 * String col_name = rs1.getString("COLUMN_NAME"); String data_type
			 * = rs1.getString("TYPE_NAME"); int data_size =
			 * rs1.getInt("COLUMN_SIZE"); int nullable = rs1.getInt("NULLABLE");
			 * System.out.print(col_name+"\t"+data_type+"("+data_size+")"+"\t");
			 * if(nullable == 1){ System.out.print("YES\t"); } else{
			 * System.out.print("NO\t"); } System.out.println(); }
			 * while(rs.next()){ String show = rs.getString("products");
			 * System.out.println(show); }
			 */
			query = "Insert into products (productCode,name,quantity,price) "
					+ "values( \"F08\",\"Sony M\", 321,6777);";
			statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			query = "Select * from products;";
			rs = statement.executeQuery(query);
			while (rs.next()) {
				int productId = rs.getInt("productId");
				String productCode = rs.getString("productCode");
				String name = rs.getString(3);
				int quantity = rs.getInt(4);
				double price = rs.getDouble(5);
				System.out.println(productId + " " + productCode + " " + name + " " + quantity + " " + price);
			}
			conn.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
