package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class IGSpecialWeaponsSquad extends RuestkammerVater {

	OptionsZaehlerGruppe o1;

	public IGSpecialWeaponsSquad() {
		grundkosten = 35;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGSpecialWeaponsSquad.jpg"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Sniper rifle", 5));
		ogE.addElement(new OptionsGruppeEintrag("Meltagun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Demolition charge", 20));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
//		o1.setAnzahl(0, 3);

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
		o1.setLegal(o1.getAnzahl() == 3);
	}

}
