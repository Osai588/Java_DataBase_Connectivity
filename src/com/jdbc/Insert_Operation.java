package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert_Operation {

	public static void main(String[] args) {

		final String url = "jdbc:mysql://localhost:3306/University";
		final String username = "root";
		final String password = "123456";

		String Query = "insert into student values(?,?,?,?)";

		try (Connection conn = DriverManager.getConnection(url, username, password);

				PreparedStatement ps = conn.prepareStatement(Query);

		)

		{
			Scanner sc = new Scanner(System.in);

			System.out.println("enter id : ");
			int id = Integer.parseInt(sc.nextLine());

			System.out.println("enter name : ");
			String name = sc.nextLine();

			System.out.println("enter age : ");
			int age = Integer.parseInt(sc.nextLine());

			System.out.println("enter marks : ");
			int marks = Integer.parseInt(sc.nextLine());

			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setInt(4, marks);

			int row = ps.executeUpdate();
			
			System.out.println(row);
			
			sc.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
