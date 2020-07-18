package Model;

public class Model {
    private Matrix matrix;

    public Model(Matrix matrix) {
        this.matrix = matrix;
    }

    /*
    addObserver
    public void notify() {

    }
*/

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    public Matrix getMatrix() {
        return matrix;
    }
}
