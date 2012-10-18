package oc.whfb.units.og;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class OGTrauerfangkavallerie extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade oeM, oeS, oeC, oe1, oe2;
	RuestkammerStarter rkBanner;
	boolean bannerSelected = false;
	
	public OGTrauerfangkavallerie() {
		name = BuildaHQ.translate("Trauerfangkavallerie");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Trauerfangkavallerie"), 2, 100, 60);
		squad.setGrundkosten(0);
		add(squad);
		
		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schwere Rüstung"), 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Eisenfaust"), 5));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), 8));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 10));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 10));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Ogerpistolenpaar"), 6));

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
		oe1.setPreis(squad.getModelle() * 5);
		
		o1.setPreis(0, squad.getModelle() * 5);	
		o1.setPreis(1, squad.getModelle() * 8);
		
		oe2.setAktiv(oeC.isSelected());
		
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
		
		try {
			setUnikat(true, Integer.valueOf(budget.getText()).intValue() >= 3000 ? 6 : 3);
		} catch (Exception e){
			setUnikat(true, 3);
		}
	}
	
	@Override
	public void deleteYourself() {
		super.deleteYourself();
		
		if(bannerSelected) {
			BuildaHQ.addToInformationVector(name, -1);		
		}
	}
}
