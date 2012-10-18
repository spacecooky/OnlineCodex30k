package oc.whfb.units.og;

import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class OGFleischer extends Eintrag {

	OptionsUpgradeGruppe o1;
	RuestkammerStarter rkMagic, rkLore;
	
	public OGFleischer() {
		name = BuildaHQ.translate("Fleischer");
		grundkosten = 100;

		seperator(12);

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zusätzliche Handwaffe"), 2));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Eisenfaust"), 3));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), 9));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Upgrade zur 2. Stufe"), 35));

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "OGMagicItems", "");
		rkMagic.initKammer(false, false, true, false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);
		
		seperator();
		
		rkLore = new RuestkammerStarter(ID, randAbstand, cnt, reflectionKennung + "MagicLores", "");
		rkLore.initKammer(false, true, false);
		rkLore.setButtonText(BuildaHQ.translate("Lehren der Magie"));
		add(rkLore);
		
		BuildaHQ.addToInformationVector(BuildaHQ.translate("Fleischer"), 1);

		complete();
	}

	@Override
	public void refreshen() {
		rkLore.setAbwaehlbar(false);
		
		rkMagic.getKammer().specialAction(o1.isSelected(BuildaHQ.translate("Eisenfaust")));
		
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}
	
	@Override
	public void deleteYourself() {
		super.deleteYourself();
		
		BuildaHQ.addToInformationVector(BuildaHQ.translate("Fleischer"), -1);
	}
}
