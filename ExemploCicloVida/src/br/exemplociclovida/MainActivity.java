package br.exemplociclovida;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	private static final String CATEGORIA = "Script";
	
	// CICLO DE VIDA
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			
			Log.i(CATEGORIA, getClassName()+".onCreate();");
		}
		
		public void onStart(){
			super.onStart();
			Log.i(CATEGORIA, getClassName()+".onStart();");
		}
		
		public void onRestart(){
			super.onRestart();
			Log.i(CATEGORIA, getClassName()+".onRestart();");
		}
		
		public void onResume(){
			super.onResume();
			Log.i(CATEGORIA, getClassName()+".onResume();");
		}
		
		public void onPause(){
			super.onPause();
			Log.i(CATEGORIA, getClassName()+".onPause();");
		}
		
		public void onStop(){
			super.onStop();
			Log.i(CATEGORIA, getClassName()+".onStop();");
		}
		
		public void onDestroy(){
			super.onDestroy();
			Log.i(CATEGORIA, getClassName()+".onDestroy();");
		}
	// CICLO DE VIDA
		
	
	private String getClassName(){
		String aux = getClass().getName();
		return(aux.substring(aux.lastIndexOf(".") +1));
	}
	
	public void acessarAtividade2(View view){
		Intent intent = new Intent(this, Activity2.class);
		startActivity(intent);
	}
}
