package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    // Nombre de la base de datos
    static String bd = "editorial";
    // Nombre de usuario del servidor de bases de datos
    static String user = "root";
    // Contraseña de usuario del servidor de bases de datos
    static String pass = "root";
    // La dirección del servidorg de la base de datos y se le pasa el nombre de la bd
    static String url = "jdbc:mysql://localhost:3306/" + bd;
    
    // Objecto de tipo conexión
    Connection conn = null;
    
    // Método constructor
    public Conexion(){
        try{
            // Libreria de mysql
            Class.forName("com.mysql.jdbc.Driver");
            // Se le pasa la dirección, usuario y contraseña al ¿Controlador? para conectarse a la base de datos
            conn = DriverManager.getConnection(url, user, pass);
            
            // Si la conexión es distinta a nula
            if (conn != null) {
                System.out.println("¡Conexión exitosa!");
            }
        }catch(Exception e){
            // Caso sea nula tira error
            System.out.println("Error de conexión " + e);
        }
    }
    
    // Método para conectar e iniciar la conexión a la bd
    public Connection conectar(){
        return conn;
    }
    
    // Método para desconectar o terminar la conexión  de la bd
    public void desconectar() throws Exception{
        conn.close();
    }
}
