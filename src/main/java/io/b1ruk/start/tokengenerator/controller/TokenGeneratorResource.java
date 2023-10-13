package io.b1ruk.start.tokengenerator.controller;

import io.b1ruk.start.tokengenerator.generator.TokenGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("TokenGeneratorResource")
public class TokenGeneratorResource {

    private TokenGeneratorService tokenGeneratorService;

    public TokenGeneratorResource(TokenGeneratorService tokenGeneratorService) {
        this.tokenGeneratorService = tokenGeneratorService;
    }

    @GetMapping("generate")
    public ResponseEntity<String> generateToken(@RequestParam("digits") String digits) {
        return tokenGeneratorService.generateToken(digits);
    }
}
