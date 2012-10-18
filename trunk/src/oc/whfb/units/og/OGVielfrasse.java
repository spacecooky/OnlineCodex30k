package oc.whfb.units.og;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class OGVielfrasse extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1, o2;
	OptionsEinzelUpgrade oeu1, oeu2, oeu3, oeu4, oeu5, oeu6, oeu7, oeu8;
	OptionsEinzelUpgrade oeM, oeS, oeC, oe1, oe2;
	RuestkammerStarter rkBanner;
	boolean bannerSelected = false;
	
	public static final String IMMUNGEGENPSYCHOLOGIE = "Immun gegen Psychologie";
	public static final String GIFTATTACKEN = "Giftattacken";
	public static final String KUNDSCHAFTER = "Kundschafter";
	public static final String ZIELSICHER = "Zielsicher";
	public static final String GELAENDEERFAHREN = "Gel‰ndeerfahren";
	public static final String UNNACHGIEBIG = "Unnachgiebig";
	public static final String SCHNELLEBEWEGUNG = "Schnelle Bewegung";
	public static final String VORHUT = "Vorhut";
	
	boolean immunSelected = false;
	boolean giftattackenSelected = false;
	boolean kundschafterSelected = false;
	boolean zielsicherSelected = false;
	boolean gelaendeerfahrenSelected = false;
	boolean unnachgiebigSelected = false;
	boolean schnellebewegungSelected = false;
	boolean vorhutSelected = false;
	
	public OGVielfrasse() {
		name = BuildaHQ.translate("Vielfraﬂe");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Vielfraﬂ"), BuildaHQ.translate("Vielfraﬂe"), 3, 100, 50);
		squad.setGrundkosten(0);
		add(squad);

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schwere R¸stung"), 4));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zus‰tzliche Handwaffe"), 2));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), 11));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ogerpistole"), 7));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ogerpistolenpaar"), 12));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		add(oeu1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Immun gegen Psychologie"), 0, false));
		add(oeu2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Giftattacken"), 0, false));
		add(oeu3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Kundschafter"), 0, false));
		add(oeu4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Zielsicher"), 0, false));
		add(oeu5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Gel‰ndeerfahren"), 0, false));
		add(oeu6 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Unnachgiebig"), 0, false));
		add(oeu7 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schnelle Bewegung"), 0, false));
		add(oeu8 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Vorhut"), 0, false));
		
		seperator();
		
		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 10));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartentr‰ger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 10));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Sp‰hgnoblar"), 5));

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
		oe1.setPreis(squad.getModelle() * 4);
		
		o1.setMaxAnzahl(squad.getModelle());
		//o1.setLegal(o1.getAnzahl() == squad.getModelle());
		
		oe2.setAktiv(oeS.isSelected());
		
		rkBanner.setAktiv(oeS.isSelected());
		
		int anzahlOptions = 0;
		
		if (oeu1.isSelected())anzahlOptions++;
		if (oeu2.isSelected())anzahlOptions++;
		if (oeu3.isSelected())anzahlOptions++;
		if (oeu4.isSelected())anzahlOptions++;
		if (oeu5.isSelected())anzahlOptions++;
		if (oeu6.isSelected())anzahlOptions++;
		if (oeu7.isSelected())anzahlOptions++;
		if (oeu8.isSelected())anzahlOptions++;
		
		if ( anzahlOptions < 2 ) {
			setFehlermeldung("2 Options");
		} else if ( anzahlOptions > 2 ){
			setFehlermeldung("Max. 2 Options");
		} else {
			setFehlermeldung("");
		}
		
		oeu1.setLegal(anzahlOptions == 2);
		oeu2.setLegal(anzahlOptions == 2);
		oeu3.setLegal(anzahlOptions == 2);
		oeu4.setLegal(anzahlOptions == 2);
		oeu5.setLegal(anzahlOptions == 2);
		oeu6.setLegal(anzahlOptions == 2);
		oeu7.setLegal(anzahlOptions == 2);
		oeu8.setLegal(anzahlOptions == 2);
		
		boolean bannerGlobal = ( BuildaHQ.getCountFromInformationVector(name) > 0 ? true : false );
		if(bannerGlobal && !bannerSelected){
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
		
		boolean global = ( BuildaHQ.getCountFromInformationVector(IMMUNGEGENPSYCHOLOGIE) > 0 ? true : false );
		if(global && !immunSelected) oeu1.setAktiv(false);
		else oeu1.setAktiv(true);

		if(oeu1.isSelected()) {
			immunSelected = true;
			BuildaHQ.setInformationVectorValue(IMMUNGEGENPSYCHOLOGIE, 1);
		} else {
			if(immunSelected) {
				immunSelected = false;
				BuildaHQ.setInformationVectorValue(IMMUNGEGENPSYCHOLOGIE, 0);
				BuildaHQ.refreshEntries(2);
			}
		}
		
		global = ( BuildaHQ.getCountFromInformationVector(GIFTATTACKEN) > 0 ? true : false );
		if(global && !giftattackenSelected) oeu2.setAktiv(false);
		else oeu2.setAktiv(true);

		if(oeu2.isSelected()) {
			giftattackenSelected = true;
			BuildaHQ.setInformationVectorValue(GIFTATTACKEN, 1);
		} else {
			if(giftattackenSelected) {
				giftattackenSelected = false;
				BuildaHQ.setInformationVectorValue(GIFTATTACKEN, 0);
				BuildaHQ.refreshEntries(2);
			}
		}
		
		global = ( BuildaHQ.getCountFromInformationVector(KUNDSCHAFTER) > 0 ? true : false );
		if(global && !kundschafterSelected) oeu3.setAktiv(false);
		else oeu3.setAktiv(true);

		if(oeu3.isSelected()) {
			kundschafterSelected = true;
			BuildaHQ.setInformationVectorValue(KUNDSCHAFTER, 1);
		} else {
			if(kundschafterSelected) {
				kundschafterSelected = false;
				BuildaHQ.setInformationVectorValue(KUNDSCHAFTER, 0);
				BuildaHQ.refreshEntries(2);
			}
		}
		
		global = ( BuildaHQ.getCountFromInformationVector(ZIELSICHER) > 0 ? true : false );
		if(global && !zielsicherSelected) oeu4.setAktiv(false);
		else oeu4.setAktiv(true);

		if(oeu4.isSelected()) {
			zielsicherSelected = true;
			BuildaHQ.setInformationVectorValue(ZIELSICHER, 1);
		} else {
			if(zielsicherSelected) {
				zielsicherSelected = false;
				BuildaHQ.setInformationVectorValue(ZIELSICHER, 0);
				BuildaHQ.refreshEntries(2);
			}
		}
		
		global = ( BuildaHQ.getCountFromInformationVector(GELAENDEERFAHREN) > 0 ? true : false );
		if(global && !gelaendeerfahrenSelected) oeu5.setAktiv(false);
		else oeu5.setAktiv(true);

		if(oeu5.isSelected()) {
			gelaendeerfahrenSelected = true;
			BuildaHQ.setInformationVectorValue(GELAENDEERFAHREN, 1);
		} else {
			if(gelaendeerfahrenSelected) {
				gelaendeerfahrenSelected = false;
				BuildaHQ.setInformationVectorValue(GELAENDEERFAHREN, 0);
				BuildaHQ.refreshEntries(2);
			}
		}
		
		global = ( BuildaHQ.getCountFromInformationVector(UNNACHGIEBIG) > 0 ? true : false );
		if(global && !unnachgiebigSelected) oeu6.setAktiv(false);
		else oeu6.setAktiv(true);

		if(oeu6.isSelected()) {
			unnachgiebigSelected = true;
			BuildaHQ.setInformationVectorValue(UNNACHGIEBIG, 1);
		} else {
			if(unnachgiebigSelected) {
				unnachgiebigSelected = false;
				BuildaHQ.setInformationVectorValue(UNNACHGIEBIG, 0);
				BuildaHQ.refreshEntries(2);
			}
		}
		
		global = ( BuildaHQ.getCountFromInformationVector(SCHNELLEBEWEGUNG) > 0 ? true : false );
		if(global && !schnellebewegungSelected) oeu7.setAktiv(false);
		else oeu7.setAktiv(true);

		if(oeu7.isSelected()) {
			schnellebewegungSelected = true;
			BuildaHQ.setInformationVectorValue(SCHNELLEBEWEGUNG, 1);
		} else {
			if(schnellebewegungSelected) {
				schnellebewegungSelected = false;
				BuildaHQ.setInformationVectorValue(SCHNELLEBEWEGUNG, 0);
				BuildaHQ.refreshEntries(2);
			}
		}
		
		global = ( BuildaHQ.getCountFromInformationVector(VORHUT) > 0 ? true : false );
		if(global && !vorhutSelected) oeu8.setAktiv(false);
		else oeu8.setAktiv(true);

		if(oeu8.isSelected()) {
			vorhutSelected = true;
			BuildaHQ.setInformationVectorValue(VORHUT, 1);
		} else {
			if(vorhutSelected) {
				vorhutSelected = false;
				BuildaHQ.setInformationVectorValue(VORHUT, 0);
				BuildaHQ.refreshEntries(2);
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
		
		if(bannerSelected)  BuildaHQ.addToInformationVector(name, -1);		
		if(immunSelected) BuildaHQ.setInformationVectorValue(IMMUNGEGENPSYCHOLOGIE, 0);	
		if(giftattackenSelected)BuildaHQ.setInformationVectorValue(GIFTATTACKEN, 0);	
		if(kundschafterSelected)BuildaHQ.setInformationVectorValue(KUNDSCHAFTER, 0);	
		if(zielsicherSelected)BuildaHQ.setInformationVectorValue(ZIELSICHER, 0);	
		if(gelaendeerfahrenSelected)BuildaHQ.setInformationVectorValue(GELAENDEERFAHREN, 0);	
		if(unnachgiebigSelected)BuildaHQ.setInformationVectorValue(UNNACHGIEBIG, 0);	
		if(schnellebewegungSelected)BuildaHQ.setInformationVectorValue(SCHNELLEBEWEGUNG, 0);	
		if(vorhutSelected)BuildaHQ.setInformationVectorValue(VORHUT, 0);	
	}
}
