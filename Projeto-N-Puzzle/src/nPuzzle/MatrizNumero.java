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
		this.setTabuleiro(new int [tamanhoTabuleiro] [tamanhoTabuleiro]);
		this.setMatrizResposta(new int [tamanhoTabuleiro] [tamanhoTabuleiro]);
		this.numerosUsados = new int [tamanhoTabuleiro*tamanhoTabuleiro];
		this.setTamanhoTabuleiro(tamanhoTabuleiro);
	}
	
	public int check() {
		
		for(int i=0;i<getTamanhoTabuleiro()*getTamanhoTabuleiro();i++) {
			if (numerosUsados[i]==temp){
				numerosUsados[i]=0;
				return temp;
			}	
		}
		 temp=rand.nextInt(1,(getTamanhoTabuleiro()*getTamanhoTabuleiro()));
		 return temp=check();
	}
		
	
	public void posicaoDe0() {
		for(int i=0;i<getTamanhoTabuleiro();i++) {
			for(int j=0;j<getTamanhoTabuleiro();j++){
				if(getTabuleiro()[i][j]==0) {
					x=j;
					y=i;
				}
			}
		}
	}
	
public void exibirTabuleiro() {
		
		for(int i=0;i<getTamanhoTabuleiro();i++) {
			for(int j=0;j<getTamanhoTabuleiro();j++) {
				if(getTabuleiro() [i][j]==getMatrizResposta()[i][j]) {
					System.out.print(getTabuleiro()[i][j]+"=C ");
				}else {
					System.out.print(getTabuleiro()[i][j]+"=E ");
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
			pecasMoviNum[0]=getTabuleiro()[y][x-1];
		}if(x+1<3) {
			pecasMoviNum[1]=getTabuleiro()[y][x+1];
		}if(y-1>-1) {
			pecasMoviNum[2]=getTabuleiro()[y-1][x];
		}if(y+1<3) {
			pecasMoviNum[3]=getTabuleiro()[y+1][x];
		}
	}
		
	
	public void criarTabuleiro() {
		int cont=0;
		
		for(int i=0;i<(getTamanhoTabuleiro()*getTamanhoTabuleiro());i++) {
			numerosUsados [i]=i;
	}
		
		
		for(int i=0;i<getTamanhoTabuleiro();i++) {
			temp=0;
			for(int j=0;j<getTamanhoTabuleiro();j++) {
				getMatrizResposta()[i][j]=cont+1;
				cont=cont+1;
				if(i==(getTamanhoTabuleiro()-1) && j==(getTamanhoTabuleiro()-1)) {
					getMatrizResposta()[i][j]=0;
					getTabuleiro()[i][j]=0;
					break;
				}
				temp = rand.nextInt(1,getTamanhoTabuleiro()*getTamanhoTabuleiro());
				temp = check();
				getTabuleiro()[i][j]=temp;
				//System.out.println(getTabuleiro()[i][j]);
				
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
				
			
		for(int i=0;i<getTamanhoTabuleiro();i++) {
			for(int j=0;j<getTamanhoTabuleiro();j++) {
				if(getTabuleiro()[i][j]==pecaSelecionada) {
					getTabuleiro()[i][j]=0;
					getTabuleiro()[y][x]=pecaSelecionada;
				}
			}
		}
		
	}
	}
	
	public void moverPecaP(int pecaSelecionada) {
		for(int i=0;i<getTamanhoTabuleiro();i++) {
			for(int j=0;j<getTamanhoTabuleiro();j++) {
				if(getTabuleiro()[i][j]==pecaSelecionada) {
					getTabuleiro()[i][j]=0;
					getTabuleiro()[y][x]=pecaSelecionada;
				}
			}
		}
	}

	public int [] [] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(int [] [] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public int [] [] getMatrizResposta() {
		return matrizResposta;
	}

	public void setMatrizResposta(int [] [] matrizResposta) {
		this.matrizResposta = matrizResposta;
	}

	public int getTamanhoTabuleiro() {
		return tamanhoTabuleiro;
	}

	public void setTamanhoTabuleiro(int tamanhoTabuleiro) {
		this.tamanhoTabuleiro = tamanhoTabuleiro;
	}
}
