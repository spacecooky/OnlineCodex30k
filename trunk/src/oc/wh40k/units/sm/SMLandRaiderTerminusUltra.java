package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class SMLandRaiderTerminusUltra extends Eintrag {

	OptionsEinzelUpgrade chronus;

	boolean chronusSelected = false;

	public SMLandRaiderTerminusUltra() {
		name = "Land Raider Terminus Ultra";
		grundkosten = 300;

		add(ico = new oc.Picture("oc/wh40k/images/SMLandRaiderTerminus Ultra.jpg"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
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
