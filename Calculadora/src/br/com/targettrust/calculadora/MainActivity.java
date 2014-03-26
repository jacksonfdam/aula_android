package br.com.targettrust.calculadora;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText etOp1, etOp2;
	Button btSomar;
	TextView tvResultado;

	
	OnFocusChangeListener onFocusChange = new OnFocusChangeListener() {
		
		@Override
		public void onFocusChange(View v, boolean hasFocus) {
			
			String st = "Operando ...";
			if (v.getId() == R.id.etOp1) {
//			if (v.equals(etOp1)) {
				st = "Operando 1";
			}
			
			if (hasFocus) {
				Toast.makeText(
						getBaseContext(), 
						"Digite o " + st, 
						Toast.LENGTH_SHORT)
						.show();
			}
			
		}
	};
	
	OnLongClickListener onLongClick = new OnLongClickListener() {
		
		@Override
		public boolean onLongClick(View v) {

			int op1 = Integer.valueOf(etOp1.getText().toString());
			int op2 = Integer.valueOf(etOp2.getText().toString());
			
			tvResultado.setText("Resultado: " + (op1 * op2));

			
			return true;
		}
	};
	
	OnClickListener onClick = new OnClickListener() {
		@Override
		public void onClick(View v) {

			int op1 = Integer.valueOf(etOp1.getText().toString());
			int op2 = Integer.valueOf(etOp2.getText().toString());
			
			tvResultado.setText("Resultado: " + (op1 + op2));

		}
	};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        etOp1 = (EditText)findViewById(R.id.etOp1);
        etOp2 = (EditText) findViewById(R.id.etOp2);
        btSomar = (Button) findViewById(R.id.button1);
        tvResultado = (TextView) findViewById(R.id.tvResultado);
        
        btSomar.setOnClickListener(onClick);
        btSomar.setOnLongClickListener(onLongClick);
        etOp1.setOnFocusChangeListener(onFocusChange);
        
        
    }

    public void limpar (View v) {
    	
    	// widget criado em runtime
    	final EditText etValor = new EditText(getBaseContext());
    	
    	AlertDialog.Builder dialog = new AlertDialog.Builder(this)
    	.setTitle("Confirmação")
    	.setMessage("Deseja limpar?")
    	.setIcon(R.drawable.ic_launcher)
    	.setView(etValor)
    	.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
			   	etOp1.setText("");
		    	
			   	etOp2.setText(etValor.getText().toString());
		    	
			}
		})
    	.setNegativeButton("Cancelar", null);
    	
    	dialog.show();
    	
    	
    	
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
