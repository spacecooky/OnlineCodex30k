package oc.whfb.units.doc;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DOCKhorneDaemonenprinz extends Eintrag {

	RuestkammerStarter rkMagic;
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	
	OptionsGruppeEintrag mok;
	OptionsGruppeEintrag mot;
	OptionsGruppeEintrag mon;
	OptionsGruppeEintrag mos;
	
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;

	public DOCKhorneDaemonenprinz() {
		name = BuildaHQ.translate("Khorne Dämonenprinz");
		grundkosten = 335;

		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "DOCMagicItems", "");
		rkMagic.initKammer(true, false, false, false, true, false, false, false, false);
		rkMagic.setButtonText(BuildaHQ.translate("Dämonengeschenke"));
		add(rkMagic);

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
