package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SMLandRaiderHelios extends Eintrag {

	OptionsEinzelUpgrade chronus;

	boolean chronusSelected = false;
    OptionsUpgradeGruppe o1;

	public SMLandRaiderHelios() {
		name = "Land Raider Helios";
		grundkosten = 260;

		add(ico = new oc.Picture("oc/wh40k/images/SMLandRaiderHelios.jpg"));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("WW-Raketenwerfer", "Whirlwind-Raketenwerfer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Hyperios launcher", "Hyperios anti-aircraft launcher", 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));
//		add(chronus = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Antaro Chronus", 70));

		complete();
	}

	@Override
	public void refreshen() {
        o1.alwaysSelected();

//		// Unique entry: Antaro Chronus
//		boolean chronusGlobal = ( BuildaHQ.getCountFromInformationVector("SMChronus") > 0 ? true : false );
//		if(chronusGlobal && !chronusSelected) chronus.setAktiv(false);
//		else chronus.setAktiv(true);
//
//		if(chronus.isSelected()) {
//			chronusSelected = true;
//			BuildaHQ.addToInformationVector("SMChronus", 1);
//		} else {
//			if(chronusSelected) {
//				chronusSelected = false;
//				BuildaHQ.setInformationVectorValue("SMChronus", 0);
//				BuildaHQ.refreshEntries(1);
//				BuildaHQ.refreshEntries(2);
//				BuildaHQ.refreshEntries(3);
//				BuildaHQ.refreshEntries(4);
//				BuildaHQ.refreshEntries(5);
//			}
//		}
	}

	@Override
	public void deleteYourself() {
//		if(chronusSelected) {
//			BuildaHQ.setInformationVectorValue("SMChronus", 0);
//		}
//		super.deleteYourself();
	}

}
