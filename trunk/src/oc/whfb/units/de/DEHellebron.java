package oc.whfb.units.de;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class DEHellebron extends Eintrag {

	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	boolean set = false;
	
	public DEHellebron() {
		name = BuildaHQ.translate("Hellebron");
		grundkosten = 350;

		add(ico = new oc.Picture("oc/whfb/images/DEHellebron.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Mantikor"), 200));

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
			if ( !set ) BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Hexenkriegerinnen");
			set = true;
		} else {
			if(genSelected) {
				genSelected = false;
				BuildaHQ.setInformationVectorValue("Gen", 0);
				BuildaHQ.refreshEntries(2);
				BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Hexenkriegerinnen"));
				set = false;
			}
		}
	}

	@Override
	public void deleteYourself() {		
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
			BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Hexenkriegerinnen"));
		}
		super.deleteYourself();
	}

}
