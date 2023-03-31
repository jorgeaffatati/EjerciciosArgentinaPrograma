package Mundial_Qatar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PronosticosDeportivos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String prono = "pronostico.csv";
        String resul = "resultados.csv";
        String vec[]= {"empate","ganador","perdedor"};
        
        double puntos = 0;
		int id = 1;
		try {
			List<String> lista = Files.readAllLines(Paths.get(resul));
			List<String> lpronos = Files.readAllLines(Paths.get(prono));
			String[] linea1 = lista.get(0).split(";");
        	String[] linea2 = lista.get(1).split(";");
        	String[] lprono1 = lpronos.get(0).split(";");
        	String[] lprono2 = lpronos.get(1).split(";");

         	Equipo equi1 = new Equipo(linea1[0], id++);
        	Equipo equi2 = new Equipo(linea1[3], id++);
        	Equipo equi3 = new Equipo(linea2[0], id++);
        	Equipo equi4 = new Equipo(linea2[3], id++);
        	id = 1;
        
        	Partido part1 = new Partido(id++, equi1, equi2, Integer.parseInt(linea1[1]), Integer.parseInt(linea1[2]));
        	Partido part2 = new Partido(id++, equi3, equi4, Integer.parseInt(linea2[1]), Integer.parseInt(linea2[2]));
        	id = 1;
            
        	Pronostico prono1 = new Pronostico(id++, part1, equi1, 2);
        	Pronostico prono2 = new Pronostico(id++, part1, equi2, 1);
        	Pronostico prono3 = new Pronostico(id++, part2, equi3, 0);
        	Pronostico prono4 = new Pronostico(id++, part2, equi4, 0);
        
        int k1 = prono1.getPartido().resultado(prono1.getEquipo());
        int k2 = prono2.getPartido().resultado(prono2.getEquipo());
        int k3 = prono3.getPartido().resultado(prono3.getEquipo());
        int k4 = prono4.getPartido().resultado(prono4.getEquipo());
        
        if  (prono1.getResultado() == k1 &&! (prono1.getResultado() == 0)) {puntos = puntos + 1;} 
        else if (prono1.getResultado() == 0) {puntos = puntos + 0.5;}
   
        if  (prono2.getResultado() == k2 &&! (prono2.getResultado() == 0)) {puntos = puntos + 1;} 
        else if (prono2.getResultado() == 0) {puntos = puntos + 0.5;}
        
        if  (prono3.getResultado() == k3 &&! (prono3.getResultado() == 0)) {puntos = puntos + 1;} 
        else if (prono3.getResultado() == 0) {puntos = puntos + 0.5;}
        
        if  (prono1.getResultado() == k4 &&! (prono4.getResultado() == 0)) {puntos = puntos + 1;} 
        else if (prono4.getResultado() == 0) {puntos = puntos + 0.5;}
        }
		catch (IOException e){System.out.println("error");}
	        System.out.println("Puntaje =  " + (int)puntos); 
	}
}