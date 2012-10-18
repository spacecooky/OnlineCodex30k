package oc.whfb.units.em;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class EMKroqGar extends Eintrag {
	
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;

	public EMKroqGar() {
		name = BuildaHQ.translate("Kroq Gar");
		grundkosten = 635;

		add(ico = new oc.Picture("oc/whfb/images/EMKroqGar.jpg"));
		
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Sauruskavallerie"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
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
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Sauruskavallerie"));
	}

}
