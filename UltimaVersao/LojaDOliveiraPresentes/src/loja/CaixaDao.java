package loja;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Classe CaixaDao que implementa as operacoes basicas na tabela Caixa,
 * essa classe esta relacionada com a GenericDao utilizando composicao */
public class CaixaDao {

    private GenericDao genericDao;

    /* Construtor que recebe o endereco do arquivo de banco de dados SQLite*/
    public CaixaDao() throws SQLException {
        genericDao = new GenericDao("Caixa");
    }

    /* Metodo all, que retorna um objeto ArrayList<Caixa> contendo todas as linhas da tabela caixa
	 * Esse metodo lanca a excecao SQLException caso haja algum problema no decorrer da consulta ao banco de dados */
    public ArrayList<Caixa> all() throws SQLException {
        ArrayList<Caixa> caixa = new ArrayList<Caixa>();
        ArrayList<String> resultado;
        String array[] = new String[20];
        resultado = genericDao.all();
        for (int i = 0; i < resultado.size(); i++) {
            array = resultado.get(i).split(",");
            //Caixa caixas = new Caixa(Integer.parseInt(array[0]), Double.parseDouble(array[1]));
            Caixa caixas = new Caixa(Integer.parseInt(array[0]), array[1]);
            caixa.add(caixas);
        }
        return caixa;
    }
    

    /* Metodo findyBy, que retorna um ArrayList<Caixa> contendo todas as linhas da tabela 
	 * que atende a uma determinada condicao. Esse metodo recebe um objeto Map sendo cada par: 
	 * uma chave que representa a coluna da tabela e um valor que representa o valor que se 
	 * espera nessa coluna, esse par expressa uma condicao a ser atendida. Esse metodo lanca 
	 * a excecao SQLException caso haja algum problema no decorrer da consulta ao banco de dados */
    public ArrayList<Caixa> findBy(Map<String, Object> mapping) throws SQLException {
        ArrayList<Caixa> caixa = new ArrayList<Caixa>();
        ArrayList<String> resultado;
        String array[] = new String[20];
        resultado = genericDao.findBy(mapping);
        for (int i = 0; i < resultado.size(); i++) {
            array = resultado.get(i).split(",");
            Caixa caixas = new Caixa(Integer.parseInt(array[0]), array[1]);
            //Caixa caixas = new Caixa(Integer.parseInt(array[0]), Double.parseDouble(array[1]));
            
            caixa.add(caixas);
        }
        return caixa;
    }

    /* Metodo insert, que insere uma linha na tabela. Esse metodo recebe um objeto Caixa
	 * e retorna true caso a insercao foi realizada corretamente e false caso contrario */
    public boolean insert(Caixa caixa) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            ArrayList<String> busca;
            map.put("data_caixa", caixa.getDataCaixa());
            //map.put("valor_caixa", caixa.getValorA());
            busca = genericDao.findBy(map);
            map.clear();
            if (busca.size() == 0) {
            	//map.put("valor_caixa", caixa.getValorA());
                map.put("data_caixa", caixa.getDataCaixa());
                return genericDao.insert(map);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /* Metodo remove, que remove uma linha na tabela. Esse metodo recebe um objeto Caixa e
	 * retorna true caso a remocao foi realizada corretamente e false caso contrario */
    public boolean remove(Caixa caixa) {
        try {
            GenericDao genericDao = new GenericDao("Caixa");
            Map<String, Object> map = new HashMap<String, Object>();

            if (caixa.getCodCaixa() != null) {
                map.put("cod_caixa", caixa.getCodCaixa());
            }
            if (caixa.getDataCaixa() != null) {
                map.put("data_caixa", caixa.getDataCaixa());
            }
            /*
            if (caixa.getValorA() != null) {
                map.put("valor_caixa", caixa.getValorA());
            }*/

            return genericDao.remove(map);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /* Metodo update, que atualiza uma linha na tabela. Esse metodo recebe um objeto Caixa com um cod_caixa,
	 * e cada campo desse objeto representa os novos valores da linha com esse cod_caixa no banco de dados.
	 * Esse metodo retorna true caso a atualizacao do caixa recebida foi realizada corretamente e false caso contrario */
    public boolean update(Caixa caixa) {
        Map<String, Object> novos = new HashMap<String, Object>();
        Map<String, Object> condicao = new HashMap<String, Object>();
        if (caixa.getDataCaixa() != null) {
            novos.put("data_caixa", caixa.getDataCaixa());
        }
        /*
        if (caixa.getValorA() != null) {
            novos.put("valor_caixa", caixa.getValorA());
        }*/
        condicao.put("cod_caixa", caixa.getCodCaixa());
        return genericDao.update(condicao, novos);
    }
}
