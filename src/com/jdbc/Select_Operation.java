package com.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class Select_Operation {

	public static void main(String[] args) {

		try (
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/University", "root", "123456");

				Statement st = con.createStatement();

				// ResultSet rs = st.executeQuery("Select * from student where id=101"); for
				// single user and static value

				ResultSet rs = st.executeQuery("Select * from student");
			)//try with resources
		
		{
			while (rs.next()) {

				int id = rs.getInt(1);
				System.out.println("id : " + id);

				String name = rs.getString(2);
				System.out.println("name :" + name);

				int age = rs.getInt(3);
				System.out.println("age : " + age);

				int marks = rs.getInt(4);
				System.out.println("marks : " + marks);

				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
