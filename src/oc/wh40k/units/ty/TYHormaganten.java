package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class TYHormaganten extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	RuestkammerStarter pod;

	public TYHormaganten() {
		name = "Hormaganten";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Hormaganten", 10, 30, 6);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/TYHormaganten.jpg"));

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenalindrüsen", 2));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxinkammern", 2));

		seperator();

		pod = new RuestkammerStarter(ID, randAbstand, cnt, "TYLandungsspore", "Landungsspore");
		pod.initKammer();
		add(pod);

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 2);
		oe2.setPreis(squad.getModelle() * 2);

		pod.setAktiv(squad.getModelle() <= 20);
	}

}
