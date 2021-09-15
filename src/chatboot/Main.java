package chatboot;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        EntradasUsuario entradasUsuario = new EntradasUsuario();
        RespostaUsuario respostaUsuario = new RespostaUsuario();
        Pedido pedido = new Pedido();
        Scanner myObj = new Scanner(System.in, "Windows-1252");
        Cliente cliente = new Cliente(myObj);

        boolean respostaUsarioEncontrada = false;
        boolean primairaEntradaEncontrada = false;

        // Create a Scanner object
        String primeiraEntrada = myObj.nextLine();
        while (!primairaEntradaEncontrada) {
            for (String item : entradasUsuario.ENTRADAS_USUARIOS) {
                primairaEntradaEncontrada = item.toLowerCase().contains(primeiraEntrada.toLowerCase());
                if (primairaEntradaEncontrada == true) {
                    break;
                }
            }
            if (!primairaEntradaEncontrada) {
                System.out.println("Seja bem vindo(a) ao nosso\r\n"
                        + "canal de atendimento, para iniciar o atendimento digite 'Oi'");
                primeiraEntrada = myObj.nextLine();
            }
        }
        if (primairaEntradaEncontrada == true) {
            System.out.println("Seja bem vindo(a) ao nosso\r\n" + "canal de atendimento, Me informe seu nome:");
            cliente.setNome(myObj.nextLine());
        }
        if (primairaEntradaEncontrada == true) {
            System.out.println("Seja bem vindo(a) " + cliente.getNome() + " ao nosso\r\n"
                    + "canal de atendimento, em que posso te ajudar? ");
        }

        while (respostaUsarioEncontrada == false) {
            String respostaUsuarioString = myObj.nextLine();
            while (respostaUsuarioString.equalsIgnoreCase("")) {
                System.out.println("Não entendi, pode me explicar melhor? Ex.: Gostaria de comprar frutas.");
                respostaUsuarioString = myObj.nextLine();
                respostaUsarioEncontrada=false;
            }

            respostaUsuarioString = respostaUsuarioString.replaceAll(",", "");
            // respostaUsuarioString = respostaUsuarioString.replaceAll(".", "");
            String[] palavras = respostaUsuarioString.split(" ");
            for (String palavra : palavras) {
                for (String item : respostaUsuario.respostasUsuario) {
                    respostaUsarioEncontrada = item.toLowerCase().contains(palavra.toLowerCase());


                    if (respostaUsarioEncontrada == true) {
                        break;
                    }
                }
                if (respostaUsarioEncontrada == true) {
                    break;
                }
            }
            if (respostaUsarioEncontrada == false) {
                System.out.println("Não entendi, pode me explicar melhor? Ex.: Gostaria de comprar frutas.");
            }

        }

        if (primairaEntradaEncontrada == true) {
            pedido = pedido.exibirCardapio(myObj, pedido);
        }

        System.out.print("Sr(a) NOMEDOCLIENTE informe seu endereço nesta\r\n" + "ordem:”\r\n"
                + "1 Rua................:\r\n" + "2 Nº...................:\r\n" + "3 Bairro.............:\r\n"
                + "4 Cidade...........:\r\n" + "5 UF..................:\r\n" + "6 Cep................:\r\n"
                + "7 Zona...............:\r\n" + "8 Ponto de ref....:");

        List<String> endereco = new ArrayList<String>();
        int i = 0;
        while (endereco.size() < 8) {

            while (myObj.hasNext()) {
                if (myObj.hasNext() == false) {
                    break;
                }
                endereco.add(myObj.nextLine().concat("\r\n"));
                if (endereco.size() == 8) {
                    break;
                }
            }
        }

        cliente.validarEndereco(endereco);
        boolean acrescentar = true;
        while (acrescentar) {
            try {
                System.out.println("Sr(a) " + cliente.nome + ", deseja acrescentar mais alguma coisa?");
                String respostaMaisAlgumaCoisa = myObj.nextLine();

                while (!respostaMaisAlgumaCoisa.equalsIgnoreCase("s")
                        && !respostaMaisAlgumaCoisa.equalsIgnoreCase("n")) {
                    System.out.println("Não entendi, favor responder S-SIM ou N-NÃO");
                    respostaMaisAlgumaCoisa = myObj.nextLine();
                }

                if (respostaMaisAlgumaCoisa.equalsIgnoreCase("N")) {
                    acrescentar = false;
                    break;
                }
                if (respostaMaisAlgumaCoisa.equalsIgnoreCase("S")) {
                    while (respostaMaisAlgumaCoisa.equalsIgnoreCase("S")) {
                        pedido = pedido.exibirCardapio(myObj, pedido);
                        System.out.println("Sr(a) " + cliente.nome + ", deseja acrescentar mais alguma coisa?");
                        respostaMaisAlgumaCoisa = myObj.nextLine();
                        if (respostaMaisAlgumaCoisa.equalsIgnoreCase("N")) {
                            acrescentar = false;
                            break;
                        }
                    }

                }
            } catch (Exception e) {
                System.out.println("Não entendi, favor responder S-SIM ou N-NÃO");
            }
        }

        System.out.println("Sr(a) " + cliente.nome + ", por gentileza, confira seu\r\n" + "pedido!”");

        List<String> frutaList = new ArrayList<String>();
        List<Double> valores = new ArrayList<Double>();
        List<Double> quantidade = new ArrayList<Double>();

        for (Frutas fruta : pedido.frutas) {
            frutaList.add(fruta.nome);
            valores.add(fruta.valor);
            quantidade.add(fruta.quantidade);
        }

        String resumoPedido = "******************************************************\r\n"
                + "******************Frutaria só Fruta*******************\r\n"
                + "******************Dados do Cliente********************\r\n" + "Dados do cliente: "
                + cliente.getNome() + "\r\n" + "*****************Dados do Endereço********************\r\n"
                + endereco.get(0) + endereco.get(1) + endereco.get(2) + endereco.get(3) + endereco.get(4)
                + endereco.get(5) + endereco.get(6) + endereco.get(7)
                + "*******************Dados do pedido********************\r\n" + "Descrição: " + frutaList + "\r\n"
                + "Quantidade: " + quantidade + "\r\n" + "Valor Unitário(KG): R$" + valores + "\r\n" + "Total: R$"
                + pedido.calcularPedido(pedido) + "\r\n" + "Observação:\r\n"
                + "******************************************************";

        System.out.println(resumoPedido);

        PrintWriter pedidoArquivo = new PrintWriter("pedido.txt");

        System.out.println("Sr(a) " + cliente.getNome() + " posso confirmar seu pedido?\r\n"
                + " Digite SIM, se estiver tudo certo.");
        String confirmarPedido = myObj.nextLine();

        while (!confirmarPedido.equalsIgnoreCase("sim") && !confirmarPedido.equalsIgnoreCase("não")) {
            System.out.println("Não entendi, favor responder sim ou não");
            confirmarPedido = myObj.nextLine();
        }

        if (confirmarPedido.equalsIgnoreCase("Não")) {
            System.out.println("Seu pedido será cancelado, obrigado pelo contato");
            System.exit(0);
        }

        if (confirmarPedido.equalsIgnoreCase("sim")) {

            System.out.println("Sr(a) " + cliente.getNome() + " Gostaria de adicionar observações? Ex.: Troco\r\n"
                    + "Digite SIM, caso precise");

            String adicionarObservacoes = myObj.nextLine();

            while (!adicionarObservacoes.equalsIgnoreCase("sim") && !adicionarObservacoes.equalsIgnoreCase("não")) {
                System.out.println("Não entendi, favor responder sim ou não");
                adicionarObservacoes = myObj.nextLine();
            }

            if (adicionarObservacoes.equalsIgnoreCase("não")) {
                pedidoArquivo.print(resumoPedido);
                pedidoArquivo.close();
            }

            if (adicionarObservacoes.equalsIgnoreCase("sim")) {

                System.out.println("Digite a observação");
                String observacao = myObj.nextLine();

                resumoPedido = "******************************************************\r\n"
                        + "******************Frutaria só Fruta*******************\r\n"
                        + "******************Dados do Cliente********************\r\n" + "Dados do cliente: "
                        + cliente.getNome() + "\r\n" + "*****************Dados do Endereço********************\r\n"
                        + endereco.get(0) + endereco.get(1) + endereco.get(2) + endereco.get(3) + endereco.get(4)
                        + endereco.get(5) + endereco.get(6) + endereco.get(7)
                        + "*******************Dados do pedido********************\r\n" + "Descrição: " + frutaList
                        + "\r\n" + "Quantidade: " + quantidade + "\r\n" + "Valor Unitário(KG): R$" + valores + "\r\n"
                        + "Total: R$" + pedido.calcularPedido(pedido) + "\r\n" + "Observação: " + observacao + "\r\n"
                        + "******************************************************";

                System.out.println(resumoPedido);
                pedidoArquivo.print(resumoPedido);
                pedidoArquivo.close();
            }

            System.out.println("Sr(a) " + cliente.getNome() + ", seu pedido chegará em 40\r\n" + "        minutos");

            System.out.println("A Frutaria Só Frutas, agradece a sua preferência!");

            System.out.println("Volte sempre!");
        }
    }

}
