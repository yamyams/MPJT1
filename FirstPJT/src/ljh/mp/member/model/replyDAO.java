package ljh.mp.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

class replyDAO {
	private DataSource ds;

	replyDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/myoracle");
		} catch (NamingException ne) {
			System.out.println(ne);
		}
	}

	void insert(replyDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(MemberSQL.sqlMI);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getPwd());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getReply_id_fk());
			pstmt.setString(6, dto.getReply_idx_fk());
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
