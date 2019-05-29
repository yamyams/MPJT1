package ljh.board.model;

class BoardSQL {
	static final String sqlSB = "select SEQ, WRITER, EMAIL, SUBJECT, RDATE from BOARD order by SEQ desc";
	static final String sqlSC = "select SEQ, WRITER, EMAIL, SUBJECT, CONTENT from BOARD where SEQ=?";
	static final String sqlSU = "select WRITER, EMAIL, SUBJECT, CONTENT from BOARD where SEQ=?";
	static final String sqlSD ="delete from BOARD where SEQ=?";
	static final String sqlSI = "insert into BOARD values(BOARD_SEQ.nextval, ?,?,?,?,SYSDATE)";
	static final String sqlSU1 = "update BOARD set EMAIL=?, SUBJECT=?, CONTENT=? where SEQ=?";
}
