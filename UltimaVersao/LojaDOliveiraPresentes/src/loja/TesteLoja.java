package loja;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import loja.Caixa;
import loja.Produto;
import loja.GenericDao;
import loja.Menu;

/* Main */
public class TesteLoja {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
        	/* Modificar aqui o endereco do banco*/
            Config.setUrl("/home/priscila/workspace/LojaDOliveiraPresentes/bd/LojaD'OliveiraPresentesData.sqlite");
            
            Map<String, Object> map = new HashMap<String, Object>();

            GenericDao genericDao;
            CaixaDao caixaDao = new CaixaDao();
            ProdutoDao produtoDao = new ProdutoDao();
            VendaDao vendaDao = new VendaDao();
            ClienteDao clienteDao = new ClienteDao();

            ArrayList<Caixa> caixas;
            ArrayList<Produto> produtos;
            ArrayList<Venda> vendas;
            ArrayList<Cliente> clientes;

            Caixa caixa;
            Produto produto;
            Venda venda;
            Cliente cliente;

            Scanner scanner = new Scanner(System.in);
            int opcao;
            int valor;
            int option;
            boolean inscritos;
            String nome;
            String ent;

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

                            System.out.println("Para exibir informações de um caixa digite 1: ");
                            System.out.println("Para exibir informações de todos os caixas digite 2: ");
                            valor = scanner.nextInt();

                            /* Opcao de exibir um caixa especifico */
                            if (valor == 1) {
                                System.out.println("\nDigite a data do caixa: ");
                                scanner.nextLine();
                                ent = scanner.nextLine();
                                map.clear();
                                map.put("data_caixa", ent);
                                caixas = caixaDao.findBy(map);
                                for (int i = 0; i < caixas.size(); i++) {
                                    System.out.println("\nInformação do Caixa: \n");
                                    System.out.println("Codigo caixa: " + caixas.get(i).getCodCaixa());
                                    System.out.println("Data do caixa: " + caixas.get(i).getDataCaixa() + "\n");
                                }

                                /* Opcao de voltar */
                                System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                                option = scanner.nextInt();
                                if (option == 1) {
                                    opcao = -1;
                                }
                            }

