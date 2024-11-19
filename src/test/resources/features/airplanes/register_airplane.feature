Feature: Gestion de tipos de avión

  Scenario: CP01 Registro de un tipo de avión con información válida
    Given que el usuario navega a la sección de gestión de tipos de avión
    And da clic en el botón Agregar aeronave
    And es redirigido al formulario para crear un tipo de avión
    When ingresa datos válidos en todos los campos requeridos
      | Nombre                   | A340   |
      | Familia                  | Airbus |
      | Número de asientos       | 210    |
      | Distribución de asientos | 2-3-2  |
    And intenta dar clic en el botón "Agregar aeronave" dentro del formulario
    Then debe mostrar el mensaje de éxito, "La aeronave ha sido creada exitosamente"
    And redirige hacia la sección de aeronaves
    And muestra el tipo de avión "A340" registrado en el sistema
