package oc.whfb.units.zw;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class ZWThain extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	RuestkammerStarter rkRunen;
	RuestkammerStarter rkBanner;
	boolean astSelected = false;
	
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;

	public ZWThain() {
		name = BuildaHQ.translate("Thain");
		grundkosten = 65;

		add(ico = new oc.Picture("oc/whfb/images/ZWThain.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), 4));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Pistole"), 5));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Armbrust"), 5));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zwergenmuskete"), 10));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schild"), 2));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Eidstein"), 20));

		seperator();

		rkRunen = new RuestkammerStarter(ID, randAbstand, cnt, "ZWRunen", "");
		rkRunen.initKammer(true, false, false, false, false, false);
		rkRunen.setButtonText(BuildaHQ.translate("Runen"));
		add(rkRunen);

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "ZWStandarte", BuildaHQ.translate("Armeestandartenträger"));
		rkBanner.initKammer(true);
		rkBanner.setGrundkosten(25);
		add(rkBanner);

		complete();
	}

	@Override
	public void refreshen() {	
		oe1.setAktiv(!rkBanner.isSelected());		
		o1.setAktiv(!rkBanner.isSelected());
		o2.setAktiv(!rkBanner.isSelected());
		
		rkRunen.setAktiv(rkBanner.getKosten() <= 25);		
		rkBanner.setAktiv(!rkRunen.isSelected());
		
		// Unique entry: AST
		boolean astGlobal = ( BuildaHQ.getCountFromInformationVector("ZWast") > 0 ? true : false );
		if(astGlobal && !astSelected) rkBanner.setAktiv(false);
		else {
			rkBanner.setAktiv(true);
		}

		if ( !genSelected ) {
			if(rkBanner.isSelected()) {
				astSelected = true;
				BuildaHQ.setInformationVectorValue("ZWast", 1);
			} else {
				if(astSelected) {
					astSelected = false;
					BuildaHQ.setInformationVectorValue("ZWast", 0);
					BuildaHQ.refreshEntries(2);
				}
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
	}

	@Override
	public void deleteYourself() {
		if(astSelected) {
			BuildaHQ.setInformationVectorValue("ZWast", 0);
		}
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}
}
