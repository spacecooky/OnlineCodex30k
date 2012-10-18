package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class TYAbsorberschwaerme extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelUpgrade oe4;

	public TYAbsorberschwaerme() {
		name = "Absorberschwärme";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Absorberschwärme", 3, 9, 10);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/TYAbsorber.jpg"));

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stachelfäuste", 5));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenalindrüsen", 4));
		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxinkammern", 4));

		seperator();

		add(oe4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wühlerschwarm", 2));

		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("[Forgeworld] Malanthrope");

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 5);
		oe2.setPreis(squad.getModelle() * 4);
		oe3.setPreis(squad.getModelle() * 4);
		oe4.setPreis(squad.getModelle() * 2);
	}

}
