package oc.whfb.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class OROrkGargboss extends Eintrag {

	OptionsEinzelUpgrade oe0;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsUpgradeGruppe o1;

	RuestkammerStarter rkMount;
	RuestkammerStarter rkMagic;
	RuestkammerStarter rkBanner;

	boolean astSelected = false;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;

	public OROrkGargboss() {
		name = BuildaHQ.translate("Ork-Gargboss");
		grundkosten = 55;

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Upgrade zum Wildork"), 20));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Upgrade zum Schwarzork"), 35));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), 4));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zusätzliche Handwaffe"), 2));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Speer"), 2));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Schild"), 2));

		seperator();

		rkMount = new RuestkammerStarter(ID, randAbstand, cnt, "ORMount", "");
		rkMount.initKammer(false, false, true, false, false);
		rkMount.setButtonText(BuildaHQ.translate("Reittier"));
		add(rkMount);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "ORMagicItems", "");
		rkMagic.initKammer(true, false, false, true, false, false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "ORBanner", BuildaHQ.translate("Armeestandartenträger"));
		rkBanner.initKammer(true, false, false, true);
		rkBanner.setGrundkosten(25);
		add(rkBanner);

		complete();
	}

	@Override
	public void refreshen() {
		rkMagic.setAktiv(rkBanner.getKosten() <= 25);

		oe1.setAktiv(!oe2.isSelected());
		oe2.setAktiv(!oe1.isSelected());
		
		if (oe2.isSelected()){
			o1.setAktiv(false);
		} else {
			o1.setAktiv(true);
			if (!oe1.isSelected())
				o1.setAktiv(BuildaHQ.translate("Zusätzliche Handwaffe"), rkMount.getKammer().getKosten() == 0);
			o1.setAktiv(BuildaHQ.translate("Speer"), rkMount.getKammer().getKosten() > 0);
		}
		
		rkMount.getKammer().specialAction(false, oe1.isSelected());
		
		// Unique entry: AST
		boolean astGlobal = ( BuildaHQ.getCountFromInformationVector("ORast") > 0 ? true : false );
		if(astGlobal && !astSelected) rkBanner.setAktiv(false);
		else rkBanner.setAktiv(true);

		if(rkBanner.isSelected()) {
			astSelected = true;
			BuildaHQ.setInformationVectorValue("ORast", 1);
		} else {
			if(astSelected) {
				astSelected = false;
				BuildaHQ.setInformationVectorValue("ORast", 0);
				BuildaHQ.refreshEntries(2);
			}
		}
		
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
		

		/*if (ico != null ) panel.remove(ico);
		//if ( BuildaMenu.bilderAneigen.isSelected() ) {
			if( oe1.isSelected()){
				ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + "2" + JPG);
			} else if( oe2.isSelected()){
				ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + "1" + JPG);
			}else {
				ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			}
			
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico);		
			
			panel.repaint(); }*/
	}

	@Override
	public void deleteYourself() {
		if(astSelected) {
			BuildaHQ.setInformationVectorValue("ORast", 0);
		}
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}

}
