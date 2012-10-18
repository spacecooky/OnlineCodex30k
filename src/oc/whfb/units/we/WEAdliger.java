package oc.whfb.units.we;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class WEAdliger extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	RuestkammerStarter rkKindred;
	RuestkammerStarter rkMount;
	RuestkammerStarter rkMagic;
	RuestkammerStarter rkBanner;

	boolean isWardancer = false;
	boolean isAlter = false;
	boolean isScout = false;
	boolean isWildHunter = false;
	boolean isWaywatcher = false;
	
	boolean astSelected = false;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	

	public WEAdliger() {
		name = BuildaHQ.translate("Adliger");
		grundkosten = 75;

		add(ico = new oc.Picture("oc/whfb/images/WEAdliger.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("zus. Handwaffe"), 4));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Speer"), 2));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), 4));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Leichte Rüstung"), 2));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schild"), 2));

		seperator();

		rkKindred = new RuestkammerStarter(ID, randAbstand, cnt, "WEKindred", "");
		rkKindred.initKammer(true, true);
		rkKindred.setButtonText(BuildaHQ.translate("Sippe"));
		add(rkKindred);

		seperator();

		rkMount = new RuestkammerStarter(ID, randAbstand, cnt, "WEMount", "");
		rkMount.initKammer(false, true, false, false);
		rkMount.setButtonText(BuildaHQ.translate("Reittier"));
		add(rkMount);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "WEMagicItems", "");
		rkMagic.initKammer(true, false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "WEBanner", BuildaHQ.translate("Armeestandartenträger"));
		rkBanner.initKammer(true, false);
		rkBanner.setGrundkosten(15);
		add(rkBanner);
		
		complete();
	}

	@Override
	public void refreshen() {
		rkMagic.setAktiv(rkBanner.getKosten() <= 20);
		
		rkMagic.getKammer().switchEntry(BuildaHQ.translate("Bernsteinamulett"), rkMount.getKosten() == 0);
		rkMagic.getKammer().switchEntry(BuildaHQ.translate("Dornenrüstung"), rkMount.getKosten() == 0);

		String KindredValue = (String) ((WEKindred) rkKindred.getKammer()).getSpecialValue();
		rkMagic.getKammer().switchEntry(BuildaHQ.translate("Kampftänzer-Sippe"), KindredValue.equals(BuildaHQ.translate("Kampftänzer-Sippe")));
		rkMagic.getKammer().switchEntry(BuildaHQ.translate("Wilde Jäger-Sippe"), KindredValue.equals(BuildaHQ.translate("Wilde Jäger-Sippe")));
		rkMagic.getKammer().switchEntry(BuildaHQ.translate("Waldläufer-Sippe"), KindredValue.equals(BuildaHQ.translate("Waldläufer-Sippe")));
		rkMount.getKammer().switchEntry(BuildaHQ.translate("Wilde Jäger-Sippe"), KindredValue.equals(BuildaHQ.translate("Wilde Jäger-Sippe")));
		
		isWardancer = KindredValue.equals(BuildaHQ.translate("Kampftänzer-Sippe"));
		isAlter = KindredValue.equals(BuildaHQ.translate("Wandler-Sippe"));
		isScout = KindredValue.equals(BuildaHQ.translate("Kundschafter-Sippe"));
		isWildHunter = KindredValue.equals(BuildaHQ.translate("Wilde Jäger-Sippe"));
		isWaywatcher = KindredValue.equals(BuildaHQ.translate("Waldläufer-Sippe"));

		o1.setPreis(BuildaHQ.translate("Speer"), 2);
		oe1.setPreis(2);
		
		o1.setAktiv(BuildaHQ.translate("Speer"), true);
		o1.setAktiv(BuildaHQ.translate("Zweihandwaffe"), true);
		o1.setAktiv(BuildaHQ.translate("zus. Handwaffe"), true);
		o1.setAktiv(true);
		oe1.setAktiv(true);
		oe2.setAktiv(true);
		rkMount.setAktiv(true);
				
		rkKindred.setAktiv(!rkBanner.isSelected());	
		rkBanner.setAktiv(rkKindred.getKosten() > 0);
		oe2.setAktiv(!rkBanner.isSelected());
		o1.setAktiv(!rkBanner.isSelected());
		if(rkBanner.isSelected()){
			isWardancer = false;
			isAlter = false;
			isScout = false;
			isWildHunter = false;
			isWaywatcher = false;

		}		
		
		if( isWildHunter ) {
			o1.setPreis(BuildaHQ.translate("Speer"), 0);
			o1.setAktiv(BuildaHQ.translate("zus. Handwaffe"), false);
			o1.setAktiv(BuildaHQ.translate("Zweihandwaffe"), false);
			oe1.setPreis(0);
			oe2.setAktiv(false);
			o1.setSelected(1, true);
			oe1.setSelected(true);
		}
		else if( isScout ){			
			o1.setAktiv(BuildaHQ.translate("Zweihandwaffe"), false);
			rkMount.setAktiv(false);
		} 
		else if( isAlter ){			
			rkMount.setAktiv(false);
			oGen.setAktiv(false);
		} 
		else if( isWardancer ){			
			oe1.setAktiv(false);
			oe2.setAktiv(false);
			rkMount.setAktiv(false);
		} 
		else if( isWaywatcher ){
			o1.setAktiv(BuildaHQ.translate("Zweihandwaffe"), false);
			oe1.setAktiv(false);
			oe2.setAktiv(false);
			rkMount.setAktiv(false);
		} 

		oe2.setAktiv(!rkBanner.isSelected() && !isWaywatcher && !isWardancer);

		rkMagic.setAktiv(rkBanner.getKosten() < 25);

		// Unique entry: AST
		boolean astGlobal = (BuildaHQ.getCountFromInformationVector("WEast") > 0 ? true : false );
		if(astGlobal && !astSelected) rkBanner.setAktiv(false);
		else rkBanner.setAktiv(true);

		if(rkBanner.isSelected()) {
			astSelected = true;
			BuildaHQ.setInformationVectorValue("WEast", 1);
			
			rkMagic.getKammer().switchEntry("WEast", true);
		} else {
			if(astSelected) {
				astSelected = false;
				BuildaHQ.setInformationVectorValue("WEast", 0);
				BuildaHQ.refreshEntries(2);
			}
			
			rkMagic.getKammer().switchEntry("WEast", false);
		}
		
		if ( !isAlter ){
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
	}

	@Override
	public void deleteYourself() {
		if(astSelected) {
			BuildaHQ.setInformationVectorValue("WEast", 0);		
		}
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}
}
