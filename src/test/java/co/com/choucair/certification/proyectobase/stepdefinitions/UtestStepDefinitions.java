package co.com.choucair.certification.proyectobase.stepdefinitions;

import co.com.choucair.certification.proyectobase.model.DatosP;
import co.com.choucair.certification.proyectobase.questions.Validar;
import co.com.choucair.certification.proyectobase.tasks.Abrir;
import co.com.choucair.certification.proyectobase.tasks.RealizaRegistro;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class UtestStepDefinitions {

    @Before
    public void DoSomethingBefore() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Andres");
    }

    @Dado("^que Andres quiere acceder a la Web Automation Utest$")
    public void queAndresQuiereAccederALaWebAutomationUtest() {
        OnStage.theActorCalled("Andres").wasAbleTo(Abrir.LaPaginaUtest());
    }

    @Cuando("^el realiza el registro en la pagina$")
    public void elRealizaElRegistroEnLaPagina(List<DatosP> datosP) {
        OnStage.theActorInTheSpotlight().attemptsTo(RealizaRegistro.IngresaInformacion(datosP.get(0)));
    }

    @Entonces("^el verifica que se carga la pantalla correctamente (.*)$")
    public void elVerificaQueSeCargaLaPantallaCorrectamente(String textoValidacion) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Validar.creacionUsuario(), org.hamcrest.Matchers.containsString(textoValidacion)));
    }
}
