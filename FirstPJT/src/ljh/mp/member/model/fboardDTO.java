package ljh.mp.member.model;

import java.sql.*;

public class fboardDTO {
	int idx;
	String writer;
	String email;
	String homepage;
	String pwd;
	String subject;
	String content;
	Date writedate;
	int readnum;
	String filename;
	String ofilename;
	long filesize;
	int refer;
	int lev;
	int sunbun;

	public fboardDTO() {

	}

	public fboardDTO(int idx, String writer, String email, String homepage, String pwd, String subject,
			String content, Date writedate, int readnum, String filename, String ofilename, long filesize, int refer,
			int lev, int sunbun) {
		super();
		this.idx = idx;
		this.writer = writer;
		this.email = email;
		this.homepage = homepage;
		this.pwd = pwd;
		this.subject = subject;
		this.content = content;
		this.writedate = writedate;
		this.readnum = readnum;
		this.filename = filename;
		this.ofilename = ofilename;
		this.filesize = filesize;
		this.refer = refer;
		this.lev = lev;
		this.sunbun = sunbun;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

	public int getReadnum() {
		return readnum;
	}

	public void setReadnum(int readnum) {
		this.readnum = readnum;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getOfilename() {
		return ofilename;
	}

	public void setOfilename(String ofilename) {
		this.ofilename = ofilename;
	}

	public long getFilesize() {
		return filesize;
	}

	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}

	public long getRefer() {
		return refer;
	}

	public void setRefer(int refer) {
		this.refer = refer;
	}

	public int getLev() {
		return lev;
	}

	public void setLev(int lev) {
		this.lev = lev;
	}

	public int getSunbun() {
		return sunbun;
	}

	public void setSunbun(int sunbun) {
		this.sunbun = sunbun;
	}

}