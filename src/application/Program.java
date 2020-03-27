package application;

import java.util.Random;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		//instancia um objeto da classe Random usando o construtor básico
		Random gerador = new Random();
		Scanner sc = new Scanner(System.in);
		int[][] tabuleiro = new int[4][4];
		int submarinos = 5;
		int destruidos = 0;
		int tiros = 10;
		int sorteio;
		int posx, posy;
		

		//percorre matriz para sortear lugares onde serão ocupados
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				sorteio = gerador.nextInt(2); //gera número randômico: 0 sendo água e 1 sendo ocupado
				if((sorteio == 1)&&(submarinos>0)) { //se foi sorteado para ocupar o espaço e ainda tiverem submarinos para distribuir...
					tabuleiro[i][j] = sorteio; //define o espaço como ocupado
					submarinos--; //diminui a quantidade de submarinos a serem distribuídos
				}
				else
					tabuleiro[i][j] = 0;
			}
		}
		
		while((tiros>0) && (destruidos<5)) { //enquanto tiver tiros disponíveis e submarinos não destruídos
			System.out.println("Informe as coordenadas x e y do mapa: "); //solicita ao usuário os índices da matriz 
			posx = sc.nextInt();
			posy = sc.nextInt();
			if((posx>3)||(posy>3)) //testa se as coordenadas são válidas
				System.out.println("Suas coordenadas x e y estão fora do mapa. Você perdeu este tiro!!!");
			else {
				if(tabuleiro[posx][posy] == 0) //se as coordenadas representam água (errou o tiro)...
					System.out.println("Água");
				else {
					tabuleiro[posx][posy] = 2; //se as coordenadas representam um submarino (acertou o tiro)...
					System.out.println("Fogo");	
					destruidos++; //incrementa número de submarinos destruídos
				}				
			}
			System.out.println();
			tiros--;
		}
		
		//imprime o tabuleiro (matriz) para exibir resultado final
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.printf("%d\t", tabuleiro[i][j]);
				if(j==3)
					System.out.println();
			}
		}
		
		sc.close();
	}

}
