package salárioprofessorfaculdade;

import java.text.DecimalFormat;

public class Professor {

    private String nome, matricula;

    private int horasMes;

    private boolean ativo;

    private Categoria categoria;

    public Professor(String nome, String matricula, Categoria categoria) {
        this.nome = nome;
        this.matricula = matricula;
        this.categoria = categoria;
        horasMes = 200;
        ativo = true;
    }

    public Professor(String nome, String matricula, int horasMes, Categoria categoria) {
        this.nome = nome;
        this.matricula = matricula;
        this.horasMes = horasMes;
        this.categoria = categoria;
        ativo = true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getHorasMes() {
        return horasMes;
    }

    public void setHorasMes(int horasMes) {
        this.horasMes = horasMes;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void encerraContrato() {
        ativo = false;
    }

    public double salarioBruto() {
        return horasMes * getCategoria().getValorHora();
    }

    public double inss() {
        double salario = salarioBruto();
        if (salario <= 1174.86) {
            return salario * 8 / 100;
        } else if (salario <= 1958.10) {
            return salario * 9 / 100;
        } else if (salario <= 3916.20) {
            return salario * 11 / 100;
        } else {
            return 3916.20 * 11 / 100;
        }
    }

    public double impostoRenda() {
        double salario = salarioBruto();
        if (salario <= 1566.61) {
            return 0;
        } else if (salario <= 2347.85) {
            return salario * 7.5 / 100;
        } else if (salario <= 3130.51) {
            return salario * 15.100;
        } else if (salario <= 3911.63) {
            return salario * 22.5 / 100;
        } else {
            return salarioBruto() * 27.5 / 100;
        }
    }

    public double salarioLiquido() {
        return salarioBruto() - (inss() + impostoRenda());

    }

    public String dados() {
        DecimalFormat mascara = new DecimalFormat("#,##0.00");
        String dados;
        if (!ativo) {
            dados = "Professor inativo. Não faz mais parte da grade.";
        } else {
            dados = "Nome do professor: " + nome
                    + "\nMatrícula: " + matricula
                    + "\nSituação: Ativo"
                    + "\nCategoria: " + categoria.getNomeCategoria()
                    + "\nHoras trabalhadas por mês: " + horasMes
                    + "\nSalário/hora: R$" + mascara.format(categoria.getValorHora())
                    + "\nSalário bruto: R$" + mascara.format(salarioBruto())
                    + "\nINSS: R$" + mascara.format(inss())
                    + "\nIR: R$" + mascara.format(impostoRenda())
                    + "\nSalário líquido: R$" + mascara.format(salarioLiquido());
        }
        return dados;
    }
}
