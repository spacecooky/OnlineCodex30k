package oc.whfb.units.ck;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CKAuserkorene extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelUpgrade oe4;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	RuestkammerStarter rkBanner;
	RuestkammerStarter rkBoss;
	
	public CKAuserkorene() {
		name = BuildaHQ.translate("Auserkorene");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Auserkorene"), 5, 100, 18);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/whfb/images/CKAuserkorene.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Khorne"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Nurgle"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Tzeentch"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Slaanesh"), 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schilde"), 1));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Zusätzliche Handwaffen"), 1));
		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Zweihandwaffen"), 2));
		add(oe4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Hellebarden"), 1));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Musiker"), 10));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Standartenträger"), 20));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Champion"), 20));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "CKMagicItems", "");
		rkBoss.initKammer(false, true, false, false, true); // 5te Option: nur 1 mag. Gegenstand
		rkBoss.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "CKBanner", "");
		rkBanner.initKammer(true, true, false);
		rkBanner.setButtonText(BuildaHQ.translate("Magische Standarte"));
		rkBanner.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBanner);

		complete();
	}

	@Override
	public void refreshen() {
		rkBanner.setAktiv(oeS.isSelected());
		rkBoss.setAktiv(oeC.isSelected());

		oe1.setPreis(squad.getModelle() * 1);
		oe2.setPreis(squad.getModelle() * 1);
		oe3.setPreis(squad.getModelle() * 2);
		oe4.setPreis(squad.getModelle() * 1);

		boolean legalOptions = oe1.isSelected() || oe2.isSelected() || oe3.isSelected() || oe4.isSelected();
		oe1.setLegal(legalOptions);
		oe2.setLegal(legalOptions);
		oe3.setLegal(legalOptions);
		oe4.setLegal(legalOptions);

		rkBoss.getKammer().specialAction(
			!o1.isSelected(BuildaHQ.translate("Mal des Khorne")),
			true
		);
	}
}
