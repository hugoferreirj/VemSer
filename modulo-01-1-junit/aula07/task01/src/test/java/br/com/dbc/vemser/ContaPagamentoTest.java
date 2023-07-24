package br.com.dbc.vemser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaPagamentoTest {
    ContaPagamento contaPagamentoTest = new ContaPagamento(new Cliente("Hugo Ferreira Gabriel Vieira", "4392818274"), "1", 123, 1000.00);

    @Test
    void deveTestarSaqueContaPagamentoEVerificarSaldoComSucesso() {
        contaPagamentoTest.sacar(5.75); //A TAXA DE SAQUE É DE 4.25
        double saldoContaPagPosSaque = contaPagamentoTest.getSaldo();
        Assertions.assertEquals(990.0, saldoContaPagPosSaque);
    }

    @Test
    void deveTestarSaqueContaPagamentoSemSaldo() {
        contaPagamentoTest.sacar(1100.0);
        double saldoContaPagPosSaque = contaPagamentoTest.getSaldo();
        Assertions.assertEquals(1000.0, saldoContaPagPosSaque);
    }
}