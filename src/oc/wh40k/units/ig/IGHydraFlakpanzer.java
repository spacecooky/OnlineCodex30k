package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IGHydraFlakpanzer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsEinzelUpgrade oe;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelUpgrade oe4;
	OptionsEinzelUpgrade oe5;

	public IGHydraFlakpanzer() {
		grundkosten = 0;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGHydraFlakTank.jpg"));
		

		seperator();

		add(oe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hydra Flakpanzer", 75));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Sturmbolter", 10));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Maschinengewehr", 10));
		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Suchkopfrakete", 10));
		add(oe4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Bulldozerschaufel", 10));
		add(oe5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Zusätzliche Panzerung", 15));

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
		oe.setSelected(true);

		if(!o1.isSelected()) o1.setSelected(0,true);

		oe1.setAktiv(!oe2.isSelected());
		oe2.setAktiv(!oe1.isSelected());
	}

}
