import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurante restaurante = new Restaurante();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Fazer Pedido");
            System.out.println("2. Sair");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                Pedido pedido = new Pedido();

                System.out.print("Digite o nome do cliente: ");
                scanner.nextLine();
                String nomeCliente = scanner.nextLine();

                restaurante.exibirCardapio();
                while (true) {
                    System.out.print("Escolha um item (ou 0 para finalizar): ");
                    int numeroItem = scanner.nextInt();
                    if (numeroItem == 0) {
                        break;
                    }
                    ItemMenu item = restaurante.getItemMenu(numeroItem);
                    if (item != null) {
                        pedido.adicionarItem(item);
                        System.out.println(item.getName() + " adicionado ao pedido.");
                    } else {
                        System.out.println("Item inválido.");
                    }
                }

                double total = pedido.calcularTotal();
                System.out.println("\nNota Fiscal:");
                for (ItemMenu item : pedido.getItems()) {
                    System.out.println(item.getName() + " - R$" + item.getPrice());
                }
                System.out.println("Taxa de Serviço (10%): R$" + (total - pedido.calcularTotal() / (1 + pedido.getItems().size())));
                System.out.println("Total: R$" + total);

                System.out.print("Valor recebido em dinheiro: R$");
                double valorRecebido = scanner.nextDouble();
                double troco = valorRecebido - total;
                System.out.println("Troco: R$" + troco);

            } else if (opcao == 2) {
                System.out.println("Programa encerrado.");
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }
}