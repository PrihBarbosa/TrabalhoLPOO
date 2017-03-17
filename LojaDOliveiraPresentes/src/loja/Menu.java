package loja;

import java.util.ArrayList;

/* Menu */
public class Menu {
	private static ArrayList<String> menu = new ArrayList<String>();
	
	public static void initialMenu()
	{
		String message = "";
		message = message+"==================================================\n"+
		"Sistema da Loja D'OliveiraPresentes\n"+
		"=====================================================\n"+
		"Selecione uma das Opcoes:\n"+
		"1 - Exibir\n"+
		"2 - Inserir\n"+
		"3 - Atualizar\n"+
		"4 - Remover\n"+
		"Opcao: ";
		System.out.print(message);
	}
	
	public static void getSubMenu(int i)
	{
		menu.add("\n==================================================\n"+
				"Exibir\n"+
				"==================================================\n"+
				"Selecione uma das Opcoes:\n"+
				"1 - Exibir informacoes de caixa\n"+
				"2 - Exibir informacoes de produtos\n"+
				"3 - Exibir informacoes de venda\n"+
				"Opcao: "
				);
		menu.add("\n==================================================\n"+
				"Inserir\n"+
				"==================================================\n"+
				"Selecione uma das Opcoes:\n"+
				"1 - Novo caixa\n"+
				"2 - Novo produto\n"+
				"3 - Nova venda\n"+
				"Opcao: "
				);
		menu.add("\n==================================================\n"+
				"Atualizar\n"+
				"==================================================\n"+
				"Selecione uma das Opcoes:\n"+
				"1 - Atualizar dados de um caixa\n"+
				"2 - Atualizar dados de um produto\n"+
				"3 - Atualizar dados de uma venda\n"+
				"Opcao: "
				);
		menu.add("\n==================================================\n"+
				"Remover\n"+
				"==================================================\n"+
				"Selecione uma das Opcoes:\n"+
				"1 - Remover um caixa\n"+
				"2 - Remover uma produto\n"+
				"3 - Remover uma venda\n"+
				"Opcao: "
				);
		
		if(i<0 || i >4)
		{
			menuError();
			menu.clear();
		}
		else
		{
			System.out.println(menu.get(i));
			menu.clear();
		}
	}
	public static void menuError()
	{
		System.out.println("Opcao Invalida");
	}
	
}
