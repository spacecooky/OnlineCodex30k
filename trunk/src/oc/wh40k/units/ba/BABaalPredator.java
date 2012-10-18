package oc.wh40k.units.ba;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class BABaalPredator extends Eintrag {

	OptionsUpgradeGruppe o1;

	public BABaalPredator() {
		name = "Baal-Predator";
		grundkosten = 115;

		add(ico = new oc.Picture("oc/wh40k/images/BABaalPredator.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sync. Sturmkanone", "Synchronisierte Sturmkanone", 0));
		ogE.addElement(new OptionsGruppeEintrag("Flammensturmkanone", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("2 Schwere Flamer", "Seitenkuppeln mit Schweren Flammenwerfern", 25));
		ogE.addElement(new OptionsGruppeEintrag("2 Schwere Bolter", "Seitenkuppeln mit Schweren Boltern", 30));
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
		if(!o1.isSelected()) o1.setSelected(0, true);
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}

}
