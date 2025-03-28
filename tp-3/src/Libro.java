public class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;

    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                '}';
    }

    public void setAñoPublicacion(int nuevoAnio){
        if(nuevoAnio>1900 && nuevoAnio<2025){
            this.anioPublicacion = nuevoAnio;
        }else{
            System.out.println("La nueva fecha tiene que estar entre 1900 y 2025");
        }
    }
}
