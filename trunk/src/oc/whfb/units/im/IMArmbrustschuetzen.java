package oc.whfb.units.im;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class IMArmbrustschuetzen extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	RuestkammerStarter rkBanner;
	RuestkammerStarter rkAbteilung1; 
	RuestkammerStarter rkAbteilung2;
	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade oe8;

	IMAbteilung abteilung1;
	IMAbteilung abteilung2;
	
	boolean familienBannerSelected = false;
	
	public IMArmbrustschuetzen() {
		name = BuildaHQ.translate("Armbrustsch�tzen");
		grundkosten = 0;
                
                add(ico = new oc.Picture(this));
                
                seperator();

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Armbrustsch�tzen"), 10, 100, 8);
		squad.setGrundkosten(0);
		add(squad);

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 5));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartentr�ger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 5));
		
		seperator();
		
		abteilung1 = new IMAbteilung();
		rkAbteilung1 = new RuestkammerStarter(ID, randAbstand, cnt, abteilung1);
		rkAbteilung1.initKammer(true, false, false, false, false);
		rkAbteilung1.setButtonText("1. " + BuildaHQ.translate("Abteilung"));
		add(rkAbteilung1);
		
		seperator();
		
		abteilung2 = new IMAbteilung();
		rkAbteilung2 = new RuestkammerStarter(ID, randAbstand, cnt, abteilung2);
		rkAbteilung2.initKammer(true, false, false, false, false);
		rkAbteilung2.setButtonText("2. " + BuildaHQ.translate("Abteilung"));
		add(rkAbteilung2);
		
		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "IMBanner", "");
		rkBanner.initKammer(false, false, false);
		rkBanner.setButtonText(BuildaHQ.translate("Magische Standarte"));
		rkBanner.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBanner);
		
		complete();
	}

	@Override
	public void refreshen() {
		
		// Unique entry: Familienbanner
		boolean familienBanner = ( BuildaHQ.getCountFromInformationVector("GOTE_BANNER") > 0 ? true : false );
		if(familienBanner && !familienBannerSelected) rkBanner.setAktiv(false);
		else rkBanner.setAktiv(true);

		if(rkBanner.isSelected()) {
			familienBannerSelected = true;
			BuildaHQ.setInformationVectorValue("GOTE_BANNER", 1);
		} else {
			if(familienBannerSelected) {
				familienBannerSelected = false;
				BuildaHQ.setInformationVectorValue("GOTE_BANNER", 0);
			}
		}
		
		boolean gote = ( BuildaHQ.getCountFromInformationVector("IM_GOTE") > 0 ? true : false );
		if(!familienBannerSelected)rkBanner.setAktiv(oeS.isSelected() && gote && !familienBanner);
		
		abteilung1.setAnzahl(squad.getModelle());
		abteilung2.setAnzahl(squad.getModelle());
		
		setProzentKosten(abteilung1.getKosten() + abteilung2.getKosten());
		
//		/*if (ico != null ) panel.remove(ico);
//		if ( BuildaMenu.bilderAneigen.isSelected() ) {
//			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
//			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
//			panel.add(ico);
//		}
	}
	
	@Override
	public void deleteYourself() {
		if (rkAbteilung1 != null) rkAbteilung1.setModelle(0);
		if (rkAbteilung2 != null) rkAbteilung2.setModelle(0);
		
		if(familienBannerSelected) {
			BuildaHQ.setInformationVectorValue("GOTE_BANNER", 0);
		}
		
		super.deleteYourself();
	}
}
