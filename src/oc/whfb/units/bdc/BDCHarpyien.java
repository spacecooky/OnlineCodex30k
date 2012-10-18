package oc.whfb.units.bdc;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class BDCHarpyien extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade o1;
	
	public BDCHarpyien() {
		name = BuildaHQ.translate("Harpyien");
		grundkosten = 0;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Harpyien"),5, 10, 11);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/whfb/images/DEHarpien.jpg"));
		
		seperator();
		
		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Kundschafter"), 3));

		complete();
	}

	@Override
	public void refreshen() {
		o1.setPreis(squad.getModelle() * 3);
	}
}
