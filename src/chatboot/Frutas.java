package chatboot;

public class Frutas {

    String nome;
    double quantidade;
    double valor;

    public boolean obterFutaPorId(String fruta) {
        // TODO Auto-generated method stub

        int idFruta = Integer.parseInt(fruta);

        switch (idFruta) {
            case 1:
                nome = "Banana";
                valor = 3.00;
                return true;

            case 2:
                nome = "Maça";
                valor = 3.00;
                return true;

            case 3:
                nome = "Maracujá";
                valor = 5.00;
                break;

            case 4:
                nome = "Manga";
                valor = 5.50;
                break;

            case 5:
                nome = "Limão";
                valor = 2.00;
                break;

            default:
                return false;
        }
        return false;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
}
