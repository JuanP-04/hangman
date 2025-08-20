# Jogo da Forca - Console em Java

## Sobre o Projeto

Este projeto é uma aplicação de console em Java que implementa o clássico Jogo da Forca. Foi desenvolvido como parte de um desafio de projeto do curso de Java da **DIO**, ministrado pelo desenvolvedor **José Luiz Abreu Cardoso Junior**, com o objetivo de consolidar e aplicar na prática os pilares da Programação Orientada a Objetos (POO) em um ambiente de console interativo.

O foco foi a criação de um jogo completo, desde a definição da palavra oculta (passada por argumentos de linha de comando) até a montagem de uma interface gráfica simplificada da forca e a interação com o usuário por meio de um menu.

---

## Funcionalidades

* **Lógica do Jogo:**
    * Definição de uma palavra oculta através dos argumentos de inicialização do programa.
    * Permite que o usuário insira letras para tentar adivinhar a palavra.
    * Controle de tentativas erradas, com um limite de 6 erros.
    * Atualização do status do jogo para "PENDING", "WIN" ou "LOSE".
* **Interface de Console:**
    * Exibição de uma representação gráfica da forca que é atualizada a cada erro.
    * Menu interativo para o usuário escolher entre "Informar uma letra", "Verificar status do jogo" ou "Sair".
    * Feedback claro para o usuário sobre letras já informadas, acertos, erros e o resultado final do jogo.
* **Tratamento de Erros:**
    * Impede que o usuário insira uma letra já utilizada.
    * Finaliza o jogo e informa o resultado quando o jogador ganha ou perde.

---

## Arquitetura e Conceitos de POO Aplicados

O projeto foi estruturado para demonstrar a aplicação prática de conceitos fundamentais da Programação Orientada a Objetos.

### 1. Classes e Objetos
O domínio do problema foi modelado em classes distintas, cada uma com sua responsabilidade, demonstrando o conceito de abstração.
* **`HangmanGame`**: É a classe central que orquestra toda a lógica do jogo. Ela gerencia o estado da partida, as tentativas do jogador, a palavra a ser adivinhada e a representação gráfica da forca.
* **`HangmanChar`**: Representa um único caractere da palavra oculta. Cada objeto `HangmanChar` armazena o caractere, sua posição na palavra e seu estado de visibilidade (se já foi adivinhado ou não). Isso transforma uma simples `String` em um objeto rico em informações e comportamentos.

### 2. Encapsulamento
O encapsulamento é garantido pelo uso de modificadores de acesso (`private`). Os atributos internos das classes, como a lista de `characters` e o `hangmanGameStatus` em `HangmanGame`, são protegidos. O acesso e a modificação desses dados são controlados por métodos públicos (`inputCharacter()`, `getHangmanGameStatus()`), garantindo a integridade do estado do jogo.

### 3. Enumerações (`Enums`)
Para gerenciar o estado do jogo de forma segura e legível, foi utilizado um `enum` chamado `HangmanGameStatus`. Ele define os três possíveis estados da partida: `PENDING`, `WIN` e `LOSE`. O uso de um `enum` previne erros e torna o código mais explícito e robusto em comparação com o uso de strings ou inteiros para representar o estado.

### 4. Exceções Personalizadas
Foram criadas exceções específicas para lidar com situações de erro previsíveis no fluxo do jogo, tornando o tratamento de erros mais claro.
* **`LetterAlreadyInputedException`**: Lançada quando o jogador tenta inserir uma letra que já foi utilizada anteriormente.
* **`GameIsFinishedException`**: Lançada se o jogador tentar realizar uma ação (como inserir uma letra) quando o jogo já terminou.

---

## Estruturas de Dados e Decisões de Implementação

* ### `List`
    A `List` (`ArrayList`) é a principal estrutura de dados utilizada no projeto para armazenar coleções dinâmicas de objetos, como:
    * A lista de `HangmanChar` que representa a palavra a ser adivinhada.
    * A lista `failAttempts`, que armazena os caracteres que o usuário tentou e errou.
    * A lista `hangmanPaths`, que contém as partes do corpo do boneco a serem desenhadas na forca a cada erro.

* ### `Stream`
    A API de Streams do Java foi utilizada para processar as coleções de forma funcional e declarativa, resultando em um código mais conciso.
    * **Processamento da Entrada:** Na classe `Main`, um `stream` é usado para converter os argumentos de linha de comando (strings) em uma lista de objetos `HangmanChar`.
    * **Filtragem e Verificação:** Na classe `HangmanGame`, `streams` são usados para filtrar a lista de caracteres e encontrar correspondências com a letra inserida pelo usuário, bem como para verificar se todas as letras já foram reveladas (`noneMatch(HangmanChar::isInvisible)`) para determinar a vitória.

* ### `StringBuilder`
    Para montar e atualizar a representação gráfica do jogo no console, o `StringBuilder` foi utilizado. Ele oferece uma forma eficiente de manipular a string que desenha a forca, permitindo a modificação de caracteres em posições específicas (`setCharAt`) para adicionar partes do corpo ou revelar letras adivinhadas.

---

## Tecnologias Utilizadas

* **Java 21:** Versão da linguagem utilizada para o desenvolvimento.
* **Gradle:** Ferramenta de automação de build para gerenciar dependências e executar o projeto.

---

## Como Executar o Projeto

**Pré-requisitos:**
* JDK 21 ou superior instalado.
* O Gradle Wrapper (`gradlew`) já está incluído no projeto.

**Passos:**

1.  Clone o repositório:
    ```bash
    git clone https://github.com/JuanP-04/hangman.git
    ```

2.  Navegue até o diretório do projeto:
    ```bash
    cd hangman
    ```

3.  Execute a aplicação usando o Gradle Wrapper. **É fundamental passar a palavra a ser adivinhada como argumentos após `--args`**. Cada letra da palavra deve ser um argumento separado.

    **Exemplo para a palavra "java":**
    ```bash
    ./gradlew run --args="j a v a"
    ```

    **Exemplo para a palavra "oracle":**
    ```bash
    ./gradlew run --args="o r a c l e"
    ```

4.  O jogo será iniciado no console e você poderá interagir com o menu.
