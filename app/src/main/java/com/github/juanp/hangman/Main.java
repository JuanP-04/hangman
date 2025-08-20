package com.github.juanp.hangman;

import java.util.stream.Stream;

import com.github.juanp.hangman.model.HangmanChar;
import com.github.juanp.hangman.model.HangmanGame;

public class Main {

    public static void main(String... args) {
        var characters = Stream.of(args)
                .map(a -> a.toLowerCase().charAt(0))
                .map(HangmanChar::new).toList();
        System.out.println(characters);
        var hangmanGame = new HangmanGame(characters);
        System.out.println(hangmanGame);
        hangmanGame.inputCharacter('t');
        System.out.println(hangmanGame);
        hangmanGame.inputCharacter('e');
        System.out.println(hangmanGame);
        hangmanGame.inputCharacter('s');
        System.out.println(hangmanGame);
        hangmanGame.inputCharacter('t');
        System.out.println(hangmanGame);
        hangmanGame.inputCharacter('e');
    }
}
