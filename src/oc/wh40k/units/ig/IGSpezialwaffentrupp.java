package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class IGSpezialwaffentrupp extends RuestkammerVater {

	OptionsZaehlerGruppe o1;

	public IGSpezialwaffentrupp() {
		grundkosten = 35;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGSpecialWeaponsSquad.jpg"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Granatwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Scharfschützengewehr", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Sprengladung", 20));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
//		o1.setAnzahl(0, 3);

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
		o1.setLegal(o1.getAnzahl() == 3);
	}

}
