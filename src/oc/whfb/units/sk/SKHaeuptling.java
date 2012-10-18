package oc.whfb.units.sk;

import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class SKHaeuptling extends Eintrag {

	RuestkammerStarter rkEquipment;
	RuestkammerStarter rkMagic;
	RuestkammerStarter rkBanner;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	boolean astSelected = false;

	public SKHaeuptling() {
		name = BuildaHQ.translate("Häuptling");
		grundkosten = 45;

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();
		
		rkEquipment = new RuestkammerStarter(ID, randAbstand, cnt, "SKEquipment", "");
		rkEquipment.initKammer(false, true, false, false, false, false);
		rkEquipment.setButtonText(BuildaHQ.translate("Ausrüstung"));
		add(rkEquipment);
		
		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "SKMagicItems", "");
		rkMagic.initKammer(false, true, true, false, false, false, false, false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "SKBanner", BuildaHQ.translate("Armeestandartenträger"));
		rkBanner.initKammer(false, true, true, false);
		rkBanner.setGrundkosten(25);
		add(rkBanner);
		
		complete();
	}

	@Override
	public void refreshen() {
		// Unique entry: AST
		boolean astGlobal = ( BuildaHQ.getCountFromInformationVector("SKast") > 0 ? true : false );
		if(astGlobal && !astSelected) rkBanner.setAktiv(false);
		else rkBanner.setAktiv(true);

		if(rkBanner.isSelected()) {
			astSelected = true;
			BuildaHQ.setInformationVectorValue("SKast", 1);
		} else {
			if(astSelected) {
				astSelected = false;
				BuildaHQ.setInformationVectorValue("SKast", 0);
				BuildaHQ.refreshEntries(2);
			}
		}
		
		if(BuildaHQ.getCountFromInformationVector("SK_SKROLK") == 0){
			BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Seuchenmönche"));
			BuildaHQ.refreshEntries(3);
			BuildaHQ.getChooserGruppe(4).addSpezialAuswahl(BuildaHQ.translate("Seuchenmönche"));
			BuildaHQ.refreshEntries(4);	
		}
		if(BuildaHQ.getCountFromInformationVector("SK_SKROTZ") == 0){
			BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Kern Rattenoger"));
			BuildaHQ.refreshEntries(3);
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
		rkMagic.getKammer().specialAction(false,rkBanner.getKammer().getKosten() > 25);
		
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}

	@Override
	public void deleteYourself() {
		if(astSelected) {
			BuildaHQ.setInformationVectorValue("SKast", 0);
		}
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();			
	}
}
