package ljh.mp.member.model;

import java.sql.Date;

public class replyDTO {

	int idx_reply;
	String writer;
	String pwd;
	String content;
	Date writedate;
	String reply_id_fk;
	String reply_idx_fk;

	replyDTO() {
	}

	public replyDTO(int idx_reply, String writer, String pwd, String content, Date writedate, String reply_id_fk,
			String reply_idx_fk) {
		super();
		this.idx_reply = idx_reply;
		this.writer = writer;
		this.pwd = pwd;
		this.content = content;
		this.writedate = writedate;
		this.reply_id_fk = reply_id_fk;
		this.reply_idx_fk = reply_idx_fk;
	}

	public int getIdx_reply() {
		return idx_reply;
	}

	public void setIdx_reply(int idx_reply) {
		this.idx_reply = idx_reply;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	public String getReply_id_fk() {
		return reply_id_fk;
	}

	public void setReply_id_fk(String reply_id_fk) {
		this.reply_id_fk = reply_id_fk;
	}

	public String getReply_idx_fk() {
		return reply_idx_fk;
	}

	public void setReply_idx_fk(String reply_idx_fk) {
		this.reply_idx_fk = reply_idx_fk;
	}

}
