package loja;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Produto {

    private Integer codigoProduto;
    private String nome;
    private Double precoAquisicao;
    private Double precoUnitario;
    private String dataValidade;
    private Integer quantidade;
    private String descricao;
    private VendaDao vendaDao;

    public Produto(Integer codigoProduto, String nome,
            Double precoAquisicao, Double precoUnitario, String dataValidade,
            Integer quantidade, String descricao) {
        super();
        setCodigoProduto(codigoProduto);
        setNome(nome);
        setPrecoAquisicao(precoAquisicao);
        setPrecoUnitario(precoUnitario);
        setDataValidade(dataValidade);
        setQuantidade(quantidade);
        setDescricao(descricao);
    }

    public Produto(String nome,
            Double precoAquisicao, Double precoUnitario, String dataValidade,
            Integer quantidade, String descricao) {
        super();
        setNome(nome);
        setPrecoAquisicao(precoAquisicao);
        setPrecoUnitario(precoUnitario);
        setDataValidade(dataValidade);
        setQuantidade(quantidade);
        setDescricao(descricao);
    }

    public Integer getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Integer codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrecoAquisicao() {
        return precoAquisicao;
    }

    public void setPrecoAquisicao(Double precoAquisicao) {
        this.precoAquisicao = precoAquisicao;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /* Metodo getVendas, que retorna um ArrayList<Venda> contendo todas as Vendas associadas a esse produto */
    public ArrayList<Venda> getVendas() throws SQLException {
        vendaDao = new VendaDao();
        ArrayList<Venda> vendas = new ArrayList<Venda>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("cod_produto", this.codigoProduto);
        vendas = vendaDao.findBy(map);
        return vendas;
    }

}
