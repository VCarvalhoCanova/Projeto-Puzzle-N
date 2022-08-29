package nPuzzle;

import java.util.Random;
import java.util.Scanner;

public class MatrizChar extends Matriz{
Scanner sc = new Scanner(System.in);
	
	
	private char [] [] tabuleiro = new char [3] [3];
	private int [] [] matrizResposta = new int [3] [3];
	private Random rand = new Random();
	
	
	
	
		
	
	
	public void PosicaoDe0() {
		int posicaoX,posicaoY;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++){
				if(this.tabuleiro[i][j]==0) {
					posicaoX=j;
					posicaoY=i;
					pecaMovimentaveis(posicaoX,posicaoY);
				}
			}
		}
	}
	
	public void pecaMovimentaveis(int x,int y){
		char [] pecasMovi = new char [4];
		if(x-1>-1) {
			pecasMovi[0]=this.tabuleiro[y][x-1];
		}if(x+1<3) {
			pecasMovi[1]=this.tabuleiro[y][x+1];
		}if(y-1>-1) {
			pecasMovi[2]=this.tabuleiro[y-1][x];
		}if(y+1<3) {
			pecasMovi[3]=this.tabuleiro[y+1][x];
		}
		moverPeca(pecasMovi,x,y);
	}
	
	public void moverPeca(char [] pecasMovi,int x,int y) {
		char pecaSelecionada;
		for(int k=0;k<4;k++) {
			if(pecasMovi[k]!=0) {
				System.out.println(pecasMovi[k]);
			}	
		}pecaSelecionada= sc.next().charAt(0);
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(this.tabuleiro[i][j]==pecaSelecionada) {
					this.tabuleiro[i][j]=0;
					this.tabuleiro[y][x]=pecaSelecionada;
				}
			}
		}
		exibirTabuleiro();
	}
	
    
	public void exibirTabuleiro() {
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(this.tabuleiro[i][j]);
			}
			System.out.println();
		}
	}
	
	public void criarTabuleiro() {
		int cont=0;
		int temp;
		int [] numerosUsados = {1,2,3,4,5,6,7,8};
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				this.matrizResposta[i][j]=cont+1;
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
	
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MatrizChar m = new MatrizChar();	
		//m.criarTabuleiro();
		//for(int i=0;i<4;i++){
			//m.PosicaoDe0();	
		//}
		
			
		sc.close();
	}
} 