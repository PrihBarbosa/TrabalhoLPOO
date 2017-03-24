package loja;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClienteDao {

    private GenericDao genericDao;

    /* Construtor que recebe o endereco do arquivo de banco de dados SQLite*/
    public ClienteDao() throws SQLException {
        genericDao = new GenericDao("Cliente");
    }

    /* Metodo all, que retorna um objeto ArrayList<Cliente> contendo todas as linhas da tabela Cliente 
	 * Esse metodo lanca a excecao SQLException caso haja algum problema no decorrer da consulta ao banco de dados */
    public ArrayList<Cliente> all() throws SQLException {
        ArrayList<Cliente> cliente = new ArrayList<Cliente>();
        ArrayList<String> resultado;
        String array[] = new String[50];
        resultado = genericDao.all();
        for (int i = 0; i < resultado.size(); i++) {
            array = resultado.get(i).split(",");
            Cliente clientes = new Cliente(Integer.parseInt(array[0]), array[1], array[2], array[3]);
            cliente.add(clientes);
        }
        return cliente;
    }

    /* Metodo findyBy, que retorna um ArrayList<Cliente> contendo todas as linhas da tabela 
	 * que atende a uma determinada condicao. Esse metodo recebe um objeto Map sendo cada par: 
	 * uma chave que representa a coluna da tabela e um valor que representa o valor que se 
	 * espera nessa coluna, esse par expressa uma condicao a ser atendida. Esse metodo lanca 
	 * a excecao SQLException caso haja algum problema no decorrer da consulta ao banco de dados */
    public ArrayList<Cliente> findBy(Map<String, Object> mapping) throws SQLException {
        ArrayList<Cliente> cliente = new ArrayList<Cliente>();
        ArrayList<String> resultado;
        String array[] = new String[50];
        resultado = genericDao.findBy(mapping);
        for (int i = 0; i < resultado.size(); i++) {
            array = resultado.get(i).split(",");
            Cliente clientes = new Cliente(Integer.parseInt(array[0]), array[1], array[2], array[3]);
            cliente.add(clientes);
        }
        return cliente;
    }

    /* Metodo insert, que insere uma linha na tabela. Esse metodo recebe um objeto Cliente
	 * e retorna true caso a insercao foi realizada corretamente e false caso contrario */
    public boolean insert(Cliente cliente) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            ArrayList<String> busca;
            map.put("nome_Cliente", cliente.getNome());
            map.put("end_cliente", cliente.getEndereco());
            map.put("email_cliente", cliente.getEmail());
            busca = genericDao.findBy(map);
            map.clear();
            if (busca.size() == 0) {
                map.put("nome_Cliente", cliente.getNome());
                map.put("end_cliente", cliente.getEndereco());
                map.put("email_cliente", cliente.getEmail());
                return genericDao.insert(map);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /* Metodo remove, que remove uma linha na tabela. Esse metodo recebe um objeto Cliente e
	 * retorna true caso a remocao foi realizada corretamente e false caso contrario */
    public boolean remove(Cliente cliente) {
        try {
            GenericDao genericDao = new GenericDao("Cliente");
            Map<String, Object> map = new HashMap<String, Object>();

            if (cliente.getCodCliente() != null) {
                map.put("cod_cliente", cliente.getCodCliente());
            }
            if (cliente.getNome() != null) {
                map.put("nome_cliente", cliente.getNome());
            }
            if (cliente.getEndereco() != null) {
                map.put("end_cliente", cliente.getEndereco());
            }
            if (cliente.getEmail() != null) {
                map.put("email_cliente", cliente.getEmail());
            }

            return genericDao.remove(map);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /* Metodo update, que atualiza uma linha na tabela. Esse metodo recebe um objeto Cliente com um cod_Cliente,
	 * e cada campo desse objeto representa os novos valores da linha com esse cod_Cliente no banco de dados.
	 * Esse metodo retorna true caso a atualizacao do Cliente recebida foi realizada corretamente e false caso contrario */
    public boolean update(Cliente cliente) {
        Map<String, Object> novos = new HashMap<String, Object>();
        Map<String, Object> condicao = new HashMap<String, Object>();

        if (cliente.getNome() != null) {
            novos.put("nome_cliente", cliente.getNome());
        }
        if (cliente.getEndereco() != null) {
            novos.put("end_cliente", cliente.getEndereco());
        }
        if (cliente.getEmail() != null) {
            novos.put("email_cliente", cliente.getEmail());
        }

        condicao.put("cod_cliente", cliente.getCodCliente());
        return genericDao.update(condicao, novos);
    }
}
