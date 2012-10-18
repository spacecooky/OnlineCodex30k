package oc.whfb.units.de;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class DESchatten extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsGruppeEintrag og1;
	OptionsGruppeEintrag og2;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oeC;
	
	public DESchatten() {
		name = BuildaHQ.translate("Schatten");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Schatten"), 5, 100, 16);
		squad.setGrundkosten(0);
		add(squad);
		
		add(ico = new oc.Picture("oc/images/DESchatten.jpg"));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Leichte Rüstung"), 1));

		seperator();

		ogE.addElement(og1 = new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffen"), 2));
		ogE.addElement(og2 = new OptionsGruppeEintrag(BuildaHQ.translate("Zusätzliche Handwaffen"), 1));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 18));

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 1);
		o1.setPreis(0, squad.getModelle() * 2);
		o1.setPreis(1, squad.getModelle() * 1);
	}
}
