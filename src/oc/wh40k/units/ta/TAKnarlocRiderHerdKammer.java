package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class TAKnarlocRiderHerdKammer extends RuestkammerVater {

	AnzahlPanel boyz;
	
	OptionsZaehlerGruppe fk;

	public TAKnarlocRiderHerdKammer() {
		
		name = "Knarloc Rider Herd\n";
		grundkosten = 0;
	}
	public void initButtons(boolean... defaults) {	
		
		add(boyz = new AnzahlPanel(ID, randAbstand, cnt, "Knarloc Riders", 3, 6, 30));
		
		add(ico = new oc.Picture("oc/wh40k/images/ShaperCouncil.gif"));
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		
	}
}
