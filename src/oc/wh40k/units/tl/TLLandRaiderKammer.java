package oc.wh40k.units.tl;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class TLLandRaiderKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade o2;

	boolean[] defaults;
	boolean chronusSelected = false;
    boolean isBefehl;

	public TLLandRaiderKammer() {
		grundkosten = 0;
	}

	public void initButtons(boolean... defaults) {
		this.defaults = defaults;
        isBefehl = defaults[0];

        if (isBefehl) add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Befehlspanzer", 0));
        if (isBefehl) seperator();

		add(ico = new oc.Picture("oc/wh40k/images/TLLandRaiderGross.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Land Raider", 250));
		ogE.addElement(new OptionsGruppeEintrag("Land Raider Crusader", 250));
		ogE.addElement(new OptionsGruppeEintrag("Land Raider Redeemer", 240));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multimelter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
        if (isBefehl) o2.setSelected(true);
	}	
}
