package com.cursolais.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursolais.cursomc.domain.Categoria;
import com.cursolais.cursomc.repositories.CategoriaRepository;
import com.cursolais.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID: "+ id + ", Tipo:" + Categoria.class.getName());
		}
		return obj.get();
		//return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id:"+ id + " Tipo:"+ Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

}
