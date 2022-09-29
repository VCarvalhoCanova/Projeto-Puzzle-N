package nPuzzle;
import java.util.Random;
import java.util.Scanner;


public class MatrizNumero extends Matriz{
	private MatrizNumero mN;
	private int [] [] tabuleiro;
	private int [] [] matrizResposta;
	private int [] numerosUsados;
	private int x, y,tamanhoTabuleiro,temp;
	private Random rand = new Random();
	
	public MatrizNumero(int tamanhoTabuleiro) {
		super(tamanhoTabuleiro);
		this.tabuleiro=new int [tamanhoTabuleiro] [tamanhoTabuleiro];
		this.matrizResposta= new int [tamanhoTabuleiro] [tamanhoTabuleiro];
		this.numerosUsados = new int [tamanhoTabuleiro*tamanhoTabuleiro];
		this.tamanhoTabuleiro=tamanhoTabuleiro;
	}
	
	public int check() {
		
		for(int i=0;i<=8;i++) {
			if (numerosUsados[i]==temp){
				numerosUsados[i]=0;
				return temp;
			}	
		}
		 temp=rand.nextInt(1,(tamanhoTabuleiro*tamanhoTabuleiro));
		 return temp=check();
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
	
	
	
	
	public void pecaMovimentaveis(){
		for(int k=0;k<4;k++) {
			pecasMoviNum[k]=0;
		}
		if(x-1>-1) {
			pecasMoviNum[0]=tabuleiro[y][x-1];
		}if(x+1<3) {
			pecasMoviNum[1]=tabuleiro[y][x+1];
		}if(y-1>-1) {
			pecasMoviNum[2]=tabuleiro[y-1][x];
		}if(y+1<3) {
			pecasMoviNum[3]=tabuleiro[y+1][x];
		}
	}
		
	
	public void criarTabuleiro() {
		int cont=0;
		
		for(int i=0;i<(tamanhoTabuleiro*tamanhoTabuleiro);i++) {
			numerosUsados [i]=i;
	}
		
		
		for(int i=0;i<tamanhoTabuleiro;i++) {
			temp=0;
			for(int j=0;j<tamanhoTabuleiro;j++) {
				matrizResposta[i][j]=cont+1;
				cont=cont+1;
				if(i==2 && j==2) {
					matrizResposta[i][j]=0;
					tabuleiro[i][j]=0;
					break;
				}
				temp = rand.nextInt(1,tamanhoTabuleiro*tamanhoTabuleiro);
				temp = check();
				tabuleiro[i][j]=temp;
				System.out.println(tabuleiro[i][j]);
				
			}
		
		}
		
	}
	
	
	
	public void moverPeca()throws ValorInvalido {
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
				
			
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(tabuleiro[i][j]==pecaSelecionada) {
					tabuleiro[i][j]=0;
					tabuleiro[y][x]=pecaSelecionada;
				}
			}
		}
		
	}
	}
}
