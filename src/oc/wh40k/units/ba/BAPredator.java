package oc.wh40k.units.ba;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class BAPredator extends Eintrag {

	OptionsUpgradeGruppe o1;

	public BAPredator() {
		name = "Predator";
		grundkosten = 70;

		add(ico = new oc.Picture("oc/wh40k/images/BAPredator.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Maschinenkanone", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 45));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected("autocannon", true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("2 Schwere Bolter", "Seitenkuppeln mit Schweren Boltern", 30));
		ogE.addElement(new OptionsGruppeEintrag("2 Laserkanonen", "Seitenkuppeln mit Laserkanonen", 65));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1));

		complete();
	}

	@Override
	public void refreshen() {
		if (!o1.isSelected()) {
			o1.setSelected("Maschinenkanone", true);
		}
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}

}
