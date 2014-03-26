package br.com.targettrust.aulacodbarras;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView tvResultado;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tvResultado = (TextView) findViewById(R.id.tvResultado);
    }


    public void leCodBarras (View v) {
    	
    	Intent intent = new Intent("com.google.zxing.client.android.SCAN");
    	startActivityForResult(intent, 10);
    	
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    	if (requestCode == 10) {
    		
    		if (resultCode == RESULT_OK) {
    			
    			String codigo = data.getStringExtra("SCAN_RESULT");
    			String formato = data.getStringExtra("SCAN_RESULT_FORMAT");
    			
    			tvResultado.setText(codigo + " - " + formato);
    		
    		} else {
    			
    			Toast.makeText(getBaseContext(), 
    					"Usuário cancelou...", 
    					Toast.LENGTH_SHORT).show();
    			
    		}
    		
    	}
    	
    
    }
    
    
}
