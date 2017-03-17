package loja;

import java.util.Date;

public class Venda {
	
	private Integer codVenda;
	private Produto[] produtos;	//nome, categoria, precoUnitario, codigoproduto, des
	private Integer quantidade;
	private Double valorTotal;
	//private GerenciadorProduto acessoProdutos;
	
	public Venda(Integer codigoVenda, Integer quantidade,
			Double valorTotal) {
		super();
		this.codVenda = codigoVenda;
		this.quantidade = quantidade;
		this.valorTotal = valorTotal;
	}

	public Integer getCodigoVenda() {
		return codVenda;
	}

	public void setCodigoVenda(Integer codigoVenda) {
		this.codVenda = codigoVenda;
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
	

	public double calculoVenda(){
		return 1.0;
		
	}
}
