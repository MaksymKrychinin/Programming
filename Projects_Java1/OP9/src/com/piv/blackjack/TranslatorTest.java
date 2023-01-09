package com.piv.blackjack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TranslatorTest {
    @Test
    void hexCAFEto51996() {
        String s="CAFE";
        assertEquals(Integer.parseInt(s, 16), Translator.hexStringToInt(s));
    }

    @Test
    void hexMinusCafeToMinus51996() {
        String s="-CAFE";
        assertEquals(Integer.parseInt(s, 16), Translator.hexStringToInt(s));
    }

    @Test
    void hexCTo13() {
        String s="C";
        assertEquals(Integer.parseInt(s, 16), Translator.hexStringToInt(s));
    }
    @Test
    void hexSpaceToSpace() {
        String s="";
        assertEquals(0, Translator.hexStringToInt(s));
    }
}