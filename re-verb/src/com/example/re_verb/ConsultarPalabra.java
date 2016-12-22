package com.example.re_verb;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.re_verb.DTO.VerboDTO;
import com.example.re_verb.persistencia.AlmacenVerbosSQLite;

public class ConsultarPalabra extends Activity {

	private List<VerboDTO> lista ;
	
	private int posicion;
	 
	private boolean bandera=true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_consultar_palara);
		AlmacenVerbosSQLite almacen = new AlmacenVerbosSQLite(this);
		lista = almacen.consultarListaVerbos();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.consultar_palara, menu);
		return true;
	}
	
	public void siguiente(View view){
		if(bandera){
			
			TextView infinitivo = (TextView)findViewById(R.id.textInfinitivo);
			TextView lableParticipio = (TextView)findViewById(R.id.textRespuestaParticipio);
			TextView lableSimple = (TextView)findViewById(R.id.textRespuestaSimple);
			TextView lableSignificado = (TextView)findViewById(R.id.textSignificado);
			EditText edicionSimple = (EditText)findViewById(R.id.editSimple);
			EditText edicionParticipio = (EditText)findViewById(R.id.editParticipio);
			
			lableParticipio.setText("");
			lableSimple.setText("");
			lableSignificado.setText("");
			infinitivo.setText("");
			edicionSimple.setText("");
			edicionParticipio.setText("");
			
			int numeroVerbos = lista.size();
			if (numeroVerbos != 0) {
				posicion = (int) (Math.random() * numeroVerbos);
				VerboDTO verbo = lista.get(posicion);
				infinitivo.setText(verbo.getInfinitivo());
			}else {
				lableSignificado.setText("Se ha terminado la lista de verbos!!!");
			}
			bandera=false;
		}
		
	}
	
	public void validarRespuesta(View view){
		if(!bandera){
			
			VerboDTO verbo = lista.get(posicion);
			TextView lableParticipio = (TextView)findViewById(R.id.textRespuestaParticipio);
			TextView lableSimple = (TextView)findViewById(R.id.textRespuestaSimple);
			TextView lableSignificado = (TextView)findViewById(R.id.textSignificado);
			
			lableParticipio.setText(verbo.getPasadoParticipio());
			lableSimple.setText(verbo.getPasadoSimple());
			lableSignificado.setText(verbo.getSignificado());
			
			lista.remove(posicion);
			bandera=true;
		}
		
	}

}
