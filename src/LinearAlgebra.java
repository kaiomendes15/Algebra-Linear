public class LinearAlgebra {


    //    CONSTRUTOR:
    private Matrix matrix;
    private Vector vector;

    public LinearAlgebra(Matrix matrix) {
        this.matrix = matrix;
    }
    public LinearAlgebra(Vector vector) {
        this.vector = vector;
    }





//      ■ Um método chamado transpose que tem como função retornar uma matriz transposta ou um
//      vetor transposto. O método deve receber como parâmetro um objeto da classe Matrix ou um
//      objeto da classe Vector . A assinatura da função transpose deve seguir a seguinte estrutura:
//      transpose(a){}
//      a -> A matriz ou o vetor a ser transposto.
//      Retorno -> Uma matriz ou o vetor transposto.

    public Object transpose() {
//        SE O PARAMETRO DO CONSTRUTOR "LinearAlgebra" FOR UMA MATRIX
        if (matrix != null) {
//            chama o método auxiliar para transpor matrizes
            return transposeMatrix();

//        SE O PARAMETRO DO CONSTRUTOR "LinearAlgebra" FOR UM VECTOR
        } else if (vector != null) {
//            chama o método auxiliar para transpor vetores
            return transposeVector();

//        SE O PARAMETRO DO CONSTRUTOR "LinearAlgebra" FOR QUALQUER OUTRO ALEM DE MATRIX E VECTOR
        } else {
            throw new IllegalStateException("Nenhuma matriz ou vetor foi inicializado.");
        }
    }

    //    transpor matrix
    private Matrix transposeMatrix() {
        int rows = matrix.getRows();
        int cols = matrix.getCols();
        int[][] matrixTransposedElements = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixTransposedElements[i][j] = matrix.getPosition(j, i);
            }
        }
        return new Matrix(rows, cols, matrixTransposedElements);
    }

    //    transpor vector
    private Matrix transposeVector() {
//        VETOR NORMALMENTE TEM UMA LINHA E getDim COLUNAS
//        ao transpor, inverto esses valores, fazendo esse vetorTransposto ter getDIm linhas e 1 coluna
//        TRATO O VETOR COMO SE FOSSE UMA MATRIZ PARA MEXER COM AS COLUNAS, POR ISSO O TIPO Object Matrix

        int[][] transposedElements = new int[vector.getDim()][1];

        for (int i = 0; i < vector.getDim(); i++) {
            transposedElements[i][0] = vector.getPositionVetor(i);
        }
        return new Matrix(vector.getDim(), 1, transposedElements);
    }





//    ■ Um método chamado sum que tem como função somar duas matrizes ou dois vetores. O
//  método deve receber como parâmetro dois objetos da classe Matrix ou dois objetos da classe
//  Vector . A assinatura da função sum deve seguir a seguinte estrutura:
//  sum(a, b){}
//  a, b -> A matriz ou o vetor a ser somado.
//  Retorno -> Uma matriz ou vetor resultante da soma.


    //    UTILIZAR PARA SOMAR MATRIZES PASSADAS PELO USUÁRIO, MATRIZES TRANSPOSTAS E VETORES TRANSPOSTOS
//    vetores transpostos são do tipo "Matrix"
    public Object sum(Matrix matrix2) {
        if (matrix != null) {
            return sumMatrix(matrix2);
        } else {
            throw new IllegalStateException("Nenhuma matriz ou vetor foi inicializado.");
        }
    }

    //    UTILIZAR PARA SOMAR VETORES PASSADOS PELO USUÁRIO
    public Object sum(Vector vector2) {
        if (vector != null) {
            return sumVector(vector2);
        } else {
            throw new IllegalStateException("Nenhuma matriz ou vetor foi inicializado.");
        }
    }

    private Object sumMatrix(Matrix matrix2) {
        if (matrix.getRows() == matrix2.getRows() && matrix.getCols() == matrix2.getCols() ) {
            int[][] matrixSumElements = new int[matrix2.getRows()][matrix2.getCols()];
            for (int i = 0; i < matrix.getRows(); i++) {
                for (int j = 0; j < matrix.getCols(); j++) {
                    matrixSumElements[i][j] = matrix.getPosition(i, j)+ matrix2.getPosition(i, j);
                }
            }
            Matrix somaMatrizes = new Matrix(matrix.getRows(), matrix.getCols(), matrixSumElements);
            somaMatrizes.imprimirMatriz();
            return matrixSumElements;
        } else {
            throw new IllegalArgumentException("Impossivel somar as matrizes");
        }

    }


    private Object sumVector(Vector vector2) {
        if (vector.getDim() == vector2.getDim()) {
            int[] vectorSumElements = new int[vector.getDim()];
            for (int i = 0; i < vector.getDim(); i++) {
                vectorSumElements[i] = vector.getPositionVetor(i) + vector2.getPositionVetor(i);
            }
            Vector somaVetores = new Vector(vector.getDim(), vectorSumElements);
            somaVetores.imprimirVetor();
            return somaVetores;
        } else {
            throw new IllegalArgumentException("Impossivel somar os vetores");
        }

    }

