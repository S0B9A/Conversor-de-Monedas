import com.google.gson.Gson;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMonedas {

    public Conversion FactoryConversionMoneda(String paisBase, String paisDestino, double cantidad) {

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/1bdd31c52ce5565a84f39dd2/pair/"+paisBase+"/"+paisDestino+"/"+cantidad+"/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();
        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversion.class);

        } catch (IOException | InterruptedException a) {
            JOptionPane.showMessageDialog(null, "Upssss error" + a.getMessage());
        }

        return null;
    }
}
