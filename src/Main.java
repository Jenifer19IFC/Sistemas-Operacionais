import java.io.IOException;

public class Main {
    public static void main(String[] args) {
    	
        // Inicia o servidor em uma nova thread
        new Thread(() -> {
            try {
                Servidor servidor = new Servidor(3306);
                servidor.iniciar();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        
        // Envia uma mensagem para o servidor
        Cliente cliente = new Cliente("localhost", 3306);
        try {
            cliente.enviarMensagem("Olá, servidor!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
