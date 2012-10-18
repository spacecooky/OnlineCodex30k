package oc.whfb.units.zw;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class ZWKoenig extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsEinzelUpgrade oe1;
	RuestkammerStarter rkRunen;
	boolean genSelected = false;
	boolean schild = false;
	OptionsEinzelUpgrade oGen;

	public ZWKoenig() {
		name = BuildaHQ.translate("König");
		grundkosten = 145;

		add(ico = new oc.Picture("oc/whfb/images/ZWKoenig.jpg"));

		seperator(12);
		
		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), 6));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Pistole"), 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Armbrust"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zwergenmuskete"), 15));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schild"), 3));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Eidstein"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schildträger"), 25));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		rkRunen = new RuestkammerStarter(ID, randAbstand, cnt, "ZWRunen", "");
		rkRunen.initKammer(true, false, false, false, false, true);
		rkRunen.setButtonText(BuildaHQ.translate("Runen"));
		add(rkRunen);

		BuildaHQ.addToInformationVector("ZWKlankrieger" , 1);

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
		
		if(o3.isSelected(BuildaHQ.translate("Schildträger"))) {
			schild = true;
			genSelected = true;
			oGen.setSelected(true);
			BuildaHQ.setInformationVectorValue("Gen", 1);
		} else {
			if(schild) {
				schild = false;
				BuildaHQ.refreshEntries(2);
			}
		}
	}

	public void deleteYourself() {
		BuildaHQ.addToInformationVector("ZWKlankrieger" , -1);
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		
		super.deleteYourself();
	}
}
