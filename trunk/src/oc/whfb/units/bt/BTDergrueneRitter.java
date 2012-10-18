package oc.whfb.units.bt;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class BTDergrueneRitter extends Eintrag {

	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public BTDergrueneRitter() {
		name = BuildaHQ.translate("Der grüne Ritter");
		grundkosten = 275;

		add(ico = new oc.Picture("oc/whfb/images/DELokhirTeufelsherz.jpg"));
		
		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		complete();
	}

	@Override
	public void refreshen() {
		if(BuildaHQ.getCountFromInformationVector("BT_LOUEN") == 0){
			BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Bogenschützen"));
			BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Landsknechte"));
			BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl(BuildaHQ.translate("Bogenschützen"));
			BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl(BuildaHQ.translate("Landsknechte"));
			
			BuildaHQ.refreshEntries(3);
			BuildaHQ.refreshEntries(4);
		}
		
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
