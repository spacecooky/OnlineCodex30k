package oc.whfb.units.bt;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class BTDieFeenzauberin extends Eintrag {

	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	RuestkammerStarter rkBanner;
	AnzahlPanel squad;
	RuestkammerStarter rkLore;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;

	public BTDieFeenzauberin() {
		name = BuildaHQ.translate("Die Feenzauberin\n");
		grundkosten = 545;

		add(ico = new oc.Picture("oc/whfb/images/DELokhirTeufelsherz.jpg"));
		
		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();
		
		rkLore = new RuestkammerStarter(ID, randAbstand, cnt, reflectionKennung + "MagicLores", "");
		rkLore.initKammer(false,true);
		rkLore.setButtonText(BuildaHQ.translate("Lehren der Magie"));
		add(rkLore);
		
		seperator(25);
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Gralshüter"), 0, 8, 38);
		squad.setGrundkosten(0);
		add(squad);

		seperator();
		
		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 10));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 20));
		
		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "BTBanner", "");
		rkBanner.initKammer(true, true, false, false);
		rkBanner.setButtonText(BuildaHQ.translate("Magische Standarte"));
		rkBanner.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBanner);
		
		complete();
	}

	@Override
	public void refreshen() {
		
		oeM.setAktiv(squad.getModelle()>0);
		oeS.setAktiv(squad.getModelle()>0);
		rkBanner.setAktiv(oeS.isSelected());
		
		if(squad.getModelle()==1){
			setFehlermeldung("Min. 2 " + BuildaHQ.translate("Gralshüter"));
		} else {
			setFehlermeldung("");
		}
		
		if(BuildaHQ.getCountFromInformationVector("BT_LOUEN") == 0){
			BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Bogenschützen"));
			BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Landsknechte"));
			BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl(BuildaHQ.translate("Bogenschützen"));
			BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl(BuildaHQ.translate("Landsknechte"));
			
			BuildaHQ.refreshEntries(3);
			BuildaHQ.refreshEntries(4);
		}
		
		rkLore.setAbwaehlbar(false);
		
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
		
		BuildaHQ.setInformationVectorValue("Grail", (int)squad.getKosten());
	}
	
	@Override
	public void deleteYourself() {		
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		
		BuildaHQ.setInformationVectorValue("Grail", 0);
		super.deleteYourself();
	}

}
