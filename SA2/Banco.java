package SA2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Banco {
    
    public int numConta;
    protected String tipoConta;
    public String donoConta;
    private double saldoConta;
    private boolean statusConta;
    private String senha;

    private static List<Banco> contas = new ArrayList<>();

   

    public Banco() {
        this.setSaldoConta(0.0);
        this.setStatusConta(false);
        this.setNumConta(0);
        this.setSenha("1234");
        contas.add(this);
    }

    public int getNumConta() {
        return this.numConta;
    }

    public void setNumConta(int n) {
        Random rd = new Random();
        int num = rd.nextInt(4001) + 1000;
        this.numConta = num;
    }

    protected String getTipoConta() {
        return this.tipoConta;
    }

    protected void setTipoConta(String t) {
        tipoConta = t;
    }

    public String getDonoConta() {
        return this.donoConta;
    }

    public void setDonoConta(String d) {
        donoConta = d;
    }

    private double getSaldoConta() {
        return this.saldoConta;
    }

    private void setSaldoConta(double s) {
        saldoConta = s;
    }

    private boolean getStatusConta() {
        return this.statusConta;
    }

    private void setStatusConta(boolean sc) {
        statusConta = sc;
    }
     public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    

    public void estadoAtual() {
        System.out.println("=======================================");
        System.out.println("Conta: "+ this.getNumConta());
        System.out.println("Proprietário: "+ this.getDonoConta());
        System.out.println("Tipo da conta: "+ this.getTipoConta());
        System.out.println("Saldo: "+ this.getSaldoConta());
        System.out.println("Status: "+ this.getStatusConta());
        System.out.println("=======================================");
    }

    public void abrirConta(String t) {

        this.setTipoConta(t);
        this.setStatusConta(true);
        if (t == "pf") {
            this.setSaldoConta(50);
        } else if (t == "pj") {
            this.setSaldoConta(150);
        }

        System.out.println("Conta Aberta com sucesso!");
    }

    public void fecharConta() {

        if (this.getSaldoConta() > 50) {
            System.out.println("Sua conta não pôde ser fechada porquê ainda têm dinheiro!");
        } else if (this.getSaldoConta() < 0) {
            System.out.println("Sua conta está negativada");
        } else {
            this.setStatusConta(false);
            System.out.println("Conta fechada com sucesso!");
        }
    }

    

    public void depositar(double v) {

        if (this.getStatusConta()) {
            this.setSaldoConta(getSaldoConta() + v);
            System.out.println("Depósito realizado com sucesso na conta de " + this.donoConta);
        } else {
            System.out.println("impossível depositar nesta conta");
        }

    }

    public void sacar(double v) {

        if (getStatusConta()) {
            if (this.getSaldoConta() >= v) {
                this.setSaldoConta(this.getSaldoConta() - v);

                System.out.println("Saque realizado com sucesso na conta de " + this.donoConta);
            } else {
                System.out.println("Saldo insuficiente para saque!");
            }
        } else {
            System.out.println("Impossível sacar");
        }

    }

    public void emprestimo(double v) {
        if (this.getStatusConta()) {
            if (v > 0) {
                this.setSaldoConta(getSaldoConta() + v);
                System.out.println("Empréstimo de " + v + " realizado com sucesso na conta de " + this.donoConta);
            } else {
                System.out.println("Valor inválido para empréstimo!");
            }
        } else {
            System.out.println("Impossível realizar empréstimo para esta conta.");
        }
    }

     public static Banco pContaNome(String n) {
        for (Banco conta : contas) {
            if (conta.getDonoConta().equals(n)) {
                return conta;
            }
        }
        return null;
    }

    public static Banco pContaNumero(int n) {
        for (Banco conta : contas) {
            if (conta.getNumConta() == n) {
                return conta;
            }
        }
        return null;
    }

     public void sair() {
        this.setStatusConta(false);
        System.out.println("Conta encerrada. Obrigado!");
    }

}