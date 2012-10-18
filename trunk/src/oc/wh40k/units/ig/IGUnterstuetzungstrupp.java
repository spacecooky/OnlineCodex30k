package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class IGUnterstuetzungstrupp extends RuestkammerVater {

	OptionsZaehlerGruppe o1;

	public IGUnterstuetzungstrupp() {
		grundkosten = 60;
	}

    @Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGHeavyWeaponsSquad.jpg"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Mörser Team", 0));
		ogE.addElement(new OptionsGruppeEintrag("MaschKa Team", "Maschinenkanonen Team", 5));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter Team", 5));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer Team", 10));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanonen Team", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sprenggranaten", 5));

		sizeSetzen();
	}

    @Override
	public void refreshen() {
		o1.setLegal(o1.getAnzahl() == 3);
	}

}
