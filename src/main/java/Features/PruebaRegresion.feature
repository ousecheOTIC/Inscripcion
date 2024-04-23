Feature: Prueba de flujo completo para presentacion

  @test
  Scenario Outline: Usuario se logea en su perfil de sucursal virtual y hace inscripcion
    Given Ingreso a SV
    When Me logeo exitosamente con usuario <usuario> y con contraseña <contraseña>
    And El usuario selecciona el menú <tarjeta> con submenú <subTarjeta> y opción <opcion>
    And Ingreso a opcion del menu "Inscripciones"
    And Ingreso nueva inscripción
    And Buscamos cliente a inscribir
    And Buscamos susursal de cliente
    And Presionamos continuar
    And Seleccionamos tipo de linea
    And Pasamos al paso 2
    And Ingresamos codigo Sence
    And Valido informacion de curso validado
    And Ingreso valor acordado participante
    And Presionamos continuar
    And Ingreso fecha de inicio y termino del curso
    And Ingreso hora de inicio y termino del curso
    And Ingreso dias de curso
    And Selecciono horario y comentarios
    And Cargamos participantes
    And Visualizo participantes
    And Confirmamos carga exitosa
    And Validamos montos de calculo por participantes
    And Presionamos continuar
    And Seleccionamos la cuenta de financiamiento
    Then Presionamos boton inscribir curso
    Examples:
      | usuario     | contraseña   | tarjeta    | subTarjeta      | opcion                     |
      | "265589014" | "Otic2024##" | "Gestiona" | "Inscripciones" | "Administración De Cursos" |
      | "121517124" | "1215         | "Gestiona" | "Inscripciones"| "Administración De Cursos" |