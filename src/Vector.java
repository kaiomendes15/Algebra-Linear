public class Vector {
//    Classe Vector
//Implementar uma classe nomeada Vector que implemente os seguintes items:

//■ Construtor da classe Vector que receba como parâmetros a dimensão do vetor e um array com
//os elementos do vetor. A assinatura do construtor deve seguir a seguinte estrutura:
//constructor(dim, elements){}
//dim -> Um número que representa a dimensão do Vetor
//elements -> Um array que contém os elementos do vetor

//      tamanho do vetor
    private int dim;

//      vetor
    private int[] vec;

    public Vector(int dim, int[] vec) {
        if (vec == null || vec.length == 0) {
            throw new IllegalArgumentException("O array de elementos não pode ser nulo ou vazio.");
        }
        if (dim != vec.length) {
            throw new IllegalArgumentException("A dimensão não corresponde ao número de elementos.");
        }
        this.dim = dim;
        this.vec = vec;
    }

    public int getDim() {
        return dim;
    }
    public void setDim(int dim) {
        if (dim != vec.length) {
            throw new IllegalArgumentException("A dimensão não corresponde ao número de elementos.");
        } else {
            this.dim = dim;
        }
    }

    public void setVector(int[] vec) {
        if (vec == null || vec.length == 0) {
            throw new IllegalArgumentException("O array de elementos não pode ser nulo ou vazio.");
        }
        if (vec.length != dim) {
            throw new IllegalArgumentException("A dimensão não corresponde ao número de elementos.");
        }
        this.vec = vec;
    }





//■ Um método chamado get que tem como função retornar o valor armazenado em uma
//determinada posição do vetor. O método recebe como parâmetros o índice do elemento do
//vetor e retorna o valor armazenado nesta posição. A assinatura da função get deve seguir a
//seguinte estrutura:
//get(i){}
//i -> O índice do elemento que deseja-se obter.
//Retorno -> O valor do elemento que está no índice i do vetor.

    public int getPositionVetor(int index) {
        if (index < 0 || index >= dim) {
            throw new ArrayIndexOutOfBoundsException("Valor inválido");
        } else {
            return vec[index];
        }
    }


//■ Um método chamado set que tem como função atribuir um valor em uma determinada
//posição do vetor. O método recebe como parâmetros o índice do elemento do vetor e o valor a
//ser armazenado no vetor. A assinatura da função set deve seguir a seguinte estrutura:
//set(i, value){}
//i -> O índice do elemento que deseja-se obter.
//value -> O valor a ser armazenado no vetor.
//Retorno -> Nenhum.

    public void setPositionVetor(int index, int value) {
        if (index < 0 || index >= dim) {
            throw new ArrayIndexOutOfBoundsException("Valor inválido");
        } else {
            vec[index] = value;
        }
    }

    public void imprimirVetor() {
        System.out.print("[ ");
        for (int i = 0; i < dim; i++) {

            System.out.print( vec[i] + " ");
        }
        System.out.println(" ]");
    }

}
