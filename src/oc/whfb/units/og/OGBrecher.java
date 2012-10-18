package oc.whfb.units.og;

import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class OGBrecher extends Eintrag {

	OptionsEinzelUpgrade oe, oGen;
	RuestkammerStarter rkEquipment, rkName, rkMagic, rkBanner;
	boolean astSelected, genSelected = false;

	public OGBrecher() {
		name = BuildaHQ.translate("Brecher");
		grundkosten = 105;

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		add(oe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Spähgnoblar"), 5));

		seperator();

		rkEquipment = new RuestkammerStarter(ID, randAbstand, cnt, "OGEquipment", "");
		rkEquipment.initKammer(false, true);
		rkEquipment.setButtonText(BuildaHQ.translate("Ausrüstung"));
		add(rkEquipment);

		seperator();

		rkName = new RuestkammerStarter(ID, randAbstand, cnt, "OGGreatName", "");
		rkName.initKammer(false, false, true);
		rkName.setButtonText(BuildaHQ.translate("Großer Name"));
		add(rkName);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "OGMagicItems", "");
		rkMagic.initKammer(false, false, false, false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "OGBanner", BuildaHQ.translate("Armeestandartenträger"));
		rkBanner.initKammer(false, true);
		rkBanner.setGrundkosten(25);
		add(rkBanner);

		complete();
	}

	@Override
	public void refreshen() {
		if(rkMagic.getKosten() + rkName.getKosten() > 50) {
			setFehlermeldung(BuildaHQ.translate("Magie + Name") + " > 50!");
		} else {
			setFehlermeldung("");
		}

		rkMagic.setAktiv(rkBanner.getKosten() <= 25);
		
		oe.setAktiv(rkBanner.isSelected());

		// Unique entry: AST
		boolean astGlobal = ( BuildaHQ.getCountFromInformationVector("OGast") > 0 ? true : false );
		if(astGlobal && !astSelected) rkBanner.setAktiv(false);
		else rkBanner.setAktiv(true);

		if(rkBanner.isSelected()) {
			astSelected = true;
			BuildaHQ.setInformationVectorValue("OGast", 1);
		} else {
			if(astSelected) {
				astSelected = false;
				BuildaHQ.setInformationVectorValue("OGast", 0);
				BuildaHQ.refreshEntries(2);
			}
		}
		
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
		
		if ( !astGlobal ) rkBanner.setAktiv(!oGen.isSelected());
		if ( !genGlobal ) oGen.setAktiv(!rkBanner.isSelected());
		
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}

	@Override
	public void deleteYourself() {
		if(astSelected) {
			BuildaHQ.setInformationVectorValue("OGast", 0);
		}
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}

}
