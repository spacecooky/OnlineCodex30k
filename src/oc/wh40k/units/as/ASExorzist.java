package oc.wh40k.units.as;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;

public class ASExorzist extends Eintrag {

	OptionsUpgradeGruppe o1;

	public ASExorzist() {
		name = "Exorzist";
		grundkosten = 135;

		add(ico = new oc.Picture("oc/wh40k/images/ASExorzist.jpg"));

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
