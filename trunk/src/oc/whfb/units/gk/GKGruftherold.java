package oc.whfb.units.gk;

import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class GKGruftherold extends Eintrag {

	OptionsEinzelUpgrade oe;
	RuestkammerStarter rkEquipment;
	RuestkammerStarter rkMount;
	RuestkammerStarter rkMagic;
	RuestkammerStarter rkBanner;
	boolean astSelected = true;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public GKGruftherold(){
		name = BuildaHQ.translate("Gruftherold");
		grundkosten = 60;
                
                add(ico = new oc.Picture(this));
                
                seperator();
		
		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();
	
		rkEquipment = new RuestkammerStarter(ID, randAbstand, cnt, "GKEquipment", "");
		rkEquipment.initKammer(false, false, true, false);
		rkEquipment.setButtonText(BuildaHQ.translate("Ausrüstung"));
		add(rkEquipment);
	
		seperator();
	
		rkMount = new RuestkammerStarter(ID, randAbstand, cnt, "GKMount", "");
		rkMount.initKammer(false, false, true, false);
		rkMount.setButtonText(BuildaHQ.translate("Reittier"));
		add(rkMount);
	
		seperator();
	
		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "GKMagicItems", "");
		rkMagic.initKammer(false, true, false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);
	
		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "GKBanner", BuildaHQ.translate("Armeestandartenträger"));
		rkBanner.initKammer(false, false, true, true, false);
		rkBanner.setGrundkosten(25);
		add(rkBanner);
		
		complete();
	}
	
	public void refreshen() {
		
		rkMagic.setAktiv(rkBanner.getKosten() <= 25);
		
		rkMagic.getKammer().switchEntry(BuildaHQ.translate("Staubmantel"), rkMount.getKosten() == 0);
		
		// Unique entry: AST
		boolean astGlobal = ( BuildaHQ.getCountFromInformationVector("GKast") > 0 ? true : false );
		if(astGlobal && !astSelected) rkBanner.setAktiv(false);
		else rkBanner.setAktiv(true);

		if(rkBanner.isSelected()) {
			astSelected = true;
			BuildaHQ.setInformationVectorValue("GKast", 1);
		} else {
			if(astSelected) {
				astSelected = false;
				BuildaHQ.setInformationVectorValue("GKast", 0);
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
		
//		/*if (ico != null ) panel.remove(ico);
//		if ( BuildaMenu.bilderAneigen.isSelected() ) {
//			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
//			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
//			panel.add(ico);
//		}
	}
	
	public void deleteYourself() {
		if(astSelected) {
			BuildaHQ.setInformationVectorValue("GKast", 0);
		}
		super.deleteYourself();
	}

}
