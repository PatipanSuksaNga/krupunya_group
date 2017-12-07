package data;

public class language {
	
	public String lbid = "ID";
	public String lbpassword = "Password";
	public String btnlogin = "Login";
	public String mnLanguage = "Language";
	public String mntmEnglish = "English";
	public String mntmThai = "Thai";
	
	public void getEng() {
		this.lbid = "ID";
		this.lbpassword = "Password";
		this.btnlogin = "Login";
		this.mnLanguage = "Language";
		this.mntmEnglish = "English";
		this.mntmThai = "Thai";
	}
	
	public void getThai() {
		this.lbid = "ชื่อผู้ใช้";
		this.lbpassword = "รหัสผ่าน";
		this.btnlogin = "เข้าสู่ระบบ";
		this.mnLanguage = "ภาษา";
		this.mntmEnglish = "English";
		this.mntmThai = "ไทย";
	}
	
}
