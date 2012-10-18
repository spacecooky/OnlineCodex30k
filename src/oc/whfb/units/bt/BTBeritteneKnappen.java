package oc.whfb.units.bt;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class BTBeritteneKnappen extends Eintrag {

	AnzahlPanel squad;
	
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	
	public BTBeritteneKnappen() {
		name = BuildaHQ.translate("Berittene Knappen");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Berittene Knappen"), 5, 100, 15);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/DEDunkelelfenkrieger.jpg"));
		
		seperator();
		
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schilde"), 1));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Leichte Rüstung"), 2));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 7));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 14));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 14));

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 1);
		oe2.setPreis(squad.getModelle() * 2);
	}	
}
