package br.pucrs;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public ArrayList<> mergeSort(ArrayList<Int> lista){
        if(lista.size()==1){
            return lista;
        }
        else{
            ArrayList a = mergeSort(lista.subList(0,lista.size()/2));
            ArrayList b = mergeSort(lista.subList(lista.size()/2,lista.size()));
        }
    }
    public ArrayList<Int> organiza(ArrayList<Int> a, ArrayList<Int> b){
//novo ArrayList
ArrayList ordenada = new ArrayList<Int> ();

        for (int i =0;i<a.size();i++) {
            
        }
    }
}
