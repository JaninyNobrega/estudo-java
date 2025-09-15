# Desafio de Programação Java - Gerenciamento de Funcionários

Este projeto é uma solução para o desafio de programação em Java, que simula o gerenciamento de funcionários de uma indústria. O objetivo é demonstrar habilidades em Programação Orientada a Objetos (POO), manipulação de coleções (`List`, `Map`), formatação de dados e uso da API de Data e Hora (`java.time`).

## Requisitos do Projeto

O projeto foi desenvolvido para atender aos seguintes requisitos:

* **Classes:**
    * **Pessoa:** Classe base com os atributos `nome` e `dataNascimento`.
    * **Funcionario:** Estende a classe `Pessoa`, adicionando os atributos `salario` e `funcao`.
* **Funcionalidades:**
    * Inserir os dados de todos os funcionários em uma lista.
    * Remover o funcionário "João" da lista.
    * Imprimir a lista de funcionários com formatação específica para datas e valores numéricos.
    * Aplicar um aumento de 10% nos salários de todos os funcionários.
    * Agrupar os funcionários por função em um `Map`.
    * Imprimir os funcionários agrupados por função.
    * Imprimir os funcionários que fazem aniversário nos meses de outubro e dezembro.
    * Identificar e imprimir o funcionário com a maior idade.
    * Imprimir a lista de funcionários em ordem alfabética.
    * Calcular e imprimir o total dos salários.
    * Calcular e imprimir quantos salários mínimos cada funcionário recebe, considerando R$ 1.212,00.

## Estrutura do Projeto

O projeto é composto por três classes principais:

* `Pessoa.java`: A classe base.
* `Funcionario.java`: A classe filha que herda de `Pessoa`.
* `Principal.java`: Contém o método `main` e a lógica para executar todas as ações solicitadas.

## Como Compilar e Executar o Projeto

Para executar este projeto, você precisa ter o **Java Development Kit (JDK)** instalado em sua máquina.

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/SeuUsuario/NomeDoSeuRepositorio.git](https://github.com/SeuUsuario/NomeDoSeuRepositorio.git)
    cd NomeDoSeuRepositorio
    ```
2.  **Abra o projeto:** Use uma IDE como **VS Code** ou IntelliJ IDEA para abrir a pasta do projeto.
3.  **Execute a classe principal:** Rode a classe `Principal.java`. O resultado será impresso diretamente no terminal ou console da sua IDE.

## Tecnologias Utilizadas

* **Linguagem:** Java 11+
* **IDE:** VS Code (com o "Extension Pack for Java")

## Contato

* **Seu Nome**
* **GitHub:** [Link para o seu perfil do GitHub](https://github.com/JaninyNobrega)