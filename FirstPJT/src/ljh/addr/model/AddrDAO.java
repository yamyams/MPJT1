package ljh.addr.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

class AddrDAO {
	private DataSource ds;

	AddrDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
		} catch (NamingException ne) {
			System.out.println(ne);
		}
	}

	ArrayList<AddrDTO> select() {
		ArrayList<AddrDTO> list = new ArrayList<AddrDTO>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(AddrSQL.sqlS);
			while (rs.next()) {
				int seq = rs.getInt(1);
				String name = rs.getString(2);
				String addr = rs.getString(3);
				java.sql.Date rdate = rs.getDate(4);
				AddrDTO dto = new AddrDTO(seq, name, addr, rdate);
				list.add(dto);
			}
			return list;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
	}

	void insert(AddrDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AddrSQL.sqlI);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2,  dto.getAddr());
			pstmt.executeUpdate();
		} catch (SQLException se) {
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
	}

	void delete(int seq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(AddrSQL.sqlD);
			pstmt.setInt(1,  seq);
			pstmt.executeUpdate();
		} catch (SQLException se) {
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
	}
	
}
