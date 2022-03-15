package psb.android;

import java.io.InputStream;

import org.json.JSONArray;

import psb.android.R;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class cariasal extends lista {
	JSONArray jArray5;
	String result5 = null;
	InputStream is5 = null;
	StringBuilder sb5 =null;
	
	Button keluar;
	EditText strcari2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cariasal);
	}

}