                            /* Opcao de exibir todos os caixas */
                            if (valor == 2) {
                                caixas = caixaDao.all();
                                System.out.println("\nInformacao de todas os caixas: \n");
                                for (int i = 0; i < caixas.size(); i++) {

                                    System.out.println("Codigo caixa: " + caixas.get(i).getCodCaixa());
                                    System.out.println("Data do caixa: " + caixas.get(i).getDataCaixa() + "\n");
                                }

                                System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                                option = scanner.nextInt();
                                if (option == 1) {
                                    opcao = -1;
                                }
                            }
                        }

                        /* Exibe informacoes da tabela Produto */
                        if (opcao == 2) {
                            System.out.println("Para exibir informacoes de um produto digite 1: ");
                            System.out.println("Para exibir informacoes de todos os produtos digite 2: ");
                            valor = scanner.nextInt();

                            /* Opcao de exibir um produto especifico */
                            if (valor == 1) {
                                System.out.println("\nDigite o nome do produto: ");
                                scanner.nextLine();
                                nome = scanner.nextLine();
                                map.clear();
                                map.put("nome_produto", nome);
                                produtos = produtoDao.findBy(map);
                                for (int i = 0; i < produtos.size(); i++) {
                                    System.out.println("\nInformacao do produto: \n");
                                    System.out.println("Codigo: " + produtos.get(i).getCodigoProduto());
                                    System.out.println("Nome: " + produtos.get(i).getNome());
                                    System.out.println("Preço de aquisição: " + produtos.get(i).getPrecoAquisicao());
                                    System.out.println("Preço de unitario: " + produtos.get(i).getPrecoUnitario());
                                    System.out.println("Data de validade: " + produtos.get(i).getDataValidade());
                                    System.out.println("Quantidade: " + produtos.get(i).getQuantidade());
                                    System.out.println("Descrição: " + produtos.get(i).getDescricao()+ "\n");

                                }

                                /* Opcao de voltar */
                                System.out.println("\nGostaria de realizar mais alguma operacao?\n1 - Sim  2 - Nao\nOpcao: ");

                                option = scanner.nextInt();
                                if (option == 1) {
                                    opcao = -1;
                                }
                            }

                            /* Opcao de exibir todos os produtos */
                            if (valor == 2) {
                                produtos = produtoDao.all();
                                System.out.println("\nInformacao de todos os produtos: \n");
                                for (int i = 0; i < produtos.size(); i++) {
                                    System.out.println("\nInformacao do produto: \n");
                                    System.out.println("Codigo: " + produtos.get(i).getCodigoProduto());
                                    System.out.println("Nome: " + produtos.get(i).getNome());
                                    System.out.println("Preço de aquisição: " + produtos.get(i).getPrecoAquisicao());
                                    System.out.println("Preço de unitario: " + produtos.get(i).getPrecoUnitario());
                                    System.out.println("Data de validade: " + produtos.get(i).getDataValidade());
                                    System.out.println("Quantidade: " + produtos.get(i).getQuantidade());
                                    System.out.println("Descrição: " + produtos.get(i).getDescricao()+ "\n");
                                }

                                /* Opcao de voltar */
                                System.out.println("Gostaria de realizar mais alguma operacao?\n1 - Sim 2 - Nao\nOpcao: ");
                                option = scanner.nextInt();
                                if (option == 1) {
                                    opcao = -1;
                                }
                            }

                        }

                        /* Exibe informacoes da tabela Venda */
                        if (opcao == 3) {
                            Integer cod;
                            System.out.println("Para exibir informacoes de uma venda digite 1: ");
                            System.out.println("Para exibir informacoes de todas as vendas digite 2: ");
                            valor = scanner.nextInt();

                            /* Opcao de exibir uma venda especifico */
                            if (valor == 1) {
                                System.out.println("\nDigite o codigo da venda: ");
                                cod = scanner.nextInt();
                                map.clear();
                                map.put("cod_venda", cod);
                                vendas = vendaDao.findBy(map);
                                for (int i = 0; i < vendas.size(); i++) {
                                    System.out.println("\nInformacao da venda: \n");
                                    System.out.println("Codigo da venda: " + vendas.get(i).getCodVenda());
                                    //System.out.println("Codigo do caixa: " + vendas.get(i).getCodCaixa());
                                    System.out.println("Quantidade: " + vendas.get(i).getQuantidade());
                                    System.out.println("Valor total: " + vendas.get(i).getValorTotal()+ "\n");

                                }

                                /* Opcao de voltar */
                                System.out.println("\nGostaria de realizar mais alguma operacao?\n1 - Sim  2 - Nao\nOpcao: ");

                                option = scanner.nextInt();
                                if (option == 1) {
                                    opcao = -1;
                                }
                            }

                            /* Opcao de exibir todas as vendas */
                            if (valor == 2) {
                                vendas = vendaDao.all();
                                System.out.println("\nInformacao de todas as vendas: \n");
                                for (int i = 0; i < vendas.size(); i++) {
                                    System.out.println("\nInformacao da venda: \n");
                                    System.out.println("Codigo da venda: " + vendas.get(i).getCodVenda());
                                    //System.out.println("Codigo do caixa: " + vendas.get(i).getCodCaixa());
                                    System.out.println("Quantidade: " + vendas.get(i).getQuantidade());
                                    System.out.println("Valor total: " + vendas.get(i).getValorTotal()+ "\n");
                                }

                                /* Opcao de voltar */
                                System.out.println("Gostaria de realizar mais alguma operacao?\n1 - Sim 2 - Nao\nOpcao: ");
                                option = scanner.nextInt();
                                if (option == 1) {
                                    opcao = -1;
                                }
                            }

                        }

                        /* Exibe informacoes da tabela Cliente */
                        if (opcao == 4) {
                            System.out.println("Para exibir informacoes de um cliente digite 1: ");
                            System.out.println("Para exibir informacoes de todos os clientes digite 2: ");
                            valor = scanner.nextInt();

                            /* Opcao de exibir um cliente especifico */
                            if (valor == 1) {
                                System.out.println("\nDigite o nome do cliente: ");
                                scanner.nextLine();
                                nome = scanner.nextLine();
                                map.clear();
                                map.put("nome_cliente", nome);
                                clientes = clienteDao.findBy(map);
                                for (int i = 0; i < clientes.size(); i++) {
                                    System.out.println("\nInformacao do cliente: \n");
                                    System.out.println("Codigo: " + clientes.get(i).getCodCliente());
                                    System.out.println("Nome: " + clientes.get(i).getNome());
                                    System.out.println("Endereço: " + clientes.get(i).getEndereco());
                                    System.out.println("Email: " + clientes.get(i).getEmail()+ "\n");

                                }

                                /* Opcao de voltar */
                                System.out.println("\nGostaria de realizar mais alguma operacao?\n1 - Sim  2 - Nao\nOpcao: ");

                                option = scanner.nextInt();
                                if (option == 1) {
                                    opcao = -1;
                                }
                            }

                            /* Opcao de exibir todos os clientes */
                            if (valor == 2) {
                                clientes = clienteDao.all();
                                System.out.println("\nInformacao de todos os clientes: \n");
                                for (int i = 0; i < clientes.size(); i++) {
                                    System.out.println("Codigo: " + clientes.get(i).getCodCliente());
                                    System.out.println("Nome: " + clientes.get(i).getNome());
                                    System.out.println("Endereço: " + clientes.get(i).getEndereco());
                                    System.out.println("Email: " + clientes.get(i).getEmail()+ "\n");
                                }

                                /* Opcao de voltar */
                                System.out.println("Gostaria de realizar mais alguma operacao?\n1 - Sim 2 - Nao\nOpcao: ");
                                option = scanner.nextInt();
                                if (option == 1) {
                                    opcao = -1;
                                }
                            }

                        }

                        break;
                    /*Inserir*/
                    case 2:
                        Menu.getSubMenu(1);
                        opcao = scanner.nextInt();

                        /* Insere informacoes na tabela Caixa */
                        if (opcao == 1) {
                        	
                            System.out.println("\nDigite a data do caixa: ");
							scanner.nextLine();
                            ent = scanner.nextLine();

                            caixa = new Caixa(ent);
                            inscritos = caixaDao.insert(caixa);
                            map.clear();
                            map.put("data_caixa", ent);
                            caixa = caixaDao.findBy(map).get(0);
                            if (inscritos == true) {
                            	
                                int op;
                                do {
                                    clientes = clienteDao.all();
                                    System.out.println("CodCliente || Nome || Endereço || Email ");
                                    for (int i = 0; i < clientes.size(); i++) {
                                        System.out.println(clientes.get(i).getCodCliente() + " " + clientes.get(i).getNome() + " " + clientes.get(i).getEndereco() + " " + clientes.get(i).getEmail());
                                    }
                                    System.out.println("\nInforme o codigo do cliente a ser associado: ");
                                    int cod = scanner.nextInt();
                                    genericDao = new GenericDao("ClienteCaixa");
                                    map.clear();
                                    map.put("cod_caixa", caixa.getCodCaixa());
                                    map.put("cod_cliente", cod);
                                    genericDao.insert(map);
                                    map.clear();

                                    // Opcao de inserir mais clientes 
                                    System.out.println("Gostaria de inserir mais clientes? 1-Sim\n2-Nao\n");
                                    op = scanner.nextInt();
                                } while (op == 1);
                                System.out.println("\nInserido com sucesso!\n");
                                
                            } else {
                                System.out.println("\nFalha ao inserir, tente novamente!\n");
                            }

                            /* Opcao de voltar */
                            System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                            option = scanner.nextInt();
                            if (option == 1) {
                                opcao = -1;
                            }
                        }

                        /* Insere informacoes na tabela Produto */
                        if (opcao == 2) {

                            Double precoAquisicao;
                            Double precoUnitario;
                            String dataValidade;
                            Integer quantidade;
                            String descricao;

                            System.out.println("\nDigite o nome do produto: ");
                            scanner.nextLine();
                            nome = scanner.nextLine();
                            System.out.println("\nDigite o preco de aquisição do produto: ");
                            precoAquisicao = scanner.nextDouble();
                            System.out.println("\nDigite o preco unitario do produto: ");
                            precoUnitario = scanner.nextDouble();
                            System.out.println("\nDigite a data de Validade do produto:");
                            scanner.nextLine();
                            dataValidade = scanner.nextLine();
                            System.out.println("\nDigite a quantidade do produto:");
                            quantidade = scanner.nextInt();
                            System.out.println("\nDigite a descricao do produto:");
                            scanner.nextLine();
                            descricao = scanner.nextLine();

                            produto = new Produto(nome, precoAquisicao, precoUnitario, dataValidade, quantidade, descricao);

                            inscritos = produtoDao.insert(produto);
                            if (inscritos == true) {
                                System.out.println("\nInserido com sucesso!\n");
                            } else {
                                System.out.println("\nFalha ao inserir, tente novamente!\n");
                            }

                            /* Opcao de voltar */
                            System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                            option = scanner.nextInt();
                            if (option == 1) {
                                opcao = -1;
                            }
                        }

                        /* Insere informacoes na tabela Venda */
                        if (opcao == 3) {
                            Double valorTotal;
                            Integer quantProdutos;
                            Integer codCaixa;

                            caixas = caixaDao.all();
                            System.out.println("\n");
                            for (int i = 0; i < caixas.size(); i++) {
                            	System.out.println("CodCaixa || DataCaixa ");
                                System.out.println("Codigo do caixa: " + caixas.get(i).getCodCaixa()
                                        + " Data do caixa: " + caixas.get(i).getDataCaixa() + "\n");
                            }
                            System.out.println("Escolha um caixa pelo codigo: ");
                            codCaixa = scanner.nextInt();

                            System.out.println("\nDigite a quantidade de produtos: ");
                            quantProdutos = scanner.nextInt();
                            System.out.println("\nDigite o valor total: ");
                            valorTotal = scanner.nextDouble();

                            venda = new Venda(quantProdutos, valorTotal);

                            inscritos = vendaDao.insert(venda);
                            map.clear();
                            map.put("qnt_produtos", quantProdutos);
                            venda = vendaDao.findBy(map).get(0);
                            if (inscritos == true) {
                                int op;
                                do {
                                    produtos = produtoDao.all();
                                    System.out.println("CodProduto || Nome || PreçoUnitario || Quantidade");
                                    for (int i = 0; i < produtos.size(); i++) {
                                        System.out.println(produtos.get(i).getCodigoProduto() + " " + produtos.get(i).getNome() + " " + produtos.get(i).getPrecoUnitario() + " " + produtos.get(i).getQuantidade());

                                    }
                                    System.out.println("Informe o codigo do produto a ser adicionado na venda");
                                    int cod = scanner.nextInt();
                                    genericDao = new GenericDao("VendaProduto");
                                    map.clear();
                                    map.put("cod_venda", venda.getCodVenda());
                                    map.put("cod_produto", cod);
                                    genericDao.insert(map);
                                    map.clear();

                                    System.out.println("Gostaria de inserir mais produtos? 1-Sim\n2-Nao\n");
                                    op = scanner.nextInt();
                                } while (op == 1);

                                System.out.println("\nInserido com sucesso!\n");

                            } else {
                                System.out.println("\nFalha ao inserir, tente novamente!\n");
                            }

                            /* Opcao de voltar */
                            System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                            option = scanner.nextInt();
                            if (option == 1) {
                                opcao = -1;
                            }
                            break;
                        }

                        /* Insere informacoes na tabela Cliente */
                        if (opcao == 4) {
                            String end;
                            String email;

                            System.out.println("\nDigite o nome do cliente: ");
                            scanner.nextLine();
                            nome = scanner.nextLine();
                            System.out.println("\nDigite o endereço do cliente: ");
                            end = scanner.nextLine();
                            System.out.println("\nDigite o email do cliente: ");
                            email = scanner.nextLine();

                            cliente = new Cliente(nome, end, email);

                            inscritos = clienteDao.insert(cliente);
                            if (inscritos == true) {
                                System.out.println("\nInserido com sucesso!\n");
                            } else {
                                System.out.println("\nFalha ao inserir, tente novamente!\n");
                            }

                            /* Opcao de voltar */
                            System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                            option = scanner.nextInt();
                            if (option == 1) {
                                opcao = -1;
                            }
                        }
                        break;

                    /*Atualizar*/
                    case 3:
                        Menu.getSubMenu(2);
                        opcao = scanner.nextInt();

                        /* Atualiza informacoes na tabela Caixa */
                        if (opcao == 1) {
                            String novaData;
                            boolean ret;
                            int codCaixa;

                            System.out.println("\nDigite o codigo do caixa que deseja atualizar os dados: ");
                            codCaixa = scanner.nextInt();
                            System.out.println("\nInforme o novo valor de abertura: ");
                            novaData = scanner.nextLine();
                            Caixa abertura = new Caixa(codCaixa, novaData);
                            ret = caixaDao.update(abertura);

                            if (ret == true) {
                                System.out.println("\nAlterado com sucesso!\n");
                            } else {
                                System.out.println("\nFalha ao alterar, Tente novamente!\n");
                            }

                            /* Opcao de voltar */
                            System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                            option = scanner.nextInt();
                            if (option == 1) {
                                opcao = -1;
                            }
                        }

                        /* Atualiza informacoes na tabela Produto */
                        if (opcao == 2) {
                            boolean ret;
                            String novoNome;
                            String novaDat;
                            String novaDesc;
                            Double novoPrecoAq;
                            Double novoPrecoUni;
                            Integer novaQuant;

                            int codProduto;
                            System.out.println("\nDigite o o codigo do produto que deseja atualizar os dados: ");
                            codProduto = scanner.nextInt();
                            System.out.println("\n Digite 1 para alterar o nome \n Digite 2 para alterar o preço de aquisição\n Digite 3 para alterar o preço unitário \n Digite 4 para alterar a data de validade \n Digite 5 para alterar a quantidade \n Digite 6 para alterar a descrição \n Digite 7 para alterar todos os campos: ");
                            valor = scanner.nextInt();

                            /* Opcao de alterar apenas o nome */
                            if (valor == 1) {
                                System.out.println("\nInforme o novo nome: ");
                                scanner.nextLine();
                                novoNome = scanner.nextLine();
                                Produto name = new Produto(codProduto, novoNome,
                                        null, null, null, null, null);
                                ret = produtoDao.update(name);
                                if (ret == true) {
                                    System.out.println("\nAlterado com sucesso!\n");
                                } else {
                                    System.out.println("\nFalha ao alterar!\n");
                                }

                                /* Opcao de voltar */
                                System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                                option = scanner.nextInt();
                                if (option == 1) {
                                    opcao = -1;
                                }
                            }

                            /* Opcao de alterar apenas o preço de aquisição */
                            if (valor == 2) {
                                System.out.println("\nInforme o novo preço de aquisição: ");
                                novoPrecoAq = scanner.nextDouble();
                                Produto aquis = new Produto(codProduto, null,
                                        novoPrecoAq, null, null, null, null);
                                ret = produtoDao.update(aquis);
                                if (ret == true) {
                                    System.out.println("\nAlterado com sucesso!\n");
                                } else {
                                    System.out.println("\nFalha ao alterar!\n");
                                }

                                /* Opcao de voltar */
                                System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                                option = scanner.nextInt();
                                if (option == 1) {
                                    opcao = -1;
                                }
                            }

                            /* Opcao de alterar apenas o preço unitário */
                            if (valor == 3) {
                                System.out.println("\nInforme o novo preco unitário: ");
                                novoPrecoUni = scanner.nextDouble();
                                Produto unit = new Produto(codProduto, null,
                                        null, novoPrecoUni, null, null, null);
                                ret = produtoDao.update(unit);
                                if (ret == true) {
                                    System.out.println("\nAlterado com sucesso!\n");
                                } else {
                                    System.out.println("\nFalha ao alterar!\n");
                                }

                                /* Opcao de voltar */
                                System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                                option = scanner.nextInt();
                                if (option == 1) {
                                    opcao = -1;
                                }
                            }

                            /* Opcao de alterar apenas a data de validade */
                            if (valor == 4) {
                                System.out.println("\nInforme a nova data de validade: ");
                                scanner.nextLine();
                                novaDat = scanner.nextLine();
                                Produto data = new Produto(codProduto, null,
                                        null, null, novaDat, null, null);
                                ret = produtoDao.update(data);
                                if (ret == true) {
                                    System.out.println("\nAlterado com sucesso!\n");
                                } else {
                                    System.out.println("\nFalha ao alterar!\n");
                                }

                                /* Opcao de voltar */
                                System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                                option = scanner.nextInt();
                                if (option == 1) {
                                    opcao = -1;
                                }
                            }

                            /* Opcao de alterar apenas a quantidade */
                            if (valor == 5) {
                                System.out.println("\nInforme a nova quantidade: ");
                                novaQuant = scanner.nextInt();
                                Produto qnt = new Produto(codProduto, null,
                                        null, null, null, novaQuant, null);
                                ret = produtoDao.update(qnt);
                                if (ret == true) {
                                    System.out.println("\nAlterado com sucesso!\n");
                                } else {
                                    System.out.println("\nFalha ao alterar!\n");
                                }

                                /* Opcao de voltar */
                                System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                                option = scanner.nextInt();
                                if (option == 1) {
                                    opcao = -1;
                                }
                            }

                            /* Opcao de alterar apenas a descrição */
                            if (valor == 6) {
                                System.out.println("\nInforme a nova descrição: ");
                                scanner.nextLine();
                                novaDesc = scanner.nextLine();
                                Produto desc = new Produto(codProduto, null,
                                        null, null, null, null, novaDesc);
                                ret = produtoDao.update(desc);
                                if (ret == true) {
                                    System.out.println("\nAlterado com sucesso!\n");
                                } else {
                                    System.out.println("\nFalha ao alterar!\n");
                                }

                                /* Opcao de voltar */
                                System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                                option = scanner.nextInt();
                                if (option == 1) {
                                    opcao = -1;
                                }
                            }

                            /* Opcao de alterar todos os dados */
                            if (valor == 7) {
                                System.out.println("\nInforme o novo nome: ");
                                scanner.nextLine();
                                novoNome = scanner.nextLine();
                                System.out.println("\nInforme o novo preço de aquisição: ");
                                novoPrecoAq = scanner.nextDouble();
                                System.out.println("\nInforme o novo preço unitário: ");
                                novoPrecoUni = scanner.nextDouble();
                                System.out.println("\nInforme a nova data de validade: ");
                                scanner.nextLine();
                                novaDat = scanner.nextLine();
                                System.out.println("\nInforme a nova quantidade: ");
                                novaQuant = scanner.nextInt();
                                System.out.println("\nInforme a nova descrição: ");
                                scanner.nextLine();
                                novaDesc = scanner.nextLine();

                                Produto produtoNovo = new Produto(codProduto, novoNome, novoPrecoAq, novoPrecoUni, novaDat, novaQuant, novaDesc);
                                ret = produtoDao.update(produtoNovo);
                                if (ret == true) {
                                    System.out.println("\nAlterado com sucesso!\n");
                                } else {
                                    System.out.println("\nFalha ao alterar!\n");
                                }

                                /* Opcao de voltar */
                                System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                                option = scanner.nextInt();
                                if (option == 1) {
                                    opcao = -1;
                                }
                            }
                        }

                        /* Atualiza informacoes na tabela Venda */
                        if (opcao == 3) {
                            boolean ret;
                            Integer novaQntP;
                            Double novoValorT;

                            int codVenda;
                            System.out.println("\nDigite o codigo da venda que deseja atualizar os dados: ");
                            codVenda = scanner.nextInt();
                            System.out.println("\n Digite 1 para alterar a quantidade de produtos \n Digite 2 para alterar o valor total dos produtos \n Digite 3 para alterar todos os campos: ");
                            valor = scanner.nextInt();

                            /* Opcao de alterar apenas a quantidade de produtos */
                            if (valor == 1) {
                                System.out.println("\nInforme a nova quantidade: ");
                                novaQntP = scanner.nextInt();
                                Venda qnt = new Venda(codVenda, novaQntP, null);
                                ret = vendaDao.update(qnt);
                                if (ret == true) {
                                    System.out.println("\nAlterado com sucesso!\n");
                                } else {
                                    System.out.println("\nFalha ao alterar!\n");
                                }

                                /* Opcao de voltar */
                                System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                                option = scanner.nextInt();
                                if (option == 1) {
                                    opcao = -1;
                                }
                            }

                            /* Opcao de alterar apenas o valor total */
                            if (valor == 2) {
                                System.out.println("\nInforme o novo valor: ");
                                novoValorT = scanner.nextDouble();
                                Venda valorT = new Venda(codVenda, null, novoValorT);
                                ret = vendaDao.update(valorT);
                                if (ret == true) {
                                    System.out.println("\nAlterado com sucesso!\n");
                                } else {
                                    System.out.println("\nFalha ao alterar!\n");
                                }

                                /* Opcao de voltar */
                                System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                                option = scanner.nextInt();
                                if (option == 1) {
                                    opcao = -1;
                                }
                            }

                            /* Opcao de alterar todos os dados */
                            if (valor == 3) {
                                System.out.println("\nInforme a nova quantidade: ");
                                novaQntP = scanner.nextInt();
                                System.out.println("\nInforme o novo valor total: ");
                                novoValorT = scanner.nextDouble();
                                Venda vendaNovo = new Venda(codVenda, novaQntP, novoValorT);
                                ret = vendaDao.update(vendaNovo);
                                if (ret == true) {
                                    System.out.println("\nAlterado com sucesso!\n");
                                } else {
                                    System.out.println("\nFalha ao alterar!\n");
                                }

                                /* Opcao de voltar */
                                System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                                option = scanner.nextInt();
                                if (option == 1) {
                                    opcao = -1;
                                }
                            }
                        }

                        /* Atualiza informacoes na tabela Cliente */
                        if (opcao == 4) {
                            boolean ret;
                            String novoNome;
                            String novoEnd;
                            String novoEmail;

                            int codCliente;

                            System.out.println("\n Digite o codigo do cliente que deseja atualizar os dados: ");
                            codCliente = scanner.nextInt();
                            System.out.println("\n Digite 1 para alterar nome do cliente \n Digite 2 para alterar o endereço do cliente \n Digite 3 para alterar o email do cliente \n Digite 4 para alterar todos os campos: ");
                            valor = scanner.nextInt();

                            /* Opcao de alterar apenas o nome do cliente */
                            if (valor == 1) {

                                System.out.println("\nInforme o novo nome: ");
                                scanner.nextLine();
                                novoNome = scanner.nextLine();

                                Cliente novoN = new Cliente(codCliente, novoNome, null, null);
                                ret = clienteDao.update(novoN);
                                if (ret == true) {
                                    System.out.println("\nAlterado com sucesso!\n");
                                } else {
                                    System.out.println("\nFalha ao alterar!\n");
                                }

                                /* Opcao de voltar*/
                                System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                                option = scanner.nextInt();
                                if (option == 1) {
                                    opcao = -1;
                                }
                            }

                            /* Opcao de alterar apenas o endereço do cliente */
                            if (valor == 2) {

                                System.out.println("\nInforme o novo endereço: ");
                                scanner.nextLine();
                                novoEnd = scanner.nextLine();

                                Cliente novoEn = new Cliente(codCliente, null, novoEnd, null);
                                ret = clienteDao.update(novoEn);
                                if (ret == true) {
                                    System.out.println("\nAlterado com sucesso!\n");
                                } else {
                                    System.out.println("\nFalha ao alterar!\n");
                                }

                                /* Opcao de voltar*/
                                System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                                option = scanner.nextInt();
                                if (option == 1) {
                                    opcao = -1;
                                }
                            }

                            /* Opcao de alterar apenas o email do cliente */
                            if (valor == 3) {

                                System.out.println("\nInforme o novo email: ");
                                scanner.nextLine();
                                novoEmail = scanner.nextLine();

                                Cliente novoEm = new Cliente(codCliente, null, null, novoEmail);
                                ret = clienteDao.update(novoEm);
                                if (ret == true) {
                                    System.out.println("\nAlterado com sucesso!\n");
                                } else {
                                    System.out.println("\nFalha ao alterar!\n");
                                }

                                /* Opcao de voltar*/
                                System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                                option = scanner.nextInt();
                                if (option == 1) {
                                    opcao = -1;
                                }
                            }

                            /* Opcao de alterar todos os dados */
                            if (valor == 4) {

                                System.out.println("\nInforme o novo nome: ");
                                scanner.nextLine();
                                novoNome = scanner.nextLine();
                                System.out.println("\nInforme o novo endereço: ");
                                novoEnd = scanner.nextLine();
                                System.out.println("\nInforme o novo email: ");
                                novoEmail = scanner.nextLine();

                                Cliente novo = new Cliente(codCliente, novoNome, novoEnd, novoEmail);
                                ret = clienteDao.update(novo);
                                if (ret == true) {
                                    System.out.println("\nAlterado com sucesso!\n");
                                } else {
                                    System.out.println("\nFalha ao alterar!\n");
                                }

                                /* Opcao de voltar*/
                                System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                                option = scanner.nextInt();
                                if (option == 1) {
                                    opcao = -1;
                                }
                            }
                        }

                        break;

                    /*Remover*/
                    case 4:
                        Menu.getSubMenu(3);
                        opcao = scanner.nextInt();

                        /* Remove informacoes da tabela Caixa */
                        if (opcao == 1) {
                            boolean ret;
                            int codCaixa;

                            System.out.println("\nDigite o codigo do caixa que deseja excluir os dados: ");
                            codCaixa = scanner.nextInt();
                            Caixa cod = new Caixa(codCaixa, null);
                            ret = caixaDao.remove(cod);
                            if (ret == true) {
                                System.out.println("\nRemovido com sucesso!\n");
                            } else {
                                System.out.println("\nFalha ao remover!\n");
                            }

                            /*Opcao de voltar*/
                            System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                            option = scanner.nextInt();
                            if (option == 1) {
                                opcao = -1;
                            }
                        }

                        /* Remove informacoes da tabela Produto */
                        if (opcao == 2) {
                            boolean ret;
                            int codProduto;

                            System.out.println("\nDigite o codigo do produto que deseja excluir os dados: ");
                            codProduto = scanner.nextInt();
                            Produto cod = new Produto(codProduto, null, null, null, null, null, null);
                            ret = produtoDao.remove(cod);
                            if (ret == true) {
                                System.out.println("\nRemovido com sucesso!\n");
                            } else {
                                System.out.println("\nFalha ao remover!\n");
                            }

                            /*Opcao de voltar*/
                            System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                            option = scanner.nextInt();
                            if (option == 1) {
                                opcao = -1;
                            }
                        }

                        /* Remove informacoes da tabela Venda */
                        if (opcao == 3) {
                            boolean ret;
                            int codVenda;

                            System.out.println("\nDigite o codigo da venda que deseja excluir os dados: ");
                            codVenda = scanner.nextInt();
                            Venda cod = new Venda(codVenda, null, null);
                            ret = vendaDao.remove(cod);
                            if (ret == true) {
                                System.out.println("\nRemovido com sucesso!\n");
                            } else {
                                System.out.println("\nFalha ao remover!\n");
                            }

                            /*Opcao de voltar*/
                            System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                            option = scanner.nextInt();
                            if (option == 1) {
                                opcao = -1;
                            }
                        }

                        /* Remove informacoes da tabela Cliente */
                        if (opcao == 4) {
                            boolean ret;
                            int codCliente;

                            System.out.println("\nDigite o codigo do cliente que deseja excluir os dados: ");
                            codCliente = scanner.nextInt();
                            Cliente cod = new Cliente(codCliente, null, null, null);
                            ret = clienteDao.remove(cod);
                            if (ret == true) {
                                System.out.println("\nRemovido com sucesso!\n");
                            } else {
                                System.out.println("\nFalha ao remover!\n");
                            }

                            /*Opcao de voltar*/
                            System.out.println("Gostaria de realizar mais alguma operação?\n1 - Sim 2 - Não\nOpcao: ");
                            option = scanner.nextInt();
                            if (option == 1) {
                                opcao = -1;
                            }
                        }
                        break;

                    case 5:
                    	System.exit(0);
                    	break;
                    	
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
