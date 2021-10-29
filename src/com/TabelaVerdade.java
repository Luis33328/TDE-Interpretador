package com;

import java.util.ArrayList;

public class TabelaVerdade {
	
	private ArrayList<String> tTable = new ArrayList();
	
	
	private int p;
	private int q;
	
	public void atribuicaoValoresTabela(String prop){
		String[] ent = prop.split("->|v|\\^|\\<->");
		
		if(ent.length > 1) {
			String arg1 = ent[0];
			String arg2 = ent[1];
			
			if((int)arg1.charAt(0) < (int)arg2.charAt(0)) {
				this.p = 0;	
				this.q = 1;
				
			}
			
			else if((int)arg1.charAt(0) == (int)arg2.charAt(0)) {
				System.out.println("As variáveis devem ser diferentes.");
				return;
			}
			
			else {
				this.p = 1;	
				this.q = 0;
			}
			
			
			if(arg1.contains("~")) {
				tTable.add("FFVV");
				System.out.println("FFVV");
			}
			else {
				tTable.add("VVFF");
				System.out.println("VVFF");
			}
			if(arg2.contains("~")) {
				tTable.add("FVFV");
				System.out.println("FVFV");
			}
			else {
				tTable.add("VFVF");
				System.out.println("VFVF");
			}
			
			if(prop.contains("<->")) {
				System.out.println("--------------");
				System.out.println("Resultado\n");
				System.out.println(calcBic(tTable.get(p), tTable.get(q)));
			}
			else if(prop.contains("->")) {
				System.out.println("--------------");
				System.out.println("Resultado\n");
				System.out.println(calcImplic(tTable.get(p), tTable.get(q)));
			}
			else if(prop.contains("v")) {
				System.out.println("--------------");
				System.out.println("Resultado\n");
				System.out.println(calcOr(tTable.get(p), tTable.get(q)));
			}
			else if(prop.contains("^")) {
				System.out.println("--------------");
				System.out.println("Resultado\n");
				System.out.println(calcAnd(tTable.get(p), tTable.get(q)));
			}
		}
		else {
			System.out.println("Digite mais de uma variável.");
		}
		
		
	}
	


	public String calcImplic(String t1, String t2) {
		String result = "";
		
		for(int i = 0; i < t1.length(); i++) {
			for(int j = 0; j < t2.length(); j++) {
				
				if(Character.toString(t1.charAt(i)).contains("V") && Character.toString(t2.charAt(j)).contains("F")) {
					result += "F";
					i++;
				}
				else {
					result += "V";
					i++;
				}
				
			}
		}
		
		return result;
	}
	
	public String calcOr(String t1, String t2) {
		
		String result = "";
		
		for(int i = 0; i < t1.length(); i++) {
			for(int j = 0; j < t2.length(); j++) {
				
				if(Character.toString(t1.charAt(i)).contains("F") && Character.toString(t2.charAt(j)).contains("F")) {
					result += "F";
					i++;
				}
				else {
					result += "V";
					i++;
				}
				
			}
		}
		
		
		return result;
	}
	
	public String calcAnd(String t1, String t2) {
		
		String result = "";
		
		for(int i = 0; i < t1.length(); i++) {
			for(int j = 0; j < t2.length(); j++) {
				
				if(Character.toString(t1.charAt(i)).contains("V") && Character.toString(t2.charAt(j)).contains("V")) {
					result += "V";
					i++;
				}
				else {
					result += "F";
					i++;
				}
				
			}
		}
		
		
		return result;
	}
	
	public String calcBic(String t1, String t2) {
		
		String result = "";
		
		for(int i = 0; i < t1.length(); i++) {
			for(int j = 0; j < t2.length(); j++) {
				
				if(Character.toString(t1.charAt(i)).contains("V") && Character.toString(t2.charAt(j)).contains("V") || Character.toString(t1.charAt(i)).contains("F") && Character.toString(t2.charAt(j)).contains("F")) {
					result += "V";
					i++;
				}
				else {
					result += "F";
					i++;
				}
				
			}
		}
		
		
		return result;
	}


}
