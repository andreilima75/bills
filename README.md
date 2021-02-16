# bills-java-api
https://github.com/andreilima75/bills

## Sobre

Desenvolver um Serviço Rest para tratar as regras de negócio descritas abaixo.
- Linguagem: Java
- Injeção de dependência
- Informações devem ser persistidas em um banco de dados relacional.

## Características

Esta API fornece HTTP endpoint e ferramentas para:

* Criar uma conta: POST 'http://localhost:8080/contas'
  * {
  * "nome":"nome73",
  * "valorOriginal":"12",
  * "dataVencimento":"2012-09-09",
  * "dataPagamento":"2012-08-08"
  * }
  
* Retornar todas as contas do banco: GET 'http://localhost:8080/contas'
* Retornar todas as contas com o mesmo nome do banco: GET 'http://localhost:8080/contas/{nome}'
* Apagar todas as contas com o mesmo nome do banco: DELETE 'http://localhost:8080/contas/{nome}'
* Apagar todas as contas do banco: DELETE 'http://localhost:8080/contas'
* Swagger: 'http://localhost:8080/swagger-ui/'

### Detalhes

Serviços

* Inclusão de conta a pagar
  * Nome: Texto
  * Valor Original: Numeral
  * Data de Vencimento: Data
  * Data de Pagamento: Data
    
* Listagem das contas cadastradas
    * Nome: Texto
    * Valor Original: Numeral
    * Valor Corrigido: Numeral
    * Quantidade de dias de atraso: Numeral
    * Data de Pagamento: Data

 
### Regras de Negócio

* Todos os campos são obrigatórios
* No cadastro de contas a pagar terá que verificar se a conta está em atraso, caso esteja será incluído a seguinte
regra:
* Dias em atraso Multa Juros / dia
* até 3 dias 2% 0,1%
* superior a 3 dias 3% 0,2%
* superior a 5 dias 5% 0,3%
* A quantidade de dias em atraso e a regra para o cálculo, devem ser persistidos.
    
### Tecnologias usadas


* **Java 08**
* **Spring Boot 2.4.2**
* **Maven**
* **JUnit 5**
* **H2 1.4.2**
* **Swagger 3.0.0**
* **Model Mapper 2.3.9**
* **JPA**
* **Lombok 1.18.16**
* **Swagger 3.0.0**
* **Fmt 2.10**


### Execução

Baixe o projeto do github e abra, preferencialmente com intelliJ; no maven, 
execute um 'clean' e 'install' para baixar todas as dependências.
Esse projeto usa um pequeno banco de dados relacional H2, que é baixado automaticamente pelo maven e as tabelas são criadas na 
primeira execução. O arquivo físico do banco fica localizado em 'c:\temp', e pode ser alterado 
nas propriedades do projeto.

### Testes

São executados testes automaticamente a cada compilação do projeto, que envolvem as 
todos os serviços implementados.

Por default, a API está disponível em 'http://localhost:8080/contas'

### Documentação

* Swagger (ambiente de desenvolvimento): 'http://localhost:8080/swagger-ui/'


