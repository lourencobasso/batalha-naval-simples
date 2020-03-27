package application;

import java.util.Random;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		//instância um objeto da classe Random usando o construtor básico
		Random gerador = new Random();
		Scanner sc = new Scanner(System.in);
		int[][] tabuleiro = new int[4][4];
		int submarinos = 5;
		int destruidos = 0;
		int tiros = 10;
		int sorteio;
		int posx, posy;
		

		//imprime sequência de 10 números inteiros aleatórios entre 0 e 25
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				sorteio = gerador.nextInt(2);
				if((sorteio == 1)&&(submarinos>0)) {
					tabuleiro[i][j] = sorteio;
					submarinos--;
				}
				else
					tabuleiro[i][j] = 0;
			}
		}
		
		while((tiros>0) && (destruidos<5)) {
			System.out.println("Informe as coordenadas x e y do mapa: ");
			posx = sc.nextInt();
			posy = sc.nextInt();
			if((posx>3)||(posy>3))
				System.out.println("Suas coordenadas x e y estão fora do mapa. Você perdeu este tiro!!!");
			else {
				if(tabuleiro[posx][posy] == 0)
					System.out.println("Água");
				else {
					tabuleiro[posx][posy] = 2;
					System.out.println("Fogo");	
					destruidos++;
				}				
			}
			System.out.println();
			tiros--;
		}
		
		
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
