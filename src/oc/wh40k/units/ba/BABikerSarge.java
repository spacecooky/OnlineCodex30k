package oc.wh40k.units.ba;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class BABikerSarge extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	boolean peilsender = false;

	public BABikerSarge() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		if(defaults[0]) peilsender = true;
		
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));

		if(peilsender)
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Peilsender", 25));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
