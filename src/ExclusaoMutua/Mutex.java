package ExclusaoMutua;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Mutex {
    static ReentrantLock mutex = new ReentrantLock();
    static ArrayList<String> listaCompartilhada = new ArrayList<String>(); //Recurso compartilhado

    public static void main(String[] args) {
        int numThreads = 5;
        Thread[] threads = new Thread[numThreads];
        int contador = 1;

        // Cria as threads
        for (int i = 0; i < numThreads; i++) {
            final int id = contador;
            threads[i] = new Thread(new Runnable() {
                public void run() {
                	System.out.println("Entrando na se��o cr�tica: " + id);
                    mutex.lock();
                    System.out.println("Thread " + id + " entrou na se��o cr�tica");
                    
                    listaCompartilhada.add("Elemento " + id);
                    System.out.println("Lista compartilhada: " + listaCompartilhada);

                    mutex.unlock();
                    System.out.println("Thread " + id + " saiu da se��o cr�tica");
                }
            });

            // Inicia a execu��o de uma nova thread 
            threads[i].start();
            contador++;
        }
        
    }
}
