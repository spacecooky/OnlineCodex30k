package oc.wh40k.units.dm;

import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DMPainboy extends RuestkammerVater {

	OptionsZaehlerGruppe o1;

	public DMPainboy() {
		grundkosten = 20;
	}

	@Override
	public void initButtons(boolean... defaults) {
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option","Bosspole", 5));
		add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "option","Grot Orderlies", 2, 5));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

	
}
