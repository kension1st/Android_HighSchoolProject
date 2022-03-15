package psb.android;

import java.util.HashMap;



public class siswabaru extends HashMap<String, String>{
	private static final long serialVersionUID = 12872473L;
	public String id_calonsiswa;
	public String nama_sekolah;
	public String nama_jurusan;
	public String nama_staff;
	public String nama;
	public String nisn;
	public String nik;
	public String alamat;
	public String jk;
	public String no_telp;
	public String nama_wali;
	
	public static String KEYid_calonsiswa = "str1";
	public static String KEYnama_sekolah = "str2";
	public static String KEYnama_jurusan = "str3";
	public static String KEYnama_staff = "str4";
	public static String KEYnama = "str5";
	public static String KEYnisn = "str6";
	public static String KEYnik = "str7";
	public static String KEYalamat = "str8";
	public static String KEYjk = "str9";
	public static String KEYno_telp = "str10";
	public static String KEYnama_wali = "str11";
	
	public siswabaru(String str1, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11){
		this.id_calonsiswa = str1;
		this.nama_sekolah = str2;
		this.nama_jurusan = str3;
		this.nama_staff = str4;
		this.nama = str5;
		this.nisn = str6;
		this.nik = str7;
		this.alamat = str8;
		this.jk = str9;
		this.no_telp = str10;
		this.nama_wali = str11;
		;
		
	}
	
	@Override
	public String get(Object k){
		String key = (String) k;
		if (KEYid_calonsiswa.equals(key))
			return id_calonsiswa;
		else if(KEYnama_sekolah.equals(key))
			return nama_sekolah;
		else if(KEYnama_jurusan.equals(key))
			return nama_jurusan;
		else if(KEYnama_staff.equals(key))
			return nama_staff;
		else if(KEYnama.equals(key))
			return nama;
		else if(KEYnisn.equals(key))
			return nisn;
		else if(KEYnik.equals(key))
			return nik;
		else if(KEYalamat.equals(key))
			return alamat;
		else if(KEYjk.equals(key))
			return jk;
		else if(KEYno_telp.equals(key))
			return no_telp;
		else if(KEYnama_wali.equals(key))
			return nama_wali;
		return null;
	}
}
