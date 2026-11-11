package Framework.Utils;

import net.datafaker.Faker;

import java.text.Normalizer;
import java.util.Locale;

public class FakersGeneration {

    private final Faker faker;

    public FakersGeneration() {
        faker = new Faker(Locale.forLanguageTag("pt-BR"));
    }

    public static String removerAcentos(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
    }

    public String getNome() {
        return removerAcentos(faker.name().firstName() + " " + faker.name().lastName());
    }

    public String getEmail() {
        // sufixo numerico evita colisao entre execucoes
        return "teste" + System.nanoTime() + "@tqs.com";
    }

    public String getSenha() {
        return "Senha@" + faker.number().digits(4);
    }
}
