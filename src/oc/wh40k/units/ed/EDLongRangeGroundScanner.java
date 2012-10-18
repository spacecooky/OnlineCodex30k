package oc.wh40k.units.ed;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class EDLongRangeGroundScanner extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;

	public EDLongRangeGroundScanner() {
		name = "Long Range Ground Scanner\n";
		grundkosten = 50;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Guardsman", "Guardsmen", 1, 4, 6);
		squad.setGrundkosten(-6);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGStormTrooperSquad.jpg"));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "krak grenades", 0));

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
        setEintragsCNT(0);

        oe1.setPreis(squad.getModelle());
	}

}
