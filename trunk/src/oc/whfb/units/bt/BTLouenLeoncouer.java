package oc.whfb.units.bt;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class BTLouenLeoncouer extends Eintrag {

	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public BTLouenLeoncouer() {
		name = "Louen Leoncouer";
		grundkosten = 728;

		add(ico = new oc.Picture("oc/whfb/images/DELokhirTeufelsherz.jpg"));
		
		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();
			
		complete();
	}

	@Override
	public void refreshen() {
		oGen.setSelected(true);//Louen muss General der Armee sein !!!
		
		BuildaHQ.setInformationVectorValue("BT_LOUEN", 1);		
		
		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl(BuildaHQ.translate("Bogenschützen"));
		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl(BuildaHQ.translate("Landsknechte"));
		BuildaHQ.refreshEntries(4);
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Bogenschützen"));
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Landsknechte"));
		BuildaHQ.refreshEntries(3);
		
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
		super.deleteYourself();
		
		BuildaHQ.setInformationVectorValue("BT_LOUEN", 0);
		
		BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Bogenschützen");
		BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("Landsknechte");
		BuildaHQ.refreshEntries(4);
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Bogenschützen");
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Landsknechte");
		BuildaHQ.refreshEntries(3);
		
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
	}

}
