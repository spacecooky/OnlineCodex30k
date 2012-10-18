package oc.whfb.units.sk;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class SKSturmratten extends Eintrag {

	AnzahlPanel squad;

	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	
	OptionsEinzelUpgrade oe1, oe2;
	RuestkammerStarter rkBanner;
	RuestkammerStarter rkBoss;
	
	boolean lwSelected = false;
	OptionsUpgradeGruppe o1;
	boolean astSelected = false;
	
	public SKSturmratten() {
		name = BuildaHQ.translate("Sturmratten");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Sturmratten"), 10, 100, 7);
		squad.setGrundkosten(0);
		add(squad);

		seperator();
		
		add(oe1= new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schilde"), 1));

		seperator();
		
		add(oe2= new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Leibwache"), 4));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 5));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 10));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Giftwindmörser"), 65));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Warpflammenwerfer"), 70));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ratlingkanone"), 55));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ding-Schredder"), 55));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "SKBanner", "");
		rkBanner.initKammer(true, true, false, false);
		rkBanner.setButtonText(BuildaHQ.translate("Magische Standarte"));
		rkBanner.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBanner);
		
		seperator();
		
		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "SKBeutehaufen", "");
		rkBoss.initKammer(false);
		rkBoss.setButtonText(BuildaHQ.translate("Der Beutehaufen"));
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);
		
		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 1);
		oe2.setPreis(squad.getModelle() * 4);
		
		// Unique entry: AST
		boolean astGlobal = ( BuildaHQ.getCountFromInformationVector("STURMRATTEN STANDARTE") > 0 ? true : false );
		if(astGlobal && !astSelected) rkBanner.setAktiv(false);
		else rkBanner.setAktiv(oeS.isSelected());

		if(rkBanner.isSelected()) {
			astSelected = true;
			BuildaHQ.setInformationVectorValue("STURMRATTEN STANDARTE", 1);
		} else {
			if(astSelected) {
				astSelected = false;
				BuildaHQ.setInformationVectorValue("STURMRATTEN STANDARTE", 0);
				BuildaHQ.refreshEntries(2);
			}
		}
		
		rkBoss.setAktiv(oeC.isSelected());
		
		
		boolean lwGlobal = ( BuildaHQ.getCountFromInformationVector("SKlw") > 0 ? true : false );
		if(BuildaHQ.getCountFromInformationVector("SK_QUEEK") == 1){
			if(lwGlobal && !lwSelected) oe2.setAktiv(false);
			else oe2.setAktiv(true);
	
			if(oe2.isSelected()) {
				lwSelected = true;
				BuildaHQ.setInformationVectorValue("SKlw", 1);
			} else {
				if(lwSelected) {
					lwSelected = false;
					BuildaHQ.setInformationVectorValue("SKlw", 0);
					BuildaHQ.refreshEntries(3);
				}
			}
		}else{
			oe2.setAktiv(false);
		}
		
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}
	
	@Override
	public void deleteYourself() {
		if(lwSelected){		
			BuildaHQ.setInformationVectorValue("SKlw", 0);
		}
		if(astSelected) {
			BuildaHQ.setInformationVectorValue("STURMRATTEN STANDARTE", 0);
		}
	}
}
