package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insert_Operation {

	public static void main(String[] args) {

		final String url = "jdbc:mysql://localhost:3306/University";
		final String name = "root";
		final String password = "123456";

		String Query = "insert into student values(102,'ram',20,70)";

		try {
			Connection conn = DriverManager.getConnection(url, name, password);

			Statement st = conn.createStatement();

			int rows = st.executeUpdate(Query);

			System.out.println(rows + "\t row of data Inserted");
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