//    ■ Um método chamado times que tem como função multiplicar elemento a elemento duas
//  matrizes ou dois vetores ou um escalar com uma Matrix. O método deve receber como
//  parâmetro dois objetos da classe Matrix ou dois objetos da classe Vector . A assinatura da
//  função times deve seguir a seguinte estrutura:
//  times(a, b){}
//  a -> Pode ser um escalar (número) ou um objeto do tipo Matrix
//  ou um objeto do tipo Vector.
//  b -> Um objeto do tipo Matrix ou um objeto do tipo Vector.

    //    MATRIZ POR UM NÚMERO
    public Object times( int number) {
        if (matrix != null) {
            return timesEscalarMatrix(number);
        } else if (vector != null) {
            return timesEscalarVector(number);
        } else {
            throw new IllegalArgumentException("Operação não suportada.");
        }
    }

    private Matrix timesEscalarMatrix(int escalar) {
        int[][] result = new int[matrix.getRows()][matrix.getCols()];
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                result[i][j] = escalar * matrix.getPosition(i, j);
            }
        }
        Matrix timesEscalarMatrix = new Matrix(matrix.getRows(), matrix.getCols(), result);
        timesEscalarMatrix.imprimirMatriz();
        return timesEscalarMatrix;
    }

    private Vector timesEscalarVector(int escalar) {
        int[] result = new int[vector.getDim()];
        for (int i = 0; i < vector.getDim(); i++) {
            result[i] = escalar * vector.getPositionVetor(i);
        }
        Vector timesEscalarVector = new Vector(vector.getDim(), result);
        timesEscalarVector.imprimirVetor();
        return timesEscalarVector;
    }

//    MATRIZ POR MATRIZ

    public Object dot(Matrix matrix2) {

        if (matrix.getCols() != matrix2.getRows()) {
            //       para que a multiplicação seja possível, é necessário que
            //       o n* de colunas da matriz A seja igual ao número de linhas da matriz B.
            throw new IllegalArgumentException("Impossivel multiplicar as matrízes");

        } else {
            //       a matriz resultante da multiplicação vai ter o numero de linhas da
            //       matriz A e o numero de colunas da matriz B.
            int[][] result = new int[matrix.getRows()][matrix2.getCols()];

//            LOOP para percorrer as linhas da matriz A
            for (int i = 0; i < matrix.getRows(); i++) {

//                LOOP para percorrer as colunas da matriz B
                for (int j = 0; j < matrix2.getCols(); j++) {

//                    LOOP que faz a multiplicação e soma os resultados para preencher o elemento
                    for (int k = 0; k < matrix.getCols(); k++) {

                        result[i][j] += matrix.getPosition(i, k) * matrix2.getPosition(k, j);

//                        EXEMPLO COM VALORES:
//                        Matriz A (2x3) = {
//                          { 1  2  3 }
//                          { 4  5  6 }
//                        }
//                        Matriz B (3x2) = {
//                          { 7  8}
//                          { 9 10 }
//                          { 11 12 }
//                        }
//                        primeira interação: k = 0 -> result[0][0]
//                        o elemento result[0][0] é resultado da soma das multiplicações da
//                        primeira linha de A com a primeira coluna de B.

//                        result[0][0] += 1 (matrizA.getposition[0][0]) * 7 (matrizB.getposition[0][0])
//                        result[0][0] = 7

//                        segunda interação: k = 1 -> result[0][0]

//                        result[0][0] += 2 (matrizA.getposition[0][1]) * 9 (matrizB.getposition[1][0])
//                        result[0][0] = 7 + 18 = 25

//                        terceira interação: k = 2 -> result[0][0]

//                        result[0][0] += 3 (matrizA.getposition[0][2]) * 11 (matrizB.getposition[2][0])
//                        result[0][0] = 25 + 33 = 58

//                        LOGO, o elemento na posição (linha 0, coluna 0) seria 58.
//                        repetir esse processo para o restante da matriz.

                    }
                }
            }

            Matrix dotResult = new Matrix(matrix.getRows(), matrix2.getCols(), result);
            dotResult.imprimirMatriz();
            return dotResult;
        }
    }

    public Matrix gauss(Matrix a) {
        int rows = a.getRows();
        int cols = a.getCols();
        int[][] elements = a.getElements(); // Obter os elementos da matriz aumentada

        // Algoritmo de eliminação Gaussiana com pivotação parcial
        for (int i = 0; i < rows; i++) {
            // Procurar o pivô (primeiro elemento não nulo) da linha i
            if (elements[i][i] == 0) {
                // Se o pivô for zero, procurar por uma linha abaixo que tenha um pivô diferente de zero e troque as linhas
                for (int k = i + 1; k < rows; k++) {
                    if (elements[k][i] != 0) {
                        swapRows(elements, i, k);
                        break;
                    }
                }
            }

            // Normalizar o pivô para que seja igual a 1
            int pivot = elements[i][i];
            if (pivot != 0) {
                for (int j = 0; j < cols; j++) {
                    elements[i][j] /= pivot; // Dividir a linha pelo pivô
                }
            }

            // Eliminar os elementos abaixo do pivô
            for (int k = i + 1; k < rows; k++) {
                if (elements[k][i] != 0) {
                    int factor = elements[k][i];
                    for (int j = 0; j < cols; j++) {
                        elements[k][j] -= factor * elements[i][j];
                    }
                }
            }
        }

        return new Matrix(rows, cols, elements);
    }





