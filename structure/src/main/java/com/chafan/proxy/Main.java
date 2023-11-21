package com.chafan.proxy;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

	static final String jdbcUrl = "jdbc:mysql://127.0.0.1:3307/db01?useUnicode=true&characterEncoding=UTF-8&userSSL=false& serverTimezone=GMT%2B8";
	static final String jdbcUsername = "root";
	static final String jdbcPassword = "3306";

	public static void main(String[] args) throws Exception {
		DataSource lazyDataSource = new LazyDataSource(jdbcUrl, jdbcUsername, jdbcPassword);
		System.out.println("get lazy connection...");
		try (Connection conn1 = lazyDataSource.getConnection()) {
			// 并没有实际打开真正的Connection
		}
		System.out.println("get lazy connection...");
		try (Connection conn2 = lazyDataSource.getConnection()) {

			try (PreparedStatement ps = conn2.prepareStatement("SELECT * FROM person")) { // 打开了真正的Connection

				try (ResultSet rs = ps.executeQuery()) {

					while (rs.next()) {
						System.out.println(
								rs.getString("id")+
								rs.getString("name")+
								rs.getString("phone")+
								rs.getString("salary"));
					}

				}
			}
		}

		DataSource pooledDataSource = new PooledDataSource(jdbcUrl, jdbcUsername, jdbcPassword);

		try (Connection conn = pooledDataSource.getConnection()) {
			System.out.println("***********"+conn.toString());
		}
		try (Connection conn = pooledDataSource.getConnection()) {
			// 获取到的是同一个Connection
			System.out.println("***********"+conn.toString());
		}
		try (Connection conn = pooledDataSource.getConnection()) {
			// 获取到的是同一个Connection
			System.out.println("***********"+conn.toString());
		}
	}


}
