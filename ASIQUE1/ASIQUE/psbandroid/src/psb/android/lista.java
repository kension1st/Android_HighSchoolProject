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
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class lista extends ListActivity {
	
	JSONArray jArray;
	String result = null;
	InputStream is = null;
	StringBuilder sb =null;
	
	Button asall;
	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.asal_list);

			
			ArrayList<NameValuePair> nameValuePairs =
				new ArrayList<NameValuePair>();
			//koneksi
		
			asall.setOnClickListener(
	                new OnClickListener() {
	        			
	        			public void onClick(View v) {
	        				// TODO Auto-generated method stub
	        				klikcari();
	        			}		
	        			}
	    			);
	        
	        
			
			try
			{
				HttpClient httpClient = new DefaultHttpClient();
				HttpPost httpPost =
					new HttpPost("http://10.0.2.2:80/jsonandroid/asalsekolah.php");
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
			fillData();
			registerForContextMenu(getListView());
		}
		
		
		
		public void fillData()
		{
			List<asalsekolah> dataasalsekolah = getdata();
			ListAdapter asaladapter = new SimpleAdapter(this, dataasalsekolah, R.layout.listasal_item, new String[] {
					asalsekolah.KEYid_sekolah,asalsekolah.KEYnama_sekolah},
					new int[] {R.id.id_sekolah,R.id.nama_sekolah });
			setListAdapter(asaladapter);
		}
		
		
	
		void klikcari()
        {
        	Intent cari= new Intent(this, listcariasal.class);
        	startActivity(cari);
        }
		
		public List<asalsekolah> getdata()
		{
			List<asalsekolah> lasalsekolah = new ArrayList<asalsekolah>();
			try
			{
				jArray = new JSONArray(result);
				JSONObject json_data=null;
				for(int i=0;i<jArray.length();i++)
				{
					json_data = jArray.getJSONObject(i);
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