
package oc.wh40k.units.cm2007;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class CM2007ChaosSpaceMarinesHavocsKammer extends RuestkammerVater {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsEinzelZaehler o3;
	RuestkammerStarter rkRhino;
	RuestkammerStarter rkBoss;

        boolean child;

	public CM2007ChaosSpaceMarinesHavocsKammer() {
            grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
            name = "Chaos Space Marines Havocs";

            try {
                child = defaults[0];
            } catch(Exception e) {}

            squad = new AnzahlPanel(ID, randAbstand, cnt, "Havocs", 5, 20, 15, "Chaos Space Marines Havocs");
            add(squad);

            add(ico = new oc.Picture("oc/wh40k/images/ChaosHavocs.gif"));
            

            seperator();

            if(!child) ogE.addElement(new OptionsGruppeEintrag("Ikone d. Glorreichen Chaos", "Ikone des Glorreichen Chaos", 10));
            ogE.addElement(new OptionsGruppeEintrag("Ikone des Slaanesh", child ? 0 : 20));
            if(!child) ogE.addElement(new OptionsGruppeEintrag("Ikone des Khorne", 30));
            if(!child) ogE.addElement(new OptionsGruppeEintrag("Ikone des Nurgle", 50));
            if(!child) ogE.addElement(new OptionsGruppeEintrag("Ikone des Tzeentch", 40));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 35));
            ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 20));
            ogE.addElement(new OptionsGruppeEintrag("Maschinenkanone", 20));
            ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 15));
            ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
            ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
            ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
            add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

            if(child) seperator();

            if(child) add(o3 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Sonic Blaster", 5, squad.getModelle()));

            seperator();

            rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "CMChampion", "Upgrade zum Aufstrebenden Champion", 2);
            rkBoss.setGrundkosten(15);
            rkBoss.initKammer(false, false, false, false, true);
            rkBoss.setButtonText("Aufstrebender Champion", false);
            rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
            add(rkBoss);

            seperator();

            rkRhino = new RuestkammerStarter(ID, randAbstand, cnt, "CMTransporter", "Transporter", 2);
            rkRhino.initKammer();
            rkRhino.setButtonText("Transporter");
            add(rkRhino);

            sizeSetzen();
	}

	@Override
	public void refreshen() {
            if(child) o1.alwaysSelected();
            if(child) o3.setMaxAnzahl(squad.getModelle() - o2.getAnzahl() - (rkBoss.isSelected() ? 1 : 0));
	}

}
