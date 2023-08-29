package Lector;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la ruta completa de la carpeta ");
        String ArchivoPath = scanner.nextLine();


        System.out.print("Ingrese la palabra que desea buscar");
        String palabra = scanner.nextLine();

        Archivo archivo = new Archivo(ArchivoPath, palabra);
        archivo.contadorPalabrasArchivo();
        archivo.mostrarResultado();
    }
}
