package oc.whfb.units.im;

import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class IMSigmarpriester extends Eintrag {

	OptionsEinzelUpgrade oe;
	RuestkammerStarter rkEquipment;
	RuestkammerStarter rkMount;
	RuestkammerStarter rkBanner;
	RuestkammerStarter rkMagic;

	boolean set = false;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;

	public IMSigmarpriester() {
		name = BuildaHQ.translate("Sigmarpriester");
		grundkosten = 90;

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		rkEquipment = new RuestkammerStarter(ID, randAbstand, cnt, "IMEquipment", "");
		rkEquipment.initKammer(false, false, false, false, true);
		rkEquipment.setButtonText(BuildaHQ.translate("Ausrüstung"));
		add(rkEquipment);

		seperator();

		rkMount = new RuestkammerStarter(ID, randAbstand, cnt, "IMMount", "");
		rkMount.initKammer(false, false, false, false, false, false, true, false);
		rkMount.setButtonText(BuildaHQ.translate("Reittier"));
		add(rkMount);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "IMMagicItems", "");
		rkMagic.initKammer(false, true, true, false, false, true, false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);

		complete();
	}

	@Override
	public void refreshen() {
		int sigmar = BuildaHQ.getCountFromInformationVector("IM_SIGMAR");
		sigmar++;
		if(!set)BuildaHQ.setInformationVectorValue("IM_SIGMAR", sigmar);
		set = true;
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Kern Flagellanten"));
		BuildaHQ.refreshEntries(3);
		
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
		
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}
	

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		
		int sigmar = BuildaHQ.getCountFromInformationVector("IM_SIGMAR");
		sigmar--;
		BuildaHQ.setInformationVectorValue("IM_SIGMAR", sigmar);	
		if(sigmar == 0){
			BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Kern Flagellanten"));
			BuildaHQ.refreshEntries(3);
		}
		
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
	}
}
