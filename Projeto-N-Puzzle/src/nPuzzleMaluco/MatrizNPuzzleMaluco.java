package nPuzzleMaluco;
import nPuzzle.*;

import java.util.Random;
import java.util.Scanner;

public abstract class MatrizNPuzzleMaluco extends Matriz {
		private int nivelDeMaluquice,x,y,xRand,yRand;
		private int [] numerosMalucos;
		private int [] [] tabuleiro ;
		private Random rand= new Random();
		Scanner sc = new Scanner(System.in);
		
		public MatrizNPuzzleMaluco(int tamanhoTabuleiro, int nivelDeMaluquice) {
			super(tamanhoTabuleiro);
			this.tabuleiro= new int [tamanhoTabuleiro] [tamanhoTabuleiro];
			this.numerosMalucos= new int [2];
			this.nivelDeMaluquice=nivelDeMaluquice;
		}
		
		public void criaTabuleiro() {
			super.criarTabuleiro();
		}
		
		public void chanceDeEmbaralhar(){
			int temp= rand.nextInt(0,10);
			if(nivelDeMaluquice>temp) {
				embaralharPecas();
			}
		}
		
		public void pecasEmbaralhaveis() {
			int cont=0;
			while(true) {
			if(tabuleiro[yRand][xRand]!=tabuleiro[y][x] && tabuleiro[yRand][xRand]!=0 && tabuleiro[yRand][xRand]!= numerosMalucos[0]) {
				numerosMalucos[cont]=tabuleiro[yRand][xRand];
				cont=cont+1;
			}
			if(cont==2) {
			break;	
			}
			
			}
		}
		
		public void embaralharPecas() {
			pecasEmbaralhaveis();
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					if(tabuleiro[1][j]== numerosMalucos [0]) {
						tabuleiro[i][j]= numerosMalucos [1];
					}else if(tabuleiro[i][j]==numerosMalucos[1]) {
						tabuleiro[i][j]= numerosMalucos[0];
					}
				}
			}
		}
		
		public void exibirTabuleiro() {
			super.exibirTabuleiro();
		}
		
		
}
