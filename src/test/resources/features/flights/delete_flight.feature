Feature: Modificar un vuelo directo
  Scenario: CP19 Confirmar la eliminación de un vuelo
    Given que el usuario navega a la sección de gestión de vuelos
    When se busca el vuelo "SA5681"
    And da click en el botón de acciones
    And da clic en la opción de Eliminar
    And aparece un mensaje de confirmación
    And hago clic en el boton de eliminar
    Then debe mostrar el mensaje de éxito "Vuelo eliminado exitosamente"