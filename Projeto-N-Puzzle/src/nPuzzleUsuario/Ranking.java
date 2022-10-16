package nPuzzleUsuario;

import java.io.File;
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
	private int [] top10Tempos = new int[10];
	private String [] modoDoJogador= new String [10];
	private int novaPontuacao,novoTempo;
	private String novoJogador;
	private String novoModo;
	private int temp,tempTempo;
	private String tempNome="Bot";
	private String tempModo="N";
	
	
	public Ranking() {
		this.top10Jogadores=top10Jogadores;
		this.top10Pontuacoes=top10Pontuacoes;
		this.modoDoJogador=modoDoJogador;
		this.top10Tempos=top10Tempos;
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
				labelRanking[i]= new JLabel("Nome: "+top10Jogadores[i]+" Modo: "+modoDoJogador[i]+" Pontuacao: "+top10Pontuacoes[i]+" Melhor Tempo: "+top10Tempos[i]);
			}catch(Exception e){
				
			}
			
			labelRanking[i].setBounds(200, 50*i, 500, 40);
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
			try {
			r.top10Jogadores[i]=top10Jogadores[i];
			r.top10Pontuacoes[i]=top10Pontuacoes[i];
			r.modoDoJogador[i]=modoDoJogador[i];
			r.top10Tempos[i]=top10Tempos[i];
			}catch(Exception e){
				r.top10Jogadores[i]="AAA";
				r.top10Pontuacoes[i]=1000-(100*i);
				r.modoDoJogador[i]="N";
				r.top10Tempos[i]=((500*i)+600);
			}
		}
		try {
			SalvarECarregar.save(r, "resource//1.ranking");
			
		}catch(Exception e){
				
		}
		
	}
	public void rankingDefault() {
		Ranking r= new Ranking();
		for(int i=9;i>-1;i--) {
			r.top10Jogadores[i]="AAA";
			r.top10Pontuacoes[i]=1000-(100*i);
			r.modoDoJogador[i]="N";
			r.top10Tempos[i]=((50*i)+50);
		}
		try{
			SalvarECarregar.save(r, "resource//1.ranking");
			
		}catch(Exception e) {
		
		}
	}
		
	public void loadRanking() {
		try {
			Ranking r = (Ranking) SalvarECarregar.load("resource//1.ranking");
			top10Jogadores=r.top10Jogadores;
			top10Pontuacoes=r.top10Pontuacoes;
			modoDoJogador=r.modoDoJogador;
			top10Tempos=r.top10Tempos;
		}catch (Exception e) {
			loadErro();
		}
		
	}

	public void verificarPontuacao(int elapsedTime,String modo, String nome,int dificuldade, int nivelDeMaluquice) {
		File f = new File("resource//1.ranking");
		if(f.exists()==false) {
			rankingDefault();
		}
		
		m= new Menu(false);
		novaPontuacao=(500*dificuldade)+(10000*nivelDeMaluquice)-(1*elapsedTime);
		novoModo=modo;
		novoJogador=nome;
		novoTempo=elapsedTime;
		System.out.println(novoJogador);
		loadRanking();
		rankearJogadores();
		criarFrame();
		criarLabelRanking();
		m.voltarAoMenuPrincipal();
	}
	
	public void rankearJogadores() {
		saveRanking();
		for(int i=9;i>-1;i--) {
			if(novaPontuacao>top10Pontuacoes[i]) {
				temp=top10Pontuacoes[i];
				top10Pontuacoes[i]=novaPontuacao;
				tempNome.replace(tempNome, top10Jogadores[i]);
				top10Jogadores[i]=novoJogador;
				tempModo.replace(tempModo, top10Jogadores[i]);
				modoDoJogador[i]=novoModo;
				tempTempo=top10Tempos[i];
				top10Tempos[i]=novoTempo;
				try {
					
					top10Pontuacoes[i+1]=temp;
					top10Jogadores[i+1]=tempNome;
					modoDoJogador[i+1]=tempModo;
					top10Tempos[i+1]=tempTempo;
				}catch(Exception e){
					
				}
			}else if(novaPontuacao<top10Pontuacoes[i]){
				
				break;
			}
		}
		saveRanking();
		
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

	public String getNovoModo() {
		return novoModo;
	}

	public void setNovoModo(String novoModo) {
		this.novoModo = novoModo;
	}

	public String getNovoJogador() {
		return novoJogador;
	}

	public void setNovoJogador(String novoJogador) {
		this.novoJogador = novoJogador;
	}

	public String getTempModo() {
		return tempModo;
	}

	public void setTempModo(String tempModo) {
		this.tempModo = tempModo;
	}
	
	
	
}
