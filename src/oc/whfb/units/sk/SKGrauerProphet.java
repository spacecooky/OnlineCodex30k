package oc.whfb.units.sk;

import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class SKGrauerProphet extends Eintrag {

	RuestkammerStarter rkMount;
	RuestkammerStarter rkMagic;
	RuestkammerStarter rkLore;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public SKGrauerProphet() {
		name = "Grauer Prophet";
		grundkosten = 240;

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();
		
		rkLore = new RuestkammerStarter(ID, randAbstand, cnt, reflectionKennung + "MagicLores", "");
		rkLore.initKammer(true,true);
		rkLore.setButtonText(BuildaHQ.translate("Lehren der Magie"));
		add(rkLore);
		
		seperator();

		rkMount = new RuestkammerStarter(ID, randAbstand, cnt, "SKMount", "");
		rkMount.initKammer(true, false, false);
		rkMount.setButtonText(BuildaHQ.translate("Reitdinge"));
		add(rkMount);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "SKMagicItems", "");
		rkMagic.initKammer(true, true, true, true, false, false, false, false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);

		complete();
	}

	@Override
	public void refreshen() {
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
		
		rkMagic.getKammer().specialAction(true,false);
		rkLore.setAbwaehlbar(false);
		
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
		}
		super.deleteYourself();
	}
}
