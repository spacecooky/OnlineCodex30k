package oc.whfb.units.we;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class WEErinnye extends Eintrag {

	@Override
	public void deleteYourself() {
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}

	RuestkammerStarter rkSpites;
	OptionsEinzelUpgrade oe1;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	RuestkammerStarter rkLore;

	public WEErinnye() {
		name = BuildaHQ.translate("Erinnye");
		grundkosten = 65;

		add(ico = new oc.Picture("oc/whfb/images/WEErinnye.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Upgrade zur 1. Stufe"), 50));

		seperator();

		rkSpites = new RuestkammerStarter(ID, randAbstand, cnt, "WESpites", "");
		rkSpites.initKammer(true, true);
		rkSpites.setButtonText(BuildaHQ.translate("Feen"));
		add(rkSpites);
		
		seperator();

		rkLore = new RuestkammerStarter(ID, randAbstand, cnt, reflectionKennung+"MagicLores", "");
		rkLore.initKammer(false);
		rkLore.setButtonText(BuildaHQ.translate("Lehren der Magie"));
		add(rkLore);

		complete();
	}

	@Override
	public void refreshen() {
		rkLore.setAktiv(oe1.isSelected());
		rkLore.setAbwaehlbar(false);
		
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
}
