package oc.wh40k.units.da;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class DAOrdenspriester extends Eintrag {

	public DAOrdenspriester() {
		name = "Ordenspriester";
		grundkosten = 100;

		add(ico = new oc.Picture("oc/wh40k/images/DAChaplain.gif"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		add(new OptionsUpgradeGruppe(ID, randAbstand - 5, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasma", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		add(new OptionsUpgradeGruppe(ID, randAbstand - 5, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand - 5, cnt, "", "Melterbomben", 5));

		seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("Sprungmodul", 20));
		ogE.addElement(new OptionsGruppeEintrag("Space Marine Bike", 30));
		add(new OptionsUpgradeGruppe(ID, randAbstand - 5, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
