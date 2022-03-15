package psb.android;

import java.util.HashMap;



public class staff extends HashMap<String, String>{
	private static final long serialVersionUID = 12872473L;
	public String id_staff;
	public String nama_staff;
	public String username;
	public String pass;
	public String level_user;
	
	public static String KEYid_staff = "strid";
	public static String KEYnama_staff = "strnama_staff";
	public static String KEYusername = "strusername";
	public static String KEYpass = "strpass";
	public static String KEYlevel_user = "strlevel_user";
	
	public staff(String strid, String strnama_staff, String strusername, String strpass, String strlevel_user){
		this.id_staff = strid;
		this.nama_staff = strnama_staff;
		this.username = strusername;
		this.pass = strpass;
		this.level_user = strlevel_user;
	}
	
	@Override
	public String get(Object k){
		String key = (String) k;
		if (KEYid_staff.equals(key))
			return id_staff;
		else if(KEYnama_staff.equals(key))
			return nama_staff;
		else if(KEYusername.equals(key))
			return username;
		else if(KEYpass.equals(key))
			return pass;
		else if(KEYlevel_user.equals(key))
			return level_user;
		return null;
	}
}
