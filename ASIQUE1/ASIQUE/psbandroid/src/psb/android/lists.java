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



import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;

import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

public class lists extends ListActivity {

	JSONArray jArray;
	String result = null;
	InputStream is = null;
	StringBuilder sb =null;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.staff_list);
		
			ArrayList<NameValuePair> nameValuePairs =
				new ArrayList<NameValuePair>();
			//koneksi
			
			
			try
			{
				HttpClient httpClient = new DefaultHttpClient();
				HttpPost httpPost =
					new HttpPost("http://10.0.2.2:80/jsonandroid/staff.php");
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
		private void fillData()
		{
			List<staff> datastaff = getdata();
			ListAdapter staffadapter = new SimpleAdapter(this, datastaff, R.layout.liststaff_item, new String[] {
					staff.KEYid_staff,staff.KEYnama_staff,staff.KEYusername,staff.KEYpass,staff.KEYlevel_user},
					new int[] {R.id.id_staff,R.id.nama_staff, R.id.username, R.id.pass, R.id.level_user });
			setListAdapter(staffadapter);
		}
		
	
		
		private List<staff> getdata()
		{
			List<staff> lstaff = new ArrayList<staff>();
			try
			{
				jArray = new JSONArray(result);
				JSONObject json_data=null;
				for(int i=0;i<jArray.length();i++)
				{
					json_data = jArray.getJSONObject(i);
					lstaff.add(new staff
							(json_data.getString("id_staff"),
							json_data.getString("nama_staff"),
							json_data.getString("username"),
							json_data.getString("pass"),
							json_data.getString("level_user")));
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
			return lstaff;
		
	
		}
		
	}