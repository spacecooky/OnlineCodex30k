package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class TAGreatKnarlocPackKammer extends RuestkammerVater {

	AnzahlPanel boyz;
	OptionsZaehlerGruppe fka;
	OptionsZaehlerGruppe fk;
	
	public TAGreatKnarlocPackKammer() {
			grundkosten = 0;
	}
		
	public void initButtons(boolean... defaults) {
		name = "Great Knarloc Pack";
		

		add(boyz = new AnzahlPanel(ID, randAbstand, cnt, "Great Knarlocs", 1, 10, 60));
		
		add(ico = new oc.Picture("oc/wh40k/images/GreatKnarlocPack.gif"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Kroot Bolt Thrower", 25));
		ogE.addElement(new OptionsGruppeEintrag("Twin Kroot Gun", 30));
		add(fk = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
				
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		int shapers=boyz.getModelle();
		fk.setMaxAnzahl(shapers);
	}
}
