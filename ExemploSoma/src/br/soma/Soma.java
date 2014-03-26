package br.soma;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Soma extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_soma);
	}
	
	public void soma(View view){
		
		EditText n1 = (EditText) findViewById(R.id.n1);
		int n1Num = Integer.parseInt( n1.getText().toString() );
		
		EditText n2 = (EditText) findViewById(R.id.n2);
		int n2Num = Integer.parseInt( n2.getText().toString() );
		
		int soma = n1Num + n2Num;
		
		Toast.makeText(this, "Resultado: "+soma, Toast.LENGTH_LONG).show();
	}
}
