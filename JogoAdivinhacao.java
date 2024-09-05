
import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int limiteInf = 1, limiteSup = 99;
        int palpite, sorteado;
        
        sorteado = random.nextInt(99) + 1; // Sorteia um número entre 1 e 99
        
        System.out.println("Adivinhe o número. Insira 0 se quiser parar!");
        System.out.print("Qual seu palpite?\n");
        palpite = scanner.nextInt();
        
        for (int i = 1; i <= 11; i++) {
            if (palpite == 0) {
                System.out.println("Jogo encerrado!");
                break;
            }
            
            if (palpite == sorteado) {
                System.out.printf("PARABÉNS! Acertou o número sorteado. Acertou em %d tentativas!\n", i);
                break;
            } else if (palpite > sorteado) {
                if (limiteSup > palpite) {
                    limiteSup = palpite + 1;
                }
                System.out.printf("\nO número está entre %d e %d. Tentativa: %d\n", limiteInf, limiteSup, i);
            } else if (palpite < sorteado) {
                if (limiteInf < palpite) {
                    limiteInf = palpite - 1;
                }
                System.out.printf("\nO número está entre %d e %d. Tentativa: %d\n", limiteInf, limiteSup, i);
            }
            
            if (i < 11) {
                System.out.print("Qual o seu palpite?\n");
                palpite = scanner.nextInt();
            } else {
                System.out.printf("Suas tentativas acabaram. O número era: %d\n", sorteado);
            }
        }
        
        scanner.close();
    }
}
