package oc.wh40k.units.tl;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class TLRhinoKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;

	boolean chronusSelected = false;
	boolean[] defaults;

	public TLRhinoKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) { // [0] = kostenlos? [1] = Razorback?
		this.defaults = defaults;

		add(ico = new oc.Picture("oc/wh40k/images/SMRhinoGross.jpg"));
		
		int mod = 1;

		ogE.addElement(new OptionsGruppeEintrag("Rhino", 35 * mod));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));

		sizeSetzen();

	}
	boolean razorbackBild = false;

	@Override
	public void refreshen() {
		o1.setSelected("Rhino", true);
		}

		

		

		


	
	
}
