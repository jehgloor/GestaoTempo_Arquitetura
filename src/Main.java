
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[]args) {
		try {	
			String opcao = "0";  
	        String textoMenu = "---- Menu ----- \n"
	                + "Digite o código da opção desejada:\n \n"
	                + "1 - Abrir arquivo Dia \n"
	                + "2 - Abrir arquivo Tempo \n"
	                + "3 - Cadastrar Dia com Atividades \n"
	                + "4 - Excluir Dia \n"
	                + "5 - Excluir atividade \n"
	                + "6 - Consultar o dia \n"
	                + "7 - Consultar as atividades \n"
	                + "8 - Editar Dia \n"
	                + "9 - Editar Tempo \n" 
	                + "0 - Sair\n";
	        ArrayList<Dia> listaDias = new ArrayList<Dia> ();
	        ArrayList<Tempo> listaTempo = new ArrayList<Tempo> ();
	       
	        do {
	            opcao = JOptionPane.showInputDialog(null,textoMenu);
	            switch (opcao) {
	            
	                case "1":		//Abrir arquivo de Dia.txt 	
	                	Dia dia1 = new Dia();
	                	listaDias = dia1.converterTxT();
	                	String textoDia = "";
	                    int j = 1;
	                    for(Dia d: listaDias){
	                    	textoDia += ++j +" - "+ d.toString();
	                    }
	                    JOptionPane.showMessageDialog(null, textoDia);
	                    break;
	                	
	                case "2": 		//ABRIR ARQUIVO TEMPO.TXT 
	                	
	                	Tempo tempo1 = new Tempo();
	                	listaTempo = tempo1.ConvertTxT();
	                
	                	int k = 1;
	                	String textoTempo = "";
	                	for(Tempo t: listaTempo){
	                		textoTempo += ++k +" - "+ t.toString();
	                    }
	                    JOptionPane.showMessageDialog(null, textoTempo);
	                	
	                	break;
	
	                case "3": 		// CADASTRA DIA E TEMPO E JA GRAVA NO ARRAYLIST DE DIA
	              	  
	                	int idDia = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o ID da Semana: "));
	                    String[] opcoesDiaSemana = {"segunda","terça","Quarta",
	                    		"Quinta","Sexta","Sabado","Domingo"
	                    };
	                    
	                    String diaSemana = (String)JOptionPane.showInputDialog(null,"Selecione o dia da semana: ","Dia da semana",
	                    		JOptionPane.QUESTION_MESSAGE,null,opcoesDiaSemana,opcoesDiaSemana[0]);
	                    String data = JOptionPane.showInputDialog(null,"Digite qual data: dd/mm/aaaa ");
	                    
	                    Dia dia = new Dia(idDia,diaSemana,data);
	                    listaDias.add(dia);
	         
	                    Scanner in = new Scanner(System.in);
	
	                    int cont = 0;
	                    int opcaoAddTempo;
	                    opcaoAddTempo = Integer.parseInt(JOptionPane.showInputDialog(null,"Deseja adicionar 1 atividade para o dia em questão? 1 SIM - 0 NÃO "));
	
	                    while(opcaoAddTempo != 0){
	                    	String atividade = JOptionPane.showInputDialog(null,"Digite qual atividade você fez: ");
	                    	double duracao = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite a duração da atividade "));
	                        Tempo tempo = new Tempo(idDia,atividade,duracao);
	                        listaTempo.add(tempo);
	                        dia.adicionaTempo(tempo);
	                        cont++;
	                        opcaoAddTempo = Integer.parseInt(JOptionPane.showInputDialog(null,"Deseja add mais 1 atividade para o dia , 1 SIM - 0 NÃO "));
	                    };
	                    
	                    System.out.println(dia.toString());
	                    System.out.println( dia.toStringTempo());
	                    System.out.println(listaDias.toString());
	                    break;
	                	
	                case "4": 		//Excluir DIA
	                	  
	                	int idParaExcluir = Integer.parseInt(JOptionPane.showInputDialog(null,"Dias cadastrados: \n" + listaDias.toString() + "\n\nDigite o ID da Semana que deseja excluir: "));
	                	
	                	for(int i = 0; i <= listaDias.size(); i++) {
	                		try {
	                			if(listaDias.get(i).getId() == idParaExcluir){
	                	
	                				JOptionPane.showMessageDialog(null, "O dia " + listaDias.get(i).getData() + "Foi exluido");
	                				listaDias.remove(i);
	                				
	                			}
	                		}catch(Exception e) {
	                			JOptionPane.showMessageDialog(null, "ID não encontrado, por favor tente realizar a operação novamente!");
	                		}
	                	}
	                	break;
	                case "5": //Excluir Tempo
	                	// mostrando a opção para o cliente a partir do indice:
	                	JOptionPane.showMessageDialog(null, "A lista irá aparecer no console: ");
	                	for(int i = 0 ; i< listaTempo.size() ; i++) {
	                	
	                		System.out.println( "Indice: "+(i)+"ID DIA: "+listaTempo.get(i).getIdDia()
	                				+"Atividade: "+listaTempo.get(i).getAtividade()
	                				+"Duração: "+listaTempo.get(i).getDuracao());
	                	}
	                	try {
	                		int idTParaExcluir = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o indice da atividade que deseja excluir: "));
	                	
	                		listaTempo.remove(idTParaExcluir);
	                	}catch(Exception e) {
	                		JOptionPane.showMessageDialog(null, "ID não encontrado, por favor tente realizar a operação novamente!");
	            		}
	                	   	
	                	break;
	                case "6": // consultar o dia
	                	System.out.println("Dias cadastrados: " + listaDias.toString());
	                	JOptionPane.showMessageDialog(null,"Dias cadastrados: \n" + listaDias.toString());
	                	int idDiaConsulta = Integer.parseInt(JOptionPane.showInputDialog(null," digite o Id que vc deseja consultar"));
	                	
	                	for(int i = 0; i <= listaDias.size(); i++) {
	                		try {
	                			if(listaDias.get(i).getId() == idDiaConsulta){
	                				JOptionPane.showMessageDialog(null, listaDias.get(i).toString());
	                			}
	                		}catch(IndexOutOfBoundsException e){
	                    		JOptionPane.showMessageDialog(null, "Id: "+idDiaConsulta+" não encontrado ");
	                    	}
	
	                	}
	                	break;
	                case "7": // consultar o tempo (ATIVIDADES)
	                	
	                	System.out.println("Atividades cadastrados: " + listaTempo.toString());
	                	JOptionPane.showMessageDialog(null,"Atividades cadastrados: \n" + listaTempo.toString());
	                	int idTempoConsulta = Integer.parseInt(JOptionPane.showInputDialog(null," digite o Id que vc deseja consultar"));
	                	
	                	for(int i = 0; i <= listaTempo.size(); i++) {
	                		try {
	                			if(listaTempo.get(i).getIdDia() == idTempoConsulta){
	                				JOptionPane.showMessageDialog(null, listaTempo.get(i).toString());
	                			}
	                		}catch(IndexOutOfBoundsException e){
	                			JOptionPane.showMessageDialog(null, "Id: "+idTempoConsulta+" não encontrado ");
	                		}
	                	}
	                	
	                	break;
	                case "8": // Editar o Dia
	                	
	                	JOptionPane.showMessageDialog(null,"Dias cadastrados: \n" + listaDias.toString());
	                	int idEditarDia = Integer.parseInt(JOptionPane.showInputDialog(null," digite o id do dia para editar:"));
	                	try {
	                	for(int i = 0; i <= listaDias.size(); i++) {
	                			if(listaDias.get(i).getId() == idEditarDia){
	                				JOptionPane.showMessageDialog(null, listaDias.get(i).toString());
	                				
	                				 String[] opcoesDias = {"segunda","terça","Quarta",
	                                 		"Quinta","Sexta","Sabado","Domingo"
	                                 };
	                                 
	                                 String diaSemanaNova = (String)JOptionPane.showInputDialog(null,"Selecione o dia da semana: ","Dia da semana",
	                                 		JOptionPane.QUESTION_MESSAGE,null,opcoesDias,opcoesDias[0]);
	                				listaDias.get(i).setDiaSemana(diaSemanaNova);
	                				String dataNova = JOptionPane.showInputDialog(null,"Digite a nova data: ");
	                				listaDias.get(i).setData(dataNova);
	                				JOptionPane.showMessageDialog(null, listaDias.get(i).toString());
	                			}
	               			}
	                	}catch (Exception e) {
	                		JOptionPane.showMessageDialog(null, "ID não encontrado, por favor tente realizar a operação novamente!");
						}
	                  break;
	                case "9": // Editar o tempo(atividades)
						
						JOptionPane.showMessageDialog(null,"Atividades cadastradas: " + listaTempo.toString());
						int opcaoEditarTempo = 0;
						do {
							int idEditarTempo = Integer.parseInt(JOptionPane.showInputDialog(null," digite o id da atividade que deseja editar:"));
							try {
								for(int i = 0; i <= listaTempo.size() ; i++) {
									if(listaTempo.get(i).getIdDia() == idEditarTempo){
										JOptionPane.showMessageDialog(null, "O Id selecionado foi: " + listaTempo.get(i).getIdDia());
										String novaAtividade = JOptionPane.showInputDialog(null, "escreva a nova atividade: ");
										listaTempo.get(i).setAtividade(novaAtividade);
										double novaDuracao = Double.parseDouble(JOptionPane.showInputDialog(null,"Digite a duração da atividade: "));
										listaTempo.get(i).setDuracao(novaDuracao);    
					                 
										JOptionPane.showMessageDialog(null, listaTempo.get(i).toString());
										opcaoEditarTempo = Integer.parseInt(JOptionPane.showInputDialog(null,"Deseja editar outra atividade?\n 1 SIM - 0 NÃO "));
									}
								}
							}catch (Exception e) {
							JOptionPane.showMessageDialog(null, "ID não encontrado, por favor tente realizar a operação novamente!");
							}
	                	}while(opcaoEditarTempo != 0);
					  break;
	                default:
	                    JOptionPane.showMessageDialog(null,"O sistema será encerrado. \n Tchau!!");
	            }
	        } while (!opcao.equals("0"));
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"O sistema será cancelado. \\n Tchau!!");
		}
	}
}
