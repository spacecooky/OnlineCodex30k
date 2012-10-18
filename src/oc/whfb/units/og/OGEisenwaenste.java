package oc.whfb.units.og;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class OGEisenwaenste extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade oe1, oeM, oeS, oeC;
	RuestkammerStarter rkBanner;
	boolean bannerSelected = false;

	public OGEisenwaenste() {
		name = BuildaHQ.translate("Eisenwänste");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Eisenwänste"), 3, 100	, 43);
		squad.setGrundkosten(0);
		add(squad);

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 10));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 10));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Spähgnoblar"), 5));

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "OGBanner", "");
		rkBanner.initKammer(true, false);
		rkBanner.setButtonText(BuildaHQ.translate("Magische Standarte"));
		rkBanner.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBanner);
		
		complete();
	}

	@Override
	public void refreshen() {
		oe1.setAktiv(oeS.isSelected());
		rkBanner.setAktiv(oeS.isSelected());
		
		boolean genGlobal = ( BuildaHQ.getCountFromInformationVector(name) > 0 ? true : false );
		if(genGlobal && !bannerSelected){
			rkBanner.setAktiv(false);
		} else {
			rkBanner.setAktiv(oeS.isSelected());
		}

		if( rkBanner.getKosten() > 0 ) {
			if(!bannerSelected)BuildaHQ.addToInformationVector(name, 1);
			bannerSelected = true;
		} else {
			if(bannerSelected) {
				bannerSelected = false;
				BuildaHQ.addToInformationVector(name, -1);	
			}
		}
		
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		
		if(bannerSelected) {
			BuildaHQ.addToInformationVector(name, -1);		
		}
	}
}
