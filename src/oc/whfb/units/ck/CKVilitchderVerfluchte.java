package oc.whfb.units.ck;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class CKVilitchderVerfluchte extends Eintrag {
	
	RuestkammerStarter rkLore;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;

	public CKVilitchderVerfluchte() {
		name = BuildaHQ.translate("Vilitch der Verfluchte");
		grundkosten = 395;

		add(ico = new oc.Picture("oc/whfb/images/CKVilitchderVerfluchte.jpg"));
		
		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		rkLore = new RuestkammerStarter(ID, randAbstand, cnt, reflectionKennung + "MagicLores", "");
		rkLore.initKammer(true);
		rkLore.setButtonText(BuildaHQ.translate("Lehren der Magie"));
		add(rkLore);
		
		complete();
	}

	@Override
	public void refreshen() {
		rkLore.getKammer().specialAction(
			true,
			false,
			false
		);
		
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

	@Override
	public void deleteYourself() {
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}
}
