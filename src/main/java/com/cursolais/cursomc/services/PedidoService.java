package com.cursolais.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursolais.cursomc.domain.Pedido;
import com.cursolais.cursomc.repositories.PedidoRepository;
import com.cursolais.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID: "+ id + ", Tipo:" + Pedido.class.getName());
		}
		return obj.get();
		//return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id:"+ id + " Tipo:"+ Pedido.class.getName()));
	}

}
