package oc.wh40k.units.de;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DEFleischgeboreneKabalenkrieger extends Eintrag {

	AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1x;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o3;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
	RuestkammerStarter rkBoss;
    RuestkammerStarter rkBarke;
    RuestkammerStarter rkViper;

	public DEFleischgeboreneKabalenkrieger() {
		name = "Fleischgeborenen-Trupp\n";
		grundkosten = 0;
        überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Fleischgeborene Kabalenkrieger", 3, 10, 12);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/DEFleischgeboreneKabalenkrieger.jpg"));

		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Splittergewehr", 0));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Pistole & NKW", "Splitterpistole & Nahkampfwaffe", 0));
        ogE.addElement(new OptionsGruppeEintrag("Splitterkarabiner", 5));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Shredder", 5));
        ogE.addElement(new OptionsGruppeEintrag("Schattenkatapult", 15));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Splitterkanone", 10));
        ogE.addElement(new OptionsGruppeEintrag("Schattenlanze", 25));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Plasmagranaten", 0));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Impulsminen", 0));

        seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DEDracon", "Upgrade zum Dracon");
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
        int bossCount = rkBoss.isSelected() ? 1 : 0;
        
        o1.setMaxAnzahl(squad.getModelle() - o2.getAnzahl() - o3.getAnzahl() - bossCount);
        o1x.setMaxAnzahl(squad.getModelle() - o2.getAnzahl() - o3.getAnzahl() - bossCount);
        o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl() - o2.getAnzahl() - o3.getAnzahl() - bossCount);

        int o2max = squad.getModelle() - o3.getAnzahl() - bossCount;
        o2.setMaxAnzahl(o2max > 4 ? 4 : o2max);

        int o3max = squad.getModelle() - o2.getAnzahl() - bossCount;
        o3.setMaxAnzahl(o3max > 2 ? 2 : o3max);

        oe1.setPreis(squad.getModelle() * 1);
        oe2.setPreis(squad.getModelle() * 2);

        rkBarke.setAktiv(squad.getModelle() <= 10 && !rkViper.isSelected());
        rkViper.setAktiv(squad.getModelle() <= 5 && !rkBarke.isSelected());
	}

}
