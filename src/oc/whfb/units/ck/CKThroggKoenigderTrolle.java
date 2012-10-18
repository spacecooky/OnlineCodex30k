package oc.whfb.units.ck;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CKThroggKoenigderTrolle extends Eintrag {

	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public CKThroggKoenigderTrolle() {
		name = BuildaHQ.translate("Throgg, König der Trolle");
		grundkosten = 175;

		add(ico = new oc.Picture("oc/whfb/images/CKThrossKoenigderTrolle.jpg"));
		
		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Chaostrolle"));

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
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Chaostrolle"));
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}
}
