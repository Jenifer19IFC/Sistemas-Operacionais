import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
	
    private String endereco;
    private int porta;
    
    public Cliente(String endereco, int porta) {
        this.endereco = endereco;
        this.porta = porta;
    }
    
    public void enviarMensagem(String mensagem) throws IOException {
    	
        // Cria um Socket com o endereço e porta especificados
        Socket socket = new Socket(endereco, porta);
        
        // Cria os objetos de leitura e escrita para comunicação com o servidor
        BufferedReader leitor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
        
        // Envia a mensagem para o servidor
        escritor.println(mensagem);
        
        // Lê a resposta do servidor
        String resposta = leitor.readLine();
        System.out.println("Resposta do servidor: " + resposta);
        
        // Fecha os recursos utilizados
        escritor.close();
        leitor.close();
        socket.close();
    }
}
