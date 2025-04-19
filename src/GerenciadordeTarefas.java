import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadordeTarefas {
    public static class Tarefa {
        String descricao;
        boolean concluida;

        Tarefa(String descricao) {
            this.descricao = descricao;
            this.concluida = false;
        }

        @Override
        public String toString() {
            return (concluida ? "[x] " : "[ ] ") + descricao;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n== Gerenciador de Tarefas ==");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Marcar tarefa como concluída");
            System.out.println("4. Remover tarefa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite a descrição da tarefa: ");
                    String desc = scanner.nextLine();
                    tarefas.add(new Tarefa(desc));
                    System.out.println("Tarefa adicionada.");
                }
                case 2 -> {
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa.");
                    } else {
                        System.out.println("\nTarefas:");
                        for (int i = 0; i < tarefas.size(); i++) {
                            System.out.println((i + 1) + ". " + tarefas.get(i));
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Digite o número da tarefa a marcar como concluída: ");
                    int num = scanner.nextInt();
                    if (num > 0 && num <= tarefas.size()) {
                        tarefas.get(num - 1).concluida = true;
                        System.out.println("Tarefa marcada como concluída.");
                    } else {
                        System.out.println("Número inválido.");
                    }
                }
                case 4 -> {
                    System.out.print("Digite o número da tarefa a remover: ");
                    int num = scanner.nextInt();
                    if (num > 0 && num <= tarefas.size()) {
                        tarefas.remove(num - 1);
                        System.out.println("Tarefa removida.");
                    } else {
                        System.out.println("Número inválido.");
                    }
                }
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
