package nPuzzleUsuario;

import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ranking implements Serializable{
	private static final long serialVersionUID= 2L;
	private Menu m;
    private JFrame frame = new JFrame();
    private JLabel label;
    private JLabel [] labelRanking= new JLabel [10];
	private  String [] top10Jogadores= new String [10];
	private int [] top10Pontuacoes= new int [10];
	private String [] modoDoJogador= new String [10];
	private int novaPontuacao;
	private int temp;
	
	
	public Ranking() {
		this.top10Jogadores=top10Jogadores;
		this.top10Pontuacoes=top10Pontuacoes;
		this.modoDoJogador=modoDoJogador;
	}
	
	 public void criarFrame() {
	    	frame.setSize(800, 800);
	    	frame.setLayout(null);
	    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    frame.setVisible(true);
	    }
	public void criarLabelRanking() {
		for(int i=9;i>-1;i--) {
			try {
				loadRanking();
				labelRanking[i]= new JLabel("Nome: "+top10Jogadores[i]+" Modo: "+modoDoJogador[i]+" Pontuacao: "+top10Pontuacoes[i]);
			}catch(Exception e){
				
			}
			
			labelRanking[i].setBounds(200, 40*i, 200, 40);
			frame.getContentPane().add(labelRanking[i]);
		}
	}
	
	public void loadErro() {
		label = new JLabel("Não foi possivel carregar o ranking");
		label.setBounds(200,500,300,200);
		frame.getContentPane().add(label);
	}
	
	public void saveRanking() {
		Ranking r = new Ranking();
		for(int i=9;i>-1;i--) {
			r.top10Jogadores[i]=top10Jogadores[i];
			r.top10Pontuacoes[i]=top10Pontuacoes[i];
			r.modoDoJogador[i]=modoDoJogador[i];
		}
		try {
			SalvarECarregar.save(r, "resource//1.ranking");
			System.out.println("salvo");
			System.out.println(r.top10Jogadores[0]);
		}catch(Exception e){
				System.out.print("Não conseguiu Salvar");
		}
		
	}
	
	
	public void loadRanking() {
		try {
			Ranking r = (Ranking) SalvarECarregar.load("resource//1.ranking");
			top10Jogadores=r.top10Jogadores;
			top10Pontuacoes=r.top10Pontuacoes;
			modoDoJogador=r.modoDoJogador;
			
		}catch (Exception e) {
			loadErro();
		}
		
	}

	public void verificarPontuacao(int contadorDePassos,String Modo, int dificuldade, int nivelDeMaluquice) {
		novaPontuacao=(300*dificuldade)+(600*nivelDeMaluquice)-(5*contadorDePassos);
	}
	
	public void rankearJogadores() {
		for(int i=9;i>0;i++) {
			if(novaPontuacao>top10Pontuacoes[i]) {
				temp=top10Pontuacoes[i];
				top10Pontuacoes[i]=novaPontuacao;
				try {
					top10Pontuacoes[i-1]=temp;
				}catch(Exception e){
					
				}
			}
		}
	}
	
	
	public String [] getModoDoJogador() {
		return modoDoJogador;
	}
	public void setModoDoJogador(String [] modoDoJogador) {
		this.modoDoJogador = modoDoJogador;
	}
	public int [] getTop10Pontuacoes() {
		return top10Pontuacoes;
	}
	public void setTop10Pontuacoes(int [] top10Pontuacoes) {
		this.top10Pontuacoes = top10Pontuacoes;
	}
	public String [] getTop10Jogadores() {
		return top10Jogadores;
	}
	public void setTop10Jogadores(String [] top10Jogadores) {
		this.top10Jogadores = top10Jogadores;
	}
	
	
	
}
