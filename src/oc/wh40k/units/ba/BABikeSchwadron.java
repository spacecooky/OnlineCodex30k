package oc.wh40k.units.ba;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class BABikeSchwadron extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsUpgradeGruppe o2;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTrike;

	public BABikeSchwadron() {
		name = "Bike-Schwadron\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marine Biker", 3, 8, 25);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/BABikeSchwadron.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "BABikerSarge", "Upgrade zum Sergeant");
		rkBoss.initKammer(false);
		rkBoss.setGrundkosten(15);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		seperator();

		rkTrike = new RuestkammerStarter(ID, randAbstand, cnt, "BATrike", "Trike");
		rkTrike.initKammer();
		add(rkTrike);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
	}

}
