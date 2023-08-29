package Lector;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Archivo{

    private int repeticiones;

    private String ruta;
    private String palabra;


    public Archivo (String ruta, String palabra) {
        this.palabra = palabra;
        this.repeticiones = 0;
        this.ruta = ruta;

    }

    public boolean esValido(File archivo) {
        String nombreArchivo = archivo.getName();
        return nombreArchivo.endsWith(".txt") ||
                nombreArchivo.endsWith(".xml") || nombreArchivo.endsWith(".json") || nombreArchivo.endsWith(".csv");
    }

    public int contadorLineas(String linea, String palabra) {
        int count = 0;
        int pointer = linea.indexOf(palabra);
        while (pointer != -1) {
            count++;
            pointer = linea.indexOf(palabra, pointer + 1);
        }
        return count;
    }

    public int totalArchivo(File documento) {
        int count2 = 0;
        try (Scanner scanner = new Scanner(documento)) {
            while (scanner.hasNextLine()) {
                String linea = scanner.next();
                count2 += contadorLineas(linea, palabra);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return count2;
    }

    public void contadorPalabrasArchivo() {
        File carpeta = new File(ruta);
        File[] archivos = carpeta.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile() && esValido(archivo)) {
                    int repeticionesArchivo = totalArchivo(archivo);
                    repeticiones += repeticionesArchivo;
                }
            }
        }
    }

    public void mostrarResultado(){
        System.out.println("total en toda la carpeta:" + repeticiones + "veces");
    }


}
