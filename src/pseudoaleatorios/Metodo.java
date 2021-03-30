/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pseudoaleatorios;

import java.io.BufferedReader;
import java.io.IOException;


/**
 *
 * @author Dani
 */
public interface Metodo {
    void init(BufferedReader reader) throws IOException;
    double obtenerSiguiente();
    double[] obtenerSiguientes(int n);
    void entre0Y1(double[] lista);
    void aDecimales(double[] lista);
    double[] obtenerTodos();
}
