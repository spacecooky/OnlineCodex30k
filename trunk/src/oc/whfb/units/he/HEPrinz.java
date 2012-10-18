package oc.whfb.units.he;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class HEPrinz extends Eintrag {

	RuestkammerStarter rkEquipment;
	RuestkammerStarter rkMount;
	RuestkammerStarter rkMagic;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	RuestkammerStarter rkLore;
	
	public HEPrinz() {
		name = BuildaHQ.translate("Prinz");
		grundkosten = 150;

		add(ico = new oc.Picture("oc/images/HEPrinz.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		rkEquipment = new RuestkammerStarter(ID, randAbstand, cnt, "HEEquipment", "");
		rkEquipment.initKammer(true, false);
		rkEquipment.setButtonText(BuildaHQ.translate("Ausrüstung"));
		add(rkEquipment);

		seperator();

		rkMount = new RuestkammerStarter(ID, randAbstand, cnt, "HEMount", "");
		rkMount.initKammer(true, false, false, false);
		rkMount.setButtonText(BuildaHQ.translate("Reittier"));
		add(rkMount);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "HEMagicItems", "");
		rkMagic.initKammer(false, true, true, true);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);
		
		seperator();
		
		rkLore = new RuestkammerStarter(ID, randAbstand, cnt, reflectionKennung + "MagicLores", "");
		rkLore.initKammer(false);
		rkLore.setButtonText(BuildaHQ.translate("Lehren der Magie"));
		add(rkLore);

		complete();
	}

	@Override
	public void refreshen() {
		rkMagic.getKammer().switchEntry(BuildaHQ.translate("Sternenrüstung"), rkMount.getKosten() == 0);
		rkMagic.getKammer().switchEntry(BuildaHQ.translate("Das Weiße Schwert"), rkMount.getKosten() == 0);
		rkMagic.getKammer().switchEntry(BuildaHQ.translate("Maske des Meeresfürsten"), rkMount.getKosten() == 0);		
		
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
		
		boolean magicValue = ((HEMagicItems) rkMagic.getKammer()).getSternSelected();
        rkLore.setAktiv(magicValue && rkMagic.isSelected());
        rkLore.setAbwaehlbar(false);
	}
	
	@Override
	public void deleteYourself() {		
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}

}
