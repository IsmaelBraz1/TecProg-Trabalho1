package Jogo;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
	private Plano plano;
	private Jogador jogador;
	private String nomeJogador;
	private int dimensaoX, dimensaoY, nBugs, nAlunos;
	private ArrayList<Robo> listaRobos;
	private Robo peao;
	private Robo andador;
	private Robo bispo;
	private Robo torre;
	private Robo cavalo;
	private Robo rei;
	private Robo rainha;
	Scanner input = new Scanner(System.in);

	public Jogo() {
		solicitarDados();
		jogador = new Jogador(nomeJogador);
		plano = new Plano(dimensaoX, dimensaoY, nBugs, nAlunos);
		listaRobos = new ArrayList<Robo>();
		andador = new Andador("A", "Andador", 0, 0, plano);
		peao = new Peao("P", "Peao", 1, 0, plano);
		torre = new Torre("T","Torre", 2,0,plano);
		bispo = new Bispo("B","Bispo", 3,0, plano);
		cavalo = new Cavalo("C","Cavalo", 4,0,plano);
		rei = new Rei("Re", "Rei",5 , 0 ,plano);
		rainha = new Rainha("Ra", "Rainha", 6, 0 , plano);
		plano.addRobo(andador, andador.getPosicaoAtual());
		plano.addRobo(peao, peao.getPosicaoAtual());
		plano.addRobo(torre, torre.getPosicaoAtual());
		plano.addRobo(bispo, bispo.getPosicaoAtual());
		plano.addRobo(cavalo, cavalo.getPosicaoAtual());
		plano.addRobo(rei, rei.getPosicaoAtual());
		plano.addRobo(rainha, rainha.getPosicaoAtual());
		listaRobos.add(andador.getId(), andador);
		listaRobos.add(peao.getId(), peao);
		listaRobos.add(torre.getId(), torre);
		listaRobos.add(bispo.getId(),bispo);
		listaRobos.add(cavalo.getId(), cavalo);
		listaRobos.add(rei.getId(),rei);
		listaRobos.add(rainha.getId(), rainha);
	}

	public void solicitarDados() {
		boolean dadosValidos = false;
		do {	
			System.out.println("Digits seu nome :");
			try {
				nomeJogador = input.next();
			} catch (Exception e) {dadosValidos = false;input.nextLine();}
			System.out.println("Digite a dimensao X do tabuleiro que voce deseja :");
			try {
				dimensaoX = input.nextInt();
			} catch (Exception e) {dadosValidos = false;input.nextLine();}
			System.out.println("Digite a dimensao Y do tabuleiro que voce deseja :");
			try {
				dimensaoY = input.nextInt();
			} catch (Exception e) {dadosValidos = false;input.nextLine();}
			System.out.println("Digite a quantidade de Bugs que o jogo tera:");
			try {
				nBugs = input.nextInt();
			} catch (Exception e) {dadosValidos = false;input.nextLine();}
			
			System.out.println("Digite a quantidade de Alunos que o jogo tera:");
			try {
				nAlunos = input.nextInt();
			} catch (Exception e) {dadosValidos = false;input.nextLine();}
			
			if(dimensaoX > 0 && dimensaoY > 0 && nAlunos<((dimensaoX*dimensaoY)/2)&& nBugs<((dimensaoX*dimensaoY)/2)) 
				dadosValidos = true;
			else {
				dadosValidos = false;
				System.out.println("\nVoce inseriu alguma informacao errada! Por favor tente novamente\n");
			}	
		}while(!dadosValidos);
	}

	private boolean movimentarRobo(Robo robo, int direcao, int nCelulas) {
		boolean valido = true;
		if (direcao == 1) {
			valido = robo.avancar(nCelulas);
		} else if (direcao == 2) {
			valido = robo.retroceder(nCelulas);
		}
		return valido;
	}

	public void rodada() {
		int direcao = 0;
		int nCelulas = 0;
		boolean movimentoValido;
		plano.mapa();
		for (Robo robot : listaRobos) {
			System.out.println(robot.getNome()+": "+robot.coordRobo());
		}
		for (int i = 0; i < listaRobos.size(); i++) {
			Robo robo = listaRobos.get(i);
			do {
				movimentoValido = false;
				System.out.println("\nMover rôbo " + robo.getTipo() + "(" + robo.getNome() + ")");
				System.out.println("1 - Avancar\n2 - Retroceder\n=>");
				try {
					direcao = input.nextInt();
				} catch (Exception e) {movimentoValido = false; input.nextLine();}
				System.out.println("Digite o numero de celulas que deseja movimentar(limite:" + robo.getLimite() + "): ");
				try {
					nCelulas = input.nextInt();
				} catch (Exception e) {movimentoValido = false;input.nextLine();}
				
				if ((nCelulas <= robo.getLimite() && nCelulas > 0) && (direcao >= 1 && direcao <= 2)) {
					movimentoValido = movimentarRobo(robo, direcao, nCelulas);
				}
				if (!movimentoValido) {
					System.out.println("\nMOVIMENTO INVALIDO! Tente novamente seguindo as instruçoes de jogo.\n");
				}
			} while (!movimentoValido);
		}
		//pegar a ultima coordenada
		for (Robo robot : listaRobos) {
			robot.coordRobo();
		}
	}

	public String relatorioRodada() {
		String relatorioRodada = "";
		for (Robo robo : listaRobos) {
			relatorioRodada += robo.status() + "\n";
		}
		return relatorioRodada;
	}

	public String Vencedor() {
		String vencedor;
		Robo roboAux;
		roboAux = listaRobos.get(0);
		for (int i = 1; i < listaRobos.size(); i++) {
			if (listaRobos.get(i).getPontos() > roboAux.getPontos()) {
				roboAux = listaRobos.get(i);
			}
		}
		vencedor = "Jogador Vecedor: "+jogador.getNome()+" Robô Vecedor: " + roboAux.getTipo();
		return vencedor;
	}

	public String relatorioFinal() {
		String relatorioFinal = "";
		plano.mapa();
		for (Robo robo : listaRobos) {
			relatorioFinal += robo.relatorioGeral() + "\n";
		}
		return relatorioFinal;
	}

	public boolean fimJogo() {
		for (int i = 0; i < plano.getListaCelulas().size(); i++) {
			if (plano.getListaCelulas().get(i).getAluno()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean sair() {
		String sair;
		System.out.println("Deseja sair do jogo?(S/N)");
		sair = input.next();
		System.out.println("\n\n\n");
		if(sair.equals("s") || sair.equals("S")) 
			return true;
		else
			return false;
	}

	public boolean jogando() {
		if(sair()==true) {
			return false;
		}else if(fimJogo()==true) {
			return false;
		}else {
			return true;
		}
	}
}
