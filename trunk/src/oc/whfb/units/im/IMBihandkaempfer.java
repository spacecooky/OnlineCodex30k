package oc.whfb.units.im;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class IMBihandkaempfer extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	OptionsUpgradeGruppe o1;
	RuestkammerStarter rkAbteilung1;
	RuestkammerStarter rkAbteilung2;
	
	IMAbteilung abteilung1;
	IMAbteilung abteilung2;
	
	boolean familienBannerSelected = false;
	
	public IMBihandkaempfer() {
		name = BuildaHQ.translate("Bihandkämpfer");
		grundkosten = 0;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Bihandkämpfer"), 5, 100, 10);
		squad.setGrundkosten(0);
		add(squad);

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 6));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 12));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 12));
		
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
		
		complete();
	}

	@Override
	public void refreshen() {
		abteilung1.setAnzahl(squad.getModelle());
		abteilung2.setAnzahl(squad.getModelle());
		
		rkAbteilung1.setAktiv(squad.getModelle() >= 10);
		rkAbteilung2.setAktiv(squad.getModelle() >= 10);
		
		setProzentKosten(abteilung1.getKosten() + abteilung2.getKosten());
		
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
		if (rkAbteilung1 != null) rkAbteilung1.setModelle(0);
		if (rkAbteilung2 != null) rkAbteilung2.setModelle(0);
		
		if(familienBannerSelected) {
			BuildaHQ.setInformationVectorValue("GOTE_BANNER", 0);
		}
		
		super.deleteYourself();
	}
	
	
}
