package oc.wh40k.units.ba;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class BAScoutbikeSchwadron extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsUpgradeGruppe o2;
	RuestkammerStarter rkBoss;

	public BAScoutbikeSchwadron() {
		name = "Scout-Bike-Schwadron\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Scout Biker", 3, 10, 20);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/BAScoutbikeSchwadron.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Astartes-Granatwerfer", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Splitterminen", 10));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "BABikerSarge", "Upgrade zum Sergeant");
		rkBoss.initKammer(true);
		rkBoss.setGrundkosten(10);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
		o1.setMaxAnzahl(squad.getModelle() == 3 ? 2 : 3);
	}

}
