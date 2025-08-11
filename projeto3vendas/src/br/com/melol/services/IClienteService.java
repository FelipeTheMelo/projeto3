package br.com.melol.services;

import br.com.melol.domain.Cliente;
import br.com.melol.exceptions.DAOException;
import br.com.melol.exceptions.TipoChaveNaoEncontradaException;
import br.com.melol.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

    //	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
    Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
