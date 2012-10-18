package oc.whfb.units.og2004;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class OG2004SkragderSchlaechter extends Eintrag {

	RuestkammerStarter rkLore;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public OG2004SkragderSchlaechter() {
		name = BuildaHQ.translate("Skrag der Schlächter");
		grundkosten = 400;

		add(ico = new oc.Picture("oc/whfb/images/OGSkragderSchlaechter.jpg"));
		
		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();
		
		rkLore = new RuestkammerStarter(ID, randAbstand, cnt, reflectionKennung + "MagicLores", "");
		rkLore.initKammer(false);
		rkLore.setButtonText(BuildaHQ.translate("Lehren der Magie"));
		add(rkLore);

		complete();
	}

	@Override
	public void refreshen() {
		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl(BuildaHQ.translate("Verschlinger"));
		BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl(BuildaHQ.translate("Verschlinger"));
		
		BuildaHQ.refreshEntries(4);
		BuildaHQ.refreshEntries(5);
		
		rkLore.setAbwaehlbar(false);
		oGen.setSelected(true);
		
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
		BuildaHQ.getChooserGruppe(5).addSpezialAuswahl(BuildaHQ.translate("Verschlinger"));
		BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl(BuildaHQ.translate("Verschlinger"));
		
		BuildaHQ.refreshEntries(4);
		BuildaHQ.refreshEntries(5);
		
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}
}
