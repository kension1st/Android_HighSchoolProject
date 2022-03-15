package psb.android;

import java.io.InputStream;

import org.json.JSONArray;

import psb.android.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class profil extends Activity {
	JSONArray jArray;
	String result = null;
	InputStream is = null;
	StringBuilder sb =null;
	String nama,sekolah,jurusan,jk,alamat,telp,wali; //tambah
	TextView t1,t2,t3,t4,t5,t6,t7;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profilsiswa);
		t1=(TextView) findViewById(R.id.namasiswa);
		t2=(TextView) findViewById(R.id.namasekolah);
		t3=(TextView) findViewById(R.id.namajurusan);
		t4=(TextView) findViewById(R.id.jk);
		t5=(TextView) findViewById(R.id.alamat);
		t6=(TextView) findViewById(R.id.telp);
		t7=(TextView) findViewById(R.id.wali);
		Bundle extras = getIntent().getExtras();
		if(extras !=null)
		{
			nama = extras.getString("nama");
			sekolah = extras.getString("sekolah");
			jurusan = extras.getString("jurusan");
			jk = extras.getString("jk");
			alamat = extras.getString("alamat");
			telp = extras.getString("telp");
			wali = extras.getString("wali");
		}
		t1.setText(nama);
		t2.setText(sekolah);
		t3.setText(jurusan);
		t4.setText(jk);
		t5.setText(alamat);
		t6.setText(telp);
		t7.setText(wali);
	}

}
