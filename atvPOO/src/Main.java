//Patrícia Ester
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Cliente cliente1 = new Cliente("Patrícia Ester", "123.456.789-01", "Recife", "01234-567", "Brasil");
        Agencia agencia1 = new Agencia(1234);
        ContaCorrente conta1 = new ContaCorrente(cliente1, agencia1, 1001, 1500.0);

        System.out.println("Conta Corrente do(a): " + conta1.usuario.nome);
        System.out.println("Agência: " + conta1.agencia.num);
        System.out.println("Número da Conta: " + conta1.num);
        System.out.println("Saldo: R$" + conta1.saldo);

        System.out.println();
        Cliente cliente2 = new Cliente("Fátima Souza", "098.765.432-11", "Recife", "09787-771", "Brasil");
        Agencia agencia2 = new Agencia(1234);
        ContaUniversitaria conta2 = new ContaUniversitaria(cliente2, agencia2, 1005, 1900.0);

        System.out.println("Conta Universitária do(a): " + conta2.usuario.nome);
        System.out.println("Agência: " + conta2.agencia.num);
        System.out.println("Número da Conta: " + conta2.num);
        System.out.println("Saldo: R$" + conta2.saldo);

        System.out.println(" Deseja fazer algum depósito ou saque? s/n ");
        char resposta = sc.next().charAt(0);

        if (resposta == 's') {
        System.out.println("conta corrente ou universitária? 1/2");
        int conta = sc.nextInt();

            System.out.println("Depósito ou saque? d/s");
            char opc = sc.next().charAt(0);

            if (opc == 'D' || opc == 'd') {
                System.out.print("Digite o valor do depósito: ");
                double deposito = sc.nextDouble();
                Transacoes transacoes = new Transacoes();

                if (conta == 1){
                    transacoes.DepositoCorrente(conta1, deposito);
                }
                if (conta ==2){
                    transacoes.DepositoUni(conta2, deposito);
                }
            } else if (opc == 'S' || opc == 's') {
                System.out.print("Digite o valor do saque: ");
                double saque = sc.nextDouble();
                Transacoes transacoes = new Transacoes();

                if (conta == 1  ){
                    transacoes.SaqueCorrente(conta1, saque);
                }
                if (conta == 2){
                    transacoes.SaqueUni(conta2, saque);
                }
            }

        }

    }

    static class Cliente {
        String nome;
        String cpf;
        String estado;
        String cep;
        String pais;

        public Cliente(String nome, String cpf, String estado, String cep, String pais) {
            this.nome = nome;
            this.cpf = cpf;
            this.estado = estado;
            this.cep = cep;
            this.pais = pais;
        }
    }

    static class Agencia {
        int num;

        public Agencia(int num) {
            this.num = num;
        }
    }

    static class ContaCorrente {
        Cliente usuario;
        Agencia agencia;
        int num;
        double saldo;

        public ContaCorrente(Cliente usuario, Agencia agencia, int num, double saldoInicial) {
            this.usuario = usuario;
            this.agencia = agencia;
            this.num = num;
            this.saldo = saldoInicial;
        }

    }

    static class ContaUniversitaria {
        Cliente usuario;
        Agencia agencia;
        int num;
        double saldo;


        public ContaUniversitaria(Cliente usuario, Agencia agencia, int num, double saldoInicial) {
            this.usuario = usuario;
            this.agencia = agencia;
            this.num = num;
            this.saldo = saldoInicial;

        }

    }

    static class Transacoes {
        void DepositoUni(ContaUniversitaria contauni, double valor) {
            contauni.saldo += valor;
            System.out.println("Depósito concluído com sucesso. Saldo atual: R$" + contauni.saldo);
        }
       void DepositoCorrente(ContaCorrente contaCorrente ,double valor){
            contaCorrente.saldo += valor;
           System.out.println("Depósito concluído com sucesso. Saldo atual: R$" + contaCorrente.saldo);
       }
        void SaqueUni(ContaUniversitaria contauni, double valor) {
            if (contauni.saldo >= valor) {
                contauni.saldo -= valor;
                System.out.println("Saque realizado. Novo saldo: R$" + contauni.saldo);
            } else {
                System.out.println("Saldo insuficiente para o saque.");
            }
        }
        void SaqueCorrente(ContaCorrente contacorrente, double valor) {
            if (contacorrente.saldo >= valor) {
                contacorrente.saldo -= valor;
                System.out.println("Saque realizado. Novo saldo: R$" + contacorrente.saldo);
            } else {
                System.out.println("Saldo insuficiente para o saque.");
            }
        }
    }
}
