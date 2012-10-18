package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class TYGargoylen extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;

	public TYGargoylen() {
		name = "Gargoylen";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Gargoylen", 10, 30, 6);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/TYGargoyles.jpg"));

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenalindrüsen", 1));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxinkammern", 1));

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 1);
		oe2.setPreis(squad.getModelle() * 1);
	}

}
