package controlador;

import conexion.Conexion;
import dao.LibroDao;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import modelo.Libro;

public class LibroController {

    static Scanner scan = new Scanner(System.in);
    static Conexion conn = new Conexion();
    static LibroDao bookd = new LibroDao(conn);
    static Libro libro = new Libro(0);
    static String resp;

    public static void main(String[] args) {

        // Ventana de dialogo 
        resp = JOptionPane.showInputDialog(null, "¿Qué acción desea hacer?"
                + "\n 1. Insertar un registro"
                + "\n 2. Consultar registros"
                + "\n 3. Consultar un registro");

        // Menú de seleccion de acciones
        switch (resp) {
            case "1":
                //Acción de insertar
                System.out.println("Ingrese el TITULO:");
                libro.setTitulo(scan.nextLine());
                System.out.println("Ingrese el nombre del AUTOR:");
                libro.setAutor(scan.nextLine());
                System.out.println("Ingrese la FECHA de PUBLICACIÓN:");
                System.out.println("---Formato AÑO-MES-DÍA---");
                libro.setFecha_post(scan.nextLine());
                System.out.println("Ingrese el GENERO:");
                libro.setGenero(scan.nextLine());
                System.out.println("Ingrese la CANTIDAD de PÁGINAS:");
                libro.setCant_paginas(scan.nextInt());

                boolean respuesta = bookd.insert(libro);
                if (respuesta == true) {
                    JOptionPane.showMessageDialog(null, "Registro guardado");
                } else {
                    JOptionPane.showMessageDialog(null, "Registro no guardado");
                }
                break;
            case "2":
                // Acción de Listar todos los registros
                List<Libro> list = bookd.selectAll();
                for (Libro libro2 : list) {
                    System.out.println("ID: " + libro2.getId());
                    System.out.println("TITULO: " + libro2.getTitulo());
                    System.out.println("AUTOR: " + libro2.getAutor());
                    System.out.println("PUBLICADO EN: " + libro2.getFecha_post());
                    System.out.println("GENERO: " + libro2.getGenero());
                    System.out.println("CANTIDAD DE PÁGINAS: " + libro2.getCant_paginas());
                    System.out.println("*****************************************************************************");
                }
                break;
            case "3":
                // Acción de Buscar un registro
                int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Id a buscar"));
                List<Libro> listado1 = bookd.selectById(id);
                for (Libro libro2 : listado1) {
                    System.out.println("ID: " + libro2.getId());
                    System.out.println("TITULO: " + libro2.getTitulo());
                    System.out.println("AUTOR: " + libro2.getAutor());
                    System.out.println("PUBLICADO EN: " + libro2.getFecha_post());
                    System.out.println("GENERO: " + libro2.getGenero());
                    System.out.println("CANTIDAD DE PÁGINAS: " + libro2.getCant_paginas());
                }
                break;
            default:
                break;
        }

    }

}
