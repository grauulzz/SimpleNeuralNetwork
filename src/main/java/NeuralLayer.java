import java.util.function.Function;

public class NeuralLayer {
    public enum ActivationFunctions {
        TANH,
        SIGMOD
    }

    public enum InitialWeights {
        RANDOM,
        MEMORY,
        ZEROS
    }

    int inputsPerNeuron;
    int totalNeurons;
    double[][] weights;
    InitialWeights initialWeight;
    public final Function<Double, Double> activationFunction, activationFunctionDerivative;

    public NeuralLayer(int inputsPerNeuron, int totalNeurons) {
        this(ActivationFunctions.SIGMOD, InitialWeights.RANDOM, inputsPerNeuron, totalNeurons);
    }

    public NeuralLayer(ActivationFunctions activationFunction, InitialWeights initialWeight,
                       int inputsPerNeuron, int totalNeurons) {

        this.inputsPerNeuron = inputsPerNeuron;
        this.totalNeurons = totalNeurons;

        //TODO handle different activation functions
        this.activationFunction = NnMath::sigmod;
        this.activationFunctionDerivative = NnMath::sigmodDerivative;


        this.weights = new double[this.inputsPerNeuron][this.totalNeurons];

        for (int i=0; i < this.inputsPerNeuron; i++) {
            for (int j = 0; j < this.totalNeurons; j++) {
                weights[i][j] = 2*Math.random() - 1;
                //TODO handle switch based on initialWeight
            }
        }
    }

    public void printWeights() {
        for (int i=0; i < this.inputsPerNeuron; i++) {
            for (int j = 0; j < this.totalNeurons; j++) {
                System.out.print(this.weights[i][j] + ", \t");
            }
            System.out.println();
        }
    }

}
