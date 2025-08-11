package br.com.melol.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.melol.dao.generic.GenericDAO;
import br.com.melol.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

    public ClienteDAO() {
        super();
    }

    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualiarDados(Cliente entity, Cliente entityCadastrado) {
        entityCadastrado.setCidade(entity.getCidade());
        entityCadastrado.setCpf(entity.getCpf());
        entityCadastrado.setEndereco(entity.getEndereco());
        entityCadastrado.setEstado(entity.getEstado());
        entityCadastrado.setNome(entity.getNome());
        entityCadastrado.setNumero(entity.getNumero());
        entityCadastrado.setTelefone(entity.getTelefone());
        entityCadastrado.setDataNascimento(entity.getDataNascimento()); // novo campo
    }

    @Override
    protected String getQueryInsercao() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO TB_CLIENTE ");
        sb.append("(ID, NOME, CPF, TEL, ENDERECO, NUMERO, CIDADE, ESTADO, DATA_NASCIMENTO) ");
        sb.append("VALUES (nextval('sq_cliente'),?,?,?,?,?,?,?,?)");
        return sb.toString();
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stmInsert, Cliente entity) throws SQLException {
        stmInsert.setString(1, entity.getNome());
        stmInsert.setString(2, entity.getCpf());
        stmInsert.setString(3, entity.getTelefone());
        stmInsert.setString(4, entity.getEndereco());
        stmInsert.setString(5, entity.getNumero());
        stmInsert.setString(6, entity.getCidade());
        stmInsert.setString(7, entity.getEstado());
        stmInsert.setDate(8, entity.getDataNascimento() != null ? Date.valueOf(entity.getDataNascimento()) : null); // novo campo
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM TB_CLIENTE WHERE CPF = ?";
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stmExclusao, Long valor) throws SQLException {
        stmExclusao.setLong(1, valor);
    }

    @Override
    protected String getQueryAtualizacao() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE TB_CLIENTE ");
        sb.append("SET NOME = ?,");
        sb.append("TEL = ?,");
        sb.append("ENDERECO = ?,");
        sb.append("NUMERO = ?,");
        sb.append("CIDADE = ?,");
        sb.append("ESTADO = ?,");
        sb.append("DATA_NASCIMENTO = ? ");
        sb.append("WHERE CPF = ?");
        return sb.toString();
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Cliente entity) throws SQLException {
        stmUpdate.setString(1, entity.getNome());
        stmUpdate.setString(2, entity.getTelefone());
        stmUpdate.setString(3, entity.getEndereco());
        stmUpdate.setString(4, entity.getNumero());
        stmUpdate.setString(5, entity.getCidade());
        stmUpdate.setString(6, entity.getEstado());
        stmUpdate.setDate(7, entity.getDataNascimento() != null ? Date.valueOf(entity.getDataNascimento()) : null);
        stmUpdate.setString(8, entity.getCpf());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stmSelect, Long valor) throws SQLException {
        stmSelect.setLong(1, valor);
    }
}