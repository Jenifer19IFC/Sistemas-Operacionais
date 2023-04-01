package thread;

public class MyThread extends Thread {
	
    private final int numeroThreads;
    private final int numeroIteracoesLoop;

   //Construtor Thread 
    public MyThread(int numeroThreads, int numeroIteracoesLoop) {
        this.numeroThreads = numeroThreads;
        this.numeroIteracoesLoop = numeroIteracoesLoop;
    }

    @Override
    public void run() {
        long threadId = Thread.currentThread().getId(); // obtém o ID da thread atual

        for (int i = 0; i < numeroIteracoesLoop; i++) {
            System.out.println("Thread" + numeroThreads  + " - ID: " + threadId + " iteração " + i);
        }
    }
}
