package oc.whfb.units.bdc;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class BDCTodesbulle extends Eintrag {

	RuestkammerStarter rkEquipment;
	RuestkammerStarter rkMagic;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public BDCTodesbulle() {
		name = BuildaHQ.translate("Todesbulle");
		grundkosten = 235;
		
		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();
		
		rkEquipment = new RuestkammerStarter(ID, randAbstand, cnt, "BDCEquipment", "");
		rkEquipment.initKammer(true, true);
		rkEquipment.setButtonText(BuildaHQ.translate("Ausrüstung"));
		add(rkEquipment);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "BDCMagicItems", "");
		rkMagic.initKammer(false, true, true, true);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);

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
