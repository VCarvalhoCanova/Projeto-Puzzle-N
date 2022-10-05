package nPuzzleMaluco;

import java.util.Random;
import java.util.Scanner;

import nPuzzle.ValorInvalido;

public class MatrizNPuzzleMalucoNumero extends MatrizNPuzzleMaluco {
	
	private int nivelDeMaluquice,x,y,xRand,yRand,temp,tamanhoTabuleiro;
	private int [] numerosUsados;
	private int [] [] tabuleiro,matrizResposta ;
	private Random rand= new Random();
	
	
	public MatrizNPuzzleMalucoNumero(int tamanhoTabuleiro, int nivelDeMaluquice) {
		super(tamanhoTabuleiro, nivelDeMaluquice);
		this.tamanhoTabuleiro=tamanhoTabuleiro;
		matrizResposta = new int [tamanhoTabuleiro] [tamanhoTabuleiro];
		numerosUsados= new int[tamanhoTabuleiro*tamanhoTabuleiro];
		tabuleiro= new int [tamanhoTabuleiro] [tamanhoTabuleiro];
		
	}
	
	public int check() {
		for(int i=0;i<(tamanhoTabuleiro*tamanhoTabuleiro);i++) {
			if (numerosUsados[i]==temp){
				numerosUsados[i]=0;
				return temp;
			}	
		}
		temp=rand.nextInt(1,tamanhoTabuleiro*tamanhoTabuleiro);
		temp = check();
		return temp;
	}
	
	public void posicaoDe0() {
		for(int i=0;i<tamanhoTabuleiro;i++) {
			for(int j=0;j<tamanhoTabuleiro;j++){
				if(this.tabuleiro[i][j]==0) {
					this.x=j;
					this.y=i;
					
				}
			}
		}
	}
	
	public void pecaMovimentaveis(){
		for(int k=0;k<4;k++) {
			pecasMoviNum[k]=0;
		}
		if(x-1>-1) {
			pecasMoviNum[0]=this.tabuleiro[y][x-1];
		}if(x+1<tamanhoTabuleiro) {
			pecasMoviNum[1]=this.tabuleiro[y][x+1];
		}if(y-1>-1) {
			pecasMoviNum[2]=this.tabuleiro[y-1][x];
		}if(y+1<tamanhoTabuleiro) {
			pecasMoviNum[3]=this.tabuleiro[y+1][x];
		}
	}
	
	public void moverPeca() throws ValorInvalido {
		int pecaSelecionada=0;
		for(int k=0;k<4;k++) {
			if(pecasMoviNum[k]!=0) {
				System.out.println(pecasMoviNum[k]);
			}	
		}
			System.out.println("Insira um dos numeros mostrados");
		while(true) {
			try {
			pecaSelecionada= sc.nextInt();	
			break;
			}catch (Exception e){
				System.err.println("Por favor, insira um número ");
			    sc.next();
			}
		}
			if(pecaSelecionada == pecasMoviNum[0]|| pecaSelecionada == pecasMoviNum[1]||pecaSelecionada == pecasMoviNum[2]
					||pecaSelecionada == pecasMoviNum[3]) {
				
			
		for(int i=0;i<tamanhoTabuleiro;i++) {
			for(int j=0;j<tamanhoTabuleiro;j++) {
				if(tabuleiro[i][j]==pecaSelecionada) {
					tabuleiro[i][j]=0;
					tabuleiro[y][x]=pecaSelecionada;
				}
			}
		}
		
	}
}
	
	
    
	public void exibirTabuleiro() {
		
		for(int i=0;i<tamanhoTabuleiro;i++) {
			for(int j=0;j<tamanhoTabuleiro;j++) {
				if(this.tabuleiro [i][j]==this.matrizResposta[i][j]) {
					System.out.print(this.tabuleiro[i][j]+"=C ");
				}else {
					System.out.print(this.tabuleiro[i][j]+"=E ");
				}
				
			}
			
				System.out.println();
			
			
		}
		System.out.println();
	}
	
	public void criarTabuleiro() {
		int cont=0;
		for(int i=0;i<tamanhoTabuleiro*tamanhoTabuleiro;i++) {
			numerosUsados[i]=i+1;
		}
		for(int i=0;i<tamanhoTabuleiro;i++) {
			temp=0;
			for(int j=0;j<tamanhoTabuleiro;j++) {
				matrizResposta[i][j]=cont+1;
				cont=cont+1;
				if(i==tamanhoTabuleiro-1 && j==tamanhoTabuleiro-1) {
					matrizResposta[i][j]=0;
					tabuleiro[i][j]=0;
					break;
				}
				temp = rand.nextInt(1,tamanhoTabuleiro*tamanhoTabuleiro);
				temp = check();
				this.tabuleiro[i][j]=temp;
				
			
			}
			
			
		}
			
	}
	public void chanceDeEmbaralhar(){
		int temp= rand.nextInt(0,10);
		if(nivelDeMaluquice>temp) {
		}
		embaralharPecas();
	}
	
	public void pecasEmbaralhaveis() {
		int cont=0;
		while(true) {
		xRand = rand.nextInt(0, tamanhoTabuleiro);
		yRand= rand.nextInt(0, tamanhoTabuleiro);
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
		for(int i=0;i<tamanhoTabuleiro;i++) {
			for(int j=0;j<tamanhoTabuleiro;j++) {
				if(tabuleiro[i][j]== numerosMalucos [0]) {
					tabuleiro[i][j]= numerosMalucos [1];
				}else if(tabuleiro[i][j]==numerosMalucos[1]) {
					tabuleiro[i][j]= numerosMalucos[0];
				}
			}
		}
	}
	
	
	
	
	
	
}
