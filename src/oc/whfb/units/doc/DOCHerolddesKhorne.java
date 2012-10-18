package oc.whfb.units.doc;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DOCHerolddesKhorne extends Eintrag {

	OptionsEinzelUpgrade oe;
	RuestkammerStarter rkEquipment;
	RuestkammerStarter rkMount;
	RuestkammerStarter rkBanner;
	RuestkammerStarter rkMagic;
	boolean astSelected = false;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public DOCHerolddesKhorne() {
		name = BuildaHQ.translate("Herold des Khorne");
		grundkosten = 100;

		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		rkMount = new RuestkammerStarter(ID, randAbstand, cnt, "DOCMount", "");
		rkMount.initKammer(true, false, false, false, false);
		rkMount.setButtonText(BuildaHQ.translate("Reittier"));
		add(rkMount);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "DOCMagicItems", "");
		rkMagic.initKammer(false, false, false, false, false, true, false, false, false);
		rkMagic.setButtonText(BuildaHQ.translate("Dämonengeschenke"));
		add(rkMagic);

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "DOCBanner", BuildaHQ.translate("Armeestandartenträger"));
		rkBanner.initKammer(true, false, false, false, false);
		rkBanner.setGrundkosten(25);
		add(rkBanner);

		complete();
	}

	@Override
	public void refreshen() {
		//rkMagic.setAktiv(rkBanner.getKosten() <= 25);

		// Unique entry: AST
		boolean astGlobal = ( BuildaHQ.getCountFromInformationVector("DOCast") > 0 ? true : false );
		if(astGlobal && !astSelected) rkBanner.setAktiv(false);
		else rkBanner.setAktiv(true);

		if(rkBanner.isSelected()) {
			astSelected = true;
			BuildaHQ.setInformationVectorValue("DOCast", 1);
		} else {
			if(astSelected) {
				astSelected = false;
				BuildaHQ.setInformationVectorValue("DOCast", 0);
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
			BuildaHQ.setInformationVectorValue("DOCast", 0);
		}
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}
	
}
