package Jogo;

import java.util.ArrayList;

public abstract class Robo implements Movimentos, LimiteDeCasas{
	private String nome;
	private int id;
	private String tipo;
	private int posicaoAtual;
	private int pontos;
	private int alunosResgatados;
	private int bugsEncontrados;
	protected int limite;
	private ArrayList<String> celulasPercorridas;
	protected Plano plano;
	
	public Robo(String nome,String tipo, int id, int posicao, Plano plano) {
		this.nome = nome;
		this.tipo = tipo;
		this.id = id;
		this.posicaoAtual = posicao;
		this.plano = plano;
		celulasPercorridas = new ArrayList<String>();
	}
	
	public String getNome() {
		return nome;
	}
	public String getTipo() {
		return tipo;
	}
	public int getId() {
		return id;
	}
	public int getPosicaoAtual() {
		return posicaoAtual;
	}
	public void setPosicaoAtual(int posicao) {
		this.posicaoAtual = posicao;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public int getLimite() {
		return limite;
	}
	
	public void pontuador(Celula celula) {
		if(celula.getAluno()) {
			setPontos(this.pontos+10);
			this.alunosResgatados++;
		}else if(celula.getBug()) {
			setPontos(this.pontos-15);
			this.bugsEncontrados++;
		}
	}
	public String status() {
		Celula celulaAux = plano.getListaCelulas().get(this.posicaoAtual);
		if(celulaAux.getAluno()) {
			celulaAux.removeAlunoeBug();
			return this.nome+": Resgatou um aluno! ; Pontos: "+this.pontos;
			
		}else if(celulaAux.getBug()) {
			celulaAux.removeAlunoeBug();
			return this.nome+": Foi atigido por um Bug! ; Pontos: "+this.pontos;
		}
		return this.nome+": Não encontrou nada. ;Pontos: "+this.pontos;
	}
	
	public String coordRobo() {
		Celula celulaAux = plano.getListaCelulas().get(this.posicaoAtual);
		String coord = "("+celulaAux.getCoordX()+","+celulaAux.getCoordY()+")";
		celulasPercorridas.add(coord);
		return coord;
	}
	
	public String relatorioGeral() {
		String Percorridas = "";
		for(int i = 0; i < celulasPercorridas.size(); i++) {
			Percorridas += celulasPercorridas.get(i)+";";
			if((i+1)%9 == 0) {
				Percorridas += "\n";
			}
		}
		return this.nome+" => Pontos: "+this.pontos+"; Alunos resgatados: "+this.alunosResgatados+ "; Bugs encontados: "+bugsEncontrados+"; Celulas percorridas:\n"+Percorridas;
	}
	
	
	
}
