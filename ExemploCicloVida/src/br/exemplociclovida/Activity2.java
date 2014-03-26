package br.exemplociclovida;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class Activity2 extends Activity {
	private static final String CATEGORIA = "Script";
	
	// CICLO DE VIDA
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_activity2);
			
			Log.i(CATEGORIA, getClassName()+".onCreate();");
		}
		
		protected void onStart(){
			super.onStart();
			Log.i(CATEGORIA, getClassName()+".onStart();");
		}
		
		protected void onRestart(){
			super.onRestart();
			Log.i(CATEGORIA, getClassName()+".onRestart();");
		}
		
		protected void onResume(){
			super.onResume();
			Log.i(CATEGORIA, getClassName()+".onResume();");
		}
		
		protected void onPause(){
			super.onPause();
			Log.i(CATEGORIA, getClassName()+".onPause();");
		}
		
		protected void onStop(){
			super.onStop();
			Log.i(CATEGORIA, getClassName()+".onStop();");
		}
		
		protected void onDestroy(){
			super.onDestroy();
			Log.i(CATEGORIA, getClassName()+".onDestroy();");
		}
	// CICLO DE VIDA
	
	
	private String getClassName(){
		String aux = getClass().getName();
		return(aux.substring(aux.lastIndexOf(".") +1));
	}
	
	public void voltar(View view){
		finish();
	}
}
