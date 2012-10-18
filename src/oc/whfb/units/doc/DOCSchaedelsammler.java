package oc.whfb.units.doc;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DOCSchaedelsammler extends Eintrag {

	OptionsEinzelUpgrade oe;
	RuestkammerStarter rkMount;

	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;

	public DOCSchaedelsammler() {
		name = BuildaHQ.translate("Schädelsammler");
		grundkosten = 150;

		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		rkMount = new RuestkammerStarter(ID, randAbstand, cnt, "DOCMount", "");
		rkMount.initKammer(true, false, false, false, true);
		rkMount.setButtonText(BuildaHQ.translate("Reittier"));
		add(rkMount);

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
