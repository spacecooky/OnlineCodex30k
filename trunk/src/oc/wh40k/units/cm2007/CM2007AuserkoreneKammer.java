
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

public class CM2007AuserkoreneKammer extends RuestkammerVater {

	RuestkammerStarter t;
	AnzahlPanel squad;
	OptionsEinzelZaehler o2;
	OptionsEinzelZaehler o4;
        OptionsEinzelUpgrade o1;
        OptionsEinzelUpgrade o3;

        OptionsZaehlerGruppe oe1;
        OptionsUpgradeGruppe oe2;
        OptionsUpgradeGruppe oe3;

        boolean child;

	public CM2007AuserkoreneKammer() {
            grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
            name = "Auserkorene Chaos Space Marines";

            try {
                child = defaults[0];
            } catch(Exception e) {}

            squad = new AnzahlPanel(ID, randAbstand, cnt, "Auserkorene CSM", 5, 10, 18, "Auserkorene Chaos Space Marines");
            add(squad);

            add(ico = new oc.Picture("oc/wh40k/images/ChosenChaosSpaceMarines.gif"));

            seperator();

            if(!child) ogE.addElement(new OptionsGruppeEintrag("Ikone d. Glorreichen Chaos", "Ikone des Glorreichen Chaos", 10));
            ogE.addElement(new OptionsGruppeEintrag("Ikone des Slaanesh", child ? 0 : 20));
            if(!child) ogE.addElement(new OptionsGruppeEintrag("Ikone des Khorne", 30));
            if(!child) ogE.addElement(new OptionsGruppeEintrag("Ikone des Nurgle", 50));
            if(!child) ogE.addElement(new OptionsGruppeEintrag("Ikone des Tzeentch", 40));

            add(oe3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator(8);

            add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Aufstrebender Champion", "Upgrade zum Aufstrebenden Champion", 10));

            if(child) seperator(5);

            if(child) add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schockbooster", 10));

            seperator(8);

            add(o2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Melterbomben", squad.getModelle(), 5));

            seperator(8);

            ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 15));
            ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 20));
            if(child) ogE.addElement(new OptionsGruppeEintrag("Blastmaster", 20));
            ogE.addElement(new OptionsGruppeEintrag("Maschinenkanone", 20));
            ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 35));
            ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
            ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
            if(child) ogE.addElement(new OptionsGruppeEintrag("Schockbooster", 10));
            ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));

            add(oe2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
            ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
            ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 25));
            ogE.addElement(new OptionsGruppeEintrag("Energieklauenpaar", 20));
            ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
            ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
            ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
            if(child) ogE.addElement(new OptionsGruppeEintrag("Schockbooster", 10));
            ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
            ogE.addElement(new OptionsGruppeEintrag("Synchronisierter Bolter", 5));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));

            add(oe1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

            if(child) seperator();

            if(child) add(o4 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Sonic Blaster", squad.getModelle(), 5));

            seperator();

            t = new RuestkammerStarter(ID, randAbstand, cnt, "CMTransporter", "Transporter", 2);
            t.initKammer();
            t.setButtonText("Transporter");
            add(t);

            sizeSetzen();
	}

	@Override
	public void refreshen() {
            if(child) oe3.alwaysSelected();
            if(child) o4.setMaxAnzahl(squad.getModelle() - oe2.getAnzahl() - oe1.getAnzahl());
            o2.setMaxAnzahl(squad.getModelle());
            if(o3!=null){
            	o3.setAktiv(o1.isSelected());
            }
	}

}
