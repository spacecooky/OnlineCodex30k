package oc.whfb.units.ck;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CKMeisterzauberer extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsEinzelUpgrade oe1;
	RuestkammerStarter rkMount;
	RuestkammerStarter rkGifts;
	RuestkammerStarter rkMagic;
	RuestkammerStarter rkLore;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	
	public CKMeisterzauberer() {
		name = BuildaHQ.translate("Meisterzauberer");
		grundkosten = 235;

		add(ico = new oc.Picture("oc/whfb/images/CKMeisterzauberer.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Upgrade zur 4. Stufe"), 35));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Nurgle"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Tzeentch"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Slaanesh"), 5));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		rkLore = new RuestkammerStarter(ID, randAbstand, cnt, reflectionKennung + "MagicLores", "");
		rkLore.initKammer(true,true);
		rkLore.setButtonText(BuildaHQ.translate("Lehren der Magie"));
		add(rkLore);
		
		seperator();

		rkGifts = new RuestkammerStarter(ID, randAbstand, cnt, "CKGiftsOfChaos", "");
		rkGifts.initKammer(false, true, false, true);
		rkGifts.setButtonText(BuildaHQ.translate("Geschenke des Chaos"));
		add(rkGifts);

		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "CKMagicItems", "");
		rkMagic.initKammer(true, false, false, true);
		rkMagic.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		add(rkMagic);

		seperator();

		rkMount = new RuestkammerStarter(ID, randAbstand, cnt, "CKMount", "");
		rkMount.initKammer(false, true, false, false);
		rkMount.setButtonText(BuildaHQ.translate("Reittier"));
		add(rkMount);

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
			false,
			o1.isSelected(BuildaHQ.translate("Mal des Nurgle")),
			o1.isSelected(BuildaHQ.translate("Mal des Tzeentch")),
			o1.isSelected(BuildaHQ.translate("Mal des Slaanesh"))
		);
		rkMagic.getKammer().specialAction(
			true,
			!(rkMount.getKosten() > 0)
		);
		
		rkLore.getKammer().specialAction(
			o1.isSelected(BuildaHQ.translate("Mal des Tzeentch")),
			o1.isSelected(BuildaHQ.translate("Mal des Nurgle")),
			o1.isSelected(BuildaHQ.translate("Mal des Slaanesh"))
		);
		
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
	}
	
	@Override
	public void deleteYourself() {
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}
}
