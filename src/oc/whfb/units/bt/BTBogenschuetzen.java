package oc.whfb.units.bt;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class BTBogenschuetzen extends Eintrag {

	AnzahlPanel squad;
	
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	
	public BTBogenschuetzen() {
		name = BuildaHQ.translate("Bogenschützen");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Bogenschützen"), 10, 100, 6);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/DEDunkelelfenkrieger.jpg"));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Feuerbecken"), 5));
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Plänkler"), 1));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Leichte Rüstung"), 1));
		
		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 5));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 5));

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 1);
		oe2.setPreis(squad.getModelle() * 1);	
	}	
}
