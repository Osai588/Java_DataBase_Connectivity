package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Delete_operation {

	public static void main(String[] args) {
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/University", "root", "123456");
				PreparedStatement ps = conn.prepareStatement("Delete from student where id = ?");
				Scanner sc = new Scanner(System.in);
		) {
			System.out.println("enter id you want to delete");
			int id = Integer.parseInt(sc.nextLine());
			ps.setInt(1, id);
			
			int rows=ps.executeUpdate();
			if(rows >0) {
			System.out.println(rows + "has been deleted");
			}
			else {
				System.out.println("now row found with the id " + id);
			}
				

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
