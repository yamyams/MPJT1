package ljh.mp.member.model;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ljh.mp.member.model.MemberSQL;

class fboardDAO {
	private DataSource ds;

	fboardDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
		} catch (NamingException ne) {
			System.out.println(ne);
		}
	}

	ArrayList<fboardDTO> selectB() {
		ArrayList<fboardDTO> listB = new ArrayList<fboardDTO>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(MemberSQL.sqlBL);
			while (rs.next()) {
				int idx = rs.getInt(1);
				String writer = rs.getString(2);
				String email = rs.getString(3);
				String homepage = rs.getString(4);
				String pwd = rs.getString(5);
				String subject = rs.getString(6);
				String content = rs.getString(7);
				java.sql.Date writedate = rs.getDate(8);
				int readnum = rs.getInt(9);
				String filename = rs.getString(10);
				String ofilename = rs.getString(11);
				long filesize = rs.getLong(12);
				int refer = rs.getInt(13);
				int lev = rs.getInt(14);
				int sunbun = rs.getInt(15);
				fboardDTO dto = new fboardDTO(idx, writer, email, homepage, pwd, subject, content, writedate, readnum,
						filename, ofilename, filesize, refer, lev, sunbun);
				listB.add(dto);
			}
			return listB;
		} catch (SQLException se) {
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

	void insert(fboardDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(MemberSQL.sqlBI);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getHomepage());
			pstmt.setString(4, dto.getPwd());
			pstmt.setString(5, dto.getSubject());
			pstmt.setString(6, dto.getContent());
			pstmt.setString(7, dto.getFilename());
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

	fboardDTO selectC(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(MemberSQL.sqlBC);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			rs.next();
			int idx1 = rs.getInt(1);
			java.sql.Date writedate = rs.getDate(2);
			String writer = rs.getString(3);
			String homepage = rs.getString(4);
			String subject = rs.getString(5);
			String filename = rs.getString(6);
			String content = rs.getString(7);
			int readnum = rs.getInt(8);
			String email = null;
			String pwd = null;
			String ofilename = null;
			long filesize = 0;
			int refer = 0;
			int lev = 0;
			int sunbun = 0;
			fboardDTO dto = new fboardDTO(idx1, writer, email, homepage, pwd, subject, content, writedate, readnum,
					filename, ofilename, filesize, refer, lev, sunbun);
			return dto;
		} catch (SQLException se) {
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
	}
}
