package oc.wh40k.units.cm2007;

import oc.AnzahlPanel;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class CM2007ZhuforGefolgeKammer extends RuestkammerVater {

	AnzahlPanel squad;
    OptionsEinzelZaehler o1;
    OptionsUpgradeGruppe o2;
    OptionsZaehlerGruppe o3;
    OptionsEinzelZaehler o5;
    OptionsZaehlerGruppe o4;
    OptionsZaehlerGruppe o7;
//    OptionsEinzelUpgrade oe1;
    RuestkammerStarter rkRaider;

	public CM2007ZhuforGefolgeKammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Chaosterminatoren", 3, 10, 30));

		seperator();

		add(o1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Terminator Champion", squad.getModelle(), 10));

		seperator();

//		ogE.addElement(new OptionsGruppeEintrag("Ikone d. Glorreichen Chaos", "Ikone des Glorreichen Chaos", 10));
//		ogE.addElement(new OptionsGruppeEintrag("Ikone des Slaanesh", 15));
		ogE.addElement(new OptionsGruppeEintrag("Ikone des Khorne", 30));
//		ogE.addElement(new OptionsGruppeEintrag("Ikone des Nurgle", 40));
//		ogE.addElement(new OptionsGruppeEintrag("Ikone des Tzeentch", 35));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kettenfaust", 15));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, squad.getModelle()));

		seperator(7);

		add(o5 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Energieklauenpaar", squad.getModelle(), 10));

		seperator(7);

		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 5));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, squad.getModelle()));

		seperator(5);

		ogE.addElement(new OptionsGruppeEintrag("Zwillings-MaschKa", "Zwillingsmaschinenkanone", 25));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 5));
		add(o7 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();
        
//        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Mal des Khorne", 0));
        
        seperator();

		rkRaider = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosLandRaiderKammer", "Chaos Land Raider");
		rkRaider.initKammer();
		add(rkRaider);

		sizeSetzen(200, 100, 390, KAMMER_HOEHE + cnt);
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
		o3.setMaxAnzahl(squad.getModelle() - o5.getAnzahl());
		o4.setMaxAnzahl(squad.getModelle() - o7.getAnzahl() - o5.getAnzahl());
		o5.setMaxAnzahl(squad.getModelle());
		o7.setMaxAnzahl((squad.getModelle() < 10 ? 1 : 2));
                
                o2.alwaysSelected();
        
//        oe1.setSelected(true);
//        oe1.setPreis(10 * squad.getModelle());

		if (squad.getModelle() - o5.getAnzahl() < 2) {
			if (squad.getModelle() - o5.getAnzahl() < 1) {
				o7.setMaxAnzahl(0);
			} else {
				o7.setMaxAnzahl(1);
			}
		}
	}

}
