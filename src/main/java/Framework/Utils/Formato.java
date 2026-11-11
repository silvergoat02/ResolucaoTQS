package Framework.Utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formato {

    // "Saldo em conta R$ 1.000,00" -> 1000.00
    public static BigDecimal extrairValor(String texto) {
        Matcher m = Pattern.compile("(\\d{1,3}(?:\\.\\d{3})*|\\d+),(\\d{2})").matcher(texto);
        if (!m.find()) {
            throw new IllegalArgumentException("Nenhum valor monetario em: " + texto);
        }
        return new BigDecimal(m.group(1).replace(".", "") + "." + m.group(2));
    }

    // 1000.00 -> "1.000,00"
    public static String paraBR(BigDecimal valor) {
        return NumberFormat.getNumberInstance(Locale.forLanguageTag("pt-BR")).format(valor.setScale(2));
    }
}
