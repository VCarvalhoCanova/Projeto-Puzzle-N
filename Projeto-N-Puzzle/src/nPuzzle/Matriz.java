package nPuzzle;
import java.util.Random;


public class Matriz {
	
	private int [] [] tabuleiro = new int [3] [3];
	private int [] numeroUsados = new int [9];
	private Random rand = new Random();
	
	
	
	
	public int check(int temp) {
		for(int i=0;i<8;i++) {
			if (this.numeroUsados[i]==0 && i==temp){
				this.numeroUsados[i]=temp;
				break;
			}else {
				while(temp==this.numeroUsados[i]){
					temp=rand.nextInt(1, 9);
				}
				this.numeroUsados[i]=temp;
				temp=this.numeroUsados[i];
			}
			
		}
		return temp;
	}
	
	
	
	
	public void criaTabuleiro() {
		
		int temp;
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<3;j++) {
				temp = rand.nextInt(1,9);
					temp = check(temp);
					
				if (this.tabuleiro[i][j]==0) {
					this.tabuleiro[i][j]=temp;
				}
							
			}
		}
	}
	
		
	public static void main(String[] args) {
		Matriz m = new Matriz();	
			m.criaTabuleiro();
			
		
	}
	
}
