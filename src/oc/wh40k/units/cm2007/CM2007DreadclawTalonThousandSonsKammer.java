package oc.wh40k.units.cm2007;

import oc.AnzahlPanel;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class CM2007DreadclawTalonThousandSonsKammer extends RuestkammerVater {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;
	OptionsUpgradeGruppe o1;

	public CM2007DreadclawTalonThousandSonsKammer() {}
	
	public void initButtons(boolean... defaults) {
		name = "Thousand Sons";
		grundkosten = 0;

		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Thousand Sons", 5, 20, 23));
		squad.setGrundkosten(0);

		add(ico = new oc.Picture("oc/wh40k/images/ThousandSons.gif"));
		

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Persönliche Ikone", 5));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Upgrade zum Hexer", 37));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Strahl des Verderbens", 10));
		ogE.addElement(new OptionsGruppeEintrag("Warpzeit", 25));
		ogE.addElement(new OptionsGruppeEintrag("Chaoswind", 30));
		ogE.addElement(new OptionsGruppeEintrag("Geschenk des Chaos", 30));
		ogE.addElement(new OptionsGruppeEintrag("Blitz des Tzeentch", 25));
		add(o1 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		oe1.setSelected(true);
		if (!o1.isSelected()) o1.setSelected(0,true);
	}

}
