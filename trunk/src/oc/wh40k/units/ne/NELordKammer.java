package oc.wh40k.units.ne;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class NELordKammer extends RuestkammerVater {

	OptionsUpgradeGruppe typ;
    OptionsUpgradeGruppe o1;

	public NELordKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/NELord.jpg"));
		

        ogE.addElement(new OptionsGruppeEintrag("Lord", 35));
		add(typ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Stab des Lichts", 0));
		ogE.addElement(new OptionsGruppeEintrag("Hyperphasenschwert", 0));
		ogE.addElement(new OptionsGruppeEintrag("Flammenfaust", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kriegssense", 10));
		ogE.addElement(new OptionsGruppeEintrag("Entropieklinge", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Durasempisches Geflecht", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Gedankenkontrollskarab�en", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Tesserakt-Labyrinth", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Regeneratorsph�re", 30));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Phasenverzerrer", 45));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		if(!typ.isSelected()) typ.setSelected(0, true);
        if(!o1.isSelected()) o1.setSelected(0, true);
	}
	
}
