package Jogo;

import java.util.ArrayList;

public class Celula {
	private int coordX;
	private int coordY;
	private int id;
	private boolean bug;
	private boolean aluno;
	private boolean celulaVisitada;
	protected Icone icone;
	private ArrayList<Robo> listaRobos;
	public Celula(int coordX, int coordY, int id) {
		this.coordX = coordX;
		this.coordY = coordY;
		this.id = id;
		this.bug =  false;
		this.aluno = false;
		this.celulaVisitada = false;
		this.listaRobos = new ArrayList<Robo>();
		icone = new Icone(this);
	}
	public int getCoordX() {
		return coordX;
	}
	public int getCoordY() {
		return coordY;
	}
	public int getId() {
		return id;
	}
	
	public boolean getBug() {
		return bug;
	}
	public void setBug(boolean bug) {
		this.bug = bug;
	}
	public boolean getAluno() {
		return aluno;
	}
	public void setAluno(boolean aluno) {
		this.aluno = aluno;
	}
	
	public void addRobo(Robo robo) {
		this.listaRobos.add(robo);
		this.celulaVisitada = true;
	}
	
	public ArrayList<Robo> getListaRobos() {
		return this.listaRobos;
	}
	
	public boolean celulaVisitada() {
		return this.celulaVisitada;
	}
	
	public void removeAlunoeBug() {
			this.bug =  false;
			this.aluno = false;
	}
	
}
