package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class TAMountedGreatKnarlocHerd extends Eintrag {

	AnzahlPanel boyz;
	OptionsZaehlerGruppe fka;
	OptionsZaehlerGruppe fk;
	OptionsEinzelUpgrade adaption;
	
	public TAMountedGreatKnarlocHerd() {

		kategorie = 1;

		name = "Mounted Great Knarloc Herd";
		grundkosten = 0;

		add(boyz = new AnzahlPanel(ID, randAbstand, cnt, "Great Knarlocs", 1, 3, 70));
		
		add(ico = new oc.Picture("oc/wh40k/images/ShaperCouncil.gif"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Explosive Bolts", 15));
		ogE.addElement(new OptionsGruppeEintrag("Twin Kroot Gun", 20));
		add(fk = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		complete();
	}

	@Override
	public void refreshen() {
		int shapers=boyz.getModelle();
		fk.setMaxAnzahl(shapers);
		
	}
}
