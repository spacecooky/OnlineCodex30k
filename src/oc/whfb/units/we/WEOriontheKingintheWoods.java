package oc.whfb.units.we;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class WEOriontheKingintheWoods extends Eintrag {
	
	AnzahlPanel squad;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public WEOriontheKingintheWoods() {
		name = BuildaHQ.translate("Orion, the King in the Woods");
		grundkosten = 575;
		
		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Hounds of the Hunt"), 0, 2, 15);
		squad.setGrundkosten(0);
		add(squad);
		
		add(ico = new oc.Picture("oc/whfb/images/WEOriontheKingintheWoods.jpg"));

		complete();
	}

	@Override
	public void refreshen() {
		oGen.setSelected(true);
		if(squad.getModelle()>0)setName(BuildaHQ.translate("Orion, the King in the Woods")+"\n");
		
		BuildaHQ.setInformationVectorValue("WE_ORION", 1);		
		
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Kurnous Wilde Jagd"));
		BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl(BuildaHQ.translate("Kurnous Wilde Jagd"));
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Waldelfenkrieger"));
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Waldelfenkundschafter"));
		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl(BuildaHQ.translate("Waldelfenkrieger"));
		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl(BuildaHQ.translate("Waldelfenkundschafter"));
		BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl(BuildaHQ.translate("Waldläufer"));
		BuildaHQ.getChooserGruppe(1).removeSpezialAuswahl(BuildaHQ.translate("Drycha"));
		
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
		
		BuildaHQ.setInformationVectorValue("WE_ORION", 0);
		
		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl(BuildaHQ.translate("Kurnous Wilde Jagd"));
		BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Kurnous Wilde Jagd"));
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Waldelfenkrieger"));
		BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Waldelfenkundschafter"));
		BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl(BuildaHQ.translate("Waldelfenkrieger"));
		BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl(BuildaHQ.translate("Waldelfenkundschafter"));
		BuildaHQ.getChooserGruppe(5).addSpezialAuswahl(BuildaHQ.translate("Waldläufer"));
		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl(BuildaHQ.translate("Drycha"));
		
		BuildaHQ.refreshEntries(3);
		BuildaHQ.refreshEntries(4);
		BuildaHQ.refreshEntries(5);
		
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
	}

}
