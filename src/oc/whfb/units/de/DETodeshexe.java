package oc.whfb.units.de;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DETodeshexe extends Eintrag {

	OptionsEinzelUpgrade oe;
	RuestkammerStarter rkGifts;
	RuestkammerStarter rkBanner;
	boolean astSelected = false;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;

	public DETodeshexe() {
		name = BuildaHQ.translate("Todeshexe");
		grundkosten = 90;

		add(ico = new oc.Picture("oc/images/DETodeshexe.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		add(oe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Blutkessel"), 110));

		seperator();

		rkGifts = new RuestkammerStarter(ID, randAbstand, cnt, "DEGiftsOfKhaine", "");
		rkGifts.initKammer(false, true, false);
		rkGifts.setButtonText(BuildaHQ.translate("Geschenke des Khaine"));
		add(rkGifts);

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "DEBanner", BuildaHQ.translate("Armeestandartenträger"));
		rkBanner.initKammer(false, true, true, false);
		rkBanner.setGrundkosten(25);
		add(rkBanner);

		complete();
	}

	@Override
	public void refreshen() {
		if(rkBanner.getKosten() > 25) rkGifts.getKammer().specialAction(true);
		else rkGifts.getKammer().specialAction(false);

		// Unique entry: AST
		boolean astGlobal = ( BuildaHQ.getCountFromInformationVector("DEast") > 0 ? true : false );
		if(astGlobal && !astSelected) rkBanner.setAktiv(false);
		else rkBanner.setAktiv(true);

		if(rkBanner.isSelected()) {
			astSelected = true;
			BuildaHQ.setInformationVectorValue("DEast", 1);
		} else {
			if(astSelected) {
				astSelected = false;
				BuildaHQ.setInformationVectorValue("DEast", 0);
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
			BuildaHQ.setInformationVectorValue("DEast", 0);
		}
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}

}
