package br.pucrs;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        //1
        ArrayList<Integer> lista = new ArrayList<>(List.of(1, 10, 23, 4, 2, 5, 3));
        System.out.println(mergeSort(lista));
        //2
        long[] A = {1, 10, 23, 4, 2, 5, 3};
        System.out.println(maxVal1(A, A.length));
        //3
        System.out.println(maxVal2(A, 0, A.length - 1));

        //aqui 4
        System.out.println(MULTIPLY(7, 5, 4));
        System.out.println(MULTIPLY(12345, 6789, 16));
        System.out.println(MULTIPLY(123456789L, 987654321L, 64));

        System.out.println(multiply("11", "1011"));
    }

    public static long MULTIPLY(long x, long y, long n) {
        //interationCounter++;
        if (n == 1)
            return x * y;
        else {
            long m   = n / 2;
            long pot = 1L << m;          // 2^m
            long a = x / pot;
            long b = x % pot;
            long c = y / pot;
            long d = y % pot;
            long e = MULTIPLY(a, c, m);
            long f = MULTIPLY(b, d, m);
            long g = MULTIPLY(b, c, m);
            long h = MULTIPLY(a, d, m);
            return (1L << (2 * m)) * e + pot * (g + h) + f;   // 2^(2m)·e + 2^m·(g+h) + f
        }
    }

    //mergesort
    public static ArrayList<Integer> mergeSort(ArrayList <Integer> lista){
        int tam = lista.size();
        if(tam < 2){
            return lista;
        }
       ArrayList<Integer> listdown = new ArrayList<> (lista.subList(tam/2,tam));
       ArrayList<Integer> listup = new ArrayList<> (lista.subList(0, tam/2));

       //mergeSort(listadown);
       //mergeSort(listaup);
        mergeSort(listdown);
        mergeSort(listup);
        return merge(lista, listdown, listup);

    }

    public static ArrayList<Integer> merge(ArrayList <Integer> lista, ArrayList <Integer> listdown, ArrayList <Integer> listup){
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < listdown.size() && j < listup.size()){
            if(listdown.get(i) <= listup.get(j)){
                lista.set(k, listdown.get(i));
                i++;
            }else{
                lista.set(k, listup.get(j));
                j++;
            }
            k++;
        }
        while(i < listdown.size()){
            lista.set(k, listdown.get(i));
            i++;
            k++;
        }
        while(j < listup.size()){
            lista.set(k, listup.get(j));
            j++;
            k++;
        }
        return lista;
    }

    //2
    public static long maxVal1(long A[], int n) {  
       long max = A[0];
       for (int i = 1; i < n; i++) {  
           if( A[i] > max ) 
              max = A[i];
       }
       return max;
   }
   //3
   public static long max(long a, long b) {  
       if (a > b) 
           return a;  
       else 
           return b;  
   }
   public static long maxVal2(long A[], int init, int end) {  
       if (end - init <= 1)
           return max(A[init], A[end]);  
       else {
             int m = (init + end)/2;
             long v1 = maxVal2(A,init,m);   
             long v2 = maxVal2(A,m+1,end);  
             return max(v1,v2);
            }
   }
    // Multiplica duas strings de bits x e y
    // e retorna o resultado como um inteiro "long".
    // transforma bits em long, chama MULTIPLY e retorna o resultado
    public static long multiply(String X, String Y){
        long x = Long.parseLong(X, 2);
        long y = Long.parseLong(Y, 2);
        int n = Math.max(X.length(), Y.length());
        return MULTIPLY(x, y, n);
    }
    //ainda nao implementado
    //ideia para contar as iteracoes 
    //realizadas apartir de cada entrada 

}