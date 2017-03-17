package loja;

/* Classe Config utilizada para configurar o endereco do banco de dados*/
public class Config {
	private static String urlDatabase;
	
	/* Metodos estaticos para setar o endereco e obter o endereco do banco*/
	public static String getUrl()
	{
		return urlDatabase;
	}
	public static void setUrl(String url)
	{
		urlDatabase = url;
	}
}