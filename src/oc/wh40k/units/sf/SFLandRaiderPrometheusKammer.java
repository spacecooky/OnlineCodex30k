package oc.wh40k.units.sf;

import oc.OptionsEinzelUpgrade;
import oc.RuestkammerVater;

public class SFLandRaiderPrometheusKammer extends RuestkammerVater {


	public SFLandRaiderPrometheusKammer() {
		grundkosten = 270;
	}

        @Override
	public void initButtons(boolean... defaults) {

		add(ico = new oc.Picture("oc/wh40k/images/SMLandRaiderPrometheus.jpg"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}
	
}
