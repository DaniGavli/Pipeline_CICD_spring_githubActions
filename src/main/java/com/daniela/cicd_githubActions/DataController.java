package com.daniela.cicd_githubActions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController

public class DataController {

    @GetMapping("/")

    public String healthCheck() {

        return "OK OK!!";

    }

    @GetMapping("/versao")

    public String version() {

        return "A versao atual e 1.0.0";

    }

    @GetMapping("/nacoes")

    public JsonNode getRandomNations() {

        var objectMapper = new ObjectMapper();

        var faker = new Faker(new Locale("pt-BR"));

        var nations = objectMapper.createArrayNode();

        for (var i = 0; i < 10; i++) {

            var nation = faker.nation();

            nations.add(objectMapper.createObjectNode()

                    .put("Nacionalidade", nation.nationality())

                    .put("Capital da cidade", nation.capitalCity())

                    .put("Bandeira", nation.flag())

                    .put("Idioma", nation.language()));

        }

        return nations;

    }

    @GetMapping("/moedas")

    public JsonNode getRandomCurrencies() {

        var objectMapper = new ObjectMapper();

        var faker = new Faker(new Locale("pt-BR"));

        var currencies = objectMapper.createArrayNode();

        for (var i = 0; i < 20; i++) {

            var currency = faker.currency();

            currencies.add(objectMapper.createObjectNode()

                    .put("Moeda", currency.name())

                    .put("codigo", currency.code()));

        }

        return currencies;

    }

}
