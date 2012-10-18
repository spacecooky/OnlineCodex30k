package oc.wh40k.units.ab;

import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class ABStormTrooperSergeantKammer extends RuestkammerVater {

    OptionsZaehlerGruppe o1;

	public ABStormTrooperSergeantKammer() {
		grundkosten = 0;
	}

    @Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 0));
		ogE.addElement(new OptionsGruppeEintrag("Boltgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		sizeSetzen();
	}

    @Override
	public void refreshen() {
	}

}
