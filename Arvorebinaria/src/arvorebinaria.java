class ArvoreBinaria {
    // Classe  que representa um nó na árvore
    class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    Node root; // variavel aleatoria para usar de referencia para os apontamentos

    ArvoreBinaria() {
        root = null;
    }

    void insert(int value) {
        root = insertRec(root, value);
    }

    Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.value)
            root.left = insertRec(root.left, value);
        else if (value > root.value)
            root.right = insertRec(root.right, value);
        return root;
    }

    void remove(int value) {
        root = removeRec(root, value);
    }

    Node removeRec(Node root, int value) {
        if (root == null) return root;

        if (value < root.value)
            root.left = removeRec(root.left, value);
        else if (value > root.value)
            root.right = removeRec(root.right, value);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.value = minValue(root.right);
            root.right = removeRec(root.right, root.value);
        }

        return root;
    }

    int minValue(Node root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    // Método para exibir a árvore
    void printTree() {
        printTreeRec(root, 0);
    }

    void printTreeRec(Node root, int space) {
        int COUNT = 5; // Controla a distância entre os níveis

        // Caso base
        if (root == null)
            return;

        // Aumenta a distância entre os níveis
        space += COUNT;

        // Exibe o filho da direita primeiro
        printTreeRec(root.right, space);

        // Exibe o nó atual após o espaço adequado
        System.out.println();
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.println(root.value);

        // Exibe o filho da esquerda
        printTreeRec(root.left, space);
    }
}