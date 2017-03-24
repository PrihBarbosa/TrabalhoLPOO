package loja;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cliente {

    private Integer codCliente;
    private String nome;
    private String endereco;
    private String email;
    private CaixaDao caixaDao;

    public Cliente(Integer cod, String nome, String endereco, String email) {
        super();
        setCodCliente(cod);
        setNome(nome);
        setEndereco(endereco);
        setEmail(email);
    }

    public Cliente(String nome, String endereco, String email) {
        super();
        setNome(nome);
        setEndereco(endereco);
        setEmail(email);
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /* Metodo getCaixas, que retorna um ArrayList<Caixa> contendo todos os caixas associados a esse cliente */
    public ArrayList<Caixa> getCaixas() throws SQLException {
        caixaDao = new CaixaDao();
        ArrayList<Caixa> caixas = new ArrayList<Caixa>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("cod_cliente", this.codCliente);
        caixas = caixaDao.findBy(map);
        return caixas;
    }
}
