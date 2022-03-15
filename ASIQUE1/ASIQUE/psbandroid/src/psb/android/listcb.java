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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class listcb extends ListActivity {
	
	JSONArray jArray;
	String result = null;
	InputStream is = null;
	StringBuilder sb =null;
	String kode; //tambah
	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.siswa_list);
			
			//tambah
			Bundle extras = getIntent().getExtras();
			if(extras !=null)
			{
				kode = extras.getString("kode");
			}
			//----------
			
			ArrayList<NameValuePair> nameValuePairs =
				new ArrayList<NameValuePair>();
			//koneksi
			
			
			try
			{
				HttpClient httpClient = new DefaultHttpClient();
				HttpPost httpPost =
					new HttpPost("http://10.0.2.2:80/jsonandroid/caricalonsiswa.php?kode="+kode); //ganti
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
			List<siswabaru> datastaff = getdata();
			ListAdapter siswabaruadapter = new SimpleAdapter(this, datastaff, R.layout.listsiswa_item2, new String[] {
					siswabaru.KEYid_calonsiswa, siswabaru.KEYnama_sekolah, siswabaru.KEYnama_jurusan, siswabaru.KEYnama_staff, siswabaru.KEYnama, siswabaru.KEYnisn, siswabaru.KEYnik},
					new int[] {R.id.id_calonsiswa, R.id.nama_sekolah});
			setListAdapter(siswabaruadapter);
		}
		
	
		private List<siswabaru> getdata()
		{
			List<siswabaru> lsiswabaru = new ArrayList<siswabaru>();
			try
			{
				jArray = new JSONArray(result);
				JSONObject json_data=null;
				for(int i=0;i<jArray.length();i++)
				{
					json_data = jArray.getJSONObject(i);
					lsiswabaru.add(new siswabaru
							(json_data.getString("nama"),
									json_data.getString("nama_jurusan"),
									json_data.getString("nama_sekolah"),
									json_data.getString("jk"),
									json_data.getString("alamat"),
									json_data.getString("no_telp"),
									json_data.getString("nama_wali"),result, result, result, result));
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
			return lsiswabaru;
		
	
		}
		protected void onListItemClick(ListView l, View v, int position, long id) {
			// TODO Auto-generated method stub
			super.onListItemClick(l, v, position, id);
			siswabaru item = (siswabaru) l.getItemAtPosition(position);
			Intent i = new Intent(this, profil.class);
			i.putExtra("nama", item.id_calonsiswa);
			i.putExtra("jurusan", item.nama_sekolah);
			i.putExtra("sekolah", item.nama_jurusan);
			i.putExtra("jk", item.nama_staff);
			i.putExtra("alamat", item.nama);
			i.putExtra("telp", item.nisn);
			i.putExtra("wali", item.nik);
			
			
			startActivity(i);
		}
	}