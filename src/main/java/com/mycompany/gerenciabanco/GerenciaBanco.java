/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciabanco;

import java.util.Scanner;

public class GerenciaBanco {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n====== MENU ======");
            System.out.println("1. Criar conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Consultar saldo");
            System.out.println("5. Listar contas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Sobrenome: ");
                    String sobrenome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    Usuario novoUsuario = new Usuario(nome, sobrenome, cpf);
                    Conta novaConta = new Conta(novoUsuario);
                    banco.adicionarConta(novaConta);
                    System.out.println("Conta criada com sucesso!");
                    break;

                case 2:
                    System.out.print("Informe o CPF do titular: ");
                    String cpfDeposito = scanner.nextLine();
                    Conta contaDeposito = banco.buscarContaPorCpf(cpfDeposito);
                    if (contaDeposito != null) {
                        System.out.print("Valor para depositar: R$ ");
                        double valor = scanner.nextDouble();
                        contaDeposito.depositar(valor);
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Informe o CPF do titular: ");
                    String cpfSaque = scanner.nextLine();
                    Conta contaSaque = banco.buscarContaPorCpf(cpfSaque);
                    if (contaSaque != null) {
                        System.out.print("Valor para saque: R$ ");
                        double valor = scanner.nextDouble();
                        if (contaSaque.sacar(valor)) {
                            System.out.println("Saque realizado com sucesso!");
                        } else {
                            System.out.println("Saldo insuficiente ou valor inválido.");
                        }
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Informe o CPF do titular: ");
                    String cpfConsulta = scanner.nextLine();
                    Conta contaConsulta = banco.buscarContaPorCpf(cpfConsulta);
                    if (contaConsulta != null) {
                        System.out.println("Saldo atual: R$ " + contaConsulta.getSaldo());
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 5:
                    banco.listarContas();
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
