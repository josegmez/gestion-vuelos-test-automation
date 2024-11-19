package co.edu.udea.codefactory.gestion_vuelos.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class AirplaneType {
    public String name;
    public String family;
    public Integer seatNumber;
    public String seatLayout;


    public Integer[] getSeatLayoutParts() {
        String[] parts = seatLayout.split("-"); // Dividimos la cadena en partes
        return new Integer[] { Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]) };
    }

    public static AirplaneType FromMap(Map<String, Object> data) {
        return new AirplaneType(
                (String) data.get("Nombre"),
                (String) data.get("Familia"),
                Integer.parseInt((String) data.get("Número de asientos")),
                (String) data.get("Distribución de asientos")
        );
    }
}
