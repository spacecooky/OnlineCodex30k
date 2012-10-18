package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORAttakFighta extends Eintrag {

	AnzahlPanel Fightas;
	OptionsZaehlerGruppe FightasFK;
	
	public ORAttakFighta() {
		kategorie = 4;
		grundkosten = 0;

		add(Fightas = new AnzahlPanel(ID, randAbstand, cnt, "Attak Fighta", "Attak Fightas", 1, 3, 95));
		
		add(ico = new oc.Picture("oc/wh40k/images/ORAttakFighta.gif"));
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Two Bomms", 0));
		ogE.addElement(new OptionsGruppeEintrag("Two Rokkits", 0));
		add(FightasFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		complete();
	}

	public void refreshen() {
		FightasFK.setMaxAnzahl(Fightas.getModelle());
		FightasFK.setLegal(FightasFK.getAnzahl()==Fightas.getModelle());
	}
}
