package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IGRaketenpanzerManticor extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelUpgrade oe4;
	OptionsEinzelUpgrade oe5;
	OptionsEinzelUpgrade oe6;

	public IGRaketenpanzerManticor() {
		name = "Raketenpanzer Manticor";
		grundkosten = 160;

		add(ico = new oc.Picture("oc/wh40k/images/IGManticoreRocketLauncher.jpg"));

		seperator(12);

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Sturmbolter", 10));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Maschinengewehr", 10));
		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Suchkopfrakete", 10));
		add(oe4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Bulldozerschaufel", 10));
		add(oe5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Zusätzliche Panzerung", 15));
		add(oe6 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Tarnnetze", 30));

		complete();
	}

	// @OVERRIDE
	public void refreshen() {
		if(!o1.isSelected()) o1.setSelected(0,true);
	}

}
