package com.ahlymomkn.cashout.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CodeGenerator {
    private static final int CODE_LENGTH = 6;

    public static String generateCode() {
        Random random = new Random();
        StringBuilder code = new StringBuilder(CODE_LENGTH);
        for (int i = 0; i < CODE_LENGTH; i++) {
            code.append(random.nextInt(10));
        }
        return code.toString();
    }
}
