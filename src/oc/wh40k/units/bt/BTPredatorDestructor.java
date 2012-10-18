package oc.wh40k.units.bt;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class BTPredatorDestructor extends Eintrag {

	OptionsEinzelUpgrade oe1;

	public BTPredatorDestructor() {
		name = "Predator Destructor";
		grundkosten = 100;

		add(ico = new oc.Picture("oc/wh40k/images/BTPredatorDestructor.jpg"));

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Maschinenkanone", 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Zwei Schwere Bolter", "Seitenkuppeln mit Schweren Boltern", 10));
		ogE.addElement(new OptionsGruppeEintrag("Zwei Laserkanonen", "Seitenkuppeln mit Laserkanonen", 25));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Maschinengeist", 30));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Nebelwerfer", 3));

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setSelected(true);
	}

}
