package com.daniela.cicd_githubActions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class DataControllerTest {

    @Autowired

    DataController dataController;

    @Test

    void health() {

        assertEquals( "OK OK!!", dataController.healthCheck());

    }

    @Test

    void versao() {

        assertEquals( "A versao atual e 1.0.0", dataController.version());

    }

    @Test

    void nacaoSize() {

        Integer nationsLength = dataController.getRandomNations().size();

        assertEquals(10, nationsLength);

    }

    @Test

    void moedaTam() {

        Integer moedaTam = dataController.getRandomCurrencies().size();

        assertEquals(20, moedaTam);

    }

}