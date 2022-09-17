package nPuzzle;
import java.util.Random;
import java.util.Scanner;
import java.io.*;


public abstract class Matriz implements Constantes {
	Scanner sc = new Scanner(System.in);
	
	
	private int [] [] tabuleiro;
	private int [] [] matrizResposta;
	private int x,y;
	private Random rand = new Random();
	
	
	
	public Matriz(int tamanhoTabuleiro ) {
		this.tabuleiro=new int [tamanhoTabuleiro] [tamanhoTabuleiro];
		this.matrizResposta= new int [tamanhoTabuleiro] [tamanhoTabuleiro];
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
	
	public void moverPeca()throws NumeroInvalido {
		int pecaSelecionada=0;
		
		for(int k=0;k<4;k++) {
			if(pecasMovi[k]!=0) {
				System.out.println(pecasMovi[k]);
			}	
		}
			System.out.println("Insira um dos numeros mostrados");
		
			try {
			pecaSelecionada= sc.nextInt();	
			}catch(Exception e){
				throw new NumeroInvalido("Valor Invalido");
			}
			if(pecaSelecionada!=0&& pecaSelecionada == pecasMovi[0]|| pecaSelecionada == pecasMovi[1]||pecaSelecionada == pecasMovi[2]
					||pecaSelecionada == pecasMovi[3]) {
				
			
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(this.tabuleiro[i][j]==pecaSelecionada) {
					this.tabuleiro[i][j]=0;
					this.tabuleiro[y][x]=pecaSelecionada;
				}
			}
		}
		
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
	
}
