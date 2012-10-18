package oc.whfb.units.bdc;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class BDCHaeuptling extends Eintrag {

	RuestkammerStarter rkEquipment;
	RuestkammerStarter rkBanner;
	RuestkammerStarter rkMagic;
	RuestkammerStarter rkMount;
	RuestkammerStarter rkGaben;
	boolean astSelected = false;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public BDCHaeuptling() {
		name = BuildaHQ.translate("Häuptling");
		grundkosten = 85;
		
		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();
		
		rkEquipment = new RuestkammerStarter(ID, randAbstand, cnt, "BDCEquipment", "");
		rkEquipment.initKammer(false, false);
		rkEquipment.setButtonText(BuildaHQ.translate("Ausrüstung"));
		add(rkEquipment);

		seperator();
		
		rkMount = new RuestkammerStarter(ID, randAbstand, cnt, "BDCMount", "");
		rkMount.initKammer(true);
		rkMount.setButtonText(BuildaHQ.translate("Reittier"));
		add(rkMount);
		
		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "BDCMagicItems", "");
		rkMagic.initKammer(false, true, false, false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "BDCBanner", BuildaHQ.translate("Armeestandartenträger"));
		rkBanner.initKammer(true, true, true);
		rkBanner.setGrundkosten(25);
		add(rkBanner);
		
		seperator();

		rkGaben = new RuestkammerStarter(ID, randAbstand, cnt, "BDCGaben", "");
		rkGaben.initKammer(true, true, true);
		rkGaben.setButtonText(BuildaHQ.translate("Gaben des Chaos"));
		add(rkGaben);
		rkGaben.setAktiv(false);

		complete();
	}

	@Override
	public void refreshen() {
		rkMagic.setAktiv(rkBanner.getKosten() <= 25);
		rkGaben.setAktiv(rkBanner.getKosten() > 25);

		// Unique entry: AST
		boolean astGlobal = ( BuildaHQ.getCountFromInformationVector("BDCast") > 0 ? true : false );
		if(astGlobal && !astSelected) rkBanner.setAktiv(false);
		else rkBanner.setAktiv(true);

		if(rkBanner.isSelected()) {
			astSelected = true;
			BuildaHQ.setInformationVectorValue("BDCast", 1);
		} else {
			if(astSelected) {
				astSelected = false;
				BuildaHQ.setInformationVectorValue("BDCast", 0);
				BuildaHQ.refreshEntries(2);
			}
		}
		
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
		
		if ( !astGlobal ) rkBanner.setAktiv(!oGen.isSelected());
		if ( !genGlobal ) oGen.setAktiv(!rkBanner.isSelected());
	}
	
	@Override
	public void deleteYourself() {
		if(astSelected) {
			BuildaHQ.setInformationVectorValue("BDCast", 0);
		}
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}
}
