package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IGGeschuetzpanzer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;

	public IGGeschuetzpanzer() {
		grundkosten = 0;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGOrdnanceTank.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Basilisk", 125));
		ogE.addElement(new OptionsGruppeEintrag("Medusa", 135));
		ogE.addElement(new OptionsGruppeEintrag("Koloss", 140));
		ogE.addElement(new OptionsGruppeEintrag("Greif", 75));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Gepanzerte Kabine", 15));
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Sturmbolter", 10));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Maschinengewehr", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Suchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Bulldozerschaufel", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Zusätzliche Panzerung", 15));
		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Bunkerbrecher-Granaten", 5));

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
        if(!o1.isSelected()) o1.setSelected(0,true);
        if(!o2.isSelected()) o2.setSelected(0,true);
		
		oe1.setAktiv(!oe2.isSelected());
		oe2.setAktiv(!oe1.isSelected());
		oe3.setAktiv(o1.isSelected("Medusa"));
	}

}
