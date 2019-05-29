package ljh.board.model;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

class BoardDAO {
	private DataSource ds;

	BoardDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
		} catch (NamingException ne) {
			System.out.println(ne);
		}
	}

	ArrayList<BoardDTO> selectB() {
		ArrayList<BoardDTO> listB = new ArrayList<BoardDTO>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(BoardSQL.sqlSB);
			while (rs.next()) {
				int seq = rs.getInt(1);
				String writer = rs.getString(2);
				String email = rs.getString(3);
				String subject = rs.getString(4);
				java.sql.Date rdate = rs.getDate(5);
				String content = null;
				BoardDTO dto = new BoardDTO(seq, writer, email, subject, content, rdate);
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

	BoardDTO selectC(BoardDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(BoardSQL.sqlSC);
			pstmt.setInt(1, dto.getSeq());
			rs = pstmt.executeQuery();
			rs.next();
			int seq = rs.getInt(1);
			String writer = rs.getString(2);
			String email = rs.getString(3);
			String subject = rs.getString(4);
			String content = rs.getString(5);
			java.sql.Date rdate = null;
			BoardDTO dto1 = new BoardDTO(seq, writer, email, subject, content, rdate);
			return dto1;
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

	void insert(BoardDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(BoardSQL.sqlSI);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
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
			pstmt = con.prepareStatement(BoardSQL.sqlSD);
			pstmt.setInt(1, seq);
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
	BoardDTO updateC(BoardDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(BoardSQL.sqlSU);
			pstmt.setInt(1, dto.getSeq());
			rs = pstmt.executeQuery();
			rs.next();
			String writer = rs.getString(1);
			String email = rs.getString(2);
			String subject = rs.getString(3);
			String content = rs.getString(4);
			int seq = dto.getSeq();
			java.sql.Date rdate = null;
			BoardDTO dto2 = new BoardDTO(seq, writer, email, subject, content, rdate);
			return dto2;
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
	void update(BoardDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(BoardSQL.sqlSU1);
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getSeq());
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
