package oc.wh40k.units.ig;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerStarter;

public class IGGeneralMyndorasOdon extends Eintrag {

	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	RuestkammerStarter rkChimera;
	RuestkammerStarter rkValkyrie;

	boolean creedSelected = false;
	boolean strakenSelected = false;
	boolean kellSelected = false;
	boolean deddogSelected = false;

	public IGGeneralMyndorasOdon() {
		name = "General Myndoras Odon";
		grundkosten = 115;

		add(ico = new oc.Picture("oc/wh40k/images/IGGeneralMyndorasOdon.jpg"));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Regimentsstandarte", "Veteran mit Regimentsstandarte", 0));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Funkgerät", "Veteran mit Funkgerät", 0));
		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melter", "Veteran mit Melter", 0));

		seperator();

		add(new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Astropath", 1, 30));
		add(new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Artillerieoffizier", 1, 30));
		add(new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Flottenoffizier", 1, 30));
		add(new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Leibwächter", 2, 15));

		seperator();

		rkChimera = new RuestkammerStarter(ID, randAbstand, cnt, "IGChimaere", "Chimäre");
		rkChimera.initKammer(true);
		add(rkChimera);

		seperator();

		rkValkyrie = new RuestkammerStarter(ID, randAbstand, cnt, "IGWalkuereKammer", "Walküre");
		rkValkyrie.initKammer();
		add(rkValkyrie);

		complete();
	}

	@Override
	public void refreshen() {
        if(!oe1.isSelected()) oe1.setSelected(true);
        if(!oe2.isSelected()) oe2.setSelected(true);
        if(!oe3.isSelected()) oe3.setSelected(true);
        
        rkChimera.setAktiv(!rkValkyrie.isSelected());
        rkValkyrie.setAktiv(!rkChimera.isSelected());
	}

}
