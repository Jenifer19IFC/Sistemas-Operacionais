import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TratadorDeMensagem implements Runnable {

    // Atributo que guarda o socket do cliente que enviou a mensagem
    private Socket clienteSocket;

    // Construtor que recebe o socket do cliente como parâmetro
    public TratadorDeMensagem(Socket clienteSocket) {
        this.clienteSocket = clienteSocket;
    }

    // Método que será executado em uma thread separada
    @Override
    public void run() {
        try {
            // Cria um BufferedReader para ler as mensagens enviadas pelo cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));

            // Variável que armazenará a mensagem lida
            String mensagem = "";

            // Loop para ler todas as mensagens enviadas pelo cliente
            while ((mensagem = entrada.readLine()) != null) {
                // Imprime a mensagem no console do servidor
                System.out.println("Mensagem recebida: " + mensagem);
            }

            // Fecha o socket do cliente após o tratamento da mensagem
            clienteSocket.close();

        } catch (IOException e) {
            // Em caso de erro de I/O, imprime o erro no console do servidor
            e.printStackTrace();
        }
    }
}
