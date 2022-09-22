
import java.io.File;
import java.util.ArrayList;

public class Dia {
	private int id;
	private String diaSemana;
	private String data;
	private ArrayList<Tempo> tempos = new ArrayList<Tempo>();
	GerenciadorDeArquivo gerenciadorDia = new GerenciadorDeArquivo();

	public Dia() {
	}
	public Dia(int id, String diaSemana, String data) {
		this.id = id;
		this.diaSemana=diaSemana;
		this.data=data;
	}
	public Dia(int id, String diaSemana, String data, ArrayList<Tempo> tempo) {
		this.id = id;
		this.diaSemana=diaSemana;
		this.data=data;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public ArrayList<Tempo> getTempo() {
		return tempos;
	}
	public void setTempo(ArrayList<Tempo> tempo) {
		this.tempos = tempo;
	}
	
	public void adicionaTempo(Tempo tempo){
		this.tempos.add(tempo);
	}
	
	public String toString() {
		return "ID: " + this.id + "\t" +
				"Dia da Semana: " + this.diaSemana + "\t" +
				"Data: " + this.data+"\n";
	}
	public String toStringTempo() {
		String resultado = "";
		for(int i = 0 ; i < this.tempos.size() ; i++) {
			resultado += "ID da Semana: "+ this.id + "\t" +
					"Atividade: "+this.tempos.get(i).getAtividade()+ "\t" +
					"Duração: "+this.tempos.get(i).getDuracao()+ "horas"+"\n" ;
		
		}
		return resultado;
	}
	
	//COLOCAR O METODO DAO PARA LER E CONVERTER TXT EM ARRAY
	public ArrayList<Dia> converterTxT(){
		File tempoFile = gerenciadorDia.openFile(); 
		
		ArrayList<Dia> listaDia = new ArrayList<Dia>();
		ArrayList<String> arquivo = gerenciadorDia.readFile(tempoFile);
		
		for(String linha: arquivo) {
			String[]itens = linha.split(","); 	
			Dia diaTXT = new Dia();
			diaTXT.setId(Integer.parseInt(itens[0]));
			diaTXT.setDiaSemana(itens[1]);
			diaTXT.setData(itens[2]);
			
			listaDia.add(diaTXT);
				
		}
		return listaDia;
	}
	
}