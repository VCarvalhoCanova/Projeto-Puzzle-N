package nPuzzleMaluco;
import nPuzzle.*;

import java.util.Random;
import java.util.Scanner;

public abstract class MatrizNPuzzleMaluco {
		private int nivelDeMaluquice,x,y,xRand,yRand;
		private int [] numerosMalucos,pecasMovi;
		private int [] [] tabuleiro,matrizResposta ;
		private Random rand= new Random();
		Scanner sc = new Scanner(System.in);
		
		public MatrizNPuzzleMaluco(int tamanhoTabuleiro, int nivelDeMaluquice) {
			this.tabuleiro= new int [tamanhoTabuleiro] [tamanhoTabuleiro];
			this.matrizResposta= new int [tamanhoTabuleiro] [tamanhoTabuleiro];
			this.pecasMovi= new int [4];
			this.numerosMalucos= new int [2];
			this.nivelDeMaluquice=nivelDeMaluquice;
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
		
		public void posicaoDe0() {
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++){
					if(this.tabuleiro[i][j]==0) {
						this.x=j;
						this.y=i;
						
					}
				}
			}
		}
		
		public void pecaMovimentaveis(){
			for(int k=0;k<4;k++) {
				pecasMovi[k]=0;
			}
			if(x-1>-1) {
				pecasMovi[0]=this.tabuleiro[y][x-1];
			}if(x+1<3) {
				pecasMovi[1]=this.tabuleiro[y][x+1];
			}if(y-1>-1) {
				pecasMovi[2]=this.tabuleiro[y-1][x];
			}if(y+1<3) {
				pecasMovi[3]=this.tabuleiro[y+1][x];
			}
		}
		
		public void moverPeca() {
			int pecaSelecionada=0;
			
			for(int k=0;k<4;k++) {
				if(pecasMovi[k]!=0) {
					System.out.println(pecasMovi[k]);
				}	
			}
				System.out.println("Insira um dos numeros mostrados");
			while(true) {
				pecaSelecionada= sc.nextInt();	
				if(pecaSelecionada!=0&& pecaSelecionada == pecasMovi[0]|| pecaSelecionada == pecasMovi[1]||pecaSelecionada == pecasMovi[2]
						||pecaSelecionada == pecasMovi[3]) {
					break;
				}
				
			}
				
			
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
			int temp;
			int [] numerosUsados = {1,2,3,4,5,6,7,8};
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					matrizResposta[i][j]=cont+1;
					cont=cont+1;
					if(i==2 && j==2) {
						matrizResposta[i][j]=0;
						tabuleiro[i][j]=0;
						break;
					}
					temp = rand.nextInt(1,9);
					temp = check(temp,numerosUsados);
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
			xRand = rand.nextInt(0, 3);
			yRand= rand.nextInt(0, 3);
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
					if(tabuleiro[i][j]== numerosMalucos [0]) {
						tabuleiro[i][j]= numerosMalucos [1];
					}else if(tabuleiro[i][j]==numerosMalucos[1]) {
						tabuleiro[i][j]= numerosMalucos[0];
					}
				}
			}
		}
		
		
		
		
}
