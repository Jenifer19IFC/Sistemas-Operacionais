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
        	
            // Aguarda uma conexão com um cliente
            Socket socket = serverSocket.accept();
            System.out.println("Nova conexão estabelecida: " + socket.getInetAddress().getHostAddress());
            
            // Cria um objeto da classe TratadorDeMensagem para lidar com a comunicação com o cliente
            TratadorDeMensagem tratadorDeMensagem = new TratadorDeMensagem(socket);
            
            // Inicia a execução do objeto TratadorDeMensagem em uma nova thread
            new Thread(tratadorDeMensagem).start();
        }
    }
}
