package oc.wh40k.units.cd;


import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CDBlutdaemon extends Eintrag {

	public CDBlutdaemon() {

		name = "Blutd‰mon";

		grundkosten = 250;

		add(ico = new oc.Picture("oc/wh40k/images/CDBlutdaemon.gif"));
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Blutgeiﬂel", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Segen des Blutgottes", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Unheilige St‰rke", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument des Chaos", 5));

		complete();

	}

	@Override
	public void refreshen() {
	}
}
