package oc.wh40k.units.el;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;

public class ELIllumZar extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade o2;
	OptionsEinzelUpgrade o3;
	OptionsEinzelUpgrade o4;
	OptionsEinzelUpgrade o5;
	OptionsEinzelUpgrade o6;

	public ELIllumZar() {

		name = "Illum Zar";

		grundkosten = 115;



		add(ico = new oc.Picture("oc/wh40k/images/IllumZar.gif"));





		o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Shurikenkanone", 10);

		add(o2);

		seperator();

		o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vektorschubdüsen", 20);

		add(o3);

		o4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusatztriebwerke", 15);

		add(o4);

		o6 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Holofeld", 35);

		add(o6);

		o5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Seelenstein", 10);

		add(o5);





		complete();

	}

	//@OVERRIDE
	public void refreshen() {
	}
}
