package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Libro;

public class LibroDao {
    // objecto tipo conexión
    Conexion conn;

    // Constructor con parametro de conexión
    public LibroDao(Conexion conn) {
        this.conn = conn;
    }
    
    // Método para insertar un nuevo registro
    public boolean insert(Libro book){
        String sql = "insert into libros (idlibro,titulo,autor,fecha_post,genero,cant_paginas) values(?,?,?,?,?,?)";
        try{
           PreparedStatement ps = conn.conectar().prepareCall(sql);
           ps.setInt(1, book.getId());
           ps.setString(2, book.getTitulo());
           ps.setString(3, book.getAutor());
           ps.setString(4, book.getFecha_post());
           ps.setString(5, book.getGenero());
           ps.setInt(6, book.getCant_paginas());
           ps.executeUpdate();
           return true;
        }catch(Exception e){
            return false;
        }
    }
    
    // Método para Listar todos los registros de la tabla libros
    public List<Libro> selectAll(){
        String sql = "select * from libros";
        try{
            PreparedStatement ps = conn.conectar().prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            List<Libro> lista = new LinkedList<>();
            Libro book;
            
            while(rs.next()){
                book = new Libro(rs.getInt("idLibro"));
                book.setTitulo(rs.getString("titulo"));
                book.setAutor(rs.getString("autor"));
                book.setFecha_post(rs.getString("fecha_post"));
                book.setGenero(rs.getString("genero"));
                book.setCant_paginas(rs.getInt("cant_paginas"));
                
                lista.add(book);
            }
            return lista;
        }catch(Exception e){
            return null;
        }
    }
    
    // Método para Listar solo un registro de la tabla libros
    public List<Libro> selectById(int id){
        String sql = "select * from libros where idLibro = ?";
        try{
            PreparedStatement ps = conn.conectar().prepareCall(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Libro book;
            List<Libro> lista = new LinkedList<>();
            while(rs.next()){
                book = new Libro(rs.getInt("idLibro"));
                book.setTitulo(rs.getString("titulo"));
                book.setAutor(rs.getString("autor"));
                book.setFecha_post(rs.getString("fecha_post"));
                book.setGenero(rs.getString("genero"));
                book.setCant_paginas(rs.getInt("cant_paginas"));
                
                lista.add(book);
            }
            return lista;
        }catch(Exception e){
            return null;
        }
    }
    
}
