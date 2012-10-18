package oc.necro.units;

import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class Verletzungen extends RuestkammerVater {

	OptionsZaehlerGruppe oz1;
	
	public Verletzungen() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {

		
		ogE.addElement(new OptionsGruppeEintrag("Brustverletzung", "Brustverletzung (-1 W)"));
		ogE.addElement(new OptionsGruppeEintrag("Beinverletzung rechts", "Beinverletzung rechts (-1 B)"));
		ogE.addElement(new OptionsGruppeEintrag("Beinverletzung links", "Beinverletzung links (-1 B)"));
		ogE.addElement(new OptionsGruppeEintrag("Armverletzung rechts", "Armverletzung rechts (-1 S)"));
		ogE.addElement(new OptionsGruppeEintrag("Armverletzung links", "Armverletzung links (-1 S)"));
		ogE.addElement(new OptionsGruppeEintrag("Kopfverletzung"));
		ogE.addElement(new OptionsGruppeEintrag("Blindheit rechts", "Auf rechtem Auge blind"));
		ogE.addElement(new OptionsGruppeEintrag("Blindheit links", "Auf linkem Auge blind"));
		ogE.addElement(new OptionsGruppeEintrag("teilweise Taubheit", "teilweise Taubheit (-0,5 MW)"));
		ogE.addElement(new OptionsGruppeEintrag("Trauma", "Trauma (-1 I)"));
		ogE.addElement(new OptionsGruppeEintrag("Handverletzung rechts", "Handverletzung rechts (1 Finger)"));
		ogE.addElement(new OptionsGruppeEintrag("Handverletzung links", "Handverletzung links (1 Finger)"));
		ogE.addElement(new OptionsGruppeEintrag("Alte Kriegsverletzung"));
		ogE.addElement(new OptionsGruppeEintrag("Erbitterte Feindschaft", "Erbitterte Feindschaft (Hass gegen ...)"));
		ogE.addElement(new OptionsGruppeEintrag("Schreckliche Narben", "Schreckliche Narben (Angst)"));
		ogE.addElement(new OptionsGruppeEintrag("Eindrucksvolle Narben", "Eindrucksvolle Narben (+1 MW)"));
		add(oz1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
        oz1.setButtonMaxAnzahl("Auf rechtem Auge blind", 1);
        oz1.setButtonMaxAnzahl("Auf linkem Auge blind", 1);
        oz1.setButtonMaxAnzahl("Kopfverletzung", 1);
        oz1.setButtonMaxAnzahl("Handverletzung links (1 Finger)", 5);
        oz1.setButtonMaxAnzahl("Handverletzung rechts (1 Finger)", 5);

        oz1.setButtonMaxAnzahl("teilweise Taubheit (-1 MW)", 2);
	}

}
