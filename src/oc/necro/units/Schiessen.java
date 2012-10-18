package oc.necro.units;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class Schiessen extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	
	public Schiessen() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {

		
		ogE.addElement(new OptionsGruppeEintrag("Zeilgenau"));
		ogE.addElement(new OptionsGruppeEintrag("Schnellschütze"));
		ogE.addElement(new OptionsGruppeEintrag("Revolverheld"));
		ogE.addElement(new OptionsGruppeEintrag("Aus der Hüfte schießen"));
		ogE.addElement(new OptionsGruppeEintrag("Scharfschütze"));
		ogE.addElement(new OptionsGruppeEintrag("Dauerfeuer"));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 6));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
