package oc.necro.units;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class Geschick extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	
	public Geschick() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {

		
		ogE.addElement(new OptionsGruppeEintrag("Akrobatik"));
		ogE.addElement(new OptionsGruppeEintrag("Ausweichen"));
		ogE.addElement(new OptionsGruppeEintrag("Zurückspringen"));
		ogE.addElement(new OptionsGruppeEintrag("Springen"));
		ogE.addElement(new OptionsGruppeEintrag("Schnellziehen"));
		ogE.addElement(new OptionsGruppeEintrag("Sprinter"));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 6));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
