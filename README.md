# Desafio TDD - GFT

Desenvolva um programa que simule a entrega de notas quando um
cliente efetuar um saque em um caixa eletrônico. Os requisitos básicos
são os seguintes:
- Entregar o menor número de notas;
- É possível sacar o valor solicitado com as notas disponíveis;
- Notas disponíveis de R$ 100,00; R$ 50,00; R$ 20,00 e R$ 10,00
  Exemplos:
- Valor do Saque: R$ 30,00 – Resultado Esperado: Entregar 1 nota
  de R$ 20,00 e 1 nota de R$ 10,00.
- Valor do Saque: R$ 80,00 – Resultado Esperado: Entregar 1 nota
  de R$ 50,00 ; 1 nota de R$ 20,00 e 1 nota de R$ 10,00

  
## Documentação da API

#### Retornar um valor inteiro do Caixa Eletrônico

```http
 Utilizar o método 'GET' se abrir o Swagger para rodar a API -> localhost:8080/swagger-ui.html 
 ou
 Utilizar o método: 'GET' em -> localhost:8080/api/saque/valor no Insomnia/Postman
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `valor`      | `int` | **Obrigatório** : Em "Valor" adicionar um valor inteiro para ser sacado |




## Screenshots
![](../../Desktop/valorInserido.png)
![](../../Desktop/retornoValor.png)

## Funcionalidades

- Retornar os menores números de notas
- Inserir apenas números inteiros

## Screenshots dos Tests
![](../../Desktop/cedulasServiceTest.png)
![](../../Desktop/saqueServiceTest.png)

## Rodando os testes

Para rodar os testes, abra a aba **Test** no projeto!

```
  Src > Test > gft.com > CedulasServiceTest
  Src > Test > gft.com > SaqueServiceTest
```


## Ferramentas utilizadas
**Documentação da API:** Swagger UI

**Back-end:** Spring Boot, TDD, Mockito, JUnit


## Suporte

Para suporte, mande um email para RNAN@gft.com


## Autor
- Renan Almeida :
- [GitLab](https://git.gft.com/rnan)
- [Linkedin](https:///www.linkedin.com/in/renan-almeida-025b74220/)

