package SA2;

public class App {
    public static void main(String[] args) {
        Banco p1 = new Banco();
            p1.setNumConta(0);
            p1.setDonoConta("Deyverson");
            p1.abrirConta("pj");
            p1.pContaNome(null);
            p1.pContaNumero(0);
            p1.depositar(0);
            p1.estadoAtual();
            p1.sair();

    }
}