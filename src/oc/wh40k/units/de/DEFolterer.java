package oc.wh40k.units.de;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DEFolterer extends Eintrag {

	AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
	RuestkammerStarter rkBoss;
    RuestkammerStarter rkBarke;
    RuestkammerStarter rkViper;

	public DEFolterer() {
		name = "Folterer-Trupp\n";
		grundkosten = 0;
        überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Folterer", 3, 10, 10);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/DEFolterer.jpg"));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Säurewerfer", 10));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));

        seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DEAcothyst", "Upgrade zum Acothyst");
		rkBoss.initKammer();
		add(rkBoss);

		seperator();

		rkBarke = new RuestkammerStarter(ID, randAbstand, cnt, "DESchattenbarke", "Schattenbarke");
		rkBarke.initKammer();
		add(rkBarke);

		rkViper = new RuestkammerStarter(ID, randAbstand, cnt, "DESchattenviper", "Schattenviper");
		rkViper.initKammer();
		add(rkViper);

		complete();
	}

	@Override
	public void refreshen() {
        o1.setMaxAnzahl(Double.valueOf(Math.floor(squad.getModelle() / 5)).intValue());

        rkBarke.setAktiv(squad.getModelle() <= 10 && !rkViper.isSelected());
        rkViper.setAktiv(squad.getModelle() <= 5 && !rkBarke.isSelected());
	}

}
