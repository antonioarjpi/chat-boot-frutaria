package chatboot;

import java.util.List;
import java.util.Scanner;

public class Cliente {

    Scanner scanner;
    String nome;
    String enderecoUnidade;
    boolean contem = false;
    boolean estaEmBranco = false;

    public Cliente(Scanner myObj) {
        this.scanner = myObj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean validarEndereco(List<String> endereco) {

        validarRua(endereco);
        validarNumero(endereco);
        validarBairro(endereco);
        validarCidade(endereco);
        validarUf(endereco);
        validarCep(endereco);
        validarZona(endereco);
        validarPontoRef(endereco);

        return true;
    }

    public void validarRua(List<String> endereco) {
        enderecoUnidade = endereco.get(0);
        contem = enderecoUnidade.contains("1 Rua................:");
        enderecoUnidade = enderecoUnidade.replace("1 Rua................:", "");
        enderecoUnidade = enderecoUnidade.replace("\r\n", "");
        estaEmBranco = enderecoUnidade.equalsIgnoreCase("");

        if (estaEmBranco || enderecoUnidade.replace(" ", "").length() < 1) {
            System.out.println(
                    "Campo rua deve ser preenchido, por favor digite a rua no seguinte padrão: 1 Rua................: Rua Apenas um exemplo");
            endereco.set(0, scanner.nextLine());
            validarRua(endereco);
        }
    }

    private void validarPontoRef(List<String> endereco) {
        // TODO Auto-generated method stub
        enderecoUnidade = endereco.get(7);
        contem = enderecoUnidade.contains("8 Ponto de ref....:");
        enderecoUnidade = enderecoUnidade.replace("8 Ponto de ref....:", "");
        enderecoUnidade = enderecoUnidade.replace("\r\n", "");
        estaEmBranco = enderecoUnidade.equalsIgnoreCase("");

        if (estaEmBranco || enderecoUnidade.replace(" ", "").length() < 1) {
            System.out.println(
                    "O campo Ponto de Referencia deve ser preenchido, por favor digite o Ponto de Referencia no seguinte padrão: 8 Ponto de ref....: Perto da Pra�a");
            endereco.set(7, scanner.nextLine());
            validarRua(endereco);
        }
    }

    private void validarZona(List<String> endereco) {
        // TODO Auto-generated method stub
        enderecoUnidade = endereco.get(6);
        contem = enderecoUnidade.contains("7 Zona...............:");
        enderecoUnidade = enderecoUnidade.replace("7 Zona...............:", "");
        enderecoUnidade = enderecoUnidade.replace("\r\n", "");
        estaEmBranco = enderecoUnidade.equalsIgnoreCase("");

        if (estaEmBranco || enderecoUnidade.replace(" ", "").length() < 1) {
            System.out.println(
                    "O campo Zona deve ser preenchido, por favor digite a Zona no seguinte padrão: 7 Zona...............: Zona Sul");
            endereco.set(6, scanner.nextLine());
            validarRua(endereco);
        }
    }

    private void validarCep(List<String> endereco) {
        // TODO Auto-generated method stub
        enderecoUnidade = endereco.get(5);
        contem = enderecoUnidade.contains("6 Cep................:");
        enderecoUnidade = enderecoUnidade.replace("6 Cep................:", "");
        enderecoUnidade = enderecoUnidade.replace("\r\n", "");
        estaEmBranco = enderecoUnidade.equalsIgnoreCase("");

        if (estaEmBranco || enderecoUnidade.replace(" ", "").length() < 1) {
            System.out.println(
                    "O campo CEP deve ser preenchido, por favor digite o CEP no seguinte padrão: 6 Cep................: 26000-000");
            endereco.set(5, scanner.nextLine());
            validarRua(endereco);
        }
    }

    private void validarUf(List<String> endereco) {
        // TODO Auto-generated method stub
        enderecoUnidade = endereco.get(4);
        contem = enderecoUnidade.contains("5 UF..................:");
        enderecoUnidade = enderecoUnidade.replace("5 UF..................:", "");
        enderecoUnidade = enderecoUnidade.replace("\r\n", "");
        estaEmBranco = enderecoUnidade.equalsIgnoreCase("");

        if (estaEmBranco || enderecoUnidade.replace(" ", "").length() < 1) {
            System.out.println(
                    "O campo UF deve ser preenchido, por favor digite a UF no seguinte padrão: 5 UF..................: SP");
            endereco.set(4, scanner.nextLine());
            validarRua(endereco);
        }
    }

    private void validarCidade(List<String> endereco) {
        // TODO Auto-generated method stub
        enderecoUnidade = endereco.get(3);
        contem = enderecoUnidade.contains("4 Cidade...........:");
        enderecoUnidade = enderecoUnidade.replace("4 Cidade...........:", "");
        enderecoUnidade = enderecoUnidade.replace("\r\n", "");
        estaEmBranco = enderecoUnidade.equalsIgnoreCase("");

        if (estaEmBranco || enderecoUnidade.replace(" ", "").length() < 1) {
            System.out.println(
                    "O campo Cidade deve ser preenchido, por favor digite a cidade no seguinte padrão: 4 Cidade...........: Nome da Cidade");
            endereco.set(3, scanner.nextLine());
            validarRua(endereco);
        }
    }

    private void validarBairro(List<String> endereco) {
        // TODO Auto-generated method stub
        enderecoUnidade = endereco.get(2);
        contem = enderecoUnidade.contains("3 Bairro.............:");
        enderecoUnidade = enderecoUnidade.replace("3 Bairro.............:", "");
        enderecoUnidade = enderecoUnidade.replace("\r\n", "");
        estaEmBranco = enderecoUnidade.equalsIgnoreCase("");

        if (estaEmBranco || enderecoUnidade.replace(" ", "").length() < 1) {
            System.out.println(
                    "O campo Brairo deve ser preenchido, por favor digite o bairro no seguinte padrão: 3 Bairro.............: Nome do Bairro");
            endereco.set(2, scanner.nextLine());
            validarRua(endereco);
        }
    }

    private void validarNumero(List<String> endereco) {
        // TODO Auto-generated method stub
        enderecoUnidade = endereco.get(1);
        contem = enderecoUnidade.contains("2 N�...................:");
        enderecoUnidade = enderecoUnidade.replace("2 N�...................:", "");
        enderecoUnidade = enderecoUnidade.replace("\r\n", "");
        estaEmBranco = enderecoUnidade.equalsIgnoreCase("");

        if (estaEmBranco || enderecoUnidade.replace(" ", "").length() < 1) {
            System.out.println(
                    "O campo N�mero deve ser preenchido, por favor digite o número no seguinte padrão: 2 N�...................: 335");
            endereco.set(1, scanner.nextLine());
            validarRua(endereco);
        }
    }

}
