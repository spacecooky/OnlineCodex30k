package oc.whfb.units.im;

import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IMGeneraldesImperiums extends Eintrag {

	OptionsEinzelUpgrade oe;
	RuestkammerStarter rkEquipment;
	RuestkammerStarter rkMount;
	RuestkammerStarter rkBanner;
	RuestkammerStarter rkMagic;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public IMGeneraldesImperiums() {
		name = BuildaHQ.translate("General des Imperiums");
		grundkosten = 80;

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		rkEquipment = new RuestkammerStarter(ID, randAbstand, cnt, "IMEquipment", "");
		rkEquipment.initKammer(false, true, false, false, false);
		rkEquipment.setButtonText(BuildaHQ.translate("Ausr�stung"));
		add(rkEquipment);

		seperator();

		rkMount = new RuestkammerStarter(ID, randAbstand, cnt, "IMMount", "");
		rkMount.initKammer(false, true, false, false, false, false, false, false);
		rkMount.setButtonText(BuildaHQ.translate("Reittier"));
		add(rkMount);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "IMMagicItems", "");
		rkMagic.initKammer(false, true, true, true, false, false, true);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenst�nde"));
		add(rkMagic);

		complete();
	}

	@Override
	public void refreshen() {		
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
			BuildaHQ.setInformationVectorValue("IM_GOTE", 1);
		} else {
			if(genSelected) {
				genSelected = false;
				BuildaHQ.setInformationVectorValue("Gen", 0);
				BuildaHQ.setInformationVectorValue("IM_GOTE", 0);
				BuildaHQ.refreshEntries(2);
			}
		}
		
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}
	

	@Override
	public void deleteYourself() {		
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
			BuildaHQ.setInformationVectorValue("IM_GOTE", 0);
		}
		super.deleteYourself();
	}
	
}
