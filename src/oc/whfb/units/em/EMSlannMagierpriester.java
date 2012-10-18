package oc.whfb.units.em;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class EMSlannMagierpriester extends Eintrag {

	RuestkammerStarter rkSlannPowers;
	RuestkammerStarter rkMagic;
	RuestkammerStarter rkBanner;
	RuestkammerStarter rkLore;
	
	boolean astSelected = false;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;

	public EMSlannMagierpriester() {
		name = BuildaHQ.translate("Slann Magierpriester");
		grundkosten = 275;

		add(ico = new oc.Picture("oc/images/EMSlannMagierpriester.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		rkSlannPowers = new RuestkammerStarter(ID, randAbstand, cnt, "EMSlannPowers", "");
		rkSlannPowers.initKammer();
		rkSlannPowers.setButtonText(BuildaHQ.translate("Disziplinen der Alten"));
		add(rkSlannPowers);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "EMMagicItems", "");
		rkMagic.initKammer(true, false, false, true, true, false, false, false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "EMBanner", BuildaHQ.translate("Armeestandartenträger"));
		rkBanner.initKammer(false, true, true, false);
		rkBanner.setGrundkosten(25);
		add(rkBanner);
		
		seperator();
		
		rkLore = new RuestkammerStarter(ID, randAbstand, cnt, reflectionKennung + "MagicLores", "");
		rkLore.initKammer(true,false,false);
		rkLore.setButtonText(BuildaHQ.translate("Lehren der Magie"));
		add(rkLore);

		complete();
	}

	@Override
	public void refreshen() {
		rkLore.setAbwaehlbar(false);
		
		// Unique entry: AST
		boolean astGlobal = ( BuildaHQ.getCountFromInformationVector("EMast") > 0 ? true : false );
		if(astGlobal && !astSelected) rkBanner.setAktiv(false);
		else rkBanner.setAktiv(true);

		if(rkBanner.isSelected()) {
			astSelected = true;
			BuildaHQ.setInformationVectorValue("EMast", 1);
		} else {
			if(astSelected) {
				astSelected = false;
				BuildaHQ.setInformationVectorValue("EMast", 0);
				BuildaHQ.refreshEntries(1);
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
		
		rkMagic.getKammer().switchEntry(BuildaHQ.translate("Arabianischer Teppich"), false);
		
//		if ( !astGlobal ) rkBanner.setAktiv(!oGen.isSelected());
//		if ( !genGlobal ) oGen.setAktiv(!rkBanner.isSelected());
	}

	@Override
	public void deleteYourself() {
		if(astSelected) {
			BuildaHQ.setInformationVectorValue("EMast", 0);
		}
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}

}
