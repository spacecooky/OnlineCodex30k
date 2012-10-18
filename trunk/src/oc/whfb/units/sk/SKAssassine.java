package oc.whfb.units.sk;

import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class SKAssassine extends Eintrag {

	RuestkammerStarter rkMagic;

	public SKAssassine() {
		name = BuildaHQ.translate("Assassine");
		grundkosten = 120;

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "SKMagicItems", "");
		rkMagic.initKammer(false, true, true, false, true, false, false, false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);

		complete();
	}

	@Override
	public void refreshen() {
		if(BuildaHQ.getCountFromInformationVector("SK_SKROLK") == 0){
			BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Seuchenmönche"));
			BuildaHQ.refreshEntries(3);
			BuildaHQ.getChooserGruppe(4).addSpezialAuswahl(BuildaHQ.translate("Seuchenmönche"));
			BuildaHQ.refreshEntries(4);	
		}
		if(BuildaHQ.getCountFromInformationVector("SK_SKROTZ") == 0){
			BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Kern Rattenoger"));
			BuildaHQ.refreshEntries(3);
		}
		
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}
}
