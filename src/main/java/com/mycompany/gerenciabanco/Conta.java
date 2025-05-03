package com.mycompany.gerenciabanco;

public class Conta {
    private Usuario titular;
    private double saldo;

    public Conta(Usuario titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public double getSaldo() {
        return saldo;
    }

    public Usuario getTitular() {
        return titular;
    }

    public void exibirDados() {
        titular.exibirDados();
        System.out.println("Saldo: R$ " + saldo);
    }
}
