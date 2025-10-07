package org.esfe.servicio;

public class AreaService {
    /**
     * Calcula el área de un rectángulo: Largo * Ancho
     * @param largo El largo del rectángulo.
     * @param ancho El ancho del rectángulo.
     * @return El área calculada.
     * @throws IllegalArgumentException si largo o ancho son negativos.
     */
    public double calcularAreaRectangulo(double largo, double ancho) {
        // Validación: Unidades negativas no tienen sentido.
        if (largo < 0 || ancho < 0) {
            throw new IllegalArgumentException("El largo y el ancho deben ser valores positivos.");
        }

        return largo * ancho;
    }
}
