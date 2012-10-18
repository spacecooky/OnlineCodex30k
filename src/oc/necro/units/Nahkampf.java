package oc.necro.units;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class Nahkampf extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	
	public Nahkampf() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {

		
		ogE.addElement(new OptionsGruppeEintrag("Kampfmeister"));
		ogE.addElement(new OptionsGruppeEintrag("Entwaffnen"));
		ogE.addElement(new OptionsGruppeEintrag("Finte"));
		ogE.addElement(new OptionsGruppeEintrag("Parieren"));
		ogE.addElement(new OptionsGruppeEintrag("Gegenangriff"));
		ogE.addElement(new OptionsGruppeEintrag("Ducken"));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 6));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
