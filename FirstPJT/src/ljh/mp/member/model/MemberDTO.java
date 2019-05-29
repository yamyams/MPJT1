package ljh.mp.member.model;

import java.sql.Date;

public class MemberDTO {
	int no;
	int writeno;
	String nick;
	String id;
	String pwd;
	String name;
	String email;
	String phone;
	String address;
	Date joindate;

	public MemberDTO() {
	}

	public MemberDTO(int no, int writeno, String nick, String id, String pwd, String name, String email, String phone,
			String address, Date joindate) {
		super();
		this.no = no;
		this.writeno = writeno;
		this.nick = nick;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.joindate = joindate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getWriteno() {
		return writeno;
	}

	public void setWriteno(int writeno) {
		this.writeno = writeno;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}



}
