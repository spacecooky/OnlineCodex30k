package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class TAGreatKnarlocPack extends Eintrag {

	AnzahlPanel boyz;
	OptionsZaehlerGruppe fk;
	
	public TAGreatKnarlocPack() {

		kategorie = 1;

		name = "Great Knarloc Pack";
		grundkosten = 0;

		add(boyz = new AnzahlPanel(ID, randAbstand, cnt, "Great Knarlocs", 1, 10, 60));
		
		add(ico = new oc.Picture("oc/wh40k/images/ShaperCouncil.gif"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Kroot Bolt Thrower", 25));
		ogE.addElement(new OptionsGruppeEintrag("Twin Kroot Gun", 30));
		add(fk = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
				
		complete();
	}

	@Override
	public void refreshen() {
		int shapers=boyz.getModelle();
		fk.setMaxAnzahl(shapers);
	}
}
