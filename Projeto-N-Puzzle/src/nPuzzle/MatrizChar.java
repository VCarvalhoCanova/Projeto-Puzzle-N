package nPuzzle;

import java.util.Random;
import java.util.Scanner;

public class MatrizChar extends Matriz{
Scanner sc = new Scanner(System.in);
	
	private int tamanhoTabuleiro;
	private char [] [] tabuleiro;
	private char [] [] matrizResposta; 
	private char pecaSelecionada;
	private int x,y,temp;
	private int [] numerosUsados;
	private Random rand = new Random();
	
	
	
	public MatrizChar(int tamanhoTabuleiro) {
		super(tamanhoTabuleiro);
		this.tamanhoTabuleiro=tamanhoTabuleiro;
		this.tabuleiro = new char[tamanhoTabuleiro][tamanhoTabuleiro];
		this.matrizResposta = new char [tamanhoTabuleiro][tamanhoTabuleiro];
		this.numerosUsados = new int [tamanhoTabuleiro*tamanhoTabuleiro];
	}
	
	public void pecaMovimentaveis(){
		for(int k=0;k<4;k++) {
			pecasMoviChar[k]=0;
		}
		if(x-1>-1) {
			pecasMoviChar[0]=this.tabuleiro[y][x-1];
		}if(x+1<tamanhoTabuleiro) {
			pecasMoviChar[1]=this.tabuleiro[y][x+1];
		}if(y-1>-1) {
			pecasMoviChar[2]=this.tabuleiro[y-1][x];
		}if(y+1<tamanhoTabuleiro) {
			pecasMoviChar[3]=this.tabuleiro[y+1][x];
		}
	}
	
	public void moverPeca() throws ValorInvalido {
		
		for(int k=0;k<4;k++) {
			if(pecasMoviChar[k]!=0) {
				System.out.println(pecasMoviChar[k]);
			}	
		}
		try {
			pecaSelecionada= sc.next().charAt(0);
		}catch(Exception e) {
			System.err.print("Por favor, insira um caractere");
			sc.next();
		}
		
		
		for(int i=0;i<tamanhoTabuleiro;i++) {
			for(int j=0;j<tamanhoTabuleiro;j++) {
				if(this.tabuleiro[i][j]==pecaSelecionada) {
					this.tabuleiro[i][j]=0;
					this.tabuleiro[y][x]=pecaSelecionada;
				}
			}
		}
	}
	
	
	public void criarTabuleiro() {
		int cont=0;
		for(int i=1;i<(tamanhoTabuleiro*tamanhoTabuleiro);i++) {
			numerosUsados [i]=i;
	}

		
		
		
		for(int i=0;i<tamanhoTabuleiro;i++) {
			
			for(int j=0;j<tamanhoTabuleiro;j++) {
				temp=0;
				matrizResposta[i][j]=(char)((cont+1)+64);
				if(i==(tamanhoTabuleiro-1) && j==(tamanhoTabuleiro-1)) {
					this.matrizResposta[i][j]=0;
					this.tabuleiro[i][j]=0;
					System.out.print(this.tabuleiro[i][j]);
					break;
				}
				temp = rand.nextInt(1,tamanhoTabuleiro*tamanhoTabuleiro);
				temp = check();
				this.tabuleiro[i][j]=(char) (temp+64);
				System.out.print((char)this.tabuleiro[i][j]);
			
			}
			
			System.out.println();
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
	}
	public void posicaoDe0() {
		for(int i=0;i<tamanhoTabuleiro;i++) {
			for(int j=0;j<tamanhoTabuleiro;j++){
				if(tabuleiro[i][j]==0) {
					x=j;
					y=i;
				}
			}
		}
	}
	
	
	public int check() {
		for(int i=0;i<tamanhoTabuleiro*tamanhoTabuleiro;i++) {
			if (numerosUsados[i]==temp){
				numerosUsados[i]=0;
				return temp;
			}	
		}
		 temp=rand.nextInt(1,(tamanhoTabuleiro*tamanhoTabuleiro));
		 return temp=check();
		
	}

} 