package org.esfe.servicio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AreaServiceTest {
    private AreaService areaService;

    // Se ejecuta antes de cada prueba.
    @BeforeEach
    void setUp() {
        this.areaService = new AreaService();
    }

    // Probar el cálculo de área con L=2, W=3 (resultado 6).
    @Test
    void calcularAreaRectangulo_DebeDevolverAreaCorrecta() {
        double largo = 5.0;
        double ancho = 4.0;
        double resultadoEsperado = 20.0;

        double resultadoActual = areaService.calcularAreaRectangulo(largo, ancho);

        System.out.println("TEST 1: Área calculada para 5.0x4.0: " + resultadoActual);

        assertEquals(resultadoEsperado, resultadoActual, 0.001, "El área de 5x4 debe ser 20.");
    }

    // Probar el cálculo de área con decimales.
    @Test
    void calcularAreaRectangulo_DebeManejarDecimales() {
        double largo = 2.5;
        double ancho = 3.5;
        double resultadoEsperado = 8.75; // 2.5 * 3.5

        double resultadoActual = areaService.calcularAreaRectangulo(largo, ancho);
        System.out.println("TEST 2: Área calculada para 2.5x3.5: " + resultadoActual);

        assertEquals(resultadoEsperado, resultadoActual, 0.001, "El área de 2.5x3.5 debe ser 8.75.");
    }

}
