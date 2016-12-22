package com.example.re_verb.persistencia;

import java.util.List;

import com.example.re_verb.DTO.VerboDTO;

public interface AlmacenVerbos {
	
	public String guardarVerbo(VerboDTO verbo);
	
	public List<VerboDTO> listaVerbos (int cantidad);

}
