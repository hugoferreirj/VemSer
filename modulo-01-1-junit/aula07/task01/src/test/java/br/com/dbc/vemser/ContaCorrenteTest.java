package br.com.dbc.vemser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContaCorrenteTest {

    ContaCorrente contaCorrenteTest = new ContaCorrente(new Cliente("Hugo Ferreira Gabriel Vieira", "4392818274"), "1", 123, 1000.00);

    @Test
    void deveTestarSaqueContaCorrenteEVerificarSaldoComSucesso() {
        contaCorrenteTest.sacar(200.0);
        double saldoContaCorPosSaque = contaCorrenteTest.getSaldo();
        Assertions.assertEquals(800.0, saldoContaCorPosSaque);
    }

    @Test
    void deveTestarSaqueContaCorrenteSemSaldo() {
        //O valor do cheque especial é 200.0
        contaCorrenteTest.sacar(1300.0);
        double saldoContaCorPosSaque = contaCorrenteTest.getSaldo();
        Assertions.assertEquals(1000.0, saldoContaCorPosSaque);
    }
}