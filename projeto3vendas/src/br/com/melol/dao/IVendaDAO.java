package br.com.melol.dao;

import br.com.melol.dao.generic.IGenericDAO;
import br.com.melol.domain.Venda;
import br.com.melol.exceptions.DAOException;
import br.com.melol.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}