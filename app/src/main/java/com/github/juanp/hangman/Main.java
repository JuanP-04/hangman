package com.github.juanp.hangman;

import java.util.stream.Stream;

import com.github.juanp.hangman.model.HangmanChar;

public class Main {

    public static void main(String... args) {
        var letter = Stream.of(args)
                .map(a -> a.toLowerCase().charAt(0))
                .map(HangmanChar::new).toList();
        System.out.println(letter);
    }
}
