#language:es
# Autor: AndresCortes
@stories
Característica: Acceder a pagina Web Utest


  @escenario1
  Escenario: Acceder a la Web Automation Demo Site
    Dado que Andres quiere acceder a la Web Automation Utest
    Cuando el realiza el registro en la pagina
      | strNombre | strApellido | strEmail           | strClave            | strConfirmarClave   |
      | Andres    | Cortes      | Andres@prueba3.com | PruebaChoucair2021* | PruebaChoucair2021* |
    Entonces el verifica que se carga la pantalla correctamente Complete Setup

