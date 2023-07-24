package br.com.dbc.vemser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaPoupancaTest {
    ContaPoupanca contaPoupancaTest = new ContaPoupanca(new Cliente("Hugo Ferreira Gabriel Vieira", "4392818274"), "1", 123, 1000.00);

    @Test
    void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso() {
        contaPoupancaTest.creditarTaxa();
        //após creditar o saldo fica 1010
        contaPoupancaTest.sacar(20.0);
        double saldoContaPouPosSaque = contaPoupancaTest.getSaldo();
        Assertions.assertEquals(990.0, saldoContaPouPosSaque);
    }

    @Test
    void deveTestarSaqueContaPoupancaSemSaldo() {
        contaPoupancaTest.sacar(1100.0);
        double saldoContaPouPosSaque = contaPoupancaTest.getSaldo();
        Assertions.assertEquals(1000.0, saldoContaPouPosSaque);
    }
}