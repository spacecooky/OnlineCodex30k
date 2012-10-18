package oc.necro.units;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class Wildheit extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	
	public Wildheit() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {

		
		ogE.addElement(new OptionsGruppeEintrag("Berserkerangriff"));
		ogE.addElement(new OptionsGruppeEintrag("Ungest�m"));
		ogE.addElement(new OptionsGruppeEintrag("Eiserner Wille"));
		ogE.addElement(new OptionsGruppeEintrag("Killerreputation"));
		ogE.addElement(new OptionsGruppeEintrag("St�hlerne Nerven"));
		ogE.addElement(new OptionsGruppeEintrag("Z�h wie Leder"));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 6));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
