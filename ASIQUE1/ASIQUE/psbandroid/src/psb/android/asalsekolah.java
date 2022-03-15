package psb.android;

import java.util.HashMap;



public class asalsekolah extends HashMap<String, String>{
	private static final long serialVersionUID = 12872473L;
	public String id_sekolah;
	public String nama_sekolah;
	
	public static String KEYid_sekolah = "strid";
	public static String KEYnama_sekolah = "strnama";
	
	public asalsekolah(String strid, String strnama){
		this.id_sekolah = strid;
		this.nama_sekolah = strnama;
	}
	
	@Override
	public String get(Object k){
		String key = (String) k;
		if (KEYid_sekolah.equals(key))
			return id_sekolah;
		else if(KEYnama_sekolah.equals(key))
			return nama_sekolah;
		return null;
	}
}
