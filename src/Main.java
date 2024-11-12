
public class Main {
    public static void main(String[] args) {
//        CLASSE MATRIX
//            entra com um array
        int[][] ElementsMatriz1 =  {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
//        CONSTRUTOR atribui os valores do array em uma matriz com as proporções passadas.
//        se essas proporções forem inválidas, retorna um erro.
//        se for passado um número de linhas e colunas diferente do que foi declarado
//        na matriz, o construtor vai desconsiderar o que está fora da proporção passada
        Matrix matriz1 = new Matrix(3, 3, ElementsMatriz1);

//        Passo a matriz1 como parametro da classe linearalgebra
//        como o parametro é da classe Matrix, LinearAlgebra fara as operações para essa classe
        LinearAlgebra LinearAlgebraMatriz = new LinearAlgebra(matriz1);

        System.out.println("///////////////TRANSPOSIÇÃO///////////////");
        System.out.println();
        System.out.println("Matriz : ");
        matriz1.imprimirMatriz();
        System.out.println();
//        crio uma variavel do tipo Matrix para armazenar a matriz transposta
        Matrix matrixTransposta = (Matrix) LinearAlgebraMatriz.transpose();
        System.out.println("Matriz transposta: ");
        matrixTransposta.imprimirMatriz();

        System.out.println();

//          CLASSE VETOR
        int[] vectorElements = {1, 10, 55, 1, 22, 367, 15};
        Vector vector = new Vector(7, vectorElements);
        System.out.println("Vector : ");
        vector.imprimirVetor();
        System.out.println();

//        Passo a vectorElements como parametro da classe linearalgebra
//        como o parametro é da classe Vector, LinearAlgebra fara as operações para essa classe
        LinearAlgebra linearAlgebraVector = new LinearAlgebra(vector);

//        crio uma variavel do tipo Matrix para armazenar a matriz transposta
        Matrix vectorTransposta = (Matrix) linearAlgebraVector.transpose();
        System.out.println("Vetor transposto: ");
        vectorTransposta.imprimirMatriz();
        System.out.println();

        System.out.println("///////////////SOMA///////////////");
        System.out.println();
//        SOMAR Vetores
        System.out.println("Vector antes da soma: ");
        vector.imprimirVetor();
        System.out.println();
        System.out.println("Vector pós soma: ");
        Object somaVetores = linearAlgebraVector.sum(vector);

//        SOMAR MATRIZES OU VETORES TRANSPOSTOS
        System.out.println();
        System.out.println("Matriz antes da soma: ");
        matriz1.imprimirMatriz();
        System.out.println();
        System.out.println("Matriz pós soma: ");
        Object somaMatrizes = LinearAlgebraMatriz.sum(matriz1);
        System.out.println();

        System.out.println();
        System.out.println("///////////////MULTIPLICAÇÃO///////////////");
//        MULTIPLICAÇÃO MATRIZ POR ESCALAR
        System.out.println();
        int[][] ElementsMatriz2 =  {
                {5, 7, 3},
                {2, 2, 9},
                {8, 6, 9}
        };
        Matrix matriz2 = new Matrix(3, 3, ElementsMatriz2);
        System.out.println("Matriz antes da multiplicação por 2: ");
        matriz2.imprimirMatriz();
        System.out.println();

        LinearAlgebra multMatrizEscalar = new LinearAlgebra(matriz2);
        System.out.println("Matriz pós a multiplicação por 2: ");
        multMatrizEscalar.times(2);
        System.out.println();

//        MULTIPLICAÇÃO VETOR POR ESCALAR
        int[] vectorElements2 = {5, 10, 5, 6, 29, 7, 14};
        Vector vector2 = new Vector(7, vectorElements2);
        System.out.println("Vector : ");
        vector.imprimirVetor();
        System.out.println();

        LinearAlgebra multVetorEscalar = new LinearAlgebra(vector2);
        System.out.println("Vector pós a multiplicação por 2: ");
        multVetorEscalar.times(2);

//        MULTIPLICAÇÃO MATRIZ POR MATRIZ
        int[][] matrizA = {
                {2, 3},
                {1, 0},
                {4, 5}
        }; // 3x2
        System.out.println();
        System.out.println("Matriz A");
        Matrix matrixA = new Matrix(3,2,matrizA);
        matrixA.imprimirMatriz();

        int[][] matrizB = {
                {3, 1},
                {2, 4}
        }; // 2x2
        System.out.println();
        System.out.println("Matriz B");
        Matrix matrixB = new Matrix(2,2,matrizB);
        matrixB.imprimirMatriz();

//        resultado esperado da multiplicação -> {
//          {12, 14}
//          {3 ,  1}
//          {22, 24}
//        }

        LinearAlgebra LinearAlgebraMatrizA = new LinearAlgebra(matrixA);

        System.out.println();
        System.out.println("Multiplicação MatrizA * MatrizB");
        LinearAlgebraMatrizA.dot(matrixB);

        System.out.println();
        System.out.println("Matriz Original:");
        matriz1.imprimirMatriz();


        LinearAlgebra linearAlgebra = new LinearAlgebra(matriz1);
        Matrix matrizGauss = linearAlgebra.gauss(matriz1);

        System.out.println("Matriz após Eliminação Gaussiana:");
        matrizGauss.imprimirMatriz();

        System.out.println("Matriz Original:");
        matriz2.imprimirMatriz();
        LinearAlgebra linearAlgebra2 = new LinearAlgebra(matriz2);
        Matrix matrizGauss2 = linearAlgebra.gauss(matriz2);

        System.out.println("Matriz após Eliminação Gaussiana:");
        matrizGauss2.imprimirMatriz();

        // Definir a matriz aumentada
        int[][] augmentedMatrix = {
                {1,  1,  2 , 8},
                {0,  1,  -5 , -9},
                {0,  0,  1,  2}
        };

        Matrix sistema = new Matrix(3, 4 , augmentedMatrix);
        System.out.println();
        System.out.println("Matriz já escalonada: ");
        sistema.imprimirMatriz();
        LinearAlgebra sistemaLinear = new LinearAlgebra(sistema);
        System.out.println();
        System.out.println("x1 x2 x3");
        sistemaLinear.solve(sistema);




    }
}
