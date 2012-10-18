package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class SMLandRaiderKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade o2;
	OptionsEinzelUpgrade chronus;

	boolean[] defaults;
	boolean chronusSelected = false;
        boolean isBefehl;

	public SMLandRaiderKammer() {
		grundkosten = 0;
	}

	public void initButtons(boolean... defaults) {
		this.defaults = defaults;
                if(defaults.length > 0) isBefehl = defaults[0];

                if (isBefehl) add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Befehlspanzer", 0));
                if (isBefehl) seperator();

		add(ico = new oc.Picture("oc/wh40k/images/SMLandRaiderGross.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Land Raider", 250));
		ogE.addElement(new OptionsGruppeEintrag("Land Raider Crusader", 250));
		ogE.addElement(new OptionsGruppeEintrag("Land Raider Redeemer", 240));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Multimelter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));
		add(chronus = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Antaro Chronus", 70));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
        if (isBefehl) o2.setSelected(true);

		// Unique entry: Antaro Chronus
		boolean chronusGlobal = ( BuildaHQ.getCountFromInformationVector("SMChronus") > 0 ? true : false );
		if(chronusGlobal && !chronusSelected) chronus.setAktiv(false);
		else chronus.setAktiv(true);

		if(chronus.isSelected()) {
			chronusSelected = true;
			BuildaHQ.addToInformationVector("SMChronus", 1);
		} else {
			if(chronusSelected) {
				chronusSelected = false;
				BuildaHQ.setInformationVectorValue("SMChronus", 0);
			}
		}
	}

	@Override
	public void deleteYourself() {
		if(chronusSelected) {
			BuildaHQ.setInformationVectorValue("SMChronus", 0);
		}
		super.deleteYourself();
	}
	
}
