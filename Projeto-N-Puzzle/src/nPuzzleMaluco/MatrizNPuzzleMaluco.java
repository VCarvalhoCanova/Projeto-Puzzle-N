package nPuzzleMaluco;
import nPuzzle.*;
import nPuzzle.ValorInvalido;

import java.util.Random;
import java.util.Scanner;

public abstract class MatrizNPuzzleMaluco implements Constantes {
		private int nivelDeMaluquice,x,y,xRand,yRand;
		private int [] [] tabuleiro,matrizResposta ;
		private Random rand= new Random();
		Scanner sc = new Scanner(System.in);
		
		public MatrizNPuzzleMaluco(int tamanhoTabuleiro, int nivelDeMaluquice) {
			this.tabuleiro= new int [tamanhoTabuleiro] [tamanhoTabuleiro];
			this.matrizResposta= new int [tamanhoTabuleiro] [tamanhoTabuleiro];
			this.setNivelDeMaluquice(nivelDeMaluquice);
		}
		public abstract int check(); 
		
		public abstract void posicaoDe0();
		
		public abstract void pecaMovimentaveis();
		
		public abstract void moverPeca() throws ValorInvalido;
		
	    
		public abstract void exibirTabuleiro();
		
		public abstract void criarTabuleiro();	
		
		public abstract void chanceDeEmbaralhar();
		
		public abstract void pecasEmbaralhaveis();
		
		public abstract void embaralharPecas();
		public int getNivelDeMaluquice() {
			return nivelDeMaluquice;
		}
		public void setNivelDeMaluquice(int nivelDeMaluquice) {
			this.nivelDeMaluquice = nivelDeMaluquice;
		}
		
		
		
		
}
