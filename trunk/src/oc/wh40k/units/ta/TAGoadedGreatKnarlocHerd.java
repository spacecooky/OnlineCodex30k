package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TAGoadedGreatKnarlocHerd extends Eintrag {
	
	AnzahlPanel boyz;
	OptionsEinzelUpgrade shaper;
	OptionsUpgradeGruppe wpn;

	public TAGoadedGreatKnarlocHerd() {

		kategorie = 5;

		name = "Goaded Great Knarloc Herd\n";
		grundkosten = 60;
		überschriftSetzen=true;

		add(boyz = new AnzahlPanel(ID, randAbstand, cnt, "Kroot Goads", 4, 8, 10));
		
		add(ico = new oc.Picture("oc/wh40k/images/GoadedGreatKnarlocHerd.gif"));
		
		seperator();
		
		add(shaper = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Shaper", 21));
		
		ogE.add(new OptionsGruppeEintrag("Pulse Rifle", 5));
		ogE.add(new OptionsGruppeEintrag("Pulse Carbine", 5));
		add(wpn=new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		
		complete();
	}

	@Override
	public void refreshen() {
		wpn.setAktiv(shaper.isSelected());
	}
}
