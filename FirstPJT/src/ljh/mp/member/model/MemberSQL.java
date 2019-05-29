package ljh.mp.member.model;

class MemberSQL {

	static final String sqlML = "select ID, PWD from MEMBER where ID=?";
	static final String sqlMI = "insert into MEMBER values(MEMBER_NO.nextval, (SELECT NVL(MAX(WRITENO),0)+1 as AIDX FROM MEMBER), ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
	static final String sqlMU = "update MEMBER set PWD=?, EMAIL=?, PHONE=?, ADDRESS=?";
	static final String sqlBL = "select * from JSP_BOARD order by IDX desc";
	static final String sqlBI = "insert into JSP_BOARD(IDX, WRITER, EMAIL, HOMEPAGE, PWD, SUBJECT, CONTENT, WRITEDATE, FILENAME) values(JSP_BOARD_IDX.nextval, ?,?,?,?,?,?, SYSDATE, ?)";
	static final String sqlBC = "select IDX, WRITEDATE, WRITER, HOMEPAGE, SUBJECT, FILENAME, CONTENT, READNUM from JSP_BOARD where IDX=?";
	static final String sqlRI = "insert into MEMBER values(IDX_REPLY.nextval, ?, ?, ?. SYSDATE, ?, ?)";
}
