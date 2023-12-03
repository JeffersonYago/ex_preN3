package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
					String[] Split = linha.split("null,");
					int tam = Split.length;
					for(int i=0; i < tam; i++) {
					Pattern regex = Pattern.compile("strInstructionsIT(.+),");
					Matcher matcher = regex.matcher(Split[i]);
					while (matcher.find()) {
						String res = matcher.group(1);
						res = res.replace("\":", "");
						System.out.println(res);
					}
					 linha = buffer.readLine();
					}
			}
					 buffer.close();
					 leitor.close();
					 fluxo.close();
		}else {
			throw new IOException("Arquivo Inválido");
		}
	
	}
}
	
	


