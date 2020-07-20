# Desafio Projeto Vuttr Ferramentas

Desafio realizado com framework Spring e linguagem Java, implementando uma API REST

## **Configuração!**
Necessita configurar o banco no arquivo application.properties, nele contém toda configuração necessária.

## **Ferramentas usadas e Porque!**

**1. Spring:** Spring Boot
- Spring por ser um framework que disponibiliza diversas ferramentas para trabalhar com API´s e com segurança.
- Spring Boot por ser já um projeto pré-montado com os minimos preciso para configurar e desenvolver a Api

**2. MySQL:** Banco de dados relacional
- Por ser gerenciar toda estrutura relacional e ser fácil de trabalhar

**3. Flyway:** Versionamento de banco
- Ele ótimiza o versinamento do banco e faz tudo sozinho o versionamento em base da configuração

**3. Swagger:** Documentação da API
- Swagger é uma ferramenta espetacular para documentação de API onde o usuário irá poder ver como funciona e ainda poder testar direto na web

**4. JWT:** Autenticação com JWT
- É recomando de maioria das API´s implementar autenticação por JWT pela segurança e também por controlar o acesso do usuário

**5. Loombok:** Implementação das propriedades das classes
- Ele é muito útilo para implementar tudo que precisa com as propriedades das classes sem precisar user geração de getter e setters, etc.

**6. ModelMapper:** Conversor de objetos
- Ele converte os objetos das entidades com os objetos DTO para entregar ao usuário na requisição

**7. Security:** Segurança na aplicação
- Ele assegura toda a segurança na api pela autenticação do usuário e proteger.


## **Instruções para Rodar**
1. Pode importar o projeto em alguma Ide como: Eclipse, Intellij, etc.
2. Pode rodar a aplicação a partir dos comandos via prompt comando:
- mvn clean package spring-boot:run => Este comando limpa todos os arquivos,(deleta), recompila o projeto, empacota como jar e sobe aplicação
- mvn spring-boot:run => Este comando sobe a aplicação

## **Testar a Aplicação**
Pode realizar o teste via Postman que irei mandar junto com projeto e depois só importar ou outros meios.

## **Conta de usuário de teste**
- username: leandro
- password: admin123

## **Informações pelo email**
Qualquer dúvida, por favor, entre em contato com **[Leandro](mailto:leandro.cabeda@hotmail.com)**.

## **Link GitHub Desafio Projeto API**
Acesse url GitHub [documentação](https://github.com/leandro-cabeda/desafio-api-vuttr#)