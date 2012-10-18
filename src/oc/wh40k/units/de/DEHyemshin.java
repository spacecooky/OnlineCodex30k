package oc.wh40k.units.de;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DEHyemshin extends Eintrag {

	AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2;
	RuestkammerStarter rkBoss;

	public DEHyemshin() {
		name = "Hyemshîn-Trupp\n";
		grundkosten = 0;
        überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Hyemshîn", 3, 10, 22);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/DEHyemshin.jpg"));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Hitzelanze", 12));
        ogE.addElement(new OptionsGruppeEintrag("Schattenkatapult", 15));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Grav-Sporn", 10));
        ogE.addElement(new OptionsGruppeEintrag("Krähenfußwerfer", 20));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DEArenachampion", "Upgrade zum Arenachampion");
		rkBoss.initKammer();
		add(rkBoss);

		complete();
	}

	@Override
	public void refreshen() {
        o1.setMaxAnzahl(Double.valueOf(Math.floor(squad.getModelle() / 3)).intValue());
        o2.setMaxAnzahl(Double.valueOf(Math.floor(squad.getModelle() / 3)).intValue());
	}

}
