package co.com.choucair.certification.proyectobase.tasks;

import co.com.choucair.certification.proyectobase.model.DatosP;
import co.com.choucair.certification.proyectobase.userinterface.AutomationHomePage;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RealizaRegistro implements Task {

    private DatosP datosP;

    public RealizaRegistro(DatosP datosP) {
        this.datosP=datosP;
    }

    public static RealizaRegistro IngresaInformacion(DatosP datosP) {
        return Tasks.instrumented(RealizaRegistro.class, datosP);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(AutomationHomePage.BTN_INGRESAR_DATOS),
                Enter.theValue(datosP.getStrNombre()).into(AutomationHomePage.TXT_NOMBRE),
                Enter.theValue(datosP.getStrApellido()).into(AutomationHomePage.TXT_APELLIDO),
                Enter.theValue(datosP.getStrEmail()).into(AutomationHomePage.TXT_EMAIL),
                Click.on(AutomationHomePage.SLC_MES),
                Click.on(AutomationHomePage.SLC_DIA),
                Click.on(AutomationHomePage.SLC_ANO),
                WaitUntil.the(AutomationHomePage.BTN_SIG_UBICACION, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(AutomationHomePage.BTN_SIG_UBICACION),
                WaitUntil.the(AutomationHomePage.BTN_SIG_DISPOSITIVO, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(AutomationHomePage.BTN_SIG_DISPOSITIVO),
                WaitUntil.the(AutomationHomePage.BTN_SIG_PASO, isVisible()).forNoMoreThan(60).seconds(),
                Click.on(AutomationHomePage.BTN_SIG_PASO),
                WaitUntil.the(AutomationHomePage.TXT_CLAVE, isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(datosP.getStrClave()).into(AutomationHomePage.TXT_CLAVE),
                Enter.theValue(datosP.getStrConfirmarClave()).into(AutomationHomePage.TXT_CONFIRMAR_CLAVE),
                Click.on(AutomationHomePage.CHECK_TERMINOS),
                Click.on(AutomationHomePage.CHECK_POLITICAS));
    }
}
