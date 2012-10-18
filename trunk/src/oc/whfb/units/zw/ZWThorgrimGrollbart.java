package oc.whfb.units.zw;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ZWThorgrimGrollbart extends Eintrag {

	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public ZWThorgrimGrollbart() {
		name = BuildaHQ.translate("Thorgrim Grollbart");
		grundkosten = 780;

		add(ico = new oc.Picture("oc/whfb/images/ZWThorgrimGrollbart.jpg"));
		
		seperator(12);
		
		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();
		
		BuildaHQ.addToInformationVector("ZWKlankrieger" , 1);

		complete();
	}

	@Override
	public void refreshen() {
		// Unique entry: GENERAL
		boolean genGlobal = ( BuildaHQ.getCountFromInformationVector("Gen") > 0 ? true : false );
		if(genGlobal && !genSelected) oGen.setAktiv(false);
		else oGen.setAktiv(true);

		if(oGen.isSelected()) {
			genSelected = true;
			BuildaHQ.setInformationVectorValue("Gen", 1);
		} else {
			if(genSelected) {
				genSelected = false;
				BuildaHQ.setInformationVectorValue("Gen", 0);
				BuildaHQ.refreshEntries(2);
			}
		}
	}
	
	@Override
	public void deleteYourself() {		
		BuildaHQ.addToInformationVector("ZWKlankrieger" , -1);
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
	}

}
