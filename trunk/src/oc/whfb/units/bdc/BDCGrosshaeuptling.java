package oc.whfb.units.bdc;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class BDCGrosshaeuptling extends Eintrag {

	RuestkammerStarter rkEquipment;
	RuestkammerStarter rkMount;
	RuestkammerStarter rkMagic;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public BDCGrosshaeuptling() {
		name = BuildaHQ.translate("Großhäuptling");
		grundkosten = 145;
		
		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();
		
		rkEquipment = new RuestkammerStarter(ID, randAbstand, cnt, "BDCEquipment", "");
		rkEquipment.initKammer(true, false);
		rkEquipment.setButtonText(BuildaHQ.translate("Ausrüstung"));
		add(rkEquipment);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "BDCMagicItems", "");
		rkMagic.initKammer(false, true, true, false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);

		seperator();

		rkMount = new RuestkammerStarter(ID, randAbstand, cnt, "BDCMount", "");
		rkMount.initKammer(true);
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
