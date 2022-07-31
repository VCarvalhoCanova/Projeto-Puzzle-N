package nPuzzle;
import java.util.Random;


public class Matriz {
	
	private int [] [] tabuleiro = new int [3] [3];
	private Random rand = new Random();
	
	
	
	
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
	
	
	
	
	public void criaTabuleiro() {
		
		int temp;
		int [] numerosUsados = {1,2,3,4,5,6,7,8};
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(i==2 && j==2) {
					this.tabuleiro[i][j]=0;
					System.out.print(this.tabuleiro[i][j]);
					break;
				}
				temp = rand.nextInt(1,9);
					temp = check(temp,numerosUsados);
					
					this.tabuleiro[i][j]=temp;
					
				
				
				System.out.print(this.tabuleiro[i][j]);
			
			}
			
			System.out.println();
		}
		
	}
	
		
	public static void main(String[] args) {
		Matriz m = new Matriz();	
			m.criaTabuleiro();
			
		
	}
	
}
