
package oc.wh40k.units.cm2007;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class CM2007ChaosterminatorenKammer extends RuestkammerVater {

	AnzahlPanel squad;
	OptionsEinzelZaehler o1;
	OptionsUpgradeGruppe o2;
	OptionsZaehlerGruppe o3;
	OptionsZaehlerGruppe o4;
	OptionsEinzelZaehler o5;
	OptionsEinzelUpgrade o6;
	OptionsZaehlerGruppe o7;
	OptionsUpgradeGruppe o8;
	RuestkammerStarter rkRaider;

        boolean sons = false;
        boolean child = false;

	public CM2007ChaosterminatorenKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
            name = "Chaosterminatoren";
            grundkosten = 0;

            try {
                sons = defaults[0];
                child = defaults[1];
            } catch(Exception e) {}

            squad = new AnzahlPanel(ID, randAbstand, cnt, "Chaosterminatoren", 3, 10, 30);
            add(squad);

            add(ico = new oc.Picture("oc/wh40k/images/ChaosTerminators.gif"));
            

            seperator();

            if(!sons) add(o1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Terminatorchampion", squad.getModelle(), 10));
            if(sons) add(o6 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Aufstrebender Hexer", 30));

            if(sons)  {
                seperator();

                ogE.addElement(new OptionsGruppeEintrag("Strahl des Verderbens", 10));
                ogE.addElement(new OptionsGruppeEintrag("Warpzeit", 25));
                ogE.addElement(new OptionsGruppeEintrag("Chaoswind", 30));
                ogE.addElement(new OptionsGruppeEintrag("Geschenk des Chaos", 30));
                ogE.addElement(new OptionsGruppeEintrag("Blitz des Tzeentch", 25));
                add(o8 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE));
            }

            seperator(sons ? 5 : 10);

            if(!child && !sons) ogE.addElement(new OptionsGruppeEintrag("Ikone d. Glorreichen Chaos", "Ikone des Glorreichen Chaos", 10));
            if(!sons) ogE.addElement(new OptionsGruppeEintrag("Ikone des Slaanesh", 15));
            if(!child && !sons) ogE.addElement(new OptionsGruppeEintrag("Ikone des Khorne", 30));
            if(!child && !sons) ogE.addElement(new OptionsGruppeEintrag("Ikone des Nurgle", 40));
            if(!child) ogE.addElement(new OptionsGruppeEintrag((sons ? "Mal" : "Ikone") + " des Tzeentch", sons ? 0 : 35));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 10));
            ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 10));
            ogE.addElement(new OptionsGruppeEintrag("Kettenfaust", 15));
            add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, squad.getModelle()));

            seperator(7);

            add(o5 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Energieklauenpaar", squad.getModelle(), 10));

            seperator(7);

            if(child) ogE.addElement(new OptionsGruppeEintrag("Sonic Blaster", 0));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 5));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 5));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 5));
            add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, squad.getModelle()));

            seperator(5);

            if(child) ogE.addElement(new OptionsGruppeEintrag("Blastmaster", 25));
            ogE.addElement(new OptionsGruppeEintrag("Zwillings-MaschKa", "Zwillingsmaschinenkanone", 25));
            ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 5));
            add(o7 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            rkRaider = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosLandRaiderKammer", "Chaos Land Raider", 2);
            rkRaider.initKammer();
            add(rkRaider);

            sizeSetzen();
	}

	@Override
	public void refreshen() {
            if(!sons) o1.setMaxAnzahl(squad.getModelle());
            if(sons) o6.setSelected(true);
            if(sons) o8.alwaysSelected();
            if(child || sons) o2.alwaysSelected();
            o3.setMaxAnzahl((sons ? 1 : squad.getModelle()) - o5.getAnzahl());
            o4.setMaxAnzahl((sons ? 1 : squad.getModelle()) - o7.getAnzahl() - o5.getAnzahl());
            o5.setMaxAnzahl(sons ? 1 : squad.getModelle());
            o7.setMaxAnzahl(sons ? 1 - o5.getAnzahl() : (squad.getModelle() < 10 ? 1 : 2));

            if (squad.getModelle() - o5.getAnzahl() < 2 && !sons) {
                    if (squad.getModelle() - o5.getAnzahl() < 1) {
                            o7.setMaxAnzahl(0);
                    } else {
                            o7.setMaxAnzahl(1);
                    }
            }
	}

}
