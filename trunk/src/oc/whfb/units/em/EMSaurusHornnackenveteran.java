package oc.whfb.units.em;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class EMSaurusHornnackenveteran extends Eintrag {

	RuestkammerStarter rkMount;
	RuestkammerStarter rkMagic;
	RuestkammerStarter rkEquipment;
	
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public EMSaurusHornnackenveteran() {
		name = BuildaHQ.translate("Saurus Hornnackenveteran");
		grundkosten = 145;

		add(ico = new oc.Picture("oc/images/EMSaurushornnackenveteran.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		rkMount = new RuestkammerStarter(ID, randAbstand, cnt, "EMMount", "");
		rkMount.initKammer(true, false, false, false);
		rkMount.setButtonText(BuildaHQ.translate("Reittier"));
		add(rkMount);

		seperator();

		rkEquipment = new RuestkammerStarter(ID, randAbstand, cnt, "EMEquipment", "");
		rkEquipment.initKammer(true, false, false, false);
		rkEquipment.setButtonText(BuildaHQ.translate("Ausrüstung"));
		add(rkEquipment);		
		
		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "EMMagicItems", "");
		rkMagic.initKammer(false, false, false, true, false, true, false, false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);

		complete();
	}

	@Override
	public void refreshen() {
		rkMagic.getKammer().switchEntry(BuildaHQ.translate("Kampfechsenhaut"), rkMount.getKosten() == 0);
		rkMagic.getKammer().switchEntry(BuildaHQ.translate("Amulett des Jaguarkriegers"), rkMount.getKosten() == 0);
		rkMagic.getKammer().switchEntry(BuildaHQ.translate("Hörnerechse"), rkMount.getKosten() == 0);
	
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
