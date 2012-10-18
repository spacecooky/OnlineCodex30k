
package oc.wh40k.units.bt;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class BTRazorbackKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	public BTRazorbackKammer() {
		grundkosten = 70;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/BTRazorback.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("synchr. sB", "synchronisierter schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("synchr. LK", "synchronisierte Laserkanone", 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Maschinengeist", 30));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Nebelwerfer", 3));

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
		if(!o1.isSelected()) o1.setSelected(0, true);
	}

}











