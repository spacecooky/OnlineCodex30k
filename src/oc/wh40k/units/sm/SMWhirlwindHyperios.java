package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class SMWhirlwindHyperios extends Eintrag {

	OptionsEinzelUpgrade chronus;

	boolean chronusSelected = false;

	public SMWhirlwindHyperios() {
		name = "Whirlwind Hyperios";
		grundkosten = 115;

		add(ico = new oc.Picture("oc/wh40k/images/SMWhirlwindHyperios.jpg"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));
//		add(chronus = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Antaro Chronus", 70));

		complete();
	}

	@Override
	public void refreshen() {

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
