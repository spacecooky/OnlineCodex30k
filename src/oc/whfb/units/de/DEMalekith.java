package oc.whfb.units.de;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DEMalekith extends Eintrag {

	OptionsUpgradeGruppe o1;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	RuestkammerStarter rkLore;

	public DEMalekith() {
		name = BuildaHQ.translate("Malekith");
		grundkosten = 600;

		add(ico = new oc.Picture("oc/whfb/images/DEMalekith.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kampfechse"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schwarzer Drache"), 320));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Der Schwarze Streitwagen"), 110));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		rkLore = new RuestkammerStarter(ID, randAbstand, cnt, "DEMagicLores", "");
		rkLore.initKammer(true);
		rkLore.setButtonText(BuildaHQ.translate("Lehren der Magie"));
		add(rkLore);

		complete();
	}

	@Override
	public void refreshen() {
		oGen.setSelected(true);
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
