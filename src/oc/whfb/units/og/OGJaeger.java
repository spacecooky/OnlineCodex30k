package oc.whfb.units.og;

import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class OGJaeger extends Eintrag {

	OptionsUpgradeGruppe o1;
	RuestkammerStarter rkEquipment, rkName, rkMagic;
	OptionsEinzelUpgrade oeS;
	
	public OGJaeger() {
		name = BuildaHQ.translate("Jäger");
		grundkosten = 130;

		seperator(12);

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zus. Handwaffe"), 3));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Eisenfaust"), 4));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), 11));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Harpunenschleuder"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blutgeier"), 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Steinyak"), 250));

		seperator();

		rkName = new RuestkammerStarter(ID, randAbstand, cnt, "OGGreatName", "");
		rkName.initKammer(false, true, false);
		rkName.setButtonText(BuildaHQ.translate("Großer Name"));
		add(rkName);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "OGMagicItems", "");
		rkMagic.initKammer(false, false, false, true);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);

		complete();
	}

	@Override
	public void refreshen() {
		if(rkMagic.getKosten() + rkName.getKosten() > 50) {
			setFehlermeldung(BuildaHQ.translate("Magie + Name") + " > 50!");
		} else {
			setFehlermeldung("");
		}
		
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			if ( oeS.isSelected() ){
				ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/OGSteinyak" + JPG);
			} else {
				ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			}
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}
}
