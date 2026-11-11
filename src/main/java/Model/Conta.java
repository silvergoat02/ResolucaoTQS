package Model;

import java.math.BigDecimal;

public class Conta {

    public String nome;
    public String email;
    public String senha;
    public String numero;   // ex.: 123
    public String digito;   // ex.: 4
    public BigDecimal saldo;

    public String numeroCompleto() {
        return numero + "-" + digito;
    }
}
