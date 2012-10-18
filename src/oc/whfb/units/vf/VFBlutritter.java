package oc.whfb.units.vf;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class VFBlutritter extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	RuestkammerStarter rkBanner;
	RuestkammerStarter rkMagic;
	
	public VFBlutritter() {
		name = BuildaHQ.translate("Blutritter");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Blutritter"), 4, 20, 55);
		squad.setGrundkosten(0);
		add(squad);

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 10));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 20));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 20));

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "VFBanner", "");
		rkBanner.initKammer(false, true, false);
		rkBanner.setButtonText(BuildaHQ.translate("Magische Standarte"));
		add(rkBanner);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "VFBlutritterKammer", "");
		rkMagic.initKammer(true);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Waffe"));
		add(rkMagic);
		
		complete();
	}

	@Override
	public void refreshen() {
		rkBanner.setAktiv(oeS.isSelected());
		rkMagic.setAktiv(oeC.isSelected());
		
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
		
		try {
			setUnikat(true, Integer.valueOf(budget.getText()).intValue() >= 3000 ? 4 : 2);
		} catch (Exception e){
			setUnikat(true, 2);
		}
	}
}
