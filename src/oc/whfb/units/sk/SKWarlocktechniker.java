package oc.whfb.units.sk;

import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class SKWarlocktechniker extends Eintrag {

	RuestkammerStarter rkLore;
	RuestkammerStarter rkMagic;
	OptionsUpgradeGruppe o1;
	RuestkammerStarter rkEquipment;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public SKWarlocktechniker() {
		name = BuildaHQ.translate("Warlocktechniker");
		grundkosten = 15;

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Upgrade zur 1. Stufe"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Upgrade zur 2. Stufe"), 85));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		rkEquipment = new RuestkammerStarter(ID, randAbstand, cnt, "SKEquipment", "");
		rkEquipment.initKammer(false, false, true, false, false, false);
		rkEquipment.setButtonText(BuildaHQ.translate("Ausrüstung"));
		add(rkEquipment);
		
		seperator();
		
		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "SKMagicItems", "");
		rkMagic.initKammer(false, true, true, false, false, false, true, false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);
		
		seperator();
		
		rkLore = new RuestkammerStarter(ID, randAbstand, cnt, reflectionKennung + "MagicLores", "");
		rkLore.initKammer(true,false);
		rkLore.setButtonText(BuildaHQ.translate("Lehren der Magie"));
		add(rkLore);

		complete();
	}

	@Override
	public void refreshen() {
		rkMagic.getKammer().specialAction(o1.isSelected(),false);
		
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
		
		rkLore.setAbwaehlbar(false);
		rkLore.setAktiv(o1.isSelected());
		
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
