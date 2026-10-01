import info.Cliente;
import info.ProfileUsuario;
import info.Usuario;
import info.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Lista que mantém os clientes enquanto o programa está executando
    private static List<Cliente> clientes = new ArrayList<>();

    // Contadores simples para gerar IDs
    private static Long proximoIdCliente = 1L;
    private static Long proximoIdUsuario = 1L;
    private static Long proximoIdVeiculo = 1L;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {

            exibirMenu();

            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {

                case 1:
                    cadastrarCliente(scanner);
                    break;

                case 2:
                    cadastrarVeiculo(scanner);
                    break;

                case 3:
                    listarClientes();
                    break;

                case 4:
                    listarVeiculos();
                    break;

                case 0:
                    System.out.println("\nEncerrando o sistema...");
                    break;

                default:
                    System.out.println("\nOpção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    // ==========================================
    // MENU
    // ==========================================

    private static void exibirMenu() {

        System.out.println();
        System.out.println("=================================");
        System.out.println("       SISTEMA DA OFICINA");
        System.out.println("=================================");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Cadastrar veículo");
        System.out.println("3 - Listar clientes");
        System.out.println("4 - Listar veículos");
        System.out.println("0 - Sair");
        System.out.println("=================================");
    }

    // ==========================================
    // CADASTRAR CLIENTE
    // ==========================================

    private static void cadastrarCliente(Scanner scanner) {

        System.out.println();
        System.out.println("=== CADASTRO DE CLIENTE ===");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        Usuario usuario = new Usuario(
                proximoIdUsuario,
                nome,
                email,
                senha,
                ProfileUsuario.CLIENTE
        );

        usuario.ativarConta();

        Cliente cliente = new Cliente(
                proximoIdCliente,
                usuario,
                cpf,
                telefone
        );

        clientes.add(cliente);

        System.out.println();
        System.out.println("Cliente cadastrado com sucesso!");
        System.out.println("ID do cliente: " + cliente.getId());

        proximoIdUsuario++;
        proximoIdCliente++;
    }

    // ==========================================
    // CADASTRAR VEÍCULO
    // ==========================================

    private static void cadastrarVeiculo(Scanner scanner) {

        System.out.println();
        System.out.println("=== CADASTRO DE VEÍCULO ===");

        if (clientes.isEmpty()) {
            System.out.println("Não existem clientes cadastrados.");
            System.out.println("Cadastre um cliente primeiro.");
            return;
        }

        listarClientes();

        System.out.print("\nDigite o ID do cliente dono do veículo: ");
        Long idCliente = Long.parseLong(scanner.nextLine());

        Cliente cliente = buscarClientePorId(idCliente);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.print("Marca: ");
        String marca = scanner.nextLine();

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();

        System.out.print("Placa: ");
        String placa = scanner.nextLine();

        System.out.print("Cor: ");
        String cor = scanner.nextLine();

        System.out.print("Ano: ");
        int ano = Integer.parseInt(scanner.nextLine());

        System.out.print("Quilometragem: ");
        int quilometragem = Integer.parseInt(scanner.nextLine());

        Veiculo veiculo = new Veiculo(
                proximoIdVeiculo,
                marca,
                modelo,
                placa,
                cor,
                ano,
                quilometragem,
                cliente
        );

        cliente.adicionarVeiculo(veiculo);

        System.out.println();
        System.out.println("Veículo cadastrado com sucesso!");
        System.out.println("ID do veículo: " + veiculo.getId());

        proximoIdVeiculo++;
    }

    // ==========================================
    // LISTAR CLIENTES
    // ==========================================

    private static void listarClientes() {

        System.out.println();
        System.out.println("=== CLIENTES CADASTRADOS ===");

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        for (Cliente cliente : clientes) {

            System.out.println();
            System.out.println("ID: " + cliente.getId());
            System.out.println(
                    "Nome: " + cliente.getUsuario().getNome()
            );
            System.out.println(
                    "E-mail: " + cliente.getUsuario().getEmail()
            );
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Telefone: " + cliente.getTelefone());
        }
    }

    // ==========================================
    // LISTAR VEÍCULOS
    // ==========================================

    private static void listarVeiculos() {

        System.out.println();
        System.out.println("=== VEÍCULOS CADASTRADOS ===");

        boolean encontrouVeiculo = false;

        for (Cliente cliente : clientes) {

            for (Veiculo veiculo : cliente.getVeiculos()) {

                encontrouVeiculo = true;

                System.out.println();
                System.out.println("ID: " + veiculo.getId());
                System.out.println("Marca: " + veiculo.getMarca());
                System.out.println("Modelo: " + veiculo.getModelo());
                System.out.println("Placa: " + veiculo.getPlaca());
                System.out.println("Cor: " + veiculo.getCor());
                System.out.println("Ano: " + veiculo.getAno());
                System.out.println(
                        "Quilometragem: " + veiculo.getQuilometragem()
                );
                System.out.println(
                        "Dono: " + cliente.getUsuario().getNome()
                );
            }
        }

        if (!encontrouVeiculo) {
            System.out.println("Nenhum veículo cadastrado.");
        }
    }

    // ==========================================
    // BUSCAR CLIENTE POR ID
    // ==========================================

    private static Cliente buscarClientePorId(Long id) {

        for (Cliente cliente : clientes) {

            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }

        return null;
    }
}