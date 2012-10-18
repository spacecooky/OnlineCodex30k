package oc.necro.units;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class Verstohlenheit extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	
	public Verstohlenheit() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {

		
		ogE.addElement(new OptionsGruppeEintrag("Auflauern"));
		ogE.addElement(new OptionsGruppeEintrag("Abtauchen"));
		ogE.addElement(new OptionsGruppeEintrag("Entkommen"));
		ogE.addElement(new OptionsGruppeEintrag("Flink"));
		ogE.addElement(new OptionsGruppeEintrag("Infiltration"));
		ogE.addElement(new OptionsGruppeEintrag("Anschleichen"));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 6));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
