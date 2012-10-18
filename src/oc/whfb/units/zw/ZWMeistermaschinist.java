package oc.whfb.units.zw;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class ZWMeistermaschinist extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	RuestkammerStarter rkRunen;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;

	public ZWMeistermaschinist() {
		name = BuildaHQ.translate("Meistermaschinist");
		grundkosten = 70;

		add(ico = new oc.Picture("oc/whfb/images/ZWMeistermaschinist.jpg"));

		seperator(12);
		
		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Pistole"), 5));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Pistolenpaar"), 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Zwergenmuskete"), 10));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Zweihandwaffe"), 4));

		seperator();

		rkRunen = new RuestkammerStarter(ID, randAbstand, cnt, "ZWRunen", "");
		rkRunen.initKammer(false, false, false, true, false, false);
		rkRunen.setButtonText("Runen");
		add(rkRunen);

		complete();
	}

	@Override
	public void refreshen() {
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
