package salárioprofessorfaculdade;

import javax.swing.JOptionPane;

public class SalarioProfessorFaculdade {

    public static void main(String[] args) {

        String catProf[] = {"Professor Auxiliar", "Professor Adjunto", "Professor Assistente", "Sair"};

        String operações[] = {"Listar informações", "Reajustar valor da hora de trabalho", "Demitir professor", "Sair"};

        Professor professor;

        String nome = JOptionPane.showInputDialog(null, "Informe o nome do proffessor:", "Salario", 3);

        String matricula = JOptionPane.showInputDialog(null, "Informe a matrícula do professor:", "Salario", 3);
        
        String nomeCategoria = (String) JOptionPane.showInputDialog(null, "Escolha a categoria:", "Categoria", 3, null, catProf, catProf[0]);
        
        int valorHora = Integer.parseInt(JOptionPane.showInputDialog(null, "Inofrme o valor da hora:", "Categoria", 3));
        
        if (JOptionPane.showConfirmDialog(null, "O tempo de trabalho é integral?", "Salario", JOptionPane.YES_NO_OPTION, 3) == 0) {
            professor = new Professor(nome, matricula, new Categoria(nomeCategoria, valorHora));
        } else {
            int horasMes = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a carga horária mensal de trabalho", "Salario", 3));
            professor = new Professor(nome, matricula, horasMes, new Categoria(nomeCategoria, valorHora));
        }
        
        String opçãoUser = "";

        do{
            opçãoUser = (String) JOptionPane.showInputDialog(null, "Selecione a operação desejada:", "Categoria", 3, null, operações, operações[0]);
            
        switch (opçãoUser) {
            case "Listar informações":
                
               JOptionPane.showMessageDialog(null, "As informações do professor são são:\n" + professor.dados(), "Salario", 1);
            
            break;
            case "Reajustar valor da hora de trabalho":
                
                if(professor.isAtivo()){    
                float reajuste = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe seu reajuste:", "Categoria", 3));
                professor.getCategoria().reajuste(reajuste);
                } else{
                    JOptionPane.showMessageDialog(null, "Operação impossível, professor não ativo.", "Professor", 1);
                }                
            break;
            case "Demitir professor":
                
                if(professor.isAtivo()){
                
                if (JOptionPane.showConfirmDialog(null, "Quer demitir mesmo o professor?", "Salario", JOptionPane.YES_NO_OPTION, 3) == 0) {
                professor.encerraContrato();
                JOptionPane.showMessageDialog(null, "Professor demitido com sucesso", "Professor", 1);
                }
                } else{
                     JOptionPane.showMessageDialog(null, "Operação impossível, professor não ativo.", "Professor", 1);
                }
            break;    
            } 
        } while (!opçãoUser.equals(operações[3]));
        System.exit(0);
        
    }
}
