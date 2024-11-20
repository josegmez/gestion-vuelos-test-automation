Feature: Consulta de vuelos
  Scenario: CP05 Consulta de información general de vuelos
    Given que el usuario navega a la pagina principal de la aplicacion
    When el usuario navega a la sección de gestiones de vuelos
    Then se muestran los vuelos en el sistema en una tabla con las columnas “Número de Vuelo”, “Estado”, “Tipo de Vuelo”, “Origen”, “Destino”, “Fecha de salida” y “Fecha de llegada”