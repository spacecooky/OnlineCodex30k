package oc.wh40k.units.el;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ELSerpentKammer extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade o2;
	OptionsEinzelUpgrade o3;
	OptionsEinzelUpgrade o4;
	OptionsEinzelUpgrade o5;

	public ELSerpentKammer() {
		grundkosten = 90;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/ELSerpentGross.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Shurikenkanone", 10));
		ogE.addElement(new OptionsGruppeEintrag("Impulslaser", 25));
		ogE.addElement(new OptionsGruppeEintrag("Eldar-Raketenwerfer", 30));
		ogE.addElement(new OptionsGruppeEintrag("Sternenkanone", 35));
		ogE.addElement(new OptionsGruppeEintrag("Laserlanze", 45));


		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator(15);

		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Shurikenkanone", 10));
		add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vektorschubdüsen", 20));
		add(o4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusatztriebwerke", 15));
		add(o5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Seelenstein", 10));

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
            o1.alwaysSelected();
	}
	
}












