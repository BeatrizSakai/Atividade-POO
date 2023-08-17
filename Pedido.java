import java.util.ArrayList;

public class Pedido {
    private ArrayList<ItemMenu> items = new ArrayList<>();
    private double taxaServico = 0.1; // 10%

    public void adicionarItem(ItemMenu item) {
        items.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemMenu item : items) {
            total += item.getPrice();
        }
        return total + total * taxaServico;
    }

    public ArrayList<ItemMenu> getItems() {
        return items;
    }  
}
