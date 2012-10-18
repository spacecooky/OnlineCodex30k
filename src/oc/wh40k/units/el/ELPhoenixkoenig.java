package oc.wh40k.units.el;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ELPhoenixkoenig extends Eintrag {

	OptionsUpgradeGruppe oG;

	public ELPhoenixkoenig() {

		name = "Phönixkönig";

		grundkosten = 0;





		add(ico = new oc.Picture("oc/wh40k/images/nix.gif"));





		ogE.addElement(new OptionsGruppeEintrag("Asurmen", 230));

		ogE.addElement(new OptionsGruppeEintrag("Jain Zar", 190));

		ogE.addElement(new OptionsGruppeEintrag("Baharroth", 200));

		ogE.addElement(new OptionsGruppeEintrag("Karandras", 215));

		ogE.addElement(new OptionsGruppeEintrag("Fuegan", 205));

		ogE.addElement(new OptionsGruppeEintrag("Maugan Ra", 195));



		oG = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE);

		add(oG);



		seperator();





		complete();

	}

	//@OVERRIDE
	public void refreshen() {



		String bildname;



		if (oG.isSelected("Jain Zar")) {

			bildname = "Phoenixkoenig1";
		} else if (oG.isSelected("Maugan Ra")) {

			bildname = "Phoenixkoenig2";
		} else if (oG.isSelected("Fuegan")) {

			bildname = "Phoenixkoenig3";
		} else if (oG.isSelected("Karandras")) {

			bildname = "Phoenixkoenig4";
		} else if (oG.isSelected("Asurmen")) {

			bildname = "Phoenixkoenig5";
		} else if (oG.isSelected("Baharroth")) {

			bildname = "Phoenixkoenig6";
		} else {
			bildname = "nix";
		}



		ico.setIcon("oc/wh40k/images/" + bildname + ".gif");



		try {
			ico.updateSize();
		} catch (NullPointerException e) {
			ico.setSize(0, 0);
		}

		if(!oG.isSelected()) oG.setSelected(0, true);
	}
}
