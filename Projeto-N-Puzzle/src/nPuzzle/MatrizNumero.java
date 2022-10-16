package nPuzzle;
import java.util.Random;



public class MatrizNumero implements Constantes{
	private int [] [] tabuleiro;
	private int [] [] matrizResposta;
	private int [] numerosUsados;
	private int x, y,tamanhoTabuleiro,temp,winCon,contador=0;
	private Random rand = new Random();
	
	public MatrizNumero(int tamanhoTabuleiro) {
		this.tabuleiro= new int [tamanhoTabuleiro] [tamanhoTabuleiro];
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
					setX(j);
					setY(i);
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
		if(getX()-1>-1) {
			pecasMoviNum[0]=getTabuleiro()[getY()][getX()-1];
		}if(getX()+1<getTamanhoTabuleiro()) {
			pecasMoviNum[1]=getTabuleiro()[getY()][getX()+1];
		}if(getY()-1>-1) {
			pecasMoviNum[2]=getTabuleiro()[getY()-1][getX()];
		}if(getY()+1<getTamanhoTabuleiro()) {
			pecasMoviNum[3]=getTabuleiro()[getY()+1][getX()];
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
	
	public void winCondition() {
		winCon=0;
		for(int i=0;i<getTamanhoTabuleiro();i++) {
			for(int j=0;j<getTamanhoTabuleiro();j++) {
				if(getTabuleiro()[i][j]==getMatrizResposta()[i][j]) {
					winCon=winCon+1; 
				}
			}
		}
	}
	
	public void moverPecaP(int pecaSelecionada) {
		for(int i=0;i<getTamanhoTabuleiro();i++) {
			for(int j=0;j<getTamanhoTabuleiro();j++) {
				if(getTabuleiro()[i][j]==pecaSelecionada) {
					getTabuleiro()[i][j]=0;
					getTabuleiro()[getY()][getX()]=pecaSelecionada;
				}
			}
		}
		setContador(getContador()+1);
		winCondition();
	}

	public int [] [] getTabuleiro() {
		return tabuleiro;
	}
	
	public void setTabuleiroMatriz(int [][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}


	public void setTabuleiro(int tabuleiro,int i,int j) {
		this.tabuleiro[i][j] = tabuleiro;
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

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	public int getContador() {
		return contador;
	}
	public int getWinCon() {
		return winCon;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}
	
}
