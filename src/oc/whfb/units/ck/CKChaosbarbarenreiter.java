package oc.whfb.units.ck;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.Sprache;

public class CKChaosbarbarenreiter extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelUpgrade oe4;
	OptionsEinzelUpgrade oe5;
	OptionsEinzelUpgrade oe6;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	
	public CKChaosbarbarenreiter() {
		name = BuildaHQ.translate("Chaosbarbarenreiter");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Chaosbarbarenreiter"), 5, 100, 13);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/whfb/images/CKChaosbarbarenreiter.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Khorne"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Nurgle"), 30));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Tzeentch"), 20));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Mal des Slaanesh"), 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schilde"), 1));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Leichte Rüstung"), 1));
		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Flegel")+ (BuildaHQ.getSprache() == Sprache.German ? "" : "s"), 2));
		add(oe4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Speere"), 1));
		add(oe5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Wurfspeere"), 1));
		add(oe6 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Wurfäxte"), 2));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Musiker"), 6));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Standartenträger"), 12));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Champion"), 12));

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 1);
		oe2.setPreis(squad.getModelle() * 1);
		oe3.setPreis(squad.getModelle() * 2);
		oe4.setPreis(squad.getModelle() * 1);
		oe5.setPreis(squad.getModelle() * 1);
		oe6.setPreis(squad.getModelle() * 2);
	}
}
