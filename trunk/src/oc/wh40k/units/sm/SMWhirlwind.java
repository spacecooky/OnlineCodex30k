package oc.wh40k.units.sm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class SMWhirlwind extends Eintrag {

	OptionsEinzelUpgrade chronus;

	boolean chronusSelected = false;

	public SMWhirlwind() {
		name = "Whirlwind";
		grundkosten = 85;

		add(ico = new oc.Picture("oc/wh40k/images/Whirlwind.gif"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radar-Suchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));
		add(chronus = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Antaro Chronus", 70));

		complete();
	}

	@Override
	public void refreshen() {
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
