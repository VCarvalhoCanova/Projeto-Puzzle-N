package nPuzzle;

import java.util.Random;
import java.util.Scanner;

public class MatrizChar extends Matriz{
Scanner sc = new Scanner(System.in);
	
	
	private char [] [] tabuleiro;
	private char [] [] matrizResposta; 
	private char pecaSelecionada;
	private int x,y;
	private Random rand = new Random();
	
	
	
	public MatrizChar(int tamanhoTabuleiro) {
		super(tamanhoTabuleiro);
		this.tabuleiro = new char[3][3];
		this.matrizResposta = new char [3][3];
	}
		
	public int check(int temp, int [] numerosUsados) {
		for(int i=0;i<=7;i++) {
			if (numerosUsados[i]==temp){
				numerosUsados[i]=0;
				return temp;
			}	
		}
		temp=rand.nextInt(1,10);
		temp = check(temp,numerosUsados);
		return temp;
	}
	
	public void pecaMovimentaveis(){
		for(int k=0;k<4;k++) {
			pecasMoviChar[k]=0;
		}
		if(x-1>-1) {
			pecasMoviChar[0]=this.tabuleiro[y][x-1];
		}if(x+1<3) {
			pecasMoviChar[1]=this.tabuleiro[y][x+1];
		}if(y-1>-1) {
			pecasMoviChar[2]=this.tabuleiro[y-1][x];
		}if(y+1<3) {
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
		
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(this.tabuleiro[i][j]==pecaSelecionada) {
					this.tabuleiro[i][j]=0;
					this.tabuleiro[y][x]=pecaSelecionada;
				}
			}
		}
	}
	
	
	public void criarTabuleiro() {
		int cont=0;
		int temp;
		int [] numerosUsados = {1,2,3,4,5,6,7,8};
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				matrizResposta[i][j]=(char)((cont+1)+64);
				if(i==2 && j==2) {
					this.matrizResposta[i][j]=0;
					this.tabuleiro[i][j]=0;
					System.out.print(this.tabuleiro[i][j]);
					break;
				}
				temp = rand.nextInt(1,9);
				temp = check(temp,numerosUsados);
				this.tabuleiro[i][j]=(char) (temp+64);
				System.out.print((char)this.tabuleiro[i][j]);
			
			}
			
			System.out.println();
		}
		
	}
	public void exibirTabuleiro() {
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
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
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++){
				if(tabuleiro[i][j]==0) {
					x=j;
					y=i;
				}
			}
		}
	}
	
	
		


	@Override
	public int check() {
		// TODO Auto-generated method stub
		return 0;
	}

} 