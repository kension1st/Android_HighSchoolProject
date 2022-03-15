package psb.android;

import psb.android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.view.View.OnClickListener;
import android.widget.Button;

public class menuutama extends Activity {
	Button jrsan;
	Button staf;
	Button asal;
	Button sklh;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        jrsan=(Button) findViewById(R.id.buttonjur);
        staf=(Button) findViewById(R.id.buttonstaf);
        asal=(Button) findViewById(R.id.buttonasal);
        sklh=(Button) findViewById(R.id.buttonsiswa);
     
        
        jrsan.setOnClickListener(
                new OnClickListener() {
        			
        			public void onClick(View v) {
        				// TODO Auto-generated method stub
        				klikjurusan();
        			}
        		});
  

        staf.setOnClickListener(
                new OnClickListener() {
        			
        			public void onClick(View v) {
        				// TODO Auto-generated method stub
        				klikstaf();
        			}
        		}		
                );
        
        asal.setOnClickListener(
                new OnClickListener() {
        			
        			public void onClick(View v) {
        				// TODO Auto-generated method stub
        				klikasal();
        			}
        		}		
                );
        
        sklh.setOnClickListener(
                new OnClickListener() {
        			
        			public void onClick(View v) {
        				// TODO Auto-generated method stub
        				kliksklh();
        			}		
        			}
    			);
        
        
    	}
    
    
        void kliksklh()
        {
        	Intent sklhh= new Intent(this, listcalonsiswa.class);
        	startActivity(sklhh);
        }
        
        void klikasal()
        {
        	Intent asal= new Intent(this, lista.class);
        	startActivity(asal);
        }
        
        void klikstaf()
        {
        	Intent stf= new Intent(this, lists.class);
        	startActivity(stf);
        }
        
        void klikjurusan()
        {
        	Intent jur = new Intent(this, listj.class);
        	startActivity(jur);
        }
        
        
		  
         public void onBackPressed() {
				// TODO Auto-generated method stub
				AlertDialog al=new AlertDialog.Builder(this).create();
				al.setTitle("Perhatian");
				al.setMessage("Apakah Anda Yakin Ingin Keluar ?");
				al.setButton("Ya", new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						finish();
					}
				});
				al.setButton2("Tidak", new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				});
				al.show();
				//super.onBackPressed();
			
         
    }
}