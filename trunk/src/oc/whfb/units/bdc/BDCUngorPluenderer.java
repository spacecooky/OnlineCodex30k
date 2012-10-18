package oc.whfb.units.bdc;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class BDCUngorPluenderer extends Eintrag {

	AnzahlPanel squad;
	boolean set = false;
	OptionsEinzelUpgrade oeC;
	OptionsEinzelUpgrade oeM;

	public BDCUngorPluenderer() {
		name = BuildaHQ.translate("Ungor Plünderer");
		grundkosten = 0;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Ungor Plünderer"), 5, 10, 6);
		squad.setGrundkosten(0);
		add(squad);
		
		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));
		
		seperator();
		
		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 3));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 6));
		
		complete();
	}

	@Override
	public void refreshen() { }
}
