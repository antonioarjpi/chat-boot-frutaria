package chatboot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pedido {

    int quantidade;
    Frutas _frutas = new Frutas();
    List<Frutas> frutas = new ArrayList<>();

    public Pedido exibirCardapio(Scanner myObj, Pedido pedido) {
        System.out.println("Segue abaixo os itens disponiveis:\r\n" + "Código 1: Banana, R$3,00 kg\r\n"
                + "Código 2: Maça R$3,00 kg\r\n" + "Código 3: Maracujá R$5,00 kg\r\n" + "Código 4: Manga R$5,50 kg\r\n"
                + "Código 5: Limão R$2,00 kg");
        System.out.println(
                "Digite o código e a quantida do item desejado. Ex.: 3, 2 (Maracujá, 2KG) ou 3, 1.5(Maracujá, 1.5KG)");
        boolean conseguiuEntender = false;
        while (conseguiuEntender == false) {
            try {
                String itensPedido = myObj.nextLine(); // Read user input
                itensPedido = itensPedido.replace(",", "");
                String[] ItemPedido = itensPedido.split(" ");
                double itemPedidoDouble = Double.parseDouble(ItemPedido[1]);

                Frutas frutas = new Frutas();
                frutas.obterFutaPorId(ItemPedido[0]);
                frutas.setQuantidade(itemPedidoDouble);

                pedido.frutas.add(frutas);
                conseguiuEntender = true;

            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(
                        "Não consegui entender, favor seguir o padrão: Ex.: 3, 2 (Maracujá, 2KG) ou 3, 1.5(Maracujá, 1.5KG)");
            }
        }
        return pedido;
    }

    public double calcularPedido(Pedido pedido) {

        List<Double> valores = new ArrayList<Double>();

        for (Frutas fruta : pedido.frutas) {

            valores.add(fruta.quantidade * fruta.valor);
        }

        double valorTotal = 0;
        for (Double double1 : valores) {
            valorTotal = valorTotal + double1;
        }
        return valorTotal;
    }

}
