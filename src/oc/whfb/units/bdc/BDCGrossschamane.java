package oc.whfb.units.bdc;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class BDCGrossschamane extends Eintrag {

	RuestkammerStarter rkMagic;
	OptionsEinzelUpgrade oe1;
	RuestkammerStarter rkMount;
	RuestkammerStarter rkLore;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public BDCGrossschamane() {
		name = BuildaHQ.translate("Großschamane");
		grundkosten = 200;

		add(ico = new oc.Picture("oc/images/DEDunkelelfenzauberin.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Upgrade zur 4. Stufe"), 35));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("zus. Handwaffe"), 4));

		seperator();

		rkLore = new RuestkammerStarter(ID, randAbstand, cnt, reflectionKennung + "MagicLores", "");
		rkLore.initKammer(false,false);
		rkLore.setButtonText(BuildaHQ.translate("Lehren der Magie"));
		add(rkLore);
		
		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "BDCMagicItems", "");
		rkMagic.initKammer(true, true, true, false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);
		
		seperator();

		rkMount = new RuestkammerStarter(ID, randAbstand, cnt, "BDCMount", "");
		rkMount.initKammer(true);
		rkMount.setButtonText(BuildaHQ.translate("Reittier"));
		add(rkMount);

		complete();
	}

	@Override
	public void refreshen() {
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
