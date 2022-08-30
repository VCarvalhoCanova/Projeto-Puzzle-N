package nPuzzle;
import java.util.Random;
import java.util.Scanner;


public class Matriz {
	Scanner sc = new Scanner(System.in);
	
	
	protected int [] [] tabuleiro = new int [3] [3];
	protected int [] [] matrizResposta = new int [3] [3]; 
	protected int [] pecasMovi = new int [4];
	protected int x,y;
	private Random rand = new Random();

	public void destacarPeca() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++){
				if(this.tabuleiro[i][j] == (i*3+j+1)) {
					this.tabuleiro[i][j] = this.tabuleiro[i][j];
				}	
			}
		}	
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
					x=j;
					y=i;
					
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
		while(true) {
			System.out.println("Insira um dos numeros mostrados");
			pecaSelecionada= sc.nextInt();
			if((pecaSelecionada==pecasMovi[0])||(pecaSelecionada==pecasMovi[1])||(pecaSelecionada==pecasMovi[2])||(pecaSelecionada==pecasMovi[3])) {
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
				System.out.print(this.tabuleiro[i][j] + " ");
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
				if(i==2 && j==2) {
					matrizResposta[i][j]=0;
					tabuleiro[i][j]=0;
					break;
				}
				temp = rand.nextInt(1,9);
				temp = check(temp,numerosUsados);
				this.tabuleiro[i][j]=temp;
				destacarPeca();
				
			
			}
			
			
		}
		
	}
	
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Matriz m = new Matriz();
		m.criarTabuleiro();
		m.posicaoDe0();
		m.pecaMovimentaveis();
		sc.close();
	}
	
}
