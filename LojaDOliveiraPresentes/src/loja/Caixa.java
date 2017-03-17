package loja;

public class Caixa {

	private Venda venda;
	private Integer codCaixa;
	private boolean aberturaDeCaixa;
	private Double valorAbertura;
	private Double valorFechamento;
	
	public Caixa( Integer cod, Double valorAbert, Double valorFech) {
		super();
		abrirCaixa(valorAbert);
		setValorFechamento(0.0);
	}
	
	public void abrirCaixa(double valor){
		valorAbertura = valor;
		aberturaDeCaixa = true;
	}
	
	public void fecharCaixa(double valor){
		valorFechamento = valor;
		aberturaDeCaixa=false;
	}
	
	public boolean estaAberto(){
		return aberturaDeCaixa;
	}
	
	public boolean conferenciaDeCaixa(){
		if (valorFechamento == (valorAbertura + venda.calculoVenda()))
			return true;
		return false;
	}

	public Integer getCodCaixa() {
		return codCaixa;
	}

	public void setCodCaixa(Integer codCaixa) {
		this.codCaixa = codCaixa;
	}

	public Double getValorAbertura() {
		return valorAbertura;
	}

	public void setValorAbertura(Double valorAbertura) {
		this.valorAbertura = valorAbertura;
	}

	public Double getValorFechamento() {
		return valorFechamento;
	}

	public void setValorFechamento(Double valorFechamento) {
		this.valorFechamento = valorFechamento;
	}
	
	
	
	
}