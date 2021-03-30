/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pseudoaleatorios;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Dani
 */
public class MetodoCongruencialMultiplicativo implements Metodo{
    public static String parametros="Multiplicador=15\nModulo=3\nSemilla=2";
    double multiplicador;
    double modulo;
    double semilla;
    
    public MetodoCongruencialMultiplicativo(double multiplicador, double modulo, double semilla) {
        this.multiplicador = multiplicador;
        this.modulo = modulo;
        this.semilla = semilla;
    }
    
    public MetodoCongruencialMultiplicativo(String params[]){
        for(String linea : params){
            String datos[]=linea.split("=");
            if(datos[0].equals("Multiplicador")){
                try{
                    multiplicador=Double.parseDouble(datos[1]);
                }catch(NumberFormatException e){}
            }
            else if(datos[0].equals("Modulo")){
                try{
                    modulo=Double.parseDouble(datos[1]);
                }catch(NumberFormatException e){}
            }
            else if(datos[0].equals("Semilla")){
                try{
                    semilla=Double.parseDouble(datos[1]);
                }catch(NumberFormatException e){}
            }
        }
    }
    
    @Override
    public void init(BufferedReader reader) throws IOException {
        System.out.println("Ingrese el multiplicador");
        this.multiplicador = Float.parseFloat(reader.readLine());
        System.out.println("Ingrese el módulo");
        this.modulo = Float.parseFloat(reader.readLine());
        System.out.println("Ingrese la semilla");
        this.semilla = Float.parseFloat(reader.readLine());
    }
    
    @Override
    public double obtenerSiguiente() {
        double siguiente=((semilla*multiplicador))%modulo;
        semilla=siguiente;
        return siguiente;
    }

    @Override
    public double[] obtenerSiguientes(int n) {
        double[] siguientes = new double[n];
        for(int i=0; i<n; i++){
            siguientes[i]=obtenerSiguiente();
        }
        return siguientes;
    }

    @Override
    public double[] obtenerTodos() {
        ArrayList<Double> todos = new ArrayList();
        HashSet<Double> hashSet = new HashSet<>();
        
        double siguiente=obtenerSiguiente();
        todos.add(siguiente);
        hashSet.add(siguiente);
        
        siguiente=obtenerSiguiente();
        while(!hashSet.contains(siguiente)){
            todos.add(siguiente);
            hashSet.add(siguiente);
            siguiente=obtenerSiguiente();
        }
        double[] toReturn=new double[todos.size()];
        for(int i=0; i<toReturn.length; i++){
            toReturn[i]=todos.get(i);
        }
        return toReturn;
    }

    @Override
    public void entre0Y1(double[] lista) {
        for(int i=0; i<lista.length; i++){
            lista[i]=lista[i]/(modulo-1);
        }
    }

    @Override
    public void aDecimales(double[] lista) {
      for(int i=0; i<lista.length; i++){
            lista[i]*=(modulo-1);
        }  
    }
}
