package nPuzzle;
import java.util.Random;
import java.util.Scanner;
import java.io.*;


public abstract class Matriz implements Constantes {
	Scanner sc = new Scanner(System.in);
	
	
	private int [] [] tabuleiro;
	private int [] [] matrizResposta;
	private int x,y;
	
	public Matriz(int tamanhoTabuleiro) {
		this.tabuleiro=new int [tamanhoTabuleiro] [tamanhoTabuleiro];
		this.matrizResposta= new int [tamanhoTabuleiro] [tamanhoTabuleiro];
	}
	
	
	public abstract int check();
		
	
	public void posicaoDe0() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++){
				if(tabuleiro[i][j]==0) {
					x=j;
					y=i;
				}
			}
		}
	}
	
	public abstract void pecaMovimentaveis();
	
	public abstract void moverPeca() throws ValorInvalido;
		 
	public void exibirTabuleiro() {
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(tabuleiro [i][j]==matrizResposta[i][j]) {
					System.out.print(tabuleiro[i][j]+"=C ");
				}else {
					System.out.print(tabuleiro[i][j]+"=E ");
				}
				
			}
			
				System.out.println();
			
			
		}
	}
	
	
	
	public abstract void criarTabuleiro();
		
	
}
