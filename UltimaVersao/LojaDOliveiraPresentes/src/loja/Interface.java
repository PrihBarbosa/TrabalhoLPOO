package loja;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interface extends JFrame{
	
	private JPanel painel;
	private JFrame janela; // janela maior
	private JInternalFrame subJanela; // janela menor
	private JDesktopPane pane; //parte branca dentro da janela
	private JMenuBar menu; //barra do menu
	private JLabel barraDeStatus; // dados nas janelas
	private JTextField campo; // campo de texto
	private JButton botao; // botão cancelar ok
	private BorderLayout layout = new BorderLayout();
	
	
	/*Para testar a interface descomente aki*/
	/*
	public static void main(String[] args) {
		
		Interface janela = new Interface("Loja D'Oliveira Presentes");
		
	}*/
	
	public Interface(String title)
	{
		janela = new JFrame();
		janela.setTitle(title);
		janela.setSize(800, 600);
		janela.setBackground(Color.LIGHT_GRAY);
		janela.setLayout(layout);
		
		barraDeStatus = new JLabel();
		barraDeStatus.setText("Sou uma barra de status");
		
		painel = new JPanel();
		painel.setBackground(Color.DARK_GRAY);
		
		criarMenu();

		criarAbertura();
		
		//criarFormulario(); // Exemplo de formulario 
		
		janela.add(painel, layout.CENTER);
		janela.add(menu, layout.NORTH);
		janela.add(barraDeStatus, layout.SOUTH);
		
		janela.setVisible(true);
		janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
	}
	
	private void criarMenu(){
		menu = new JMenuBar();
		
		/*Ação para sair da interface*/
		NovoAction novoAction = new NovoAction();
		
		/*Menu Produto com suas opções*/
		JMenu produto = new JMenu("Produto");
		menu.add(produto);
		
		JMenuItem exibirP = new JMenuItem("Exibir");
		produto.add(exibirP);
		
		JMenuItem inserirP = new JMenuItem("Inserir");
		produto.add(inserirP);
		
		JMenuItem atualizarP = new JMenuItem("Atualizar");
		produto.add(atualizarP);
		
		JMenuItem removerP = new JMenuItem("Remover");
		produto.add(removerP);
		
		/*Menu Cliente com suas opções*/
		JMenu cliente = new JMenu("Cliente");
		menu.add(cliente);
		
		JMenuItem exibirCl = new JMenuItem("Exibir");
		cliente.add(exibirCl);
		
		JMenuItem inserirCl = new JMenuItem("Inserir");
		cliente.add(inserirCl);
		
		JMenuItem atualizarCl = new JMenuItem("Atualizar");
		cliente.add(atualizarCl);
		
		JMenuItem removerCl = new JMenuItem("Remover");
		cliente.add(removerCl);
		
		/*Menu Venda com suas opções*/
		JMenu venda = new JMenu("Venda");
		menu.add(venda);
		
		JMenuItem exibirV = new JMenuItem("Exibir");
		venda.add(exibirV);
		
		JMenuItem inserirV = new JMenuItem("Inserir");
		venda.add(inserirV);
		
		JMenuItem atualizarV = new JMenuItem("Atualizar");
		venda.add(atualizarV);
		
		JMenuItem removerV = new JMenuItem("Remover");
		venda.add(removerV);
		
		/*Menu Caixa com suas opções*/
		JMenu caixa = new JMenu("Caixa");
		menu.add(caixa);
		
		JMenuItem exibirC = new JMenuItem("Exibir");
		caixa.add(exibirC);
		
		JMenuItem inserirC = new JMenuItem("Inserir");
		caixa.add(inserirC);
		
		JMenuItem atualizarC = new JMenuItem("Atualizar");
		caixa.add(atualizarC);
		
		JMenuItem removerC = new JMenuItem("Remover");
		caixa.add(removerC);
		
		/*Menu Sair para sair da interface*/
		JMenuItem sair = new JMenuItem("Sair");
		menu.add(sair);
		sair.addActionListener(novoAction);
		
	}
	
	private class NovoAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
		
	}
	
	private void criarAbertura() {
		
		setLayout(layout);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new FlowLayout());
		
		JLabel titulo = new JLabel("BEM VINDO!");
		titulo.setFont(new Font("Verdana", Font.PLAIN, 40));
		
		panelTitulo.add(titulo);
		
		janela.add(panelTitulo, BorderLayout.CENTER);
	}

	/*
	private void criarFormulario() {
		setLayout(layout);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new FlowLayout());
		
		JLabel titulo = new JLabel("Produtos");
		titulo.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		panelTitulo.add(titulo);
		
		JPanel panelProduto = new JPanel();
		panelProduto.setLayout(new FlowLayout());
		
		JLabel nomeLabel = new JLabel("Nome");
		JTextField nomeField = new JTextField(40);
		
		JLabel telLabel = new JLabel("Telefone");
		JTextField telField = new JTextField(20);
		
		panelProduto.add(nomeLabel);
		panelProduto.add(nomeField);
		panelProduto.add(telLabel);
		panelProduto.add(telField);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());
		
		JButton botaoSalvar = new JButton("Salvar");
		JButton botaoFechar = new JButton("Fechar");
		
		panelBotoes.add(botaoSalvar);
		panelBotoes.add(botaoFechar);
		
		janela.add(panelTitulo, BorderLayout.NORTH);
		janela.add(panelProduto, BorderLayout.CENTER);
		janela.add(panelBotoes, BorderLayout.PAGE_END);
		
		
	}*/
	
}