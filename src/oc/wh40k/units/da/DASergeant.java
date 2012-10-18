package oc.wh40k.units.da;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DASergeant extends RuestkammerVater {

	OptionsZaehlerGruppe o1;

	public DASergeant() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();

		if(defaults.length > 1 && defaults[1]) {
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Plasmapistole", 15));
		}
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melterbomben", 5));

		if(defaults.length > 0 && defaults[0]) {
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Parierschild", 10));
		}

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
