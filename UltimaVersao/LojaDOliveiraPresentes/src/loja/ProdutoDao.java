package loja;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Classe ProdutoDao que implementa as operacoes basicas na tabela Produto,
 * essa classe esta relacionada com a GenericDao utilizando composicao */
public class ProdutoDao {

    private GenericDao genericDao;

    /* Construtor que recebe o endereco do arquivo de banco de dados SQLite*/
    public ProdutoDao() throws SQLException {
        genericDao = new GenericDao("Produto");
    }

    /* Metodo all, que retorna um objeto ArrayList<Produto> contendo todas as linhas da tabela Produto 
	 * Esse metodo lanca a excecao SQLException caso haja algum problema no decorrer da consulta ao banco de dados */
    public ArrayList<Produto> all() throws SQLException {
        ArrayList<Produto> produto = new ArrayList<Produto>();
        ArrayList<String> resultado;
        String array[] = new String[50];
        resultado = genericDao.all();
        for (int i = 0; i < resultado.size(); i++) {
            array = resultado.get(i).split(",");
            Produto produtos = new Produto(Integer.parseInt(array[0]), array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), array[4], Integer.parseInt(array[5]), array[6]);
            produto.add(produtos);
        }
        return produto;
    }

    /* Metodo findyBy, que retorna um ArrayList<Produto> contendo todas as linhas da tabela 
	 * que atende a uma determinada condicao. Esse metodo recebe um objeto Map sendo cada par: 
	 * uma chave que representa a coluna da tabela e um valor que representa o valor que se 
	 * espera nessa coluna, esse par expressa uma condicao a ser atendida. Esse metodo lanca 
	 * a excecao SQLException caso haja algum problema no decorrer da consulta ao banco de dados */
    public ArrayList<Produto> findBy(Map<String, Object> mapping) throws SQLException {
        ArrayList<Produto> produto = new ArrayList<Produto>();
        ArrayList<String> resultado;
        String array[] = new String[50];
        resultado = genericDao.findBy(mapping);
        for (int i = 0; i < resultado.size(); i++) {
            array = resultado.get(i).split(",");
            Produto produtos = new Produto(Integer.parseInt(array[0]), array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), array[4], Integer.parseInt(array[5]), array[6]);
            produto.add(produtos);
        }
        return produto;
    }

    /* Metodo insert, que insere uma linha na tabela. Esse metodo recebe um objeto Produto
	 * e retorna true caso a insercao foi realizada corretamente e false caso contrario */
    public boolean insert(Produto produto) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            ArrayList<String> busca;
            map.put("nome_produto", produto.getNome());
            map.put("preco_aquisicao", produto.getPrecoAquisicao());
            map.put("preco_unitario", produto.getPrecoUnitario());
            map.put("data_validade", produto.getDataValidade());
            map.put("quantidade", produto.getQuantidade());
            map.put("descricao", produto.getDescricao());
            busca = genericDao.findBy(map);
            map.clear();
            if (busca.size() == 0) {
                map.put("nome_produto", produto.getNome());
                map.put("preco_aquisicao", produto.getPrecoAquisicao());
                map.put("preco_unitario", produto.getPrecoUnitario());
                map.put("data_validade", produto.getDataValidade());
                map.put("quantidade", produto.getQuantidade());
                map.put("descricao", produto.getDescricao());
                return genericDao.insert(map);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /* Metodo remove, que remove uma linha na tabela. Esse metodo recebe um objeto Produto e
	 * retorna true caso a remocao foi realizada corretamente e false caso contrario */
    public boolean remove(Produto produto) {
        try {
            GenericDao genericDao = new GenericDao("Produto");
            Map<String, Object> map = new HashMap<String, Object>();

            if (produto.getCodigoProduto() != null) {
                map.put("cod_produto", produto.getCodigoProduto());
            }
            if (produto.getNome() != null) {
                map.put("nome_produto", produto.getNome());
            }
            if (produto.getPrecoAquisicao() != null) {
                map.put("preco_aquisicao", produto.getPrecoAquisicao());
            }
            if (produto.getPrecoUnitario() != null) {
                map.put("preco_unitario", produto.getPrecoUnitario());
            }
            if (produto.getDataValidade() != null) {
                map.put("data_validade", produto.getDataValidade());
            }
            if (produto.getQuantidade() != null) {
                map.put("quantidade", produto.getQuantidade());
            }
            if (produto.getDescricao() != null) {
                map.put("descricao", produto.getDescricao());
            }

            return genericDao.remove(map);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /* Metodo update, que atualiza uma linha na tabela. Esse metodo recebe um objeto Produto com um cod_produto,
	 * e cada campo desse objeto representa os novos valores da linha com esse cod_produto no banco de dados.
	 * Esse metodo retorna true caso a atualizacao do produto recebida foi realizada corretamente e false caso contrario */
    public boolean update(Produto produto) {
        Map<String, Object> novos = new HashMap<String, Object>();
        Map<String, Object> condicao = new HashMap<String, Object>();

        if (produto.getNome() != null) {
            novos.put("nome_produto", produto.getNome());
        }
        if (produto.getPrecoAquisicao() != null) {
            novos.put("preco_aquisicao", produto.getPrecoAquisicao());
        }
        if (produto.getPrecoUnitario() != null) {
            novos.put("preco_unitario", produto.getPrecoUnitario());
        }
        if (produto.getDataValidade() != null) {
            novos.put("data_validade", produto.getDataValidade());
        }
        if (produto.getQuantidade() != null) {
            novos.put("quantidade", produto.getQuantidade());
        }
        if (produto.getDescricao() != null) {
            novos.put("descricao", produto.getDescricao());
        }

        condicao.put("cod_produto", produto.getCodigoProduto());
        return genericDao.update(condicao, novos);
    }
}
