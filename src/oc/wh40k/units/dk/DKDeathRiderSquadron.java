package oc.wh40k.units.dk;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class DKDeathRiderSquadron extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o3;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;

	boolean kamirSelected = false;

	public DKDeathRiderSquadron() {
		name = "Death Rider Squadron";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Death Riders", 5, 10, 16);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGRoughRaiderSquad.jpg"));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand +10, cnt, "", "Upgrade to Ridemaster", 10));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

        seperator(5);

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melta bombs", 5));

		complete();
	}

	@Override
	public void refreshen() {
        oe2.setSelected(true);
	}

}
