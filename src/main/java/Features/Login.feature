Feature: Ingreso a login
############################ CASOS POSITIVOS ########################
  @test #CASO POSITIVO
  Scenario Outline: Realizo login con distintos usuarios y sus contraseñas exitosamente
    Given Ingreso a SV
    When Me logeo exitosamente con usuario <usuario> y con contraseña <contraseña>
    And El usuario selecciona el menú <tarjeta> con submenú <subTarjeta> y opción <opcion>
    Then Cierro el navegador
    Examples:
      | usuario     | contraseña    | tarjeta    | subTarjeta                | opcion|
      | "102727215" | "Uprueba004"  | "Interno"  | "Operaciones"             | "Mantenedor Reglas Negocio"|
      | "121517124" | "1215         | "Mide"     | "Impacto de Capacitación" | "Reporte"          |
      | "192833698" | "1928"        | "Gestiona" | "Inscripciones"           | "Administración De Cursos"|

  @test #CASO POSITIVO
  Scenario Outline: Cliente se logea en la pagina principal y realiza una busqueda de curso
    Given Ingreso a SV
    When Me logeo exitosamente con usuario <usuario> y con contraseña <contraseña>
    And El usuario selecciona el menú <tarjeta> con submenú <subTarjeta> y opción <opcion>
    And Valido visibilidad de graficos
    And Filtro por Celulas
    And Filtro por etapas
    And Filtro por modalidad
    And Filtro por criticidad
    And Valido cantidad de registros seleccionados
    And Cambio cantidad de registros a mostrar
    Then Cierro el navegador Grilla
    Examples:
      | usuario     | contraseña    | tarjeta    | subTarjeta                | opcion                      | OpcMenu  |
      | "265589014" | "Otic2024##" | "Gestiona" | "Inscripciones"           | "Administración De Cursos"   |"Dashboard"|
      | "192833698" | "1928"        | "Gestiona" | "Inscripciones"           | "Administración De Cursos"   |"Dashboard"|
      | "121517124" | "1215         | "Gestiona" | "Inscripciones"           | "Administración De Cursos"   |"Dashboard"|



   @test #CASO POSITIVO #Uprueba001
   Scenario: Cliente realiza cambio de contraseña de manera exitosa
     Given Ingreso a SV
     When Me logeo exitosamente con usuario "265589014" y con contraseña "Otic2024{{"
     And Presiono boton de configuracion en sesion de usuario para "Cambiar contraseña"
     And Cambio de contraseña actual "Uprueba004" por la nueva "Uprueba005"
     Then Cierro el navegador

   @test #CASO POSITIVO
   Scenario: Cliente realiza recuperacion de contraseña
     Given Ingreso a SV
     When Presiono boton de recuperacion de contraseña
     And Ingreso Rut de usuario "265589014"
     And Inreso la contraseña "contraseñaTemporal"
     Then Cierro el navegador


  @test #CASO POSITIVO
  Scenario: Cliente bloquea contraseña por intentos de ingreso erroneos
    Given Ingreso a SV
    When Me intento logear con usuario correcto "265589014" y contraseña erronea "Uprueba004"
    And Ingreso a opcion del menu "Contenido del Curso"
    And Busco un curso por código sense
    And Agrego contenido a curso
    And Guardo contenido de curso
    Then Cierro el navegador


  @test
  Scenario: Cliente ingresa a su sesion y deshabilita usuario
    Given Ingreso a SV
    When Me logeo exitosamente con usuario "265589014" y con contraseña "Otic2024{{"
    And Ingreso a Modulo "Usuarios" del menú
    And Busco usuario por categoría "rut" y campo "156585424"
    #Se debe pasar categoria a buscar (RUT, nombre o perfil) y campo
    #And Presiono accion "Desactivar Usuario"
    #Then Cierro el navegador


############################ CASOS POSITIVOS ########################

  @test #CASO NEGATIVO
 Scenario Outline: Realizo login con usuarios y contraseñas incorrectas
    Given Ingreso a SV
    When Me logeo con usuario erroneo <usuariocorrecto> y con contraseña erronea <contraseñaIncorrecta>
    Then Cierro el navegador
    Examples:
      | usuariocorrecto | contraseñaIncorrecta |
      | "265589014"     | "Oticc2024-"         |
      | "265589014"     | "Oticc2024-"         |






