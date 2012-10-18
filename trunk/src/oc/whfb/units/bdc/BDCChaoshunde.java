package oc.whfb.units.bdc;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class BDCChaoshunde extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade o1;
	OptionsEinzelUpgrade o2;
	
	public BDCChaoshunde() {
		name = BuildaHQ.translate("Chaoshunde");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Chaoshunde"), 5, 100, 6);
		squad.setGrundkosten(0);
		add(squad);

		setCountToMinimum(false);
		
		add(ico = new oc.Picture("oc/images/DESchwarzeReiter.jpg"));
		
		seperator();
		
		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Giftattacken"), 3));
		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schuppenhaut"), 1));
				
		complete();
	}

	@Override
	public void refreshen() {
		o1.setPreis(squad.getModelle() * 3);
		o2.setPreis(squad.getModelle() * 1);
	}
}
