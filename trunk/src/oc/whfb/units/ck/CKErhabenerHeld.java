package oc.whfb.units.ck;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CKErhabenerHeld extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsEinzelUpgrade oe1;
	RuestkammerStarter rkMount;
	RuestkammerStarter rkGifts;
	RuestkammerStarter rkBanner;
	RuestkammerStarter rkMagic;
	boolean astSelected = false;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	RuestkammerStarter rkLore;

	public CKErhabenerHeld() {
		name = BuildaHQ.translate("Erhabener Held");
		grundkosten = 110;

		add(ico = new oc.Picture("oc/whfb/images/CKErhabenerHeld.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Khorne"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Nurgle"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Tzeentch"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Slaanesh"), 5));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), 8));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zusätzliche Handwaffe"), 4));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Flegel"), 4));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Hellebarde"), 4));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schild"), 5));

		seperator();

		rkGifts = new RuestkammerStarter(ID, randAbstand, cnt, "CKGiftsOfChaos", "");
		rkGifts.initKammer(true, false, false, false);
		rkGifts.setButtonText(BuildaHQ.translate("Geschenke des Chaos"));
		add(rkGifts);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "CKMagicItems", "");
		rkMagic.initKammer(false, false, true, false);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "CKBanner", BuildaHQ.translate("Armeestandartenträger"));
		rkBanner.initKammer(false, false, true);
		rkBanner.setGrundkosten(25);
		add(rkBanner);

		seperator();

		rkMount = new RuestkammerStarter(ID, randAbstand, cnt, "CKMount", "");
		rkMount.initKammer(false, false, false, true);
		rkMount.setButtonText(BuildaHQ.translate("Reittier"));
		add(rkMount);

		seperator();
		
		rkLore = new RuestkammerStarter(ID, randAbstand, cnt, reflectionKennung + "MagicLores", "");
		rkLore.initKammer(false);
		rkLore.setButtonText(BuildaHQ.translate("Lehren der Magie"));
		add(rkLore);

		complete();
	}

	@Override
	public void refreshen() {
		rkMount.getKammer().specialAction(
			o1.isSelected(BuildaHQ.translate("Mal des Khorne")),
			o1.isSelected(BuildaHQ.translate("Mal des Nurgle")),
			o1.isSelected(BuildaHQ.translate("Mal des Tzeentch")),
			o1.isSelected(BuildaHQ.translate("Mal des Slaanesh"))
		);

		if(rkGifts.isSelected()) {
			rkMagic.setAktiv(
				rkBanner.getKosten() <= 25 &&
				!rkGifts.getKammer().getSpecialValue().equals(BuildaHQ.translate("ZORN_DES_BLUTGOTTES"))
			);
		} else {
			rkMagic.setAktiv(rkBanner.getKosten() <= 25);
		}		

		rkBanner.getKammer().specialAction(rkGifts.getKammer().getSpecialValue().equals(BuildaHQ.translate("ZORN_DES_BLUTGOTTES")));
		
		rkMagic.getKammer().specialAction(
			!o1.isSelected(BuildaHQ.translate("Mal des Khorne")),
			!(rkMount.getKosten() > 0)
		);
		
		rkGifts.getKammer().specialAction(
            ((String) ((CKMagicItems) rkMagic.getKammer()).getSpecialValue()).equals("Buch der Geheimnisse")
        );

		rkLore.setAktiv( rkMagic.getKammer().getSpecialValue().equals("Buch der Geheimnisse"));
		
		// Unique entry: AST
		boolean astGlobal = ( BuildaHQ.getCountFromInformationVector("CKast") > 0 ? true : false );
		if(astGlobal && !astSelected) rkBanner.setAktiv(false);
		else rkBanner.setAktiv(true);

		if(rkBanner.isSelected()) {
			astSelected = true;
			BuildaHQ.setInformationVectorValue("CKast", 1);
		} else {
			if(astSelected) {
				astSelected = false;
				BuildaHQ.setInformationVectorValue("CKast", 0);
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
	}

	@Override
	public void deleteYourself() {
		if(astSelected) {
			BuildaHQ.setInformationVectorValue("CKast", 0);
		}
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}

}
