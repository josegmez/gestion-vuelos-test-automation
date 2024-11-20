package co.edu.udea.codefactory.gestion_vuelos.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Flight {
    @NotNull public String flightNumber;
    @NotNull public String status;
    @NotNull public String flightType;
    @NotNull public String origin;
    @NotNull public String destination;
    @NotNull public LocalDateTime departureTime;
    @NotNull public LocalDateTime arrivalTime;

    public static Flight FromMap(Map<String, Object> data) {
        return new Flight(
                (String) data.get("Número de vuelo"),
                (String) data.get("Estado"),
                (String) data.get("Tipo de vuelo"),
                (String) data.get("Origen"),
                (String) data.get("Destino"),
                LocalDateTime.parse((String) data.get("Fecha de salida")),
                LocalDateTime.parse((String) data.get("Fecha de llegada"))
        );
    }
}
