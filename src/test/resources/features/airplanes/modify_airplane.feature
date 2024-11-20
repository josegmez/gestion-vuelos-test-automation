Feature: Gestion de tipos de avión

  Scenario: CP08 Modificación exitosa de un tipo de avión
    Given que el usuario navega a la sección de Aeronaves
    When se busca el tipo de avión "A320"
    And da clic en el botón de acciones
    And da clic en la opción de “Editar”
    And modifica los datos existentes con información válida, en los campos modificables
      | Familia                  | Boeing |
      | Número de asientos       | 280    |
      | Distribución de asientos | 2-3-2  |
    And da clic en el botón de Guardar cambios
    Then el sistema debe mostrar un mensaje de éxito: "El tipo de aeronave ha sido actualizado exitosamente"