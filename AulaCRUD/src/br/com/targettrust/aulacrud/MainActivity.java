package br.com.targettrust.aulacrud;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static final String TAG = "MainActivity";
	
	SQLiteDatabase db;
	EditText etDescricao, etCodigo, etPreco, etId;
	TextView tvResultado;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        etDescricao = (EditText) findViewById(R.id.etDescricao);
        etCodigo = (EditText) findViewById(R.id.etCodigo);
        etPreco = (EditText) findViewById(R.id.etPreco);
        etId = (EditText) findViewById(R.id.etId);
        
        tvResultado = (TextView) findViewById(R.id.tvResultado);
        
        openDB();
    }

    private void openDB() {
    	Log.d(TAG , "criando ou abrindo o banco...");
    	db = openOrCreateDatabase("db_teste.db", MODE_PRIVATE, null);
        
        StringBuilder strb = new StringBuilder();
        
        strb.append(" CREATE TABLE IF NOT EXISTS PRODUTOS (        ");
        strb.append(" id         integer primary key autoincrement, ");
        strb.append(" descricao  varchar(30),                       ");
        strb.append(" codigo     varchar(100),                      ");
        strb.append(" preco      double )                           ");
        
        db.execSQL(strb.toString());
    }

    @Override
    protected void onDestroy() {
    	super.onDestroy();
    	db.close();
    }
    
    public void insert (View v) {
    	
    	String descricao = etDescricao.getText().toString();
    	String codigo = etCodigo.getText().toString();
    	String preco = etPreco.getText().toString();
    	
    	ContentValues cv = new ContentValues();
    	cv.put("descricao", descricao);
    	cv.put("codigo", codigo);
    	cv.put("preco", preco);
    	
    	long rowId = db.insert("PRODUTOS", null, cv);
    	
    	if(rowId > 0) {
    		tvResultado.setText("INSERT OK [" + rowId + "]");
    	}
    	
    	limpar();
    }
    
    private void limpar() {
    	etDescricao.setText("");
    	etCodigo.setText("");
    	etPreco.setText("");
    }
    
    public void selectAll (View v) {
    	
    	Cursor c = db.query("PRODUTOS", 
    			new String[]{"id", "descricao", "codigo", "preco"}, 
    						null, null, null, null, null);
    	
    	StringBuilder str = new StringBuilder();
    	
    	while (c.moveToNext()) {
    		
    		str.append( c.getString(0) ).append(", ");
    		str.append( c.getString(1) ).append(", ");
    		str.append( c.getString(2) ).append(", ");
    		str.append( c.getString(3) ).append("\n");
    		
    	}
    	
    	c.close();
    	
    	tvResultado.setText(str.toString());
    	
    }
    
    public void selectById (View v) {
    	
    	String id = etId.getText().toString();

//    	Cursor c = db.rawQuery("SELECT count(*) " +
//    			"FROM PRODUTOS ",
//    			null);

    	Cursor c = db.rawQuery("SELECT id, descricao, codigo, preco " +
    			"FROM PRODUTOS " +
    			"WHERE id = ?",
    			new String[] {id});
    	
//    	Cursor c = db.query("PRODUTOS", 
//    			new String[]{"id", "descricao", "codigo", "preco"},
//    			"id = ?", new String[] {id}, null, null, null);
//    	
    	if (c.moveToFirst()) {
    		
//    		tvResultado.setText(c.getString(0));
    		etDescricao.setText( c.getString( c.getColumnIndex("descricao") ) );
    		etCodigo.setText( c.getString( c.getColumnIndex("codigo") ) );
    		etPreco.setText( c.getString( c.getColumnIndex("preco") ) );
    		
    	} else {
    		limpar();
    	}
    	
    	c.close();
    	
    }
     
    public void update (View v) {
    	
    	String descricao = etDescricao.getText().toString();
    	String codigo = etCodigo.getText().toString();
    	String preco = etPreco.getText().toString();
    	
    	ContentValues cv = new ContentValues();
    	cv.put("descricao", descricao);
    	cv.put("codigo", codigo);
    	cv.put("preco", preco);
    	
    	String id = etId.getText().toString();

    	int rows = db.update("PRODUTOS", cv, "id = ?", new String[]{id});
    	
    	if (rows > 0) {
    		tvResultado.setText("UPDATE OK [" + rows + "]");
    	} else { 
    		tvResultado.setText("sem alterações");
    	}
    	
    }
    
    public void delete (View v) {
    	
    	String id = etId.getText().toString();
    	
    	int rows = db.delete("PRODUTOS", "id = ?", new String[]{id});
    	
    	if (rows > 0) {
    		tvResultado.setText("DELETE OK [" + rows + "]");
    	} else { 
    		tvResultado.setText("sem alterações");
    	}
    }
    
}
