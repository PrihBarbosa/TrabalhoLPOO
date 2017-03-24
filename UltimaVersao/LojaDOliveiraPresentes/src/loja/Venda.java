package loja;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Venda {

    private Integer codVenda;
    private Integer codCaixa;
    private Integer quantidade;
    private Double valorTotal;
    private CaixaDao caixa;
    private ProdutoDao produtoDao;
    private GenericDao generico;
    
    public Venda(Integer codigoVenda, Integer quantidade,
            Double valorTotal) throws SQLException {
        super();
        setCodVenda(codigoVenda);
        setQuantidade(quantidade);
        setValorTotal(valorTotal);
        this.caixa = new CaixaDao();
    }
    
    public Venda(Integer quantidade,
            Double valorTotal) throws SQLException {
        super();
        setQuantidade(quantidade);
        setValorTotal(valorTotal);
        this.caixa = new CaixaDao();
    }
    /*
    public Venda(Integer codigoVenda, Integer codigoCaixa, Integer quantidade,
            Double valorTotal) throws SQLException {
        super();
        setCodVenda(codigoVenda);
        setCodCaixa(codigoCaixa);
        setQuantidade(quantidade);
        setValorTotal(valorTotal);
        this.caixa = new CaixaDao();
    }
    
    public Venda(Integer codigoCaixa, Integer quantidade,
            Double valorTotal) throws SQLException {
        super();
        setCodCaixa(codigoCaixa);
        setQuantidade(quantidade);
        setValorTotal(valorTotal);
        this.caixa = new CaixaDao();
    }*/

    public Integer getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(Integer codigoVenda) {
        this.codVenda = codigoVenda;
    }

    public Integer getCodCaixa() {
        return codCaixa;
    }

    public void setCodCaixa(Integer codigoCaixa) {
        this.codCaixa = codigoCaixa;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double calculoVenda() {
        return 1.0;

    }

    /* Metodo getCaixa, que retorna o Caixa associado a essa Venda. */
    public Caixa getCaixa() throws SQLException {
        Map<String, Object> map = new HashMap<String, Object>();
        ArrayList<Caixa> caixas = new ArrayList<Caixa>();
        map.put("cod_caixa", this.codCaixa);
        caixas = this.caixa.findBy(map);
        return caixas.get(0);
    }

    /* Metodo getProduto, que retorna um ArrayList<Produto> contendo todos os produtos da Venda */
    public ArrayList<Produto> getProdutos() throws SQLException {
        ArrayList<String> resultado = new ArrayList<String>();
        produtoDao = new ProdutoDao();
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        generico = new GenericDao("VendaProduto");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("cod_venda", this.codVenda);
        resultado = generico.findBy(map);
        String chave[] = new String[2];
        for (int i = 0; i < resultado.size(); i++) {
            chave = resultado.get(i).split(",");
            map.clear();
            map.put("cod_produto", chave[1]);
            produtos.add(produtoDao.findBy(map).get(0));
        }
        return produtos;
    }
}
