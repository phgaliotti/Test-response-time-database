# Testar tempo de resposta de um banco de dados

Aplicação desenvolvida com o intuito de testar o tempo de resposta de uma query a um BD. O intuito é estabelcer uma conexão com o Banco de Dados, realizar uma query(informada por parâmetro pelo usuário) e calcular o tempo de resposta. 
Tudo de acordo com os parametros informados no start da aplicação.

## Exportar parâmetros como váriaveis de ambiente
```
JDBC_DRIVER:com.mysql.jdbc.Driver
JDBC_URL:jdbc:mysql://localhost/bd_test
JDBC_USERNAME:root
JDBC_PASSWORD:password
BD_QUERY:select * from info
```

## Passar parâmetros via linha de comando
```
java -jar response-time-database.jar 
--spring.datasource.driver-class-name={DATASOURCE_DRIVER_NAME}
--spring.datasource.url={DATASOURCE_JDBC_URL}
--spring.datasource.data-password={DATASOURCE_PASSWORD} 
--spring.datasource.data-username={DATASOURCE_USERNAME}  
--bd.query="{QUERY}"
```

## Exemplo preenchido para testes
```
java -jar response-time-database.jar  --spring.datasource.driver-class-name="com.mysql.jdbc.Driver"  --spring.datasource.url=jdbc:mysql://localhost/bd_test --spring.datasource.data-password=password  --spring.datasource.data-username=root --bd.query="select * from info"
```

## Como executar:
* - Após o clone do projeto, executar o build via maven;
* - Acessar a pasta target onde estará localizado o .jar;
* - Executar via linha de comando;
* - Aplicação será executada na porta 8090 [pode ser alterada no application.yml]


