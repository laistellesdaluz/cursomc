package com.cursolais.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursolais.cursomc.domain.Cliente;
import com.cursolais.cursomc.repositories.ClienteRepository;
import com.cursolais.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID: "+ id + ", Tipo:" + Cliente.class.getName());
		}
		return obj.get();
		//return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id:"+ id + " Tipo:"+ Cliente.class.getName()));
	}

}
