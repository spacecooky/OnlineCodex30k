package oc.whfb.units.we;

import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class WEHochgeborener extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	RuestkammerStarter rkKindred;
	RuestkammerStarter rkMount;
	RuestkammerStarter rkMagic;
	OptionsEinzelUpgrade oGen;

	boolean genSelected = false;
	boolean isWardancer = false;
	boolean isAlter = false;
	boolean isScout = false;
	boolean isWaywatcher = false;
	boolean isWildHunter = false;
	
	public WEHochgeborener() {
		name = BuildaHQ.translate("Hochgeborener");
		grundkosten = 145;

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("zus. Handwaffe"), 6));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Speer"), 3));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), 6));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Leichte Rüstung"), 3));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schild"), 3));

		seperator();

		rkKindred = new RuestkammerStarter(ID, randAbstand, cnt, "WEKindred", "");
		rkKindred.initKammer(true, false);
		rkKindred.setButtonText(BuildaHQ.translate("Sippe"));
		add(rkKindred);

		seperator();

		rkMount = new RuestkammerStarter(ID, randAbstand, cnt, "WEMount", "");
		rkMount.initKammer(true, false, false, false);
		rkMount.setButtonText(BuildaHQ.translate("Reittier"));
		add(rkMount);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "WEMagicItems", "");
		rkMagic.initKammer(false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);
		
		complete();
	}

	@Override
	public void refreshen() {
		rkMagic.getKammer().switchEntry(BuildaHQ.translate("Bernsteinamulett"), rkMount.getKosten() == 0);
		rkMagic.getKammer().switchEntry(BuildaHQ.translate("Dornenrüstung"), rkMount.getKosten() == 0);

		String KindredValue = (String) ((WEKindred) rkKindred.getKammer()).getSpecialValue();
		rkMagic.getKammer().switchEntry(BuildaHQ.translate("Kampftänzer-Sippe"), KindredValue.equals(BuildaHQ.translate("Kampftänzer-Sippe")));
		rkMagic.getKammer().switchEntry(BuildaHQ.translate("Wilde Jäger-Sippe"), KindredValue.equals(BuildaHQ.translate("Wilde Jäger-Sippe")));
		rkMagic.getKammer().switchEntry(BuildaHQ.translate("Waldläufer-Sippe"), KindredValue.equals(BuildaHQ.translate("Waldläufer-Sippe")));
		rkMount.getKammer().switchEntry(BuildaHQ.translate("Wilde Jäger-Sippe"), KindredValue.equals(BuildaHQ.translate("Wilde Jäger-Sippe")));

		isWardancer = KindredValue.equals(BuildaHQ.translate("Kampftänzer-Sippe")) && rkKindred.isSelected();
		isAlter = KindredValue.equals(BuildaHQ.translate("Wandler-Sippe")) && rkKindred.isSelected();
		isScout = KindredValue.equals(BuildaHQ.translate("Kundschafter-Sippe")) && rkKindred.isSelected();
		isWildHunter = KindredValue.equals(BuildaHQ.translate("Wilde Jäger-Sippe")) && rkKindred.isSelected();
		isWaywatcher = KindredValue.equals(BuildaHQ.translate("Waldläufer-Sippe")) && rkKindred.isSelected();

		o1.setPreis(BuildaHQ.translate("Speer"), 3);
		oe1.setPreis(3);
		
		o1.setAktiv(BuildaHQ.translate("Speer"), true);
		o1.setAktiv(BuildaHQ.translate("Zweihandwaffe"), true);
		o1.setAktiv(BuildaHQ.translate("zus. Handwaffe"), true);
		o1.setAktiv(true);
		oe1.setAktiv(true);
		oe2.setAktiv(true);
		rkMount.setAktiv(true);
		
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
                        if(oGen.isSelected()) {
                            oGen.setSelected(false);
                            BuildaHQ.setInformationVectorValue("Gen", 0);
                            BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Ewige Wache"));
                            BuildaHQ.getChooserGruppe(4).addSpezialAuswahl(BuildaHQ.translate("Ewige Wache"));
                        }
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
		
		if ( !isAlter ){
                        oGen.setAktiv(true);
                    
			// Unique entry: GENERAL
			boolean genGlobal = ( BuildaHQ.getCountFromInformationVector("Gen") > 0 ? true : false );
			if(genGlobal && !genSelected) oGen.setAktiv(false);
			else oGen.setAktiv(true);

			if(oGen.isSelected()) {
				genSelected = true;
				BuildaHQ.setInformationVectorValue("Gen", 1);
				BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Ewige Wache"));
				BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl(BuildaHQ.translate("Ewige Wache"));
			} else {
				if(genSelected) {
					genSelected = false;
					BuildaHQ.setInformationVectorValue("Gen", 0);
					BuildaHQ.refreshEntries(2);
					BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Ewige Wache"));
					BuildaHQ.getChooserGruppe(4).addSpezialAuswahl(BuildaHQ.translate("Ewige Wache"));
				}
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
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
			
			if(!isAlter){
				BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Ewige Wache"));
				BuildaHQ.getChooserGruppe(4).addSpezialAuswahl(BuildaHQ.translate("Ewige Wache"));
			}
		}
	}
}
