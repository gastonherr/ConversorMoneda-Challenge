import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Operacion {
    double conversion;


    private String base_code;
    private String target_code;
    private double montoInicial;

    public ExchangeApi busqueda (String base_code, String target_code, double montoInicial) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/94554bb489442e2a38b7867c/pair/" + base_code + "/" + target_code + "/" + montoInicial);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ExchangeApi.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public void hacerCalculo (String base_code, String target_code, double montoInicial) {
        Operacion miCalculo = new Operacion();
        conversion = miCalculo.busqueda(base_code, target_code, montoInicial).conversion_result();
        System.out.println(montoInicial + " " + base_code + " equivale a " + conversion + " " + target_code);

    }
}
