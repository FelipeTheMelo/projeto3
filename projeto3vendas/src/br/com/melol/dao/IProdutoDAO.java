package br.com.melol.dao;

import br.com.melol.dao.generic.IGenericDAO;
import br.com.melol.domain.Produto;
import br.com.melol.exceptions.DAOException;
import br.com.melol.exceptions.MaisDeUmRegistroException;
import br.com.melol.exceptions.TableException;

public interface IProdutoDAO<S> extends IGenericDAO<Produto, String>{

    void excluir(E valor) throws DAOException;

    <T> T consultar(Object valor) throws MaisDeUmRegistroException, TableException, DAOException;
}