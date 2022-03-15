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

public class listj extends ListActivity {
	
	JSONArray jArray;
	String result = null;
	InputStream is = null;
	StringBuilder sb =null;
	
	Button cari;
	EditText strcari;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.j_list);
			
			cari =(Button) findViewById(R.id.btncari2);
			strcari = (EditText) findViewById(R.id.editText1);
			
			caridata("http://10.0.2.2:80/jsonandroid/jurusan.php");
			
			fillData();
			registerForContextMenu(getListView());
		
		
		cari.setOnClickListener(
                new OnClickListener() {
                	
        		
        			public void onClick(View v) {
        				// TODO Auto-generated method stub
        				String nama=strcari.getText().toString().replace(" ", "%20");
        				caridata("http://10.0.2.2:80/jsonandroid/cjurusan.php?nama="+nama);
        				fillData();
        			}
        		});
		strcari.addTextChangedListener(new TextWatcher() {
			
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				String nama=strcari.getText().toString().replace(" ", "%20");
				caridata("http://10.0.2.2:80/jsonandroid/cjurusan.php?nama="+nama);
				fillData();
			}
			
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		}
		
		public void caridata(String url)
		{
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
				is = entity.getContent();
			}
			catch(Exception e)
			{
				Log.e("log_tag","Error http connection"+e.toString());
			}
			try
			{
				BufferedReader reader = new BufferedReader
				(new InputStreamReader(is,"iso-8859-1"),8);
				sb = new StringBuilder();
				sb.append(reader.readLine() + "\n");
				String line="0";
				while ((line = reader.readLine()) != null)
				{
					sb.append(line + "\n");
				}
				is.close();
				result = sb.toString();
			}
			catch(Exception e)
			{
				Log.e("log_tag","Error convert result" +e.toString());
			}
		}
		
		private void fillData()
		{
			List<jurusan> datajurusan = getdata();
			ListAdapter jurusanadapter = new SimpleAdapter(this, datajurusan, R.layout.list_item, new String[] {
					jurusan.KEYkodejurusan,jurusan.KEYnamajurusan},
					new int[] {R.id.kodejurusan,R.id.namajurusan });
			setListAdapter(jurusanadapter);
		}
		
		private List<jurusan> getdata()
		{
			List<jurusan> ljurusan = new ArrayList<jurusan>();
			try
			{
				jArray = new JSONArray(result);
				JSONObject json_data=null;
				for(int i=0;i<jArray.length();i++)
				{
					json_data = jArray.getJSONObject(i);
					ljurusan.add(new jurusan
							(json_data.getString("kode_jurusan"),
							json_data.getString("nama_jurusan")));
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
			return ljurusan;
		
	
		}

		@Override
		protected void onListItemClick(ListView l, View v, int position, long id) {
			// TODO Auto-generated method stub
			super.onListItemClick(l, v, position, id);
			jurusan item = (jurusan) l.getItemAtPosition(position);
			Intent i = new Intent(this, listcb.class);
			i.putExtra("kode", item.kodejurusan);
			startActivity(i);
		}
		
	}