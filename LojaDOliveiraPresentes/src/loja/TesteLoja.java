package loja;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Main */
public class TesteLoja {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		try {
			Config.setUrl("/home/priscila/workspace/LojaDOliveiraPresentes/bd/LojaD'OliveiraPresentesData.sqlite"); /* Modificar aqui o endereco do banco*/
			Map<String, Object> map = new HashMap<String, Object>();
			
			GenericDao genericDao;
			CaixaDao caixaDao = new CaixaDao();
			ProdutoDao produtoDao = new ProdutoDao();
			VendaDao vendaDao = new VendaDao();
			
			ArrayList<Caixa> caixas;
			ArrayList<Produto> produtos;
			ArrayList<Venda> vendas;
			
			Caixa caixa;
			Produto produto;
			Venda venda;
			
			Scanner scanner = new Scanner(System.in);
			int opcao;
			int valor;
			int option;
			String nome;
			double valorA;

			do {
				Menu.initialMenu();
				opcao = scanner.nextInt();

				switch (opcao) {
				
				/*Exibir*/
				case 1:
					Menu.getSubMenu(0);
					opcao = scanner.nextInt();

					/* Exibe informacoes da tabela Caixa */
					if (opcao == 1) {
						System.out.println("Para exibir informacoes de um caixa 1: ");
						System.out.println("Para exibir informacoes de todos os caixas digite 2: ");
						valor = scanner.nextInt();

						/* Opcao de exibir um caixa especifico */
						if (valor == 1) {
							System.out.println("\nDigite o valor de abertura do caixa: ");
							//scanner.nextLine();
							valorA = scanner.nextDouble();
							//nome = scanner.nextLine();
							map.clear();
							map.put("valor_abertura", valorA);
							caixas = caixaDao.findBy(map);
							for (int i = 0; i < caixas.size(); i++) {
								System.out.println("\nInformacao do caixa: \n");
								System.out.println("Codigo: " + caixas.get(i).getCodCaixa());
								System.out.println("Valor de Abertura: " + caixas.get(i).getValorAbertura());
								System.out.println("Valor de Fechamento: " + caixas.get(i).getValorFechamento());
								
							}

							/* Opcao de voltar */
							System.out.println("\nGostaria de realizar mais alguma operacao?\n1 - Sim  2 - Nao\nOpcao: ");
							
							option = scanner.nextInt();
							if (option == 1)
								opcao = -1;
						}

						/* Opcao de exibir todos os caixas */
						if (valor == 2) {
							caixas = caixaDao.all();
						System.out.println("\nInformacao de todos os caixas: \n");
							for (int i = 0; i < caixas.size(); i++) {
								System.out.println("Codigo: " + caixas.get(i).getCodCaixa());
								System.out.println("Valor de Abertura: " + caixas.get(i).getValorAbertura());
								System.out.println("Valor de Fechamento: " + caixas.get(i).getValorFechamento());	
							}
							
							/* Opcao de voltar */
							System.out.println("Gostaria de realizar mais alguma operacao?\n1 - Sim 2 - Nao\nOpcao: ");
							option = scanner.nextInt();
							if (option == 1)
								opcao = -1;
						}

					}
					
				default:
					Menu.menuError();
					opcao = -1;
					break;
				}
				
			} while (opcao == -1);
			
			scanner.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}