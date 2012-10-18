package oc.whfb.units.ck;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CKDaemonenprinz extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o2;
	RuestkammerStarter rkGifts;
	RuestkammerStarter rkLore;
	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;

	public CKDaemonenprinz() {
		name = BuildaHQ.translate("Dämonenprinz");
		grundkosten = 300;

		add(ico = new oc.Picture("oc/whfb/images/CKDaemonenprinz.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Khorne"), 10));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Nurgle"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Tzeentch"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Slaanesh"), 5));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zauberstufe"), 40));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

		seperator();

		rkGifts = new RuestkammerStarter(ID, randAbstand, cnt, "CKGiftsOfChaos", "");
		rkGifts.initKammer(false, false, true, false);
		rkGifts.setButtonText(BuildaHQ.translate("Geschenke des Chaos"));
		add(rkGifts);
		
		seperator();

		rkLore = new RuestkammerStarter(ID, randAbstand, cnt, reflectionKennung + "MagicLores", "");
		rkLore.initKammer(true,true);
		rkLore.setButtonText(BuildaHQ.translate("Lehren der Magie"));
		add(rkLore);

		complete();
	}

	@Override
	public void refreshen() {
		rkLore.setAktiv( o2.getKosten() >= 40 );
		
		o2.setAktiv(!o1.isSelected(BuildaHQ.translate("Mal des Khorne")));
		o1.setAktiv(BuildaHQ.translate("Mal des Khorne"), !o2.isSelected());
		rkGifts.getKammer().specialAction(o2.isSelected());
		
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
