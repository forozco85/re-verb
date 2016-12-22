package com.example.re_verb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.re_verb.DTO.VerboDTO;
import com.example.re_verb.persistencia.AlmacenVerbosSQLite;

public class IngresarPalabra extends Activity {
	public static final String NOMBRE_CLASE = "IngresarPalabra";
	
	private VerboDTO verbo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ingresar_palabra);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ingresar_palabra, menu);
		return true;
	}
	
	public VerboDTO getVerboDTO(){
		verbo = new VerboDTO();
		EditText infinitivo = (EditText)findViewById(R.id.editSimple);
		EditText simple = (EditText)findViewById(R.id.editText2);
		EditText participio = (EditText)findViewById(R.id.editText3);
		EditText significado = (EditText)findViewById(R.id.editText4);
		verbo.setInfinitivo(infinitivo.getText().toString());
		verbo.setPasadoSimple(simple.getText().toString());
		verbo.setPasadoParticipio(participio.getText().toString());
		verbo.setSignificado(significado.getText().toString());
		return verbo;
	}
	
	public void guardarVerbo(View view){
		AlmacenVerbosSQLite almacenVerbos = new AlmacenVerbosSQLite(this); 
		String resultado = almacenVerbos.guardarVerbo(getVerboDTO());
		TextView mensaje = (TextView)findViewById(R.id.resultadoInsersion);
		mensaje.setText(resultado);
		
		EditText infinitivo = (EditText)findViewById(R.id.editSimple);
		EditText simple = (EditText)findViewById(R.id.editText2);
		EditText participio = (EditText)findViewById(R.id.editText3);
		EditText significado = (EditText)findViewById(R.id.editText4);
		
		infinitivo.setText("");
		simple.setText("");
		participio.setText("");
		significado.setText("");
		
		System.out.println("palabra ingresa correctamente");
	}
	
	public void volver (View view){
		Intent i = new Intent(this, MainActivity.class);
		startActivity(i);
	}

}
