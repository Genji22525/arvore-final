import java.util.Scanner;

class Executora {
    ArvoreBinaria arvore;
    Scanner scanner;

    Executora() {
        arvore = new ArvoreBinaria();
        scanner = new Scanner(System.in);
    }

    void executar() {
        arvore.insert(7);
        arvore.insert(10);
        arvore.insert(5);
        arvore.insert(8);
        arvore.insert(1);
        arvore.insert(19);
        arvore.insert(-2);

        System.out.println("Árvore binária após inserção:");
        arvore.printTree(); // comando usado para exibir a arvore
        System.out.println();

        boolean continuar = true;
        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Remover nó folha");
            System.out.println("2. Remover nó com um filho");
            System.out.println("3. Remover nó com dois filhos");
            System.out.println("4. Remover a raiz");
            System.out.println("5. Sair");

            int escolha = scanner.nextInt();

            if (escolha >= 1 && escolha <= 4) {
                System.out.print("Digite o valor do nó a ser removido: ");
                int valor = scanner.nextInt();

                // Remover o nó escolhido
                arvore.remove(valor);

                // Exibir a árvore após remoção
                System.out.println("Árvore binária após a remoção:");
                arvore.printTree();
            } else if (escolha == 5) {
                continuar = false;
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }

            System.out.println();
        }

        scanner.close();
    }
}
