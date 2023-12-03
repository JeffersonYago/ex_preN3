package main;

import java.io.IOException;

import controller.Controle;

public class Principal {

	public static void main(String[] args) throws IOException {
			Controle ctr = new Controle();
			ctr.lerArquivo();
			
	}
	}
/*Pegar o conteúdo do site: https://www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita 
 * (Usar modo RAW ou Dados Brutos), esse site traz um arquivo com diferentes formas de se preparar 
 * uma Marguerita. Gravar em um arquivo chamado marg.json na pasta C:\TEMP (\tmp se for Linux) e 
 * fazer uma aplicação java que, na classe principal, no método Main, chame uma classe de controle que leia o 
 * arquivo, e, para todas as receitas, apresente as instruções em italiano (strInstructionsIT)
 */