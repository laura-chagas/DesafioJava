import java.util.Random;
import java.util.Scanner;

public class Principal {
    static int pontuacao10 = 0, pontuacao5 = 0;

    static int rodadas = 4;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("----------- VAMOS INICIAR! ----------- \nLEMBRE-SE, VOCÊ SÓ TERÁ 3 JOGADAS... BOA SORTE! \n");

        for (int i = 0; i < rodadas; i++) {
            System.out.println("Digite um número: ");
            int numUsuario = scan.nextInt();

            verificarNumeroDigitado(numUsuario);

            int dado = gerarNumeroDado();

            comparacaoDadoNumUsuario(dado, numUsuario);

        }
        contagemPontos();
    }

    public static void verificarNumeroDigitado(int numUsuario) { //verificacao numero digitado
        if (numUsuario < 1 || numUsuario > 6) {
            System.out.println("NÚMERO INVÁLIDO"); //sinal de alerta
            System.exit(0);
        }
    }

    public static int gerarNumeroDado() { //fazer o dado girar
        Random rodar = new Random();
        return rodar.nextInt(6) + 1;
    }

    public static void comparacaoDadoNumUsuario(int dado, int numUsuario) {
        if (dado == numUsuario) {
            pontuacao10++;
            System.out.println("\nVocê ganhou 10 pontos!! \nSeu número: " + numUsuario + "\nNúmero do dado: " + dado + "\n");

        } else if ((numUsuario + 1) == dado || (numUsuario - 1) == dado) {
            pontuacao5++;
            System.out.println("\nVocê ganhou 5 pontos!!  \nSeu número: " + numUsuario + "\nNúmero do dado: " + dado + "\n");

        } else {
            System.out.println("\nInfelizmente você não fez ponto \nSeu número: " + numUsuario + "\nNúmero do dado: " + dado + "\n");
        }
    }

    public static void contagemPontos() {

        if (rodadas == (pontuacao10 + pontuacao5)) {
            System.out.println("Você acertou todas as rodadas \n");

        } else if (pontuacao5 + pontuacao10 == 0) {

            System.out.println("Você não acertou o número do dado em nenhuma rodada");

        } else {

            System.out.println("Você acertou em " + (pontuacao10 + pontuacao5) + " rodadas e errou " + (rodadas - (pontuacao10 + pontuacao5)));

        }

        System.out.println("Você ganhou " + ((pontuacao10 * 10) + (pontuacao5 * 5)) + " pontos no total");
    }

}