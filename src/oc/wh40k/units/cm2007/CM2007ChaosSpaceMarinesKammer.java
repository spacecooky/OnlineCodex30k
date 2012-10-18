
package oc.wh40k.units.cm2007;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class CM2007ChaosSpaceMarinesKammer extends RuestkammerVater {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o6;
	OptionsUpgradeGruppe o7;
	OptionsUpgradeGruppe o8;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelZaehler oe2;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkRhino;

        boolean child;

	public CM2007ChaosSpaceMarinesKammer() {
            grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
            name = "Chaos Space Marines";

            try {
                child = defaults[0];
            } catch(Exception e) {}

            name = "Chaos Space Marines";
            grundkosten = 0;

            squad = new AnzahlPanel(ID, randAbstand, cnt, "Chaos Space Marines", 5, 20, 15);
            add(squad);

            add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.gif"));
            
            seperator();

            add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fabius Gallus' Elite-Krieger", 0));

            seperator();

            if(!child) ogE.addElement(new OptionsGruppeEintrag("Ikone d. Glorreichen Chaos", "Ikone des Glorreichen Chaos", 10));
            ogE.addElement(new OptionsGruppeEintrag("Ikone des Slaanesh", 20));
            if(!child) ogE.addElement(new OptionsGruppeEintrag("Ikone des Khorne", 30));
            if(!child) ogE.addElement(new OptionsGruppeEintrag("Ikone des Nurgle", 50));
            if(!child) ogE.addElement(new OptionsGruppeEintrag("Ikone des Tzeentch", 40));
            add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
            ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
            ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
            if(child) ogE.addElement(new OptionsGruppeEintrag("Schockbooster", 10));
            ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
            add(o7 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 10));
            ogE.addElement(new OptionsGruppeEintrag("Maschinenkanone", 10));
            if(child) ogE.addElement(new OptionsGruppeEintrag("Blastmaster", 10));
            ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 10));
            ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 20));
            ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
            ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
            ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
            add(o8 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            if(child) seperator();

            if(child) add(oe2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Sonic-Blaster", 5, squad.getModelle()));

            seperator();

            rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "CMChampion", "Upgrade zum Aufstrebenden Champion", 2);
            rkBoss.setGrundkosten(15);
            if(child) rkBoss.initKammer(false, false, false, false, true);
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
            if(child) o6.alwaysSelected();
            if(child) o6.setPreis(0, 0);
            if(child) oe2.setMaxAnzahl(squad.getModelle() - o7.getAnzahl() - o8.getAnzahl() - (rkBoss.isSelected() ? 1 : 0));

            o8.setAktiv(squad.getModelle() > 9);

            oe1.setAktiv(BuildaHQ.getCountFromInformationVector("CMFabiusGallus") > 0);
            oe1.setPreis(squad.getModelle() * 3);
	}

}
