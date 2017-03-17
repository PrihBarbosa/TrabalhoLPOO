package loja;


public class Produto {
	
	private Integer codigoProduto;
	private String nome;
	private Double precoAquisicao;
	private Double precoUnitario;
	private String dataValidade;
	private Integer quantidade;
	private String descricao;
	
	public Produto() {
		super();
	}
	
	

	public Produto(Integer codigoProduto, String nome,
			Double precoAquisicao, Double precoUnitario, String dataValidade,
			Integer quantidade, String descricao) {
		super();
		this.codigoProduto = codigoProduto;
		this.nome = nome;
		this.precoAquisicao = precoAquisicao;
		this.precoUnitario = precoUnitario;
		this.dataValidade = dataValidade;
		this.quantidade = quantidade;
		this.descricao = descricao;
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
	
	
}
