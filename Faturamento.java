import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FaturamentoDiario {
    public static void main(String[] args) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("faturamento.json")));
        JSONArray jsonArray = new JSONArray(content);

        List<Double> faturamentos = new ArrayList<>();
        double soma = 0;

        for (int i = 0; i < jsonArray.length(); i++) {
            double valor = jsonArray.getJSONObject(i).getDouble("valor");
            if (valor > 0) {
                faturamentos.add(valor);
                soma += valor;
            }
        }

        double media = soma / faturamentos.size();
        double menor = faturamentos.stream().min(Double::compare).get();
        double maior = faturamentos.stream().max(Double::compare).get();
        long diasAcimaDaMedia = faturamentos.stream().filter(f -> f > media).count();

        System.out.println("Menor valor de faturamento: " + menor);
        System.out.println("Maior valor de faturamento: " + maior);
        System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia);
    }
}
