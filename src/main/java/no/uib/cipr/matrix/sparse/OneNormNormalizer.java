package no.uib.cipr.matrix.sparse;

import no.uib.cipr.matrix.Vector;

/**
 * Normalizer with norm type one, the sum of the vector. Normalize the vector
 */
public class OneNormNormalizer implements Normalizer {

    protected double mu;

    @Override
    public Vector apply(Vector vector) {
        return vector.scale(mu);
    }

    @Override
    public void setX(Vector vector) {
        mu = 1.0 / vector.norm(Vector.Norm.One);
    }
}
