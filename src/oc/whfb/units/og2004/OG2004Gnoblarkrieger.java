package oc.whfb.units.og2004;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.whfb.armies.VOLKOgerAB2004;

public class OG2004Gnoblarkrieger extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeC;
	boolean set = false;

	public OG2004Gnoblarkrieger() {
		name = BuildaHQ.translate("Gnoblarkrieger");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Gnoblarkrieger"), 20, 100, 2);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/OGGnoblarkrieger.jpg"));

		seperator();

		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 2));

		complete();
	}

	@Override
	public void refreshen() {
		if(!set){
			VOLKOgerAB2004.GNOBLERKRIEGER ++;
		}		
		set = true;
		
		if(VOLKOgerAB2004.OGERBULLEN < VOLKOgerAB2004.GNOBLERKRIEGER){
			setFehlermeldung("0-"+VOLKOgerAB2004.OGERBULLEN+" " + BuildaHQ.translate("Auswahl"));
		}else{
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		VOLKOgerAB2004.GNOBLERKRIEGER --;
		super.deleteYourself();
	}
}
