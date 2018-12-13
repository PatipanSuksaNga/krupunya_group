package data;

public class language {
	
	public static String mnLanguage = "Language";
	public static String mntmEnglish = "English";
	public static String mntmThai = "Thai";
	public static String lbid = "ID";
	public static String lbpassword = "Password";
	public static String btnlogin = "Login";
	public static String lbDay = "Day";
	public static String lbMonth = "Month";
	public static String lbYear = "Year";
	public static String btnBegin = "Begin";
	public static String date = "Date " + dateIn.day + "/" + dateIn.month + "/" + dateIn.year;
	public static String lbMainpage = "Main page";
	public static String btnBuybilling = "Buy billing";
	public static String btnSellbilling = "Sellbilling";
	public static String btnOnspotsale = "On spot sale";
	public static String btnSizetable = "Size table";
	public static String btnConclusion = "Conclusion";
	
	
	public static void getEng() {
		language.mnLanguage = "English";
		language.mntmEnglish = "English";
		language.mntmThai = "��";
		language.lbid = "ID";
		language.lbpassword = "Password";
		language.btnlogin = "Login";
		language.lbDay = "Day";
		language.lbMonth = "Month";
		language.lbYear = "Year";
		language.btnBegin = "Begin";
		language.date = "Date " + dateIn.day + "/" + dateIn.month + "/" + dateIn.year;
		language.lbMainpage = "Main page";
		language.btnBuybilling = "Buy billing";
		language.btnSellbilling = "Sellbilling";
		language.btnOnspotsale = "On spot sale";
		language.btnSizetable = "Size table";
		language.btnConclusion = "Conclusion";
	}
	
	public static void getThai() {
		language.mnLanguage = "����";
		language.mntmEnglish = "English";
		language.mntmThai = "��";
		language.lbid = "���ͼ����";
		language.lbpassword = "���ʼ�ҹ";
		language.btnlogin = "�������к�";
		language.lbDay = "�ѹ";
		language.lbMonth = "��͹";
		language.lbYear = "��";
		language.btnBegin = "�������÷ӧҹ";
		language.date = "�ѹ��� " + dateIn.day + "/" + dateIn.month + "/" + dateIn.year;
		language.lbMainpage = "˹����ѡ";
		language.btnBuybilling = "��ū���";
		language.btnSellbilling = "��Ţ��";
		language.btnOnspotsale = "���ʴ";
		language.btnSizetable = "����";
		language.btnConclusion = "���ػ";
	}
	
	public static void setdate() {
		language.date = "Date " + dateIn.day + "/" + dateIn.month + "/" + dateIn.year;
	}
	
}
