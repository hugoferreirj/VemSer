package br.com.dbc.vemser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    Conta contaTest = new Conta(new Cliente("Hugo Ferreira Gabriel Vieira", "4392818274"), "1", 123, 1000.00);
    Conta conta2Test = new Conta(new Cliente("Maria Jesus", "23494392743"), "2", 436, 0.00);

    @Test
    void deveTestarDepositoEVerificarSaldoComSucessor() {
        contaTest.depositar(20.0);
        double saldoContaPouPosDeposito = contaTest.getSaldo();
        Assertions.assertEquals(1020.0, saldoContaPouPosDeposito);
    }

    @Test
    void deveTestarDepositoNegativo() {
        contaTest.depositar(-20.0);
        double saldoContaPouPosDeposito = contaTest.getSaldo();
        Assertions.assertEquals(1000.0, saldoContaPouPosDeposito);
    }

    @Test
    void deveTestarTransferenciaEVerificarSaldoComSucesso() {
        contaTest.transferir(conta2Test, 500.0);
        double saldoContaQueEnviouPosTransferencia = contaTest.getSaldo();
        double saldoContaQueRecebeuPosTransferencia = conta2Test.getSaldo();
        Assertions.assertEquals(500.0, saldoContaQueEnviouPosTransferencia);
        Assertions.assertEquals(500.0, saldoContaQueRecebeuPosTransferencia);
    }

    @Test
    void deveTestarTransferenciaSemSaldo() {
        contaTest.transferir(conta2Test, 2000.0);
        double saldoContaQueEnviouPosTransferencia = contaTest.getSaldo();
        double saldoContaQueRecebeuPosTransferencia = conta2Test.getSaldo();
        Assertions.assertEquals(1000.0, saldoContaQueEnviouPosTransferencia);
        Assertions.assertEquals(0.0, saldoContaQueRecebeuPosTransferencia);
    }


}