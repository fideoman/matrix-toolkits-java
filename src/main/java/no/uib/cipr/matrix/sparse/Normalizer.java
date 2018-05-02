package no.uib.cipr.matrix.sparse;

import no.uib.cipr.matrix.Vector;

/**
 * Normalizer interface. It can be used at the end of iterations in solver algorithms
 * to apply vectors in some specific way. Before a normalizer is used, <code>setX</code>
 * must be called
 */
public interface Normalizer {
    /**
     * @param vector to apply
     * @return transformed vector
     */
    Vector apply(Vector vector);

    /**
     * Save the mu of the tranformation
     * @param vector which from we calculate the mu
     */
    void setX(Vector vector);
}
