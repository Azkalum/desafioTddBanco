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
![valorInserido](https://user-images.githubusercontent.com/98130954/167207221-e3204dd8-f8fa-401d-8b4c-a7f8d387d3a6.png)
![retornoValor](https://user-images.githubusercontent.com/98130954/167207229-03e0dee6-92c8-44a7-923a-0abf2a7d555c.png)

## Funcionalidades

- Retornar os menores números de notas
- Inserir apenas números inteiros

## Screenshots dos Tests
![cedulasServiceTest](https://user-images.githubusercontent.com/98130954/167207256-ac5e79eb-d4cd-4aa9-858c-fbdfb19fc933.png)
![saqueServiceTest](https://user-images.githubusercontent.com/98130954/167207261-0855312a-d2a0-458c-a35f-6ce766ae0347.png)

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

