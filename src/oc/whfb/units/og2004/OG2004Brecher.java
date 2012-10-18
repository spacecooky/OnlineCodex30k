package oc.whfb.units.og2004;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class OG2004Brecher extends Eintrag {

	OptionsEinzelUpgrade oe;
	RuestkammerStarter rkEquipment;
	RuestkammerStarter rkName;
	RuestkammerStarter rkMagic;
	RuestkammerStarter rkBanner;

	boolean astSelected = false;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	

	public OG2004Brecher() {
		name = BuildaHQ.translate("Brecher");
		grundkosten = 130;

		add(ico = new oc.Picture("oc/images/OGBrecher.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		add(oe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Spähgnoblar"), 5));

		seperator();

		rkEquipment = new RuestkammerStarter(ID, randAbstand, cnt, "OG2004Equipment", "");
		rkEquipment.initKammer(false, true);
		rkEquipment.setButtonText(BuildaHQ.translate("Ausrüstung"));
		add(rkEquipment);

		seperator();

		rkName = new RuestkammerStarter(ID, randAbstand, cnt, "OG2004GreatName", "");
		rkName.initKammer(false, false, true);
		rkName.setButtonText(BuildaHQ.translate("Großer Name"));
		add(rkName);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "OG2004MagicItems", "");
		rkMagic.initKammer(false, false, false, false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "OG2004Banner", BuildaHQ.translate("Armeestandartenträger"));
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
//		rkName.setAktiv(rkBanner.getKosten() <= 25);
		
		oe.setAktiv(rkBanner.isSelected());

//		if(rkBanner.isSelected()) rkEquipment.getKammer().specialAction(false);
//		else rkEquipment.getKammer().specialAction(true);

		// Unique entry: AST
		boolean astGlobal = ( BuildaHQ.getCountFromInformationVector("OG2004ast") > 0 ? true : false );
		if(astGlobal && !astSelected) rkBanner.setAktiv(false);
		else rkBanner.setAktiv(true);

		if(rkBanner.isSelected()) {
			astSelected = true;
			BuildaHQ.setInformationVectorValue("OG2004ast", 1);
		} else {
			if(astSelected) {
				astSelected = false;
				BuildaHQ.setInformationVectorValue("OG2004ast", 0);
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
	}

	@Override
	public void deleteYourself() {
		if(astSelected) {
			BuildaHQ.setInformationVectorValue("OG2004ast", 0);
		}
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}

}
