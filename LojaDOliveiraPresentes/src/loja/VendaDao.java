package loja;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Classe VendaDao que implementa as operacoes basicas na tabela Venda,
 * essa classe esta relacionada com a GenericDao utilizando composicao */
public class VendaDao {

	private GenericDao genericDao;
	
	/* Construtor que recebe o endereco do arquivo de banco de dados SQLite*/
	public VendaDao() throws SQLException
	{
		genericDao = new GenericDao("Venda");
	}

	/* Metodo all, que retorna um objeto ArrayList<Venda> contendo todas as linhas da tabela Venda 
	 * Esse metodo lanca a excecao SQLException caso haja algum problema no decorrer da consulta ao banco de dados */
	public ArrayList<Venda> all() throws SQLException
	{
		ArrayList<Venda> venda = new ArrayList<Venda>();
		ArrayList<String> resultado;
		String array[] = new String[4];
		resultado = genericDao.all();
		for(int i=0; i<resultado.size(); i++)
		{
			array = resultado.get(i).split(",");
			Venda vendas = new Venda(Integer.parseInt(array[0]), Integer.parseInt(array[1]), Double.parseDouble(array[2]));
			venda.add(vendas);
		}
		return venda;
	}

	/* Metodo findyBy, que retorna um ArrayList<Venda> contendo todas as linhas da tabela 
	 * que atende a uma determinada condicao. Esse metodo recebe um objeto Map sendo cada par: 
	 * uma chave que representa a coluna da tabela e um valor que representa o valor que se 
	 * espera nessa coluna, esse par expressa uma condicao a ser atendida. Esse metodo lanca 
	 * a excecao SQLException caso haja algum problema no decorrer da consulta ao banco de dados */
	public ArrayList<Venda> findBy(Map<String, Object> mapping) throws SQLException
	{
		ArrayList<Venda> venda = new ArrayList<Venda>();
		ArrayList<String> resultado;
		String array[] = new String[4];
		resultado = genericDao.findBy(mapping);
		for(int i=0; i<resultado.size(); i++)
		{
			array = resultado.get(i).split(",");
			Venda vendas = new Venda(Integer.parseInt(array[0]), Integer.parseInt(array[1]), Double.parseDouble(array[2]));
			venda.add(vendas);
		}
		return venda;
	}

	/* Metodo insert, que insere uma linha na tabela. Esse metodo recebe um objeto Venda
	 * e retorna true caso a insercao foi realizada corretamente e false caso contrario */
	public boolean insert(Venda venda)
	{
		try{
			Map<String, Object> map = new HashMap<String, Object>();
			ArrayList<String> busca;
			map.put("qnt_produtos", venda.getQuantidade());
			map.put("valor_total", venda.getValorTotal());
			busca = genericDao.findBy(map);
			map.clear();
			if(busca.size() == 0)
			{
				map.put("qnt_produtos", venda.getQuantidade());
				map.put("valor_total", venda.getValorTotal());
				return genericDao.insert(map);
			}
			
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	/* Metodo remove, que remove uma linha na tabela. Esse metodo recebe um objeto Venda e
	 * retorna true caso a remocao foi realizada corretamente e false caso contrario */
	public boolean remove(Venda venda)
	{
		try{
			GenericDao genericDao = new GenericDao("Venda");
			Map<String, Object> map = new HashMap<String, Object>();
			
			if(venda.getCodigoVenda() != null)
				map.put("cod_venda", venda.getCodigoVenda());
			if(venda.getQuantidade() != null)
				map.put("qnt_produtos", venda.getQuantidade());
			if(venda.getValorTotal() != null)
				map.put("valor_total", venda.getValorTotal());
			
			return genericDao.remove(map);
			
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	/* Metodo update, que atualiza uma linha na tabela. Esse metodo recebe um objeto Venda com um cod_Venda,
	 * e cada campo desse objeto representa os novos valores da linha com esse cod_venda no banco de dados.
	 * Esse metodo retorna true caso a atualizacao da venda recebida foi realizada corretamente e false caso contrario */
	public boolean update(Venda venda)
	{
		Map<String, Object> novos = new HashMap<String, Object>();
		Map<String, Object> condicao = new HashMap<String, Object>();
		
		if(venda.getQuantidade() != null)
			novos.put("qnt_produtos", venda.getQuantidade());
		if(venda.getValorTotal() != null)
			novos.put("valor_total", venda.getValorTotal());
		
		
		condicao.put("cod_Venda", venda.getCodigoVenda());
		return genericDao.update(condicao, novos);
	}
}
