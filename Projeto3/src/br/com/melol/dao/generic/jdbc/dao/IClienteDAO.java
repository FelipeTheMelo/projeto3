package br.com.melol.dao.generic.jdbc.dao;

import java.util.List;

import br.com.melol.domin.Cliente;

public interface IClienteDAO {

    public Integer cadastrar(Cliente cliente) throws Exception;

    public Integer atualizar(Cliente cliente) throws Exception;

    public Cliente buscar(String codigo) throws Exception;

    public List<Cliente> buscarTodos() throws Exception;

    public Integer excluir(Cliente cliente) throws Exception;
}