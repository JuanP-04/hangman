package com.github.juanp.hangman;

import java.util.Scanner;
import java.util.stream.Stream;

import com.github.juanp.hangman.exception.GameIsFinishedException;
import com.github.juanp.hangman.exception.LetterAlreadyInputedException;
import com.github.juanp.hangman.model.HangmanChar;
import com.github.juanp.hangman.model.HangmanGame;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String... args) {
        var characters = Stream.of(args)
                .map(a -> a.toLowerCase().charAt(0))
                .map(HangmanChar::new).toList();
        System.out.println(characters);
        var hangmanGame = new HangmanGame(characters);
        System.out.println("Bem-vindo ao jogo da forca! Tente adivinhar a palavra, boa sorte!");
        System.out.println(hangmanGame);
        var option = -1;
        while (true){
            System.out.println("Selecione uma opcao:");
            System.out.println("1 - Informar uma letra");
            System.out.println("2 - Verificar status do jogo");
            System.out.println("3 - Sair do jogo");
            option = scanner.nextInt();
            switch (option){
                case 1 -> inputCharacter(hangmanGame);
                case 2 -> showGameStatus(hangmanGame);
                case 3 -> System.exit(0);
                default -> System.out.println("Opcao invalida");
            }
        }
    }

    private static void showGameStatus(final HangmanGame hangmanGame) {
        System.out.println(hangmanGame.getHangmanGameStatus());
        System.out.println(hangmanGame);
    }

    private static void inputCharacter(final HangmanGame hangmanGame) {
        System.out.println("Informe uma letra:");
        var character = scanner.next().charAt(0);
        try {
            hangmanGame.inputCharacter(character);
        } catch (LetterAlreadyInputedException ex) {
            System.out.println(ex.getMessage());
        } catch (GameIsFinishedException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        System.out.println(hangmanGame);
    }
}
