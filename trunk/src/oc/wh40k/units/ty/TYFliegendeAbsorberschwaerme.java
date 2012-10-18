package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class TYFliegendeAbsorberschwaerme extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;

	public TYFliegendeAbsorberschwaerme() {
		name = "Fliegende Absorberschw�rme";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Fliegende Absorberschw�rme", 3, 9, 15);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/TYAbsorber.jpg"));

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stachelf�uste", 5));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenalindr�sen", 4));
		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxinkammern", 4));

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 5);
		oe2.setPreis(squad.getModelle() * 4);
		oe3.setPreis(squad.getModelle() * 4);
	}

}
