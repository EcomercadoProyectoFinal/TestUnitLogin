package org.esfe.controlador;

import org.esfe.servicio.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/geometrica")
public class AreaController {
    @Autowired
    private AreaService areaService;

    // Endpoint: http://localhost:8080/api/geometrica/area/rectangulo?largo=5&ancho=4
    @GetMapping("/area/rectangulo")
    public ResponseEntity<?> calcularArea(
            @RequestParam double largo,
            @RequestParam double ancho) {

        try {
            double area = areaService.calcularAreaRectangulo(largo, ancho);

            // Devuelve un JSON con el resultado y el código 200 OK
            return ResponseEntity.ok(
                    "El área del rectángulo es: " + area);

        } catch (IllegalArgumentException e) {
            // Maneja el error de validación (largo o ancho negativo) con código 400 Bad Request
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        } catch (Exception e) {
            // Manejo genérico para otros errores, como que 'largo' o 'ancho' no sean números
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error: Asegúrate de que los parámetros 'largo' y 'ancho' sean números válidos.");
        }
    }
}
