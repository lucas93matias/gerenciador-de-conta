package com.mycompany.gerenciabanco;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> contas;

    public Banco() {
        contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void listarContas() {
        for (Conta conta : contas) {
            conta.exibirDados();
            System.out.println("------------------");
        }
    }

    public Conta buscarContaPorCpf(String cpf) {
        for (Conta conta : contas) {
            if (conta.getTitular().getCpf().equals(cpf)) {
                return conta;
            }
        }
        return null;
    }
}
