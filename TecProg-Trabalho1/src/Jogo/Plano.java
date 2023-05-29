package Jogo;

import java.util.ArrayList;
import java.util.Random;

public class Plano {
	private int tamanhoX;
	private int tamanhoY;
	private int nBugs;
	private int nAlunos;
	private ArrayList<Celula> listaCelulas;

	public Plano(int tamanhoX, int tamanhoY, int nBugs, int nAlunos) {
		this.tamanhoX = tamanhoX;
		this.tamanhoY = tamanhoY;
		listaCelulas = new ArrayList<Celula>();

		int id = 1;
		for (int i = 0; i < tamanhoX; i++) {
			for (int j = 0; j < tamanhoY; j++) {
				Celula celula = new Celula(i, j, id);
				listaCelulas.add(celula);
				id++;
			}
		}
		setnAlunos(nAlunos);
		setnBugs(nBugs);
		sortearAlunos(listaCelulas.size());
		sortearBugs(listaCelulas.size());
	}
		
	public int getTamanhoX() {
		return tamanhoX;
	}
	public int getTamanhoY() {
		return tamanhoY;
	}

	public void setnBugs(int nbugs) {
		if (listaCelulas.size() / 2 > nbugs)
			this.nBugs = nbugs;
	}

	public void setnAlunos(int nAlunos) {
		if (nAlunos < listaCelulas.size() / 2)
			this.nAlunos = nAlunos;
	}

	public void addRobo(Robo robo, int idCelula) {
		listaCelulas.get(idCelula).addRobo(robo);
	}

	public ArrayList<Celula> getListaCelulas() {
		return listaCelulas;
	}

	private void sortearBugs(int tamanho) {
		Random random = new Random();
		int celulaSorteada;
		for (int i = 0; i < nBugs;) {
			celulaSorteada = random.nextInt(tamanho-1);
			if (listaCelulas.get(celulaSorteada+1).getAluno() == false) {
				listaCelulas.get(celulaSorteada+1).setBug(true);
				listaCelulas.get(celulaSorteada+1).icone.setIconBug(true);
				i++;
			}
		}
	}

	private void sortearAlunos(int tamanho) {
		Random random = new Random();
		int celulaSorteada;
		for (int i = 0; i < nAlunos;) {
			celulaSorteada = random.nextInt(tamanho-1);
			if (listaCelulas.get(celulaSorteada+1).getBug() == false) {
				listaCelulas.get(celulaSorteada+1).setAluno(true);
				listaCelulas.get(celulaSorteada+1).icone.setIconAluno(true);
				i++;
			}
		}
	}

	public void mapa() {
		for (int i = 0; i < listaCelulas.size(); i++) {
			System.out.print("  " +listaCelulas.get(i).icone.retornarIcone() + "  ");
			if (listaCelulas.get(i).getCoordY() == tamanhoY-1) {
				System.out.println("\n");
			}
		}
	}
}
