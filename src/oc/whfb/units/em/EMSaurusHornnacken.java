package oc.whfb.units.em;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class EMSaurusHornnacken extends Eintrag {

	RuestkammerStarter rkMount;
	RuestkammerStarter rkMagic;
	RuestkammerStarter rkBanner;
	RuestkammerStarter rkEquipment;

	boolean astSelected = false;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public EMSaurusHornnacken() {
		name = BuildaHQ.translate("Saurus Hornnacken");
		grundkosten = 85;

		add(ico = new oc.Picture("oc/images/EMSaurusHornnacken.jpg"));
		
		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		rkEquipment = new RuestkammerStarter(ID, randAbstand, cnt, "EMEquipment", "");
		rkEquipment.initKammer(false, true, false);
		rkEquipment.setButtonText(BuildaHQ.translate("Ausrüstung"));
		add(rkEquipment);		
		
		seperator();

		rkMount = new RuestkammerStarter(ID, randAbstand, cnt, "EMMount", "");
		rkMount.initKammer(false, true, false, false);
		rkMount.setButtonText(BuildaHQ.translate("Reittier"));
		add(rkMount);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "EMMagicItems", "");
		rkMagic.initKammer(false, false, true, false, false, true, false, false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "EMBanner", BuildaHQ.translate("Armeestandartenträger"));
		rkBanner.initKammer(false, true, true, false);
		rkBanner.setGrundkosten(25);
		add(rkBanner);
		
		complete();
	}

	@Override
	public void refreshen() {
		rkMagic.getKammer().switchEntry(BuildaHQ.translate("Kampfechsenhaut"), rkMount.getKosten() == 0);
		rkMagic.getKammer().switchEntry(BuildaHQ.translate("Amulett des Jaguarkriegers"), rkMount.getKosten() == 0);
		rkMagic.getKammer().switchEntry(BuildaHQ.translate("Hörnerechse"), rkMount.getKosten() == 0);

		rkMagic.setAktiv(rkBanner.getKosten() <= 25);

		// Unique entry: AST
		boolean astGlobal = ( BuildaHQ.getCountFromInformationVector("EMast") > 0 ? true : false );
		if(astGlobal && !astSelected) rkBanner.setAktiv(false);
		else rkBanner.setAktiv(true);

		if(rkBanner.isSelected()) {
			astSelected = true;
			BuildaHQ.setInformationVectorValue("EMast", 1);
		} else {
			if(astSelected) {
				astSelected = false;
				BuildaHQ.setInformationVectorValue("EMast", 0);
				BuildaHQ.refreshEntries(1);
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
			BuildaHQ.setInformationVectorValue("EMast", 0);
		}
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}
}
