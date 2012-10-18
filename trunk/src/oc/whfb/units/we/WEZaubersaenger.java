package oc.whfb.units.we;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class WEZaubersaenger extends Eintrag {

	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	
	RuestkammerStarter rkMount;
	RuestkammerStarter rkMagic;
	
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	RuestkammerStarter rkLore;
	
	public WEZaubersaenger() {
		name = BuildaHQ.translate("Zaubersänger");
		grundkosten = 90;

		add(ico = new oc.Picture("oc/whfb/images/WEZaubersänger.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Upgrade zur 2. Stufe"), 35));

		seperator();
		
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Zauberer-Sippe"), 20));

		seperator();

		rkMount = new RuestkammerStarter(ID, randAbstand, cnt, "WEMount", "");
		rkMount.initKammer(false, false, false, true);
		rkMount.setButtonText(BuildaHQ.translate("Reittier"));
		add(rkMount);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "WEMagicItems", "");
		rkMagic.initKammer(true,true);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);
		
		seperator();

		rkLore = new RuestkammerStarter(ID, randAbstand, cnt, reflectionKennung+"MagicLores", "");
		rkLore.initKammer(false);
		rkLore.setButtonText(BuildaHQ.translate("Lehren der Magie"));
		add(rkLore);

		complete();
	}

	@Override
	public void refreshen() {
		rkLore.setAbwaehlbar(false);
		
		rkMagic.getKammer().switchEntry(BuildaHQ.translate("Bernsteinamulett"), rkMount.getKosten() == 0);
		rkMagic.getKammer().switchEntry(BuildaHQ.translate("Dornenrüstung"), rkMount.getKosten() == 0);

		String KindredValue = oe2.getText();
		rkMount.getKammer().switchEntry(BuildaHQ.translate("Zauberer-Sippe"), !(KindredValue.indexOf(BuildaHQ.translate("Zauberer-Sippe")) == -1) );
		
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
