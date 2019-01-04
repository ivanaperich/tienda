/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

public class Libro extends Recurso {
    private String autor;

    public Libro(String autor, int codigo, String nombre, String tipo, boolean prestado) {
        super(codigo, nombre, tipo, prestado);
        this.autor = autor;
    }

    
    
}
