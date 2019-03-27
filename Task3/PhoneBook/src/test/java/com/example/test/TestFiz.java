package com.example.test;

import org.junit.Assert;
import org.junit.Test;

import com.example.Fiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

class TestFiz
{
	@Test
	public void fizAddToBd()
	{
		String user = "root";
		String password = "65roguri";
		String url = "jdbc:mysql://localhost:3306/phone_book";

		Fiz fiz = new Fiz("Sandra", "123", "123");

		try
		{
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

//			<get_count> before
			ResultSet rs = st.executeQuery("SELECT COUNT * FROM fiz");
			rs.last();
			int count_before = rs.getRow();

			rs = st.executeQuery(fiz.addFizToDb());

//		    <get_count> after
			rs.last();
			int count_after = rs.getRow();

			Assert.assertEquals(count_before + 1, count_after);
			Assert.fail();
		}
		catch (SQLException error)
		{
			error.printStackTrace();
		}

	}
}