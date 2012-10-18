package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class TYSymbionten extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	RuestkammerStarter pod;
	RuestkammerStarter boss;

	public TYSymbionten() {
		name = "Symbionten";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Symbionten", 5, 20, 14);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/TYSymbionten.jpg"));

		seperator();

		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sensenklauen", 0));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenalindrüsen", 3));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxinkammern", 3));

		seperator();

		boss = new RuestkammerStarter(ID, randAbstand, cnt, "TYSymbiarch", "Upgrade zum Symbiarch");
		boss.initKammer();
		add(boss);

		seperator();

		pod = new RuestkammerStarter(ID, randAbstand, cnt, "TYLandungsspore", "Landungsspore");
		pod.initKammer();
		add(pod);

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 3);
		oe2.setPreis(squad.getModelle() * 3);

		// Sensenklauen nur fuer Symbionten, nicht fuer Symbiarch
		oe3.setPreis((squad.getModelle() - (boss.isSelected() ? 1 : 0)) * 2);
	}

}
