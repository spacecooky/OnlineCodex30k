package oc.whfb.units.he;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class HEDrachenmagiervonCaledor extends Eintrag {

	RuestkammerStarter rkMagic;
	RuestkammerStarter rkLore;
	
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public HEDrachenmagiervonCaledor() {
		name = BuildaHQ.translate("Drachenmagier von Caledor");
		grundkosten = 350;

		add(ico = new oc.Picture("oc/images/HEDrachenmagiervonCaledor.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Upgrade zur 2. Stufe"), 35));

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "HEMagicItems", "");
		rkMagic.initKammer(true, true, true, false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);
		
		seperator();
		
		rkLore = new RuestkammerStarter(ID, randAbstand, cnt, reflectionKennung + "MagicLores", "");
		rkLore.initKammer(true);
		rkLore.setButtonText(BuildaHQ.translate("Lehren der Magie"));
		add(rkLore);

		complete();
	}

	@Override
	public void refreshen() {
		rkLore.setAbwaehlbar(false);
		
		rkMagic.getKammer().switchEntry(BuildaHQ.translate("Das Weiße Schwert"), false);
		
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
	}
	
	@Override
	public void deleteYourself() {
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}
}
