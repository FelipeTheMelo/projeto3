package br.com.melol.dao.generic.jdbc.dao;

import br.com.melol.domain.Produto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProdutoDAO implements IProdutoDAO {

    private Map<String, Produto> produtos = new HashMap<>();

    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        if (produtos.containsKey(produto.getCodigo())) {
            throw new Exception("Produto já cadastrado com esse código.");
        }
        produtos.put(produto.getCodigo(), produto);
        return 1; // sucesso
    }

    @Override
    public Integer atualizar(Produto produto) throws Exception {
        if (!produtos.containsKey(produto.getCodigo())) {
            throw new Exception("Produto não encontrado para atualizar.");
        }
        produtos.put(produto.getCodigo(), produto);
        return 1;
    }

    @Override
    public Produto buscar(String codigo) throws Exception {
        return produtos.get(codigo);
    }

    @Override
    public List<Produto> buscarTodos() throws Exception {
        return new ArrayList<>(produtos.values());
    }

    @Override
    public Integer excluir(Produto produto) throws Exception {
        if (!produtos.containsKey(produto.getCodigo())) {
            throw new Exception("Produto não encontrado para excluir.");
        }
        produtos.remove(produto.getCodigo());
        return 1;
    }
}
