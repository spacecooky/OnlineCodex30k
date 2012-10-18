package oc.whfb.units.we;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class WEDrycha extends Eintrag {
	
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public WEDrycha() {
		name = BuildaHQ.translate("Drycha");
		grundkosten = 355;
		
		seperator();
		
		add(ico = new oc.Picture("oc/whfb/images/WEOriontheKingintheWoods.jpg"));
		
		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		complete();
	}

	@Override
	public void refreshen() {
		oGen.setSelected(true);
		BuildaHQ.setInformationVectorValue("WE_DRYCHA", 1);		
		
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Waldelfenkrieger"));
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Waldelfenkundschafter"));
		BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl(BuildaHQ.translate("Waldläufer"));
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Waldreiter"));
		BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl(BuildaHQ.translate("Kampftänzer"));
		BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl(BuildaHQ.translate("Falkenreiter"));
		BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl(BuildaHQ.translate("Riesenadler"));
		BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl(BuildaHQ.translate("Ewige Wache"));
		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl(BuildaHQ.translate("Orion, the King in the Woods"));
		
		BuildaHQ.refreshEntries(3);
		BuildaHQ.refreshEntries(4);
		BuildaHQ.refreshEntries(5);
		
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
		
		BuildaHQ.setInformationVectorValue("WE_DRYCHA", 0);
		
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Waldelfenkrieger"));
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Waldelfenkundschafter"));
		BuildaHQ.getChooserGruppe(5).addSpezialAuswahl(BuildaHQ.translate("Waldläufer"));
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Waldreiter"));
		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl(BuildaHQ.translate("Kampftänzer"));
		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl(BuildaHQ.translate("Falkenreiter"));
		BuildaHQ.getChooserGruppe(5).addSpezialAuswahl(BuildaHQ.translate("Riesenadler"));
		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl(BuildaHQ.translate("Ewige Wache"));
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl(BuildaHQ.translate("Orion, the King in the Woods"));
		
		BuildaHQ.refreshEntries(3);
		BuildaHQ.refreshEntries(4);
		BuildaHQ.refreshEntries(5);
		
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
	}
}
