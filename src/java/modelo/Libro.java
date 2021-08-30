package modelo;

public class Libro {
    
    /* Estos son los atributos de la clase los cuales hacen referencia a las colunmas de la 
    tabla de la base de datos */
    private int id;
    private String titulo;
    private String autor;
    private String fecha_post;
    private String genero;
    private int cant_paginas;

    // Este es el metodo contructor al cual se le esta pasando un entero id
    public Libro(int id) {
        this.id = id;
    }
    
    /* los siguientes son los metodos Getter y Setter recibir y enviar parametros sin acceder a 
    los atributos anteriores*/
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha_post() {
        return fecha_post;
    }

    public void setFecha_post(String fecha_post) {
        this.fecha_post = fecha_post;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCant_paginas() {
        return cant_paginas;
    }

    public void setCant_paginas(int cant_paginas) {
        this.cant_paginas = cant_paginas;
    }
    
    
}
