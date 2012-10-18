package oc.necro.units;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class Staerke extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	
	public Staerke() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {

		
		ogE.addElement(new OptionsGruppeEintrag("Surmangriff"));
		ogE.addElement(new OptionsGruppeEintrag("Sehr stark"));
		ogE.addElement(new OptionsGruppeEintrag("Schmetterschlag"));
		ogE.addElement(new OptionsGruppeEintrag("Kopfnuss"));
		ogE.addElement(new OptionsGruppeEintrag("Gegner schleudern"));
		ogE.addElement(new OptionsGruppeEintrag("Eisenkinn"));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 6));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
