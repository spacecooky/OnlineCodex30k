package oc.whfb.units.we;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class WEBaumaeltester extends Eintrag {

	RuestkammerStarter rkSpites;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public WEBaumaeltester() {
		name = BuildaHQ.translate("Baumältester");
		grundkosten = 325;

		add(ico = new oc.Picture("oc/whfb/images/WEBaumaeltester.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		rkSpites = new RuestkammerStarter(ID, randAbstand, cnt, "WESpites", "");
		rkSpites.initKammer(false, true);
		rkSpites.setButtonText(BuildaHQ.translate("Feen"));
		add(rkSpites);

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
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}


}
