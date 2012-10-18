package oc.whfb.units.og;

import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class OGSkragderSchlaechter extends Eintrag {

	RuestkammerStarter rkLore;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public OGSkragderSchlaechter() {
		name = BuildaHQ.translate("Skrag der Schlächter");
		grundkosten = 425;

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();
		
		rkLore = new RuestkammerStarter(ID, randAbstand, cnt, reflectionKennung + "MagicLores", "");
		rkLore.initKammer(true, false, false);
		rkLore.setButtonText(BuildaHQ.translate("Lehren der Magie"));
		add(rkLore);
		
		BuildaHQ.setInformationVectorValue(name, 1);
		
		BuildaHQ.addToInformationVector(BuildaHQ.translate("Fleischer"), 1);

		complete();
	}

	@Override
	public void refreshen() {
		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl(BuildaHQ.translate("Verschlinger"));
		BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl(BuildaHQ.translate("Verschlinger"));
		
		BuildaHQ.refreshEntries(4);
		BuildaHQ.refreshEntries(5);
		
		rkLore.setAbwaehlbar(false);
		
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
		
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
		
		setUnikat(true);
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.setInformationVectorValue(name, 0);
		
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		
		BuildaHQ.addToInformationVector(BuildaHQ.translate("Fleischer"), -1);
		
		super.deleteYourself();
	}
}
