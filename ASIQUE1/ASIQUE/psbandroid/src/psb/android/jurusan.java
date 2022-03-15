package psb.android;

import java.util.HashMap;



public class jurusan extends HashMap<String, String>{
	private static final long serialVersionUID = 12872473L;
	public String kodejurusan;
	public String namajurusan;
	
	public static String KEYkodejurusan = "strid";
	public static String KEYnamajurusan = "strnama";
	
	public jurusan(String strid, String strnama){
		this.kodejurusan = strid;
		this.namajurusan = strnama;
	}
	
	@Override
	public String get(Object k){
		String key = (String) k;
		if (KEYkodejurusan.equals(key))
			return kodejurusan;
		else if(KEYnamajurusan.equals(key))
			return namajurusan;
		return null;
	}
}