//     Método auxiliar para trocar as linhas
    private void swapRows(int[][] elements, int row1, int row2) {
        int[] temp = elements[row1];
        elements[row1] = elements[row2];
        elements[row2] = temp;
    }
//
//    public Matrix solve() {
//        int rows = matrix.getRows();
//        int cols = matrix.getCols();
//        int[][] elements = matrix.getElements(); // Obter os elementos da matriz aumentada
//
//        // Passo 1: Eliminação Gaussiana (Escalonamento)
//        Matrix escalonada = gauss(matrix); // Utiliza o método gauss já implementado
//        System.out.println();
//        System.out.println("Forma escalonada: ");
//        escalonada.imprimirMatriz();
//
//        // Passo 2: Substituição Regressiva (Para obter a solução das variáveis)
//        // A solução estará na última coluna da matriz escalonada
//        int[] solutions = new int[rows];
//
//        // Substituição regressiva (resolução de variáveis a partir da última linha)
//        for (int i = rows - 1; i >= 0; i--) {
//            int sum = escalonada.getPosition(i, cols - 1); // Última coluna é o termo independente
//            for (int j = i + 1; j < rows; j++) {
//                sum -= escalonada.getPosition(i, j) * solutions[j];
//            }
//
//            // Verificar se o coeficiente do pivô é zero
//            int pivot = escalonada.getPosition(i, i);
//            if (pivot == 0) {
//                throw new ArithmeticException("Sistema de equações não tem uma solução única (pivô zero detectado).");
//            }
//
//            // Dividir pelo coeficiente do elemento diagonal para isolar a variável
//            solutions[i] = sum / pivot;
//        }
//
//        // Passo 3: Retornar a solução na forma de uma matriz coluna
//        int[][] result = new int[rows][1];
//        for (int i = 0; i < rows; i++) {
//            result[i][0] = solutions[i];
//        }
//        Matrix solve = new Matrix(rows, 1, result);
//
//        return new Matrix(rows, 1, result); // A matriz resultante tem rows linhas e 1 coluna (vetor solução)
//    }

    public int[] solve(Matrix escalonada) {
        int rows = escalonada.getRows();
        int cols = escalonada.getCols();

        // Verifica se a matriz é válida para resolução de sistemas lineares
        if (cols != rows + 1) {
            throw new IllegalArgumentException("A matriz não está no formato adequado para resolver o sistema (matriz aumentada esperada).");
        }

        int[] solutions = new int[rows];

        // Substituição regressiva (resolução de variáveis a partir da última linha)
        for (int i = rows - 1; i >= 0; i--) {
            int sum = escalonada.getPosition(i, cols - 1); // Última coluna é o termo independente
            for (int j = i + 1; j < rows; j++) {
                sum -= escalonada.getPosition(i, j) * solutions[j];
            }

            // Verificar se o coeficiente do pivô é zero
            int pivot = escalonada.getPosition(i, i);
            if (pivot == 0) {
                throw new ArithmeticException("Sistema de equações não tem uma solução única (pivô zero detectado).");
            }

            // Dividir pelo coeficiente do elemento diagonal para isolar a variável
            solutions[i] = sum / pivot;
        }

        Vector solution = new Vector(rows, solutions);
        solution.imprimirVetor();
        return solutions; // Retorna o vetor solução
    }
}
















