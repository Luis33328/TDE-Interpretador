package com;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		TabelaVerdade tab = new TabelaVerdade();
		
		System.out.println("Digite uma proposição com ao menos 2 variáveis (Ex: p->q): ");
		
		String imp = sc.nextLine();
		
		tab.atribuicaoValoresTabela(imp);
		
	}
}
