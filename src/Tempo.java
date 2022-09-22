import java.io.File;
import java.text.ParsePosition;
import java.util.ArrayList;

public class Tempo {
	private int idDia;
	private String atividade;
	private double duracao;
	
	GerenciadorDeArquivo gerenciadorTempo = new GerenciadorDeArquivo();
	
	public Tempo() {}

	public Tempo (int idDia, String atividades, double duracao) {
		this.idDia = idDia;
		// o dia existe ?
		this.atividade = atividades;
		this.duracao = duracao;
	}
	
	public int getIdDia() {
		return idDia;
	}
	
	public void setIdDia(int idDia) {
		this.idDia = idDia;
	}
	
	public String getAtividade() {
		return atividade;
	}
	
	public void setAtividade(String atividades) {
		this.atividade = atividades;
	}
	
	public double getDuracao() {
		return duracao;
	}
	
	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}
	
	public String toString() {
		return "IdDia: " + this.idDia + "\n"
			+ "Atividade: " + this.atividade + "\n"
			+ "Duracao da atividade: " + this.duracao + "horas"+"\n";
	}
	
	
	//COLOCAR O METODO DAO PARA LER E CONVERTER TXT EM ARRAY
	
	public ArrayList<Tempo> ConvertTxT(){
		File tempoFile = gerenciadorTempo.openFile(); 
		
		ArrayList<Tempo> listaTempo = new ArrayList<Tempo>();
		ArrayList<String> arquivo = gerenciadorTempo.readFile(tempoFile);
		
		
		//For Each - Para cada tem que percorre cada linha d arquivo e transforma em uma posição do vetor
		for(String linha: arquivo) {
			String[]itens = linha.split(","); 		//Separa as posições pelas virgula contidas no TXT
			
			Tempo tempTXT = new Tempo();
			tempTXT.setIdDia(Integer.parseInt(itens[0]));
			tempTXT.setAtividade(itens[1]);
			tempTXT.setDuracao(Double.parseDouble(itens[2]));
			
			listaTempo.add(tempTXT);
		}
		return listaTempo;
	}
	
}