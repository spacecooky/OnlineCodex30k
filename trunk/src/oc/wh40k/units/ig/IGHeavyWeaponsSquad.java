package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class IGHeavyWeaponsSquad extends RuestkammerVater {

	OptionsZaehlerGruppe o1;

	public IGHeavyWeaponsSquad() {
		grundkosten = 60;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGHeavyWeaponsSquad.jpg"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Mortar team", 0));
		ogE.addElement(new OptionsGruppeEintrag("Autocannon team", 5));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter team", 5));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher team", 10));
		ogE.addElement(new OptionsGruppeEintrag("Laser cannon team", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
//		o1.setAnzahl(0, 3);

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Krak grenades", 5));

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
		o1.setLegal(o1.getAnzahl() == 3);
	}

}
