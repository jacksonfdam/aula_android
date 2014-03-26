package br.com.targettrust.aulaintents;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
    }

    public void callIntent(View v) {
    	
    	Intent i = null;
    	switch (v.getId()) {
		case R.id.button1:
			
			i = new Intent(Intent.ACTION_VIEW, 
					Uri.parse("http://www.targettrust.com.br"));
			startActivity(i);
			
			break;

		case R.id.button2:
			
			i = new Intent(Intent.ACTION_VIEW, 
					Uri.parse("geo:-29.98,-50.18?z=14"));
			
			startActivity(i);
			
			break;

		case R.id.button3:
			
			i = new Intent(Intent.ACTION_DIAL,	
					Uri.parse("tel:33252596"));
			
			startActivity(i);
			break;
			
		case R.id.button4:
			
			i = new Intent(Intent.ACTION_CALL,	
					Uri.parse("tel:33252596"));
			
			startActivity(i);
			break;
			
		case R.id.button5:
			
			i = new Intent(Intent.ACTION_SENDTO, 
					Uri.parse("smsto:5556"));   
			
			i.putExtra("sms_body", "Teste SMS!!!");   
			startActivity(i);  
			
		case R.id.button6:
			
			SmsManager sm = SmsManager.getDefault();
			sm.sendTextMessage("5556", null, "Teste SMS !!!!", null, null);
			
		default:
			break;
		}
    	
    	
    }
    

    
   
}
