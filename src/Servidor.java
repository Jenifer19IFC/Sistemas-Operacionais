import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private int porta;
    
    public Servidor(int porta) {
        this.porta = porta;
    }
    
    public void iniciar() throws IOException {
    	
        // Cria um ServerSocket na porta especificada
        ServerSocket serverSocket = new ServerSocket(porta);
        System.out.println("Servidor iniciado na porta " + porta);
        
        while (true) {
        	
            // Aguarda uma conex�o com um cliente
            Socket socket = serverSocket.accept();
            System.out.println("Nova conex�o estabelecida: " + socket.getInetAddress().getHostAddress());
            
            // Cria um objeto da classe TratadorDeMensagem para lidar com a comunica��o com o cliente
            TratadorDeMensagem tratadorDeMensagem = new TratadorDeMensagem(socket);
            
            // Inicia a execu��o do objeto TratadorDeMensagem em uma nova thread
            new Thread(tratadorDeMensagem).start();
        }
    }
}
