package loja;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Caixa {

    private Integer codCaixa;
    private String dataCaixa;
    private Double valorA;
    private ClienteDao clienteDao;
    private VendaDao vendaDao;
    private GenericDao generico;

    public Caixa(Integer cod, String data) {
        super();
        setCodCaixa(cod);
        setDataCaixa(data);
    }

    public Caixa(String data) {
        super();
        setDataCaixa(data);
    }
    /*
    public Caixa(Integer cod, Double valor) {
        super();
        setCodCaixa(cod);
        setValorA(valor);
    }

    public Caixa(Double valor) {
        super();
        setValorA(valor);
    }*/

    public Integer getCodCaixa() {
        return codCaixa;
    }

    public void setCodCaixa(Integer codCaixa) {
        this.codCaixa = codCaixa;
    }
    
    

    /*
    public Double getValorA() {
        return valorA;
    }

    public void setValorA(Double valor) {
        valorA = valor;
    }*/

    public String getDataCaixa() {
		return dataCaixa;
	}

	public void setDataCaixa(String dataCaixa) {
		this.dataCaixa = dataCaixa;
	}

	/* Metodo getCliente, que retorna um ArrayList<Cliente> contendo todos os clientes do Caixa */
    public ArrayList<Cliente> getClientes() throws SQLException {
        ArrayList<String> resultado = new ArrayList<String>();
        clienteDao = new ClienteDao();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        generico = new GenericDao("ClienteCaixa");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("cod_caixa", this.codCaixa);
        resultado = generico.findBy(map);
        String chave[] = new String[20];
        for (int i = 0; i < resultado.size(); i++) {
            chave = resultado.get(i).split(",");
            map.clear();
            map.put("cod_cliente", chave[1]);
            clientes.add(clienteDao.findBy(map).get(0));
        }
        return clientes;
    }

    /* Metodo getVenda, que retorna um ArrayList<Venda> contendo todas as vendas do Caixa */
    public ArrayList<Venda> getVendas() throws SQLException {
        vendaDao = new VendaDao();
        ArrayList<Venda> vendas = new ArrayList<Venda>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("cod_caixa", this.codCaixa);
        vendas = vendaDao.findBy(map);
        return vendas;

    }

}
