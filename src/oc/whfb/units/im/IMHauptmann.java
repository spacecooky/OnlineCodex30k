package oc.whfb.units.im;

import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IMHauptmann extends Eintrag {

	OptionsEinzelUpgrade oe;
	RuestkammerStarter rkEquipment;
	RuestkammerStarter rkMount;
	RuestkammerStarter rkBanner;
	RuestkammerStarter rkMagic;
	boolean astSelected = false;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;

	public IMHauptmann() {
		name = BuildaHQ.translate("Hauptmann");
		grundkosten = 50;

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		rkEquipment = new RuestkammerStarter(ID, randAbstand, cnt, "IMEquipment", "");
		rkEquipment.initKammer(false, false, true, false, false);
		rkEquipment.setButtonText(BuildaHQ.translate("Ausrüstung"));
		add(rkEquipment);

		seperator();

		rkMount = new RuestkammerStarter(ID, randAbstand, cnt, "IMMount", "");
		rkMount.initKammer(false, false, false, true, false, false, false, false);
		rkMount.setButtonText(BuildaHQ.translate("Reittier"));
		add(rkMount);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "IMMagicItems", "");
		rkMagic.initKammer(false, false, true, false, false, false, false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "IMBanner", BuildaHQ.translate("Armeestandartenträger"));
		rkBanner.initKammer(true, true, true);
		rkBanner.setGrundkosten(25);
		add(rkBanner);

		complete();
	}

	@Override
	public void refreshen() {
		rkMagic.setAktiv(rkBanner.getKosten() <= 25);
		
		boolean ast	= rkBanner.isSelected();	
		rkEquipment.getKammer().specialAction(ast);

		// Unique entry: AST
		boolean astGlobal = ( BuildaHQ.getCountFromInformationVector("IMast") > 0 ? true : false );
		if(astGlobal && !astSelected) rkBanner.setAktiv(false);
		else rkBanner.setAktiv(true);

		if(rkBanner.isSelected()) {
			astSelected = true;
			BuildaHQ.setInformationVectorValue("IMast", 1);
			rkMount.getKammer().switchEntry(BuildaHQ.translate("Pegasus"), false);
		} else {
			if(astSelected) {
				astSelected = false;
				BuildaHQ.setInformationVectorValue("IMast", 0);
				BuildaHQ.refreshEntries(2);
				rkMount.getKammer().switchEntry(BuildaHQ.translate("Pegasus"), true);
			}
		}
		
		int sigmar = BuildaHQ.getCountFromInformationVector("IM_SIGMAR");
		if(sigmar == 0){
			BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Kern Flagellanten"));
			BuildaHQ.refreshEntries(3);
		}
		
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
		
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}

	@Override
	public void deleteYourself() {
		if(astSelected) {
			BuildaHQ.setInformationVectorValue("IMast", 0);
		}
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}
	
}
