package ljh.addr.model;

class AddrSQL {

	static final String sqlS = "select * from ADDRESS order by SEQ desc";
	static final String sqlI = "insert into ADDRESS values(ADDRESS_SEQ.nextval, ?,?,SYSDATE)";
	static final String sqlD = "delete from ADDRESS where SEQ = ?";

}
