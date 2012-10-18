package oc.whfb.units.bt;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.whfb.armies.VOLKBretonia;

public class BTPaladin extends Eintrag {

	OptionsEinzelUpgrade oe;
	RuestkammerStarter rkEquipment;
	RuestkammerStarter rkMount;
	RuestkammerStarter rkBanner;
	RuestkammerStarter rkTugend;
	RuestkammerStarter rkMagic;
	OptionsUpgradeGruppe o1;
	boolean set = false;
	boolean astSelected = false;
	boolean pegasi = false;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;

	public BTPaladin() {
		name = BuildaHQ.translate("Paladin");
		grundkosten = 60;

		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();
				
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ritter Gel�bde"), 0));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Quest Gel�bde"), 8));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Grals Gel�bde"), 21));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);
		
		seperator();

		rkEquipment = new RuestkammerStarter(ID, randAbstand, cnt, "BTEquipment", "");
		rkEquipment.initKammer(false, true);
		rkEquipment.setButtonText(BuildaHQ.translate("Ausr�stung"));
		add(rkEquipment);

		seperator();

		rkMount = new RuestkammerStarter(ID, randAbstand, cnt, "BTMount", "");
		rkMount.initKammer(false, false, true, false);
		rkMount.setButtonText(BuildaHQ.translate("Reittier"));
		add(rkMount);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "BTMagicItems", "");
		rkMagic.initKammer(false, true, true, false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenst�nde"));
		add(rkMagic);

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "BTBanner", BuildaHQ.translate("Armeestandartentr�ger"));
		rkBanner.initKammer(true, true, true, false);
		rkBanner.setGrundkosten(0);
		rkBanner.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBanner);
		
		
		seperator();

		rkTugend = new RuestkammerStarter(ID, randAbstand, cnt, "BTTugend", "");
		rkTugend.initKammer(true);
		rkTugend.setButtonText(BuildaHQ.translate("Tugenden"));
		add(rkTugend);

		complete();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
		rkMagic.setAktiv(rkBanner.getKosten() < 10);
		rkTugend.setAktiv(!(rkBanner.getKosten() < 10));
		rkEquipment.setAktiv(!rkBanner.isSelected());

		// Unique entry: AST
		boolean astGlobal = ( BuildaHQ.getCountFromInformationVector("BTast") > 0 ? true : false );
		if(astGlobal && !astSelected) rkBanner.setAktiv(false);
		else rkBanner.setAktiv(true);

		if(rkBanner.isSelected()) {
			astSelected = true;
			BuildaHQ.setInformationVectorValue("BTast", 1);
		} else {
			if(astSelected) {
				astSelected = false;
				BuildaHQ.setInformationVectorValue("BTast", 0);
				BuildaHQ.refreshEntries(2);
			}
		}
		
		if(BuildaHQ.getCountFromInformationVector("BT_LOUEN") == 0){
			BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Bogensch�tzen"));
			BuildaHQ.getChooserGruppe(3).addSpezialAuswahl(BuildaHQ.translate("Landsknechte"));
			BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl(BuildaHQ.translate("Bogensch�tzen"));
			BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl(BuildaHQ.translate("Landsknechte"));
		}
		
		rkMagic.getKammer().specialAction(
				o1.isSelected(BuildaHQ.translate("Ritter Gel�bde")),
				o1.isSelected(BuildaHQ.translate("Quest Gel�bde")),
				o1.isSelected(BuildaHQ.translate("Grals Gel�bde")), 
				rkBanner.isSelected()
		);
		
		if(VOLKBretonia.AST  == 0 ) {
			//rkBanner.setSelected(true);
			//rkBanner.setAktiv(true);
		} else {
			if(!set)VOLKBretonia.AST ++;
			set = true;
		}
		
		rkEquipment.getKammer().specialAction(
				o1.isSelected(BuildaHQ.translate("Ritter Gel�bde")),
				o1.isSelected(BuildaHQ.translate("Quest Gel�bde")),
				o1.isSelected(BuildaHQ.translate("Grals Gel�bde"))
			);
		
		rkMagic.getKammer().specialAction(
				o1.isSelected(BuildaHQ.translate("Ritter Gel�bde")),
				o1.isSelected(BuildaHQ.translate("Quest Gel�bde")),
				o1.isSelected(BuildaHQ.translate("Grals Gel�bde")), 
				false
		);
		
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
			BuildaHQ.setInformationVectorValue("BTast", 0);
		}
		VOLKBretonia.AST -- ;
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}
}
