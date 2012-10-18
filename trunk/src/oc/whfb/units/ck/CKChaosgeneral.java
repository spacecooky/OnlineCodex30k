package oc.whfb.units.ck;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CKChaosgeneral extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsEinzelUpgrade oe1;
	RuestkammerStarter rkMount;
	RuestkammerStarter rkGifts;
	RuestkammerStarter rkMagic;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	RuestkammerStarter rkLore;
	
	public CKChaosgeneral() {
		name = BuildaHQ.translate("Chaosgeneral");
		grundkosten = 210;

		add(ico = new oc.Picture("oc/whfb/images/CKChaosgeneral.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Khorne"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Nurgle"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Tzeentch"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Slaanesh"), 5));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), 12));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zusätzliche Handwaffe"), 8));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Flegel"), 8));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Hellebarde"), 8));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schild"), 10));

		seperator();

		rkGifts = new RuestkammerStarter(ID, randAbstand, cnt, "CKGiftsOfChaos", "");
		rkGifts.initKammer(false, true, false, false);
		rkGifts.setButtonText(BuildaHQ.translate("Geschenke des Chaos"));
		add(rkGifts);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "CKMagicItems", "");
		rkMagic.initKammer(false, false, false, true);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);

		seperator();

		rkMount = new RuestkammerStarter(ID, randAbstand, cnt, "CKMount", "");
		rkMount.initKammer(true, false, false, false);
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
		if(rkGifts.isSelected()) {
			rkMagic.setAktiv(!rkGifts.getKammer().getSpecialValue().equals(BuildaHQ.translate("ZORN_DES_BLUTGOTTES")));
		} else {
			rkMagic.setAktiv(true);
		}
		
		rkMount.getKammer().specialAction(
			o1.isSelected(BuildaHQ.translate("Mal des Khorne")),
			o1.isSelected(BuildaHQ.translate("Mal des Nurgle")),
			o1.isSelected(BuildaHQ.translate("Mal des Tzeentch")),
			o1.isSelected(BuildaHQ.translate("Mal des Slaanesh"))
		);
		rkMagic.getKammer().specialAction(
			!o1.isSelected(BuildaHQ.translate("Mal des Khorne")),
			!(rkMount.getKosten() > 0)
		);
		
		rkGifts.getKammer().specialAction(
            ((String) ((CKMagicItems) rkMagic.getKammer()).getSpecialValue()).equals("Buch der Geheimnisse")
        );
		
		rkLore.setAktiv( rkMagic.getKammer().getSpecialValue().equals("Buch der Geheimnisse"));
		
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
	}
	
	@Override
	public void deleteYourself() {
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}

}
