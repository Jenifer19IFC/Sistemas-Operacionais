package thread;

public class Main {
	
    public static void main(String[] args) {
        int numeroThreads = 2;
        int numeroIteracoes = 10;

        for (int i = 0; i < numeroThreads; i++) {
            Thread t = new MyThread(i, numeroIteracoes); 
            t.start();
        }
    }
    
}
