# Resolução Prova TQS – BugBank

Automação Selenium (Java 25 + JUnit 5 + Allure) de https://bugbank.netlify.app/

Fluxo do teste (`TestCases/TransferenciaBancariaTest`):
1. Cadastra duas contas **com saldo** (R$ 1.000,00 cada)
2. Login na conta A e transfere o valor definido em `dados.properties`
3. Extrato da conta A: valida saldo (1000 − valor) e a transação
4. Login na conta B: valida saldo (1000 + valor) e a transação no extrato

## Executar
```
mvn clean test
mvn allure:serve      # abre o relatório
```
