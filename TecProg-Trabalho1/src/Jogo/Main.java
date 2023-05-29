package Jogo;

public class Main {
	public static void main(String[] args){
		Jogo jogo = new Jogo();
		System.out.println("\n\n\n\n");
		do {
			jogo.rodada();
			System.out.println("\n"+jogo.relatorioRodada());
			System.out.println("\n\n\n\n");
		}while(jogo.jogando());
		System.out.println(jogo.relatorioFinal());
		System.out.println(jogo.Vencedor());
	}
}
