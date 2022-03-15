package psb.android;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import psb.android.R;
import android.app.ListActivity;
import android.content.Intent;
import android.net.ParseException;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class listcariasal extends ListActivity {

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
		strcari2 = (EditText) findViewById(R.id.editText2);
		keluar = (Button) findViewById(R.id.btnbatal);
		
		keluar.setOnClickListener(
                new OnClickListener() {
        			
        			public void onClick(View v) {
        				// TODO Auto-generated method stub
        				strcari2.setText("");
        			}		
        			}
    			);
		
	strcari2.addTextChangedListener(new TextWatcher() {
		
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			// TODO Auto-generated method stub
			if(strcari2.getText().toString()==null){
				setListAdapter(null);
			}
			
			else if(strcari2.getText().toString()!=null){
			String nama2=strcari2.getText().toString().replace(" ", "%20");
			caridata2("http://10.0.2.2:80/jsonandroid/csekolah.php?nama="+nama2);
			
				fillData2();}
		}
		
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			caridata2("http://10.0.2.2:80/jsonandroid/asalsekolah.php");
			
			fillData2();
			registerForContextMenu(getListView());
		}
		
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}
	});
	
	}
	
	
	private void caridata2(String url){
		ArrayList<NameValuePair> nameValuePairs =
			new ArrayList<NameValuePair>();
		//koneksi
	
		try
		{
			HttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost =
				new HttpPost(url);
			httpPost.setEntity
			(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			is5 = entity.getContent();
		}
		catch(Exception e)
		{
			Log.e("log_tag","Error http connection"+e.toString());
		}
		try
		{
			BufferedReader reader = new BufferedReader
			(new InputStreamReader(is5,"iso-8859-1"),8);
			sb5 = new StringBuilder();
			sb5.append(reader.readLine() + "\n");
			String line="0";
			while ((line = reader.readLine()) != null)
			{
				sb5.append(line + "\n");
			}
			is5.close();
			result5 = sb5.toString();
		}
		catch(Exception e)
		{
			Log.e("log_tag","Error convert result" +e.toString());
		}
	}
	
	void kliksilang()
    {	
		finish();
    	Intent silang= new Intent(this, listcariasal.class);
    	startActivity(silang);
    }
	
	
	private void fillData2()
	{
		List<asalsekolah> dataasalsekolahh = getdata();
		ListAdapter asalsklhadapter = new SimpleAdapter(this, dataasalsekolahh, R.layout.listasal_item, new String[] {
				asalsekolah.KEYid_sekolah,asalsekolah.KEYnama_sekolah},
				new int[] {R.id.id_sekolah,R.id.nama_sekolah });
		setListAdapter(asalsklhadapter);
	}
	
	private List<asalsekolah> getdata()
	{
		List<asalsekolah> lasalsekolah = new ArrayList<asalsekolah>();
		try
		{
			jArray5 = new JSONArray(result5);
			JSONObject json_data=null;
			for(int i=0;i<jArray5.length();i++)
			{
				json_data = jArray5.getJSONObject(i);
				lasalsekolah.add(new asalsekolah
						(json_data.getString("id_sekolah"),
						json_data.getString("nama_sekolah")));
			}
		}
		catch(JSONException e1)
		{
			Log.e("log_tag", "Error JSONException"+e1.toString());
		}
		catch(ParseException e2)
		{
			Log.e("log_tag", "Error ParseException"+e2.toString());
		}
		return lasalsekolah;
	}
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		asalsekolah item = (asalsekolah) l.getItemAtPosition(position);
		Intent i = new Intent(this, listcs.class);
		i.putExtra("id", item.id_sekolah);
		startActivity(i);
	}
}
