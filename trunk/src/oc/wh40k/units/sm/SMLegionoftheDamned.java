package oc.wh40k.units.sm;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class SMLegionoftheDamned extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter rkBoss;

	public SMLegionoftheDamned() {
		name = "Legion of the Damned\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Legionäre", 5, 10, 30);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/SMLegionoftheDamnedSquad.gif"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 20));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 20));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 20));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 20));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 30));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 30));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", 30));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "SMSergeant", "Upgrade zum Sergeant");
		rkBoss.initKammer(true, false, false);
		rkBoss.setGrundkosten(5); // costs only 5 points!
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
	}

}

