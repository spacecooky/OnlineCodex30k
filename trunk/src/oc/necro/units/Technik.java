package oc.necro.units;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class Technik extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	
	public Technik() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {

		
		ogE.addElement(new OptionsGruppeEintrag("Waffenexperte"));
		ogE.addElement(new OptionsGruppeEintrag("Dealer"));
		ogE.addElement(new OptionsGruppeEintrag("Erfinder"));
		ogE.addElement(new OptionsGruppeEintrag("Sanitäter"));
		ogE.addElement(new OptionsGruppeEintrag("Spezialist"));
		ogE.addElement(new OptionsGruppeEintrag("Büchsenmacher"));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 6));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
