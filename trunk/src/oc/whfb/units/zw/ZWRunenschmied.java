package oc.whfb.units.zw;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ZWRunenschmied extends Eintrag {

	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	RuestkammerStarter rkRunen;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;

	public ZWRunenschmied() {
		name = BuildaHQ.translate("Runenschmied");
		grundkosten = 70;

		add(ico = new oc.Picture("oc/whfb/images/ZWRunenschmied.jpg"));

		seperator(12);
		
		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Zweihandwaffe"), 4));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schild"), 2));

		seperator();

		rkRunen = new RuestkammerStarter(ID, randAbstand, cnt, "ZWRunen", "");
		rkRunen.initKammer(false, true, false, false, false, false);
		rkRunen.setButtonText(BuildaHQ.translate("Runen"));
		add(rkRunen);

		//defaults[2]

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
