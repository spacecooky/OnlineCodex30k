package oc.whfb.units.de;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DEMorathi extends Eintrag {

	OptionsUpgradeGruppe o1;
	RuestkammerStarter rkMagic;
	RuestkammerStarter rkLore;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;

	public DEMorathi() {
		name = BuildaHQ.translate("Morathi");
		grundkosten = 455;

		add(ico = new oc.Picture("oc/whfb/images/DEMorathi.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Herzspießer"), 45));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwert der Finsternis"), 25));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "DEMorathiItems", "");
		rkMagic.initKammer();
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);
		
		seperator();
		
		rkLore = new RuestkammerStarter(ID, randAbstand, cnt, "DEMagicLores", "");
		rkLore.initKammer(true);
		rkLore.setButtonText(BuildaHQ.translate("Lehren der Magie"));
		add(rkLore);

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
