package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsZaehlerGruppe;

public class TAKnarlocRiderHerd extends Eintrag {

	AnzahlPanel boyz;
	
	OptionsZaehlerGruppe fk;

	public TAKnarlocRiderHerd() {
		
		kategorie = 4;

		name = "Knarloc Rider Herd\n";
		grundkosten = 0;
		überschriftSetzen=true;

		add(boyz = new AnzahlPanel(ID, randAbstand, cnt, "Knarloc Riders", 3, 6, 30));
		
		add(ico = new oc.Picture("oc/wh40k/images/ShaperCouncil.gif"));
		
		complete();
	}

	@Override
	public void refreshen() {
		
	}
}
