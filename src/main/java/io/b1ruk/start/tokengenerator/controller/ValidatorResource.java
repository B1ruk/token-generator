package io.b1ruk.start.tokengenerator.controller;

import io.b1ruk.start.tokengenerator.validator.ValidatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("validatorResource")
public class ValidatorResource {

    private ValidatorService validatorService;

    public ValidatorResource(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    @GetMapping("validateToken")
    public ResponseEntity<Boolean> validateToken(@RequestParam("token") String token) {
        return validatorService.validateToken(token);
    }
}
