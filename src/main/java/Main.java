public class Main {
    public static void main(String[] args) {
        System.out.println("Test neural network layer: ");
        NeuralLayer nn1 = new NeuralLayer(3, 4);
        nn1.printWeights();
    }
}
