package io.b1ruk.start.tokengenerator.generator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class TokenGeneratorService {

    public final String TOKEN_SIGNATURE = "XXXX-XXXX-XXXX-XXXX";

    public ResponseEntity<String> generateToken(String digits) {
        String availableDigits = availableDigits(digits);

        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < TOKEN_SIGNATURE.length(); i++) {
            if (TOKEN_SIGNATURE.charAt(i) != '-') {
                int index = random.nextInt(availableDigits.length());
                char generatedValue = availableDigits.charAt(index);
                stringBuilder.append(generatedValue);
            } else {
                stringBuilder.append("-");
            }
        }

        String generatedToken = stringBuilder.toString();
        return ResponseEntity.ok().body(generatedToken);
    }

    private String availableDigits(String digits) {
        digits = digits.replace(",", "");

        if (containsOnlyDigit(digits)) {
            return digits;
        }

        throw new RuntimeException("Query should only contain digits");
    }

    private boolean containsOnlyDigit(String digits) {
        String regex = "^[0-9]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(digits);
        return matcher.matches();
    }


}
