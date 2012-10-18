package oc.wh40k.units.da;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class DAMortisDreadnought extends Eintrag {

	OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade normalPod;
    OptionsEinzelUpgrade luciusPod;

	public DAMortisDreadnought() {
		name = "Mortis Dreadnought";
		grundkosten = 105;

		add(ico = new oc.Picture("oc/wh40k/images/DAMortisDreadnought.gif"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("2 Raketenwerfer", "zwei Raketenwerfer", 0));
		ogE.addElement(new OptionsGruppeEintrag("2 synchr. schwere Bolter", "zwei synchronisierte schwere Bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("2 synchr. Maschkanonen", "zwei synchronisierte Maschinenkanonen", 20));
		ogE.addElement(new OptionsGruppeEintrag("2 synchr. Laserkanone", "zwei synchronisierte Laserkanonen", 50));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));

        seperator();

		add(normalPod = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Landungskapsel", 60));
		add(luciusPod = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "[Apocalypse] Lucius-Pod", "Lucius Pattern Drop Pod [Apocalypse-Regeln]", 65));

		complete();
	}

	@Override
	public void refreshen() {
        o1.alwaysSelected();

        normalPod.setAktiv(!luciusPod.isSelected());
        luciusPod.setAktiv(!normalPod.isSelected());
	}

}
