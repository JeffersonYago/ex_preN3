package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controle {
public String local = "";
String SO = System.getProperty("os.name");
public String nome = "marq.json";

	public Controle() {
		super();
		if (SO.contains("Windows")) {
			local = "C:\\TEMP";
		}else {
			local = "\\tmp";
	}
	}
	public void lerArquivo() throws IOException {
		File arq = new File(local,nome);
		if(arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer  = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] divideLinha = linha.split("null,");
				String cortaLinha = divideLinha[0];
			 int a = linha.indexOf("strInstructionsIT");
			 int b = linha.indexOf(",\"strInstructionsZH-HANS");
				cortaLinha = linha.substring(a,b);
				System.out.println(cortaLinha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			
		}else {
			throw new IOException("Arquivo Inválido");
		}
	}
	}

	
	


