import java.util.ArrayList;

class Restaurante {
    private ArrayList<ItemMenu> cardapio = new ArrayList<>();

    public Restaurante() {
        // Adicione os itens ao cardápio
        cardapio.add(new ItemMenu("Prato 1", 10.0));
        cardapio.add(new ItemMenu("Prato 2", 15.0));
        cardapio.add(new ItemMenu("Prato 3", 20.0));
    }

    public void exibirCardapio() {
        System.out.println("Cardápio:");
        for (int i = 0; i < cardapio.size(); i++) {
            System.out.println(i + 1 + ". " + cardapio.get(i).getName() + " - R$" + cardapio.get(i).getPrice());
        }
        System.out.println("0. Finalizar Pedido");
    }

    public ItemMenu getItemMenu(int numeroItem) {
        if (numeroItem >= 1 && numeroItem <= cardapio.size()) {
            return cardapio.get(numeroItem - 1);
        }
        return null;
    }
}
