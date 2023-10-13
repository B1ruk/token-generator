package io.b1ruk.start.tokengenerator.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Service
public class ValidatorService {

    public ResponseEntity<Boolean> validateToken(String token) {
        List<Integer> tokenValues = Arrays.stream(token.replace("-", "").split(""))
                .map(Integer::parseInt)
                .toList();

        List<Integer> luhnWeights = generateWeights(tokenValues.size());

        boolean validToken = isValidToken(tokenValues, luhnWeights);

        return ResponseEntity.ok().body(validToken);
    }

    //Validates the token using
    // Luhn Algorithm
    private boolean isValidToken(List<Integer> tokenValues, List<Integer> luhnWeights) {
        int[] productSum = new int[luhnWeights.size()];

        for (int i = 0; i < tokenValues.size(); i++) {
            int digit = tokenValues.get(i);
            int weight = luhnWeights.get(i);

            int product = digit * weight;

            if (product > 9) {
                String[] value = Integer.toString(product).split("");
                product = Math.addExact(Integer.parseInt(value[0]), Integer.parseInt(value[1]));
            }
            productSum[i] = product;
            log.info("digit -> {} , weight -> {} , 'product'-> {} ", digit, weight, product);
        }

        int sum = Arrays.stream(productSum)
                .sum();

        log.info("sum is => {}", sum);

        return sum % 10 == 0;
    }

    private List<Integer> generateWeights(int size) {
        return Arrays.stream(IntStream.range(0, 16)
                .map(index -> index % 2 == 0 ? 2 : 1)
                .toArray()).boxed().collect(Collectors.toList());
    }
}
